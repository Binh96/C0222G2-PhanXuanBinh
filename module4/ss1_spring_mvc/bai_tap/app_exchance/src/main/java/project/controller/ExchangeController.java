package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExchangeController {

    @GetMapping("/exchange")
    public String showForm(){
        return "form";
    }

    @GetMapping("/exchangeMoney")
    public String moneyExchange(@RequestParam String vnd, Model model){
        model.addAttribute("vnd", vnd);
        model.addAttribute("usd", Integer.parseInt(vnd) / 23000);
        return "form";
    }

}
