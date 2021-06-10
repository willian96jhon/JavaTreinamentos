package com.automobilistico.automobilistico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.automobilistico.automobilistico.model.Cadastro;
import com.automobilistico.automobilistico.model.Cliente;
import com.automobilistico.automobilistico.repository.AutomovelRepository;
import com.automobilistico.automobilistico.repository.ClienteRepository;

@Controller
@RequestMapping("/pessoa")
public class ClienteController {
	
	@Autowired
	private ClienteRepository cr;
	
	@Autowired private AutomovelRepository ar;
	

	long id=-1;
	@GetMapping("/addVeiculo/{idCliente}")
	public ModelAndView getAddVeiculo(@PathVariable Long idCliente) {
		ModelAndView mv= new ModelAndView("addVeiculo");
		List<Cadastro> automoveis= ar.findAll();
		mv.addObject("automoveis" , automoveis);
		Cliente cliente=cr.getOne(idCliente);
		//Cliente c= cr.getOne(idCliente);
		
		mv.addObject(cliente);
		id=idCliente;
		return mv;
		
	}
	
	@PostMapping("/addVeiculo")
	public ModelAndView addVeiculo() {
		ModelAndView mv= new ModelAndView("cadastroCliente");
		Cliente c= cr.getOne(id);
		c.getVeiculos().add(c.getVeiculo());
		cr.save(c);
		
		return mv;
	}
	
	@GetMapping
	public ModelAndView getClientes() {
		ModelAndView mv=new ModelAndView("CadastroCliente");
		mv.addObject(new Cliente());
		List<Cadastro> automoveis=ar.findAll();
		mv.addObject("automoveis", automoveis);
		
		return mv;
	}
	
	
	@PostMapping
	public ModelAndView salvarCliente( @Validated Cliente cliente, Errors errors) {
		if(errors.hasErrors()) {
			ModelAndView mv=new ModelAndView("CadastroCliente");
			return mv;
			
		}
		ModelAndView mv=new ModelAndView("CadastroCliente");
		mv.addObject("mensagem", "Cliente Cadastrado com Sucesso!");
		cr.save(cliente);
		
		return mv;
		
	}
	
	
	
	
	
	@GetMapping("/listarClientes")
	public ModelAndView listarClientes() {
		ModelAndView mv=new ModelAndView("ListarClientes");
		List<Cliente> clientes=cr.findAll();
		mv.addObject("clientes", clientes);
		for(int i=0;i<clientes.size();++i) {
			List<Cadastro> automoveis= clientes.get(i).getVeiculos();
			mv.addObject("automoveis", automoveis);
		}
		
		return mv;
		
	}
	
	
	
	
	@GetMapping(value="{idCliente}")
	public ModelAndView editar(@PathVariable("idCliente") Long idCliente) {
		ModelAndView mv=new ModelAndView("CadastroCliente");
		Cliente cliente=cr.getOne(idCliente);
		mv.addObject(cliente);
		List<Cadastro> automoveis= ar.findAll();
		mv.addObject("automoveis", automoveis);
		return mv;
	}
	
	
	@DeleteMapping("/listarClientes/{idCliente}")
	public String deletarCliente(@PathVariable Long idCliente) {
		cr.deleteById(idCliente);
		return "redirect:/pessoa";
	}
	
	
	
	

	
}
