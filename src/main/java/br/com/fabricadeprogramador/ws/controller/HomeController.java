package br.com.fabricadeprogramador.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String carregarHome() {
		return "index";
	}
}
