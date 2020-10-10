package br.com.unipe.aula.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.unipe.aula.dao.TorcedorDAO;
import br.com.unipe.aula.model.Torcedor;

@Controller
public class WelcomeController {
	
	@Autowired
	private TorcedorDAO dao;
	
	public WelcomeController() {
		dao = new TorcedorDAO();
	}

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
	
	@RequestMapping(value = "/formulario", method = RequestMethod.GET)
	public ModelAndView formulario(Model model) {
		model.addAttribute("torcedor", new Torcedor());
		return new ModelAndView("formulario");
	}
	
	@RequestMapping(value = "/formulario", method = RequestMethod.POST)
	public ModelAndView exibeTime(@ModelAttribute Torcedor torcedor) {
		ModelAndView view = new ModelAndView("formulario");
		
		view.addObject("mensagem", torcedor.getNome() + " torce para o " + torcedor.getTime());
		
		return view;
	}
	
	@PostMapping(value = "/cadastro")
	public ModelAndView cadastrarTorcedor(@ModelAttribute Torcedor torcedor) {
		
		dao.salvar(torcedor);
		
		ModelAndView view = new ModelAndView("formulario");
		view.addObject("mensagem", "Torcedor cadastrado com sucesso!");
		view.addObject("torcedores", dao.getAll());
		
		return view;
	}
	
	@GetMapping(value = "/cadastro")
	public ModelAndView retornarAposExcluir(@ModelAttribute Torcedor torcedor) {
		
		ModelAndView view = new ModelAndView("formulario");
		view.addObject("mensagem", "Torcedor cadastrado com sucesso!");
		view.addObject("torcedores", dao.getAll());
		
		return view;
	}
	
	@GetMapping(value = "/excluir/{id}")
	public String excluirTorcedor(@PathVariable("id") int id, Model model) {
		
		dao.excluir(id);
		
		return "redirect:../cadastro";
	}
	
	@GetMapping(value = "/editar/{id}")
	public ModelAndView editarTorcedor(@PathVariable("id") int id, Model model) {
		
		ModelAndView view = new ModelAndView("editar");
		view.addObject("id", id);
		model.addAttribute("torcedor", dao.getId(id));
		
		return view;
	}
	
}
