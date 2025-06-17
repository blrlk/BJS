package com.springmvc.controller;

import java.util.List;
import java.util.Set;
import java.util.Map;
import org.springframework.web.bind.annotation.MatrixVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/books", method=RequestMethod.GET)
public class BookController {
	@Autowired
	private BookService bookService;
	
		
	@GetMapping
	public String requestBookList(Model model) {	//model: 뷰에 데이터를 넘겨주는 역할
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList", list);
		
		return "books";	//books.jsp
	}
	
	@GetMapping("/all")
	public ModelAndView requestAllBooks() {
		ModelAndView mav = new ModelAndView();
		List<Book> list = bookService.getAllBookList();
		mav.addObject("bookList", list);
		mav.setViewName("books");	//books.jsp
		return mav;
	}
	
	@GetMapping("/{category}")	//PathVariable 
	//@GetMapping("/{A}")의 A와 매개변수 PathVariable의 변수명이 같으면 PathVariable[("A")] [] 부분 생략 가능 -> @PathVariable String A
	public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model) {	//category의 값이 bookCategory 변수로 들어가 함수 내부에서 사용
		System.out.println("[requestBooksByCategory]" + bookCategory + model);
		
		List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
		model.addAttribute("bookList", booksByCategory);
		System.out.println(model);
		
		return "books";
	}
	
	@GetMapping("/filter/{bookFilter}")
	//pathVar PathVariable 이후에 나오는 데이터의 값을 Map<> bookFilter에 담기
	public String requestBooksByFilter(@MatrixVariable(pathVar="bookFilter") Map<String, List<String>> bookFilter, Model model) {
		Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
		model.addAttribute("bookList", booksByFilter);
		return "books";
	}

	@GetMapping("/book")
	public String requestBookById(@RequestParam("id") String bookId, Model model) {
		Book bookById = bookService.getBookById(bookId);
		model.addAttribute("book", bookById);
		
		return "book";
		
	}
}
