package com.containercrush.unbeatable.product.controller;

import com.containercrush.unbeatable.product.model.Product;
import com.containercrush.unbeatable.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin
@Api(value = "Product service CRUD Operations")
public class ProductController {
    private ProductService productService;

    @Autowired              // constructor based autowiring
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    @ApiOperation(value = "List of products", response = List.class)
    public ResponseEntity<?> getProductList() {
        ResponseEntity responseEntity;
        List<Product> productList;
        try {
            productList = productService.getProductList();
            responseEntity = new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping(value = "/Product/{id}")
    @ApiOperation(value = "Get a Product info by id")
    public ResponseEntity<?> getProductById(@PathVariable int id) {
        ResponseEntity responseEntity;
        Product product;
        try {
            product = productService.getProductById(id);
            responseEntity = new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PostMapping(value = "/Product")
    @ApiOperation(value = "save a Product info")
    public ResponseEntity<?> saveProductProfile(@RequestBody Product Product) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<Product>(productService.saveProduct(Product), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping(value = "/Product/{id}")
    @ApiOperation(value = "update a Product info")
    public ResponseEntity<?> updateProductProfile(@PathVariable int id, @RequestBody Product Product) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<Product>(productService.updateProduct(id,Product), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping(value = "/Product/{id}")
    @ApiOperation(value = "delete a Product info by id")
    public ResponseEntity<?> deleteProductProfile(@PathVariable("id") int id) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<Product>(productService.deleteProduct(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
