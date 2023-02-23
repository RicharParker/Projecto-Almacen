package com.ulsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ulsa.entity.Producto;
import com.ulsa.repository.ProductoRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
@Controller
public class ProductoController {
	
	private final ProductoRepository productoRepository;
	
	//productoRepository = new ProductoRepository;
	
	@Autowired
	public ProductoController(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository; 
	}
	
	@GetMapping("/productos")
	public String indexProductos(Model model) {
		System.out.println("&&&&& indexProductos &&&&&&");
		model.addAttribute("productos", productoRepository.findAll());
		return "productos/index-productos";
		
	}
	
	@PostMapping("/addproducto")
	public String addUser(@Validated Producto producto, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "productos/add-producto";
		}
		productoRepository.save(producto);
		model.addAttribute("productos", productoRepository.findAll());
		return "productos/index-productos";
	}
	
	@GetMapping("/newProducto")
	public String showSignUpForm(Producto producto) {
		System.out.println("&&&&& showSignUpForm &&&&&&");
		return "productos/add-producto";
	}
	
	@GetMapping("/editProducto/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Producto producto =
				productoRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid producto Id:" + id));
		model.addAttribute("producto", producto);
		return "productos/update-producto";
	}
	
	@GetMapping("/deleteProducto/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Producto producto =
			productoRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid producto Id:" + id));
		productoRepository.delete(producto);
		model.addAttribute("productos", productoRepository.findAll());
		return "productos/index-productos";
	}
	
	@PostMapping("/updateProducto/{id}")
	public String updateUser(@PathVariable("id") long id, @Validated Producto producto,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			producto.setId_producto(id);
			return "productos/update-producto";
		}
		productoRepository.save(producto);
		model.addAttribute("productos", productoRepository.findAll());
		return "productos/index-productos";
	}
	


}
