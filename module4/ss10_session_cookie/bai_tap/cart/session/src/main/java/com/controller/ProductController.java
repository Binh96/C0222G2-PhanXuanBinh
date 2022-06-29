package com.controller;


import com.model.Cart;
import com.model.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @ModelAttribute("cartList")
    public List<Cart> selectCartList(){
        return new ArrayList<>();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(){
        ModelAndView modelAndView = new ModelAndView("shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam String action){
        Optional<Product> productOptional = productService.findById(id);
        if(!productOptional.isPresent()){
            return "error.404";
        }
        if(action.equals("add")){
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if(action.equals("sub")){
            cart.subProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }


    @GetMapping("/detail")
    public String showDetail(@RequestParam Long id, Model model){
        Optional<Product> productOptional = productService.findById(id);
        if(productOptional.isPresent()){
            model.addAttribute("product", productOptional.get());
            return "detail";
        }
        return "error.404";
    }

    @GetMapping("/total")
    public String totalCart(){
        return "redirect:/total-cart";
    }
}
