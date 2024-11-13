package com.mie.microservices.product.controller;

import com.mie.microservices.product.dto.ProductRequest;
import com.mie.microservices.product.dto.ProductResponse;
import com.mie.microservices.product.model.Product;
import com.mie.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        return productService.createProduct(productRequest);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public  List<ProductResponse> getAllProducts(){
        return productService.getAllProduct();
    }
}
