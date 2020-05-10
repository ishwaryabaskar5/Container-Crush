package com.containercrush.unbeatable.product.service;

import com.containercrush.unbeatable.product.exception.ProductAlreadyExistsException;
import com.containercrush.unbeatable.product.exception.ProductNotFoundException;
import com.containercrush.unbeatable.product.model.Product;
import com.containercrush.unbeatable.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    MongoOperations mongoOperations;
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getProductList(){
        return productRepository.findAll();
    }

    public Product getProductById(int id) throws ProductNotFoundException{
        if(productRepository.existsById(id) == true) {
            return productRepository.findById(id).get();
        } else {
            throw new ProductNotFoundException(id+"not exist");
        }
    }

    public Product saveProduct(Product product) throws ProductAlreadyExistsException{
        if(productRepository.existsById(product.getId()) == false) {
            return productRepository.save(product);
        } else {
            throw new ProductAlreadyExistsException();
        }
    }

    public Product deleteProduct(int id) throws ProductNotFoundException{
        Optional<Product> productOptional;
        if(productRepository.existsById(id) == true) {
            productOptional = productRepository.findById(id);
            productRepository.deleteById(id);
            return productOptional.get();
        } else {
            throw new ProductNotFoundException();
        }
    }

    public Product updateProduct(int id, Product product) throws ProductNotFoundException{
            if(productRepository.existsById(id) == true){
                return productRepository.save(product);
            } else {
                throw new ProductNotFoundException();
            }
    }
}
