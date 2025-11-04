package edu.senac.pe.SistemaBancario_SPRING.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.senac.pe.SistemaBancario_SPRING.model.Cliente;

@Controller
public class ClienteController {

	@GetMapping("/cadastrarCliente")
	public String cadastrarCli() {
		return "cliente/formCliente";
	}

	@PostMapping("/cadastrarCliente")
	public String cadastrarCli(Cliente cliente) {
		System.out.println(cliente);;
		return "redirect:/cadastrarCliente";
	}
	
	
}
