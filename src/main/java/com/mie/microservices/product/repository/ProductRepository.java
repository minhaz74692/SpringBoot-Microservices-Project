package com.mie.microservices.product.repository;
import com.mie.microservices.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface ProductRepository  extends  MongoRepository<Product, String>{
}
