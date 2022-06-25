package com.controller;


import com.dto.ProductDto;
import com.model.Product;
import com.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String homePage(Model model){
        List<Product> products  = productService.selectAll();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/create")
    public String createPage(Model model){
        model.addAttribute("productDto", new ProductDto());
        return "create";
    }

    @PostMapping("/create")
    public String createPage(@Valid @ModelAttribute("productDto") ProductDto productDto, BindingResult bindingResult,
                             RedirectAttributes redirect){
        if(bindingResult.hasErrors()){
            return "create";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productService.createProduct(product);
        redirect.addFlashAttribute("success", "Add new success");
        return "redirect:/product";
    }

    @GetMapping("{id}/edit")
    public String editPage(@PathVariable int id, Model model){
        model.addAttribute("product", productService.selectOne(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editPage(@Valid @ModelAttribute("productDto") ProductDto productDto, BindingResult bindingResult,
                           RedirectAttributes redirect){
        if(bindingResult.hasErrors()){
            return "edit";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productService.updateProduct(product);
        redirect.addFlashAttribute("success", "Edit success");
        return "redirect:/product";
    }

    @GetMapping("{id}/delete")
    public String deletePage(@PathVariable int id, Model model){
        model.addAttribute("product", productService.selectOne(id));
        return "delete";
    }

    @GetMapping("/delete")
    public String deleteProduct(Product product, RedirectAttributes redirect){
        productService.deleteProduct(product.getId());
        redirect.addFlashAttribute("success", "Remove completed");
        return "redirect:/product";
    }

    @GetMapping("{id}/view")
    public String viewPage(@PathVariable int id, Model model){
        model.addAttribute("product", productService.selectOne(id));
        return "view";
    }
    @GetMapping("/search")
    public String searchProduct(@RequestParam String searchValue, Model model){
        model.addAttribute("products", productService.searchByName("%"+searchValue+"%"));
        return "list";
    }
}
