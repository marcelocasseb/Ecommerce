package br.com.truedev.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.truedev.ecommerce.model.Pedido;
import br.com.truedev.ecommerce.service.pedido.IPedidoService;

@RestController
public class PedidoController {

	@Autowired
	private IPedidoService service;
	
	@PostMapping("/pedidos")
	public ResponseEntity<Pedido> inserNovo (@RequestBody Pedido novo){
		Pedido ped = service.criarNovoPedido(novo);
		if (ped != null)
			return ResponseEntity.ok(ped);
		else
			return ResponseEntity.badRequest().build(); 
	}
	
	@GetMapping("/pedidos")
	public ResponseEntity<List<Pedido>> recuperarTodos(){
		return ResponseEntity.ok(service.recuperarPedidos());
	}
	
	@GetMapping("/pedidos/{id}")
	public ResponseEntity<Pedido> recuperarPedido(@PathVariable Integer id){
		Pedido ped = service.recuperaPeloNumero(id);
		if(ped != null)
			return ResponseEntity.ok(ped);
		else
			return ResponseEntity.notFound().build();
	}
}
