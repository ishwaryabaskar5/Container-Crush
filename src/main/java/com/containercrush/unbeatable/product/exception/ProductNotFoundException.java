package com.containercrush.unbeatable.product.exception;

public class ProductNotFoundException extends Exception {
	public ProductNotFoundException() {
	}
	
	public ProductNotFoundException(String message) {
		super(message);
	}
}
