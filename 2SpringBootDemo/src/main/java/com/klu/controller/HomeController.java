package com.klu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.klu.model.Message;
import com.klu.service.MessageService;
import org.springframework.ui.Model;

@Controller
public class HomeController {
	
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/")
	private String home(Model model) {
		Message msg = new Message(messageService.getMessage());
		model.addAttribute("Message",msg);
		return "home";
	}
	
}
