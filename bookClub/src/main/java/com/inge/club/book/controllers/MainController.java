package com.inge.club.book.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.inge.club.book.models.Book;
import com.inge.club.book.models.LoginUser;
import com.inge.club.book.models.User;
import com.inge.club.book.services.BookService;
import com.inge.club.book.services.UserService;



@Controller
public class MainController {

	@Autowired
	private UserService userServ;
	@Autowired 
	private BookService bookServ;
	
	@GetMapping("/")
	public String index(@ModelAttribute("registerUser") User newUser, @ModelAttribute("loginUser") LoginUser loginUser) {
		return "index.jsp";
	}
	
	@GetMapping("/books")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("loggedUser", userServ.findById(userId));
		model.addAttribute("books", bookServ.all());
		
		
		return "bookDashboard.jsp";
	}
	
	@GetMapping("/books/new")
	public String addBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("loggedUser", userServ.findById(userId));
		
		return "addBook.jsp";
	}
	
	@GetMapping("/books/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model,HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Book aBook = bookServ.findBookById(id);
		model.addAttribute("book", aBook);
		return "editBook.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String bookPage(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Book aBook = bookServ.findBookById(id);
		model.addAttribute("book", aBook);
		model.addAttribute("user", userServ.findById((Long)session.getAttribute("userId")));
		
		return "showBook.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("registerUser") User newUser, BindingResult result, HttpSession session, @ModelAttribute("loginUser") LoginUser loginUser) {
		User savedUser = userServ.validateRegister(newUser, result);
		
		if(result.hasErrors()) {
			return "index.jsp";
		}
		
		session.setAttribute("userId", savedUser.getId());
		
		return "redirect:/books";
		
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, @ModelAttribute("registerUser") User newUser, HttpSession session) {
		User aUser = userServ.validateLogin(loginUser, result);
		if(result.hasErrors()) {
			
			return "redirect:/";
		}
		session.setAttribute("userId", aUser.getId());
		return "redirect:/books";
	}
	
	
	@PostMapping("/add")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "addBook.jsp";
		}
		bookServ.createBook(book);
		return "redirect:/books";
	}
	
	
	@PutMapping("/update/{id}")
	public String updateBook(@Valid @ModelAttribute("book") Book book, Model model, BindingResult result) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		}
		bookServ.updateBook(book);
		return "redirect:/books";
	}
}
