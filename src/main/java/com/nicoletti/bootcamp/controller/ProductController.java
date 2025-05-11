package com.nicoletti.bootcamp.controller;

import com.nicoletti.bootcamp.model.Product;
import com.nicoletti.bootcamp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    private List<Product> listProducts() {
        return productService.listAllProducts();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    private Product createProduct(@RequestBody Product entity) {
        return productService.saveProduct(entity);
    }


    @DeleteMapping("/{if}")
    private ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
         productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
