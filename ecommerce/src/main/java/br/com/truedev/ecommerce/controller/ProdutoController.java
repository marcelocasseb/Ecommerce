package br.com.truedev.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.service.categoria.produto.IProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	private IProdutoService prodServ;
	
	@GetMapping("/produtos")
	public ResponseEntity<List<Produto>>RecuperarTodos(){
			return ResponseEntity.ok(prodServ.recuperarTodos());
	}		

	@PostMapping("/produtos")
	public ResponseEntity<Produto> incluirNovo(@RequestBody Produto novo){
		Produto result = prodServ.cadastrarNovo(novo);
		if (result != null)
			return ResponseEntity.status(201).body(result);
		else 
			return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/produtos/{id}")
	public ResponseEntity<Produto> RcuperarById(@PathVariable Integer id){
		Produto result = prodServ.recuperarPorId(id);
		if(result != null)
			return ResponseEntity.ok(result);
		else
			return ResponseEntity.notFound().build();
	}	
	
	@GetMapping("/produtos/search")
	public ResponseEntity<List<Produto>> RecuperarPorPalavrachave(@RequestParam(name = "Key")String key){
		List<Produto> lista = prodServ.recuperarPorPalavraChave(key);
		if(lista.size() > 0)
			return ResponseEntity.ok(lista);
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("produtos/categoria/{id}")
	public ResponseEntity<List<Produto>> RecuperarPorCategoria(@PathVariable Integer id){
		Categoria cat = new Categoria();
		cat.setId(id);
		return ResponseEntity.ok(prodServ.recuperarPorCategoria(cat));
	}
	
			
}
	
	
	
	
