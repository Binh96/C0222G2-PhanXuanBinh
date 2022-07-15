package com.exam.controller;

import com.exam.dto.ContractDto;
import com.exam.model.Contract;
import com.exam.service.ContractService;
import com.exam.service.RoomService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private RoomService roomService;

    @GetMapping("")
    public String getHomePage(Model model){
        List<Contract> contracts = contractService.selectAll();
        if(contracts.isEmpty()){
            model.addAttribute("error", "No data available");
        }
        model.addAttribute("contracts",contracts);
        return "home";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model){
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("rooms", roomService.selectAll());
        return "create";
    }

    @PostMapping ("/create")
    public String createPage(@Valid @ModelAttribute ContractDto contractDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            model.addAttribute("rooms", roomService.selectAll());
            return "create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contractService.create(contract);
        roomService.updateRoom(contract.getRoom().getId());
        redirectAttributes.addFlashAttribute("msg", "Add new completed success!");
        return "redirect:/exam";
    }
//
//    @GetMapping("/edit")
//    public String getEditPage(@RequestParam int id, Model model){
//        Student student = studentService.findById(id);
//        model.addAttribute("student", student);
//        return "edit";
//    }
//
//    @PostMapping ("/edit")
//    public String editPage(@ModelAttribute Student student, RedirectAttributes redirectAttributes){
//        studentService.save(student);
//        redirectAttributes.addFlashAttribute("msg", "Edit success");
//        return "redirect:/exam";
//    }
//
    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable int id, RedirectAttributes redirectAttributes){
        Contract contract = contractService.findById(id);
        contractService.delete(contract);
        roomService.updateRoomEndRent(id);
        redirectAttributes.addFlashAttribute("msg", "Delete success");
        return "redirect:/exam";
    }
}
