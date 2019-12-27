package com.utain.app12.javaexample;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Products {
  @Id
  private String id;
  private String name;
  private String code;
  private String description;
  @OneToMany(mappedBy = "productId")
  private List<ProductProps> props;

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<ProductProps> getProps() {
    return props;
  }

  public void setProps(List<ProductProps> props) {
    this.props = props;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
