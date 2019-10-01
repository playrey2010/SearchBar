package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    MessageRepository messageRepository;

    @RequestMapping("/")
    public String messageList(Model model) {
        model.addAttribute("messages", messageRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String addMessage(Model model) {
        model.addAttribute("message", new Message());
        return "messageform";
    }

    @PostMapping("/processMessage")
    public String processMessage(@ModelAttribute Message message) {
        messageRepository.save(message);
        return "redirect:/";
    }

    @PostMapping("/processSearch")
    public String searchResult(Model model, @RequestParam(name = "search") String search) {
        model.addAttribute("messages", messageRepository.findByTitle(search));
        return "searchlist";
    }
}
