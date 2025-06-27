package com.springmvc.exception;

public class CartException extends RuntimeException{
	private static final long serialVersionUID = -5192041563033358481L;
	private String cartId;
	
	public CartException(String cartId) {
		this.cartId = cartId;
	}

	public String getCartId() {
		return cartId;
	}
	
	
}
