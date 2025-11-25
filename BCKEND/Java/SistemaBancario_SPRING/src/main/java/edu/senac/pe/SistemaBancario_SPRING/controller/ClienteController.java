package edu.senac.pe.SistemaBancario_SPRING.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.senac.pe.SistemaBancario_SPRING.model.Cliente;
import edu.senac.pe.SistemaBancario_SPRING.repository.ClienteRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository cr;

	@GetMapping("/cadastrarCliente")
	public String cadastrarCli() {
		return "cliente/formCliente";
	}

	@PostMapping("/cadastrarCliente")
	public String cadastrarCli(Cliente cliente) {
		System.out.println(cliente);
		cr.save(cliente);
		return "cliente/salvarCliente";
	}
	
	@GetMapping("/listarClientes")
	public ModelAndView listarClientes() {
		ModelAndView mv = new ModelAndView("cliente/listarClientes");
		Iterable<Cliente> clientes = cr.findAll();
		mv.addObject("clientes", clientes);
		return mv;
	}
	
	@GetMapping("/detalharCliente/{cpf}")
	public ModelAndView detalharCliente(@PathVariable String cpf) {
		Optional<Cliente> cliente = cr.findById(cpf);
		ModelAndView mv = new ModelAndView("cliente/detalharCliente");
		mv.addObject("cliente", cliente);
		return mv;
	}

	@GetMapping("/excluirCliente/{cpf}")
	public String excluirCliente(@PathVariable String cpf) {
		cr.deleteById(cpf);
		return "redirect:/listarClientes";
	}
	
}
