package com.containercrush.unbeatable.product.exception;

public class ProductAlreadyExistsException extends Exception {
	public ProductAlreadyExistsException() {
	}
	
	public ProductAlreadyExistsException(String message) {
		super(message);
	}
}
