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

import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.model.Variante;
import br.com.truedev.ecommerce.service.variante.IVarianteService;

@RestController
public class VarianteController {
	
	@Autowired
	private IVarianteService Iserv;
	
	@PostMapping("/variantes")
	public ResponseEntity<Variante> Adicionar(@RequestBody Variante variante){
		Variante v = Iserv.adicionarNova(variante);
		if (v != null)
			return ResponseEntity.ok(v);
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/variantes/{id}")
	public ResponseEntity<Variante> Alterar (@RequestBody Variante variante, @PathVariable Integer id){
		variante.setId(id);
		Variante v = Iserv.alterarDados(variante);
		if (v != null)
			return ResponseEntity.ok(v);
		return ResponseEntity.badRequest().build();
		
	}
	
	@GetMapping("/variantes/{id}")
	public ResponseEntity<Variante> BuscarporId (@PathVariable Integer id){
		Variante v = Iserv.recuperarPorId(id);
		if (v != null)
			return ResponseEntity.ok(v);
		return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping("/variantes")
	public ResponseEntity<List<Variante>> recuperarPeloProduto(@RequestParam(name = "idproduto") Integer idproduto){
		Produto p = new Produto();
		p.setId(idproduto);
		return ResponseEntity.ok(Iserv.recuperarPorproduto(p));
	}

}
