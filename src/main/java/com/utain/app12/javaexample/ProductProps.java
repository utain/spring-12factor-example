package com.utain.app12.javaexample;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductProps {
  @Id
  private String id;
  private String name;
  private String value;
  private String productId;

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
