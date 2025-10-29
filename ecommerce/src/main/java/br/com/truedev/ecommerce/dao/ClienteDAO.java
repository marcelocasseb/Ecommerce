package br.com.truedev.ecommerce.dao;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.truedev.ecommerce.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer>{
	
	public List<Cliente> findByTelefone(String telefone);

}
