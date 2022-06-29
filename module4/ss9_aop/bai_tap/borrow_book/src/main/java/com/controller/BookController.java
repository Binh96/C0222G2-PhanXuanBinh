package com.controller;


import com.model.Book;
import com.model.DetailBook;
import com.service.BookService;
import com.service.DetailBookService;
import com.service.utils.BorrowException;
import com.service.utils.PayBackBookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private DetailBookService detailBookService;


    @GetMapping("")
    public ModelAndView homePage(@PageableDefault(value = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("books",bookService.selectAllPage(pageable));
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView createPage(){
        ModelAndView modelAndView = new ModelAndView("insert");
        modelAndView.addObject("book",new Book());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createPage(@ModelAttribute Book book, RedirectAttributes redirectAttributes){
        for(int i=0; i<book.getQuantity(); i++){
            DetailBook detailBook = new DetailBook();
            int id = (int) (Math.random()*1000);
            detailBook.setCodeOfBook(id);
            detailBook.setNameBook(book);
            detailBookService.create(detailBook);
        }
        return "redirect:/book";
    }

    @GetMapping("/detail")
    public ModelAndView detailPage(@PageableDefault(value = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("detailBooks", detailBookService.selectAllPage(pageable));
        return modelAndView;
    }




//    @GetMapping("/detail")
//    public ModelAndView detailPage(@RequestParam int id){
//        ModelAndView modelAndView = new ModelAndView("detail");
//        modelAndView.addObject("book",bookService.selectById(id));
//        return modelAndView;
//    }
//
//    @GetMapping("/borrow")
//    public String borrowPage(@RequestParam int id, Model model)
//    throws BorrowException {
//        Book book = bookService.selectById(id);
//        User user = new User();
//        user.setCodeOfBorrow((int) (Math.random()*100000));
//        if(bookService.checkBookBorrow(book)){
//            model.addAttribute("book1", book);
//            model.addAttribute("user", user);
//            return "borrow";
//        }
//        throw new BorrowException();
//    }
//
//    @PostMapping("/borrow")
//    public String borrowPage(@ModelAttribute User user){
//        userService.create(user);
//        Book book = bookService.selectById(user.getBook().getId());
//        bookService.selectById(book.getId()).borrowBook();
//        bookService.update(bookService.selectById(book.getId()));
//        return "redirect:/book";
//    }
//
//    @GetMapping("/giveback")
//    public String backBookPage(@RequestParam int id, Model model)
//    throws PayBackBookException {
//        Book book = bookService.selectById(id);
//        if(bookService.checkBookPayBack(book)){
//            model.addAttribute("book", bookService.selectById(id));
//            model.addAttribute("user", new User());
//            return "back";
//        }
//        throw new PayBackBookException();
//    }
//
//    @PostMapping("/giveback")
//    public String backBookPage(@ModelAttribute Book book, @ModelAttribute User user,
//                               RedirectAttributes redirectAttributes, Model model){
//        if(!userService.selectByCodeBorrow(user.getCodeOfBorrow(), book)){
//            model.addAttribute("msg", "invalid code book borrows");
//            return "back";
//        }
//
//        System.out.println(book.getId());
//        bookService.selectById(book.getId()).payBook();
//        bookService.update(bookService.selectById(book.getId()));
//        redirectAttributes.addFlashAttribute("msg", "success give back book");
//        return "redirect:/book";
//    }

    @ExceptionHandler(BorrowException.class)
    public String borrowErrorPage(){
        return "error_borrow";
    }

    @ExceptionHandler(PayBackBookException.class)
    public String paybackErrorPage(){
        return "error_payback";
    }
}
