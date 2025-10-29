package br.com.truedev.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.truedev.ecommerce.model.Cliente;
import br.com.truedev.ecommerce.service.cliente.IClienteService;

@RestController
public class ClienteController {

	@Autowired
	private IClienteService cliServ;
	
	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> gettAll(){
		return ResponseEntity.ok(cliServ.recuperarTodos());
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Integer id){
		Cliente result = cliServ.recuperarClientePeloId(id);
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/clientes")
	public ResponseEntity<Cliente> insertNew (@RequestBody Cliente novo){
		try {
			Cliente result = cliServ.cadastrarNovoCliente(novo);
			if (result != null) {
				return ResponseEntity.ok(result);
			}
		} catch (Exception ex){
			System.out.println("Erro co cadastrar - "+ ex.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable Integer id){
		cliente.setId(id);
		try {
			
			
			Cliente result = cliServ.alterarCliente(cliente);
			if (result != null) {
				return ResponseEntity.ok(result);
			}
		} catch (Exception ex) {
			System.out.println("Erro ao autalizar - "+ ex.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/clientes/busca")
	public ResponseEntity<List<Cliente>> searchByPhone(@RequestParam(name="telefone") String telefone){
		List<Cliente> result = cliServ.recuperarClientePeloTelefone(telefone);
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.notFound().build(); 
	}
	
	
	
	
}
