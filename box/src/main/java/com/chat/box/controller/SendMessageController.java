package com.chat.box.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {
	
	@RequestMapping("/")
	public String Hello() {
		return "Hello";
	}

}
