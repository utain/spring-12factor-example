package com.utain.app12.javaexample;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("api/v1/products")
@RestController
class ProductController {
  @Autowired
  private ProductRepository productRepository;

  @GetMapping(value = "")
  public Page<Products> allProduct(Pageable page) {
    return productRepository.findAll(page);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Products> getMethodName(@PathVariable("id") final String id) {
    final Optional<Products> product = productRepository.findById(id);
    if (product.isPresent()) {
      return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping(value = "")
  public ResponseEntity<Products> createProduct(@RequestBody final Products entity) {
    if (ObjectUtils.isEmpty(entity) || entity.getId().isEmpty()) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<Products>(productRepository.save(entity), HttpStatus.CREATED);
  }

  @PutMapping(value = "")
  public ResponseEntity<Products> postMethodName(@RequestBody final Products entity) {
    if (ObjectUtils.isEmpty(entity) || entity.getId().isEmpty()) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(productRepository.saveAndFlush(entity), HttpStatus.ACCEPTED);
  }

}