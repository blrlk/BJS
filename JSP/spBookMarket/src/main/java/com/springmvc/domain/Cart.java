package com.springmvc.domain;

import java.util.HashMap;
import java.util.Map;


public class Cart {
	private String cartId;
	private Map<String, CartItem> cartItems;
	private int grandTotal;
	
	public Cart() {
		cartItems = new HashMap<String, CartItem>();
		grandTotal = 0;
	}

	public Cart(String cartId) {
		this();
		this.cartId = cartId;
//		this.cartItems = new HashMap<String, CartItem>();
//		this.grandTotal = 0;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public Map<String, CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Map<String, CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public int getGrandTotal() {
		return grandTotal;
	}

	public void updateGrandTotal() {
		grandTotal = 0;
		for(CartItem item : cartItems.values()) {
			grandTotal += item.getTotalPrice();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj) return true;
		if(obj==null) return false;
		if(getClass() != obj.getClass()) return false;
		
		Cart other = (Cart) obj;
		if(cartId == null) {
			if(other.cartId != null) return false;
		} else if(!cartId.equals(other.cartId)) return false;
		
		return true;
	}
	
	public void addCartItem(CartItem item) {
		System.out.println("입장");
		System.out.println(item.toString());
		String bookId = item.getBook().getBookId();
		
		//도서 id가 cartItems 객체에 등록되어 있는지 여부 확인
		if(cartItems.containsKey(bookId)) {
			CartItem cartItem = cartItems.get(bookId);	//등록된 도서 id에 대한 정보 가져오기
			//등록된 도서 id의 개수 추가 저장
			cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
			cartItems.put(bookId, cartItem);	//등록된 도서 id에 대한 변경 정보(cartItem) 저장
			System.out.println("카트에 기존아이템이있음 ");
		} else {
			cartItems.put(bookId, item);	//도서 id에 대한 도서 정보(item) 저장
			System.out.println("카트에 엾음 추가함 ");
		}
		
		updateGrandTotal();
	}
	
	public void removeCartItem(CartItem item) {
		String bookId = item.getBook().getBookId();
		cartItems.remove(bookId);
		updateGrandTotal();
	}
	

}
