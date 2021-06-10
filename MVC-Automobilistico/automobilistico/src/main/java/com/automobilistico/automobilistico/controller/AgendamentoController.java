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

import com.automobilistico.automobilistico.model.Agendamento;
import com.automobilistico.automobilistico.model.Cliente;
import com.automobilistico.automobilistico.repository.AgendamentoRepository;
import com.automobilistico.automobilistico.repository.ClienteRepository;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoRepository ar;
	
	@Autowired
	ClienteRepository cr;
	
	
	@GetMapping
	public ModelAndView getAgendar() {
		ModelAndView mv= new ModelAndView("agendar");
		mv.addObject(new Agendamento());
		List<Cliente> clientes=cr.findAll();
		mv.addObject("clientes", clientes);
		return mv;
		
	}
	
	
	@PostMapping
	public ModelAndView agendar(Agendamento agendamento) {
		ModelAndView mv= new ModelAndView("agendar");
		
		
		//Agendamento age=ar.save(agendamento);
		List<Cliente> clientes=cr.findAll();
		
		
		for(int i=0; i<clientes.size();++i) {
			if(clientes.get(i).getNome().equals(agendamento.getNome())) {
				
				
				
				
				
				agendamento.setCliente(clientes.get(i));
				break;
			}
		}
		
		//Cliente cli= agendamento.getCliente();
		//cli.getServicos().add(agendamento.getServico());
		//cr.save(cli);
		ar.save(agendamento);
		

		return mv;
	}
	
	
	
	@GetMapping("/agenda")
	public ModelAndView agenda() {
		ModelAndView mv= new ModelAndView("agenda");
		List<Agendamento> agendamentos= ar.findAll();
		mv.addObject("agendamentos", agendamentos);
		return mv;
	}
	
	
	
	@DeleteMapping("/agenda/{id}")
	public String deletar(@PathVariable Long id) {
		ar.deleteById(id);
		
		return "redirect:/agendamento";
	}
	
	
	/*@GetMapping("/agenda/listar/{id}")
	public ModelAndView listarServicos(@PathVariable Long id) {
		ModelAndView mv= new ModelAndView("listarServicos");
		Cliente cliente=cr.getOne(id);
		mv.addObject(cliente);
		List<String> servicos= cliente.getServicos();
		mv.addObject("servicos", servicos);
		return mv;
	}*/
	
	
	
	
	
	
	

}
