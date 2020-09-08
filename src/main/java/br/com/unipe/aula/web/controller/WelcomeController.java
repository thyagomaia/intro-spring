package br.com.unipe.aula.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping(value = "/outraforma", method = RequestMethod.GET)
	public ModelAndView outraForma() {
		ModelAndView view = new ModelAndView("welcome");
		
		view.addObject("mensagem", "View com parâmetro funcionando com sucesso!");
		
		return view;
	}
}
