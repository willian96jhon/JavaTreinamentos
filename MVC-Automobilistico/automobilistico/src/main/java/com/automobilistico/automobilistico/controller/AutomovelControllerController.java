package com.automobilistico.automobilistico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.automobilistico.automobilistico.model.Cadastro;
import com.automobilistico.automobilistico.repository.AutomovelRepository;

@Controller
@RequestMapping("/automovel")
public class AutomovelControllerController {
	
	@Autowired
	private AutomovelRepository ar;
	
	
	@GetMapping
	public ModelAndView cadastrar() {
		ModelAndView mv= new ModelAndView("CadastroAutomovel");
		mv.addObject(new Cadastro());
		return mv;
	}
	
	
	
	@PostMapping
	public ModelAndView salvar(Cadastro cadastro) {
		ModelAndView mv= new ModelAndView("CadastroAutomovel");
		
		ar.save(cadastro);
		return mv;
	}
	
	
	
	@GetMapping("/listarAutomoveis")
	public ModelAndView listar() {
		ModelAndView mv=new ModelAndView("listarAutomoveis");
		List<Cadastro> cadastros= ar.findAll();
		mv.addObject("cadastros", cadastros);
		
		return mv;
	}
	
	
	
	
	@GetMapping("{idCadastro}")
	public ModelAndView editar(@PathVariable("idCadastro") Long idCadastro) {
		ModelAndView mv= new ModelAndView("CadastroAutomovel");
		Cadastro cadastro= ar.getOne(idCadastro);
		mv.addObject(cadastro);
		return mv;
		
	}
	
	
	@DeleteMapping("/listarAutomoveis/{idCadastro}")
	public String deletar(@PathVariable Long idCadastro) {
		ar.deleteById(idCadastro);
		return "redirect:/automovel";
		
	}
	
	
	
	
	
	

}
