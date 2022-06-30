package com.controller;


import com.model.Book;
import com.model.BorrowBook;
import com.model.DetailBook;
import com.service.BookService;
import com.service.BorrowBookService;
import com.service.DetailBookService;
import com.service.utils.BorrowException;
import com.service.utils.PayBackBookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private DetailBookService detailBookService;

    @Autowired
    private BorrowBookService borrowBookService;


    @GetMapping("")
    public ModelAndView homePage(@PageableDefault(value = 5) Pageable pageable,
                                 @RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size){
        ModelAndView modelAndView = new ModelAndView("index");
        Page<Book> books = bookService.selectAllPage(pageable);
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        int totalPages = books.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }
        modelAndView.addObject("books",books);
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
    public ModelAndView detailPage(@PageableDefault(value = 5) Pageable pageable,
                                   @RequestParam("page") Optional<Integer> page,
                                   @RequestParam("size") Optional<Integer> size){
        ModelAndView modelAndView = new ModelAndView("detail");
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<DetailBook> detailBooks = detailBookService.selectAllPage(pageable);
        int totalPages = detailBooks.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }
        modelAndView.addObject("detailBooks", detailBooks);
        return modelAndView;
    }

    @GetMapping("/borrow")
    public String borrowPage(Model model, @RequestParam int id){
        DetailBook detailBook = detailBookService.findById(id);
        BorrowBook code = new BorrowBook();
        code.setCodeOfBorrow((int) ((Math.random()+10)*1000));
        model.addAttribute("borrowBook", code);
        model.addAttribute("detailBook", detailBook);
        return "borrow";
    }

    @PostMapping("/borrow")
    public String borrowPage(@ModelAttribute DetailBook detailBook, @ModelAttribute BorrowBook borrowBook){
        detailBook.setStatus(1);
//        detailBookService.updateDetailBook(detailBook.getId());
        detailBookService.updateDetailBook(detailBook);
        System.out.println(borrowBook.getCodeOfBorrow());
        borrowBookService.createBorrowBook(borrowBook);
        bookService.bookBorrow(detailBook.getNameBook().getId());
        return "redirect:/book";
    }



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
