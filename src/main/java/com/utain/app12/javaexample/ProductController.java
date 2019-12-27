package com.utain.app12.javaexample;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/")
@RestController
class ProductController {
  @Autowired
  private ProductRepository productRepository;

  @GetMapping(value = "")
  public List<Products> allProduct() {
    return productRepository.findAll();
  }

  @GetMapping(value = "/{id}")
  public Optional<Products> getMethodName(@PathVariable("id") String id) {
    return productRepository.findById(id);
  }

  @PostMapping(value = "")
  public Products createProduct(@RequestBody Products entity) {
    return productRepository.save(entity);
  }

  @PatchMapping(value = "")
  public ResponseEntity<Products> postMethodName(@RequestBody Products entity) {
    if (ObjectUtils.isEmpty(entity) || entity.getId().isEmpty()) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(productRepository.saveAndFlush(entity), HttpStatus.ACCEPTED);
  }

}