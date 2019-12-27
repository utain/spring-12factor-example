FROM maven:3.6.3-jdk-8-slim as builder
WORKDIR /app

ADD ./pom.xml /app/pom.xml
RUN mvn dependency:go-offline

ADD . /app
RUN mvn install

FROM openjdk:8u111-jdk-alpine as finally
EXPOSE 8088
# Config for springboot app change default config location
# ENV SPRING_CONFIG_LOCATION=$HOME/.config/
ENV SPRING_CONFIG_ADDITIONAL_LOCATION=$HOME/.config/
# Config for springboot app should active profile
ENV SPRING_PROFILES_DEFAULT=default
# Copy default docker env configuration to config override
ADD ./config/docker-default.yml /.config/application.yml
VOLUME [ "/.config/" ]
# Copy jar file
COPY --from=builder /app/target/java-example-*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]