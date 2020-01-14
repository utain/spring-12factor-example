package com.utain.app12.javaexample;

import org.springframework.data.jpa.repository.JpaRepository;

interface ProductsRepository extends JpaRepository<Products, String> {

}