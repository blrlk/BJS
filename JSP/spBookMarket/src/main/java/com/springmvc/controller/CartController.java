package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.springmvc.domain.Book;
import com.springmvc.domain.Cart;
import com.springmvc.domain.CartItem;
import com.springmvc.exception.BookIdException;
import com.springmvc.service.BookService;
import com.springmvc.service.CartService;

@Controller
@RequestMapping(value="/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private BookService bookService;

	@GetMapping
	public String requestCartId(HttpServletRequest request) {
		String sessionid = request.getSession(true).getId();
		return "redirect:/cart/"+sessionid;
	}
	
	@PostMapping
	public @ResponseBody Cart create(@RequestBody Cart cart) {
		return cartService.create(cart);
	}
	
	@GetMapping("/{cartId}")
	public String requestCartList(@PathVariable(value="cartId") String cartId, Model model) {
		Cart cart = cartService.read(cartId);
		model.addAttribute("cart", cart);
		return "cart";
	}
	
	@PutMapping("/{cartId}")
	public @ResponseBody Cart read(@PathVariable(value="cartId") String cartId) {
		return cartService.read(cartId);
	}
	
	@PutMapping("/add/{bookId}")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void addCartByNewItem(@PathVariable String bookId, HttpServletRequest request) {
		System.out.println("\n== addCartByNewItem 시작 ==");
		System.out.println("현재 bookId: " + bookId);
		
		String sessionId = request.getSession(true).getId();
		System.out.println("현재 sessionId: " + sessionId);
		
		Cart cart = cartService.read(sessionId);
		if(cart == null) {
			cart = cartService.create(new Cart(sessionId));
		}
		System.out.println(cart);
		
		Book book = bookService.getBookById(bookId);
		if(book==null) {
			throw new IllegalArgumentException(new BookIdException(bookId));
		}
		System.out.println(book);
		
		CartItem ci = new CartItem(book);
		System.out.println("카트 아이템 생성 완료");
		
		cart.addCartItem(ci);
		System.out.println("카트에 항목 추가 완료");
		
		cartService.update(sessionId, cart);
	}
	
	@PutMapping("/remove/{bookId}")
	//@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public String removeCartByItem(@PathVariable String bookId, HttpServletRequest request) {
		System.out.println("\n== removeCartByItem 실행 ==");
		System.out.println("현재 bookId: " + bookId);
		
		String sessionId = request.getSession(true).getId();
		System.out.println("현재 sessionId: " + sessionId);
		
		Cart cart = cartService.read(sessionId);
		if(cart == null) {
			cart = cartService.create(new Cart(sessionId));
		}
		System.out.println(cart);
		
		Book book = bookService.getBookById(bookId);
		if(book == null) {
			throw new IllegalArgumentException(new BookIdException(bookId));
		}
		System.out.println(book);
		
		cart.removeCartItem(new CartItem(book));
		System.out.println("삭제 완료");
		
		cartService.update(sessionId, cart);
		
		//crud에서 cud 시 redirect
		return "redirect:/cart";
	}
	
	@PostMapping("/{cartId}")
	//@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public String deleteCartList(@PathVariable(value="cartId") String cartId, HttpServletRequest request) {
		System.out.println("\n== deleteCartList 시작 ==");
		System.out.println("현재 cartId: " + cartId);		
		
		cartService.delete(cartId);
		System.out.println("삭제 완료");
		
		/*
		String sessionId = request.getSession(true).getId();
		System.out.println("현재 sessionId " + sessionId);
		
		Cart cart = cartService.create(new Cart(sessionId));
		System.out.println("새 카트 추가 완료 " + cart);
		System.out.println("새 카트로 이동합니다");
		*/
		
		return "redirect:/cart";
		
	}
}
