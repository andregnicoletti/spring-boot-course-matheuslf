package com.nicoletti.bootcamp.service;

import com.nicoletti.bootcamp.model.Product;
import com.nicoletti.bootcamp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new ResolutionException("Produto com ID " + id + " não encontrado."));
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        if(!productRepository.existsById(id)){
            throw new ResolutionException("Produto com ID " + id + " não encontrado.");
        }
        productRepository.deleteById(id);
    }
}
