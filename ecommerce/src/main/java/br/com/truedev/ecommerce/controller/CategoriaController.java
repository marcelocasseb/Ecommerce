package br.com.truedev.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.service.categoria.ICategoriaService;

@RestController
public class CategoriaController {
	
	@Autowired
	private ICategoriaService catServ;
	
	@GetMapping("/categoria")
	public ResponseEntity<List<Categoria>> getall(){
		return ResponseEntity.ok(catServ.RecuperarTodasCategorias());
	}
	
	@GetMapping("/categoria/{id}")
	public ResponseEntity<Categoria> getByID(@PathVariable Integer id){
		Categoria result = catServ.RecuperarByID(id);
		if (result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/categoria")
	public ResponseEntity<Categoria>InserirCategoria(@RequestBody Categoria novo){
		try {
			Categoria result = catServ.CadastrarNovaCategoria(novo);
			if(result != null) {
				return ResponseEntity.ok(result);
			}
		} catch (Exception ex){
			System.out.println("Erro co cadastrar - "+ ex.getMessage());
		}
		return ResponseEntity.badRequest().build();	
		}

	@PutMapping("/categoria/{id}")
	public ResponseEntity<Categoria>AlterarCategoria(@RequestBody Categoria categoria, @PathVariable Integer id){
		categoria.setId(id);
		try {
			Categoria result = catServ.AlterarCategoria(categoria);
			if (result != null) {
				return ResponseEntity.ok(categoria);}
			}catch(Exception ex) {
				System.out.println("Erro co cadastrar - "+ ex.getMessage());
			}
			return ResponseEntity.badRequest().build();
		}
			
	@DeleteMapping("/categoria/{id}")
	public ResponseEntity<?>Delete (@PathVariable Integer id)
	{
		 catServ.ApagarCategoria(id);
		 return ResponseEntity.ok("Removido");
	}
			
		
	
	

}
