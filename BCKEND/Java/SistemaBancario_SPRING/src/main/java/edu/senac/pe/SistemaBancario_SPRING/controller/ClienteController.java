package edu.senac.pe.SistemaBancario_SPRING.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String cadastrarCli(Cliente cliente, RedirectAttributes redirectAttributes) {
		System.out.println(cliente);
		cr.save(cliente);
		redirectAttributes.addFlashAttribute("mensagemSucesso", "Usuário cadastrado com sucesso!");
		return "redirect:/cadastrarCliente";
	}
	
	
}
