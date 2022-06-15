package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @GetMapping("/dictionary")
    public String showForm(){
        return "form";
    }

    @GetMapping("/translate")
    public String translate(@RequestParam String vietNam, Model model){
        model.addAttribute("vietNam", vietNam);
        System.out.println(vietNam);
        switch (vietNam){
            case "xin chào" : model.addAttribute("english", "Hello");
                break;
            case "con gà" : model.addAttribute("english", "Chicken");
                break;
            case "máy tính" : model.addAttribute("english", "Computer");
                break;
            case "xe đạp" : model.addAttribute("english", "Bike");
                break;
            default:  model.addAttribute("result", "of course! it's not exists in dictionary,dumb ass");
                break;
        }
        return "form";
    }
}
