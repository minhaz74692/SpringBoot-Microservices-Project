package com.mie.microservices.product.service;

import com.mie.microservices.product.dto.ProductRequest;
import com.mie.microservices.product.dto.ProductResponse;
import com.mie.microservices.product.model.Product;
import com.mie.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("successfully created product");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductResponse> getAllProduct(){
        return  productRepository.findAll().stream().map(product -> new ProductResponse(product.getId(),product.getName(), product.getDescription(), product.getPrice())).toList();
    }

}
