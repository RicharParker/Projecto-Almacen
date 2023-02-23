package com.ulsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ulsa.entity.Proveedor;
import com.ulsa.repository.ProveedorRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
@Controller
public class ProveedorController {
	
	private final ProveedorRepository proveedorRepository;
	
	//proveedorRepository = new ProveedorRepository;
	
	@Autowired
	public ProveedorController(ProveedorRepository proveedorRepository) {
		this.proveedorRepository = proveedorRepository; 
	}
	
	@GetMapping("/proveedores")
	public String indexProveedors(Model model) {
		System.out.println("&&&&& indexProveedors &&&&&&");
		model.addAttribute("proveedores", proveedorRepository.findAll());
		return "proveedores/index-proveedores";
		
	}
	
	@PostMapping("/addproveedor")
	public String addUser(@Validated Proveedor proveedor, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "proveedores/add-proveedor";
		}
		proveedorRepository.save(proveedor);
		model.addAttribute("proveedores", proveedorRepository.findAll());
		return "proveedores/index-proveedores";
	}
	
	@GetMapping("/newProveedor")
	public String showSignUpForm(Proveedor proveedor) {
		System.out.println("&&&&& showSignUpForm &&&&&&");
		return "proveedores/add-proveedor";
	}
	
	@GetMapping("/editProveedor/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Proveedor proveedor =
				proveedorRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid proveedor Id:" + id));
		model.addAttribute("proveedor", proveedor);
		return "proveedores/update-proveedor";
	}
	
	@GetMapping("/deleteProveedor/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Proveedor proveedor =
			proveedorRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid proveedor Id:" + id));
		proveedorRepository.delete(proveedor);
		model.addAttribute("proveedores", proveedorRepository.findAll());
		return "proveedores/index-proveedores";
	}
	
	@PostMapping("/updateProveedor/{id}")
	public String updateUser(@PathVariable("id") long id, @Validated Proveedor proveedor,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			proveedor.setId_proveedor(id);
			return "proveedores/update-proveedor";
		}
		proveedorRepository.save(proveedor);
		model.addAttribute("proveedores", proveedorRepository.findAll());
		return "proveedores/index-proveedores";
	}
	


}
