package com.containercrush.unbeatable.product.service;

import com.containercrush.unbeatable.product.exception.ProductAlreadyExistsException;
import com.containercrush.unbeatable.product.exception.ProductNotFoundException;
import com.containercrush.unbeatable.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int id) throws ProductNotFoundException;

    Product saveProduct(Product product) throws ProductAlreadyExistsException;

    Product deleteProduct(int id) throws ProductNotFoundException;

    Product updateProduct(int id, Product product) throws ProductNotFoundException;
}
