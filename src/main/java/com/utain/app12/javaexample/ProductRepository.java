package com.utain.app12.javaexample;

import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepository extends JpaRepository<Products, String> {

}