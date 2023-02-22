package com.ulsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ulsa.entity.Cliente;
import com.ulsa.repository.ClienteRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
@Controller
public class ClienteController {
	
	private final ClienteRepository clienteRepository;
	
	//clienteRepository = new ClienteRepository;
	
	@Autowired
	public ClienteController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository; 
	}
	
	@GetMapping("/clientes")
	public String indexClientes(Model model) {
		System.out.println("&&&&& indexClientes &&&&&&");
		model.addAttribute("clientes", clienteRepository.findAll());
		return "clientes/index-clientes";
		
	}
	
	@PostMapping("/addcliente")
	public String addUser(@Validated Cliente cliente, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "clientes/add-cliente";
		}
		clienteRepository.save(cliente);
		model.addAttribute("clientes", clienteRepository.findAll());
		return "clientes/index-clientes";
	}
	
	@GetMapping("/new")
	public String showSignUpForm(Cliente cliente) {
		System.out.println("&&&&& showSignUpForm &&&&&&");
		return "clientes/add-cliente";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Cliente cliente =
				clienteRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid cliente Id:" + id));
		model.addAttribute("cliente", cliente);
		return "clientes/update-cliente";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Cliente cliente =
			clienteRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid cliente Id:" + id));
		clienteRepository.delete(cliente);
		model.addAttribute("clientes", clienteRepository.findAll());
		return "clientes/index-clientes";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Validated Cliente cliente,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			cliente.setId_cliente(id);
			return "clientes/update-cliente";
		}
		clienteRepository.save(cliente);
		model.addAttribute("clientes", clienteRepository.findAll());
		return "clientes/index-clientes";
	}
	
	
	
	
	
	

}
