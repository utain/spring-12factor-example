package com.utain.app12.javaexample;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
	@Id
	private String id;
	private String name;
	private String email;
	private String password;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}