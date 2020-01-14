-- create stable products
CREATE TABLE "products" (
  "id" VARCHAR(255) PRIMARY KEY,
  "name" VARCHAR(255),
  "code" VARCHAR(255),
  "description" TEXT NULL
);
-- create table users
CREATE TABLE "users" (
  "id" VARCHAR(255) PRIMARY KEY,
  "name" VARCHAR(255),
  "email" VARCHAR(255),
  "password" TEXT NULL
);
-- create table product_props
CREATE TABLE "product_props" (
  "id" VARCHAR(255) PRIMARY KEY,
  "name" VARCHAR(255),
  "value" TEXT NULL,
  "productId" VARCHAR(255) NULL
);