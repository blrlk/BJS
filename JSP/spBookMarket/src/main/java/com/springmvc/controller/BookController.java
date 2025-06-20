package com.springmvc.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.domain.Book;
import com.springmvc.exception.BookIdException;
import com.springmvc.service.BookService;

@Controller
@RequestMapping(value="/books")
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
		
		if (bookCategory.isEmpty() || bookCategory == null) {
	        throw new RuntimeException("No books found in category: " + bookCategory);  // 예외 발생
	    }
		
		List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
		
		if (booksByCategory.isEmpty() || booksByCategory == null) {
	        throw new RuntimeException("No books found in category: " + booksByCategory);  // 예외 발생
	    }
		
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
	
	@GetMapping("/add")
	public String requestAddBookForm(@ModelAttribute("NewBook") Book book) {
		return "addBook";
	}
	
	@PostMapping("/add")
	public String submitAddBookForm(@Valid @ModelAttribute("NewBook") Book book, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "addBook";
		}
		
		MultipartFile bookImage = book.getBookImage();
		
		String uploadDir = request.getServletContext().getRealPath("/resources/images");
		
		String saveName = bookImage.getOriginalFilename();
		System.out.println(saveName);
		File saveFile = new File(uploadDir, saveName);
		System.out.println(saveFile);
		
		if(bookImage != null && !bookImage.isEmpty()) {
			try {
				System.out.println(bookImage);
				bookImage.transferTo(saveFile);
				System.out.println("transfer 성공");
			} catch(Exception e) {
				throw new RuntimeException("도서 이미지 업로드 실패 ", e);
			}
		}
		
		bookService.setNewBook(book);
		return "redirect:/books";
	}
	
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("addTitle", "신규 도서 등록");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("bookId", "name", "unitPrice", "author", "description", "publisher", "category", "unitsInStock", "totalPages", "releaseDate", "condition", "bookImage");
	}
	
	@ExceptionHandler(value= {BookIdException.class})
	public ModelAndView handleError(HttpServletRequest req, BookIdException exception) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidBookId", exception.getBookId());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
		mav.setViewName("errorBook");
		return mav;
	}
	
}
