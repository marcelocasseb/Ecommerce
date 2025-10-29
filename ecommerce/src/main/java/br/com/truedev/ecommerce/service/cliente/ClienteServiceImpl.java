package br.com.truedev.ecommerce.service.cliente;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.truedev.ecommerce.dao.ClienteDAO;
import br.com.truedev.ecommerce.model.Cliente;

@Component
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private ClienteDAO cliDao;

	@Override
	public Cliente cadastrarNovoCliente(Cliente novo) {
		// TODO Auto-generated method stub
		return cliDao.save(novo);
	}

	@Override
	public Cliente alterarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return cliDao.save(cliente);
	}

	@Override
	public Cliente recuperarClientePeloId(Integer id) {
		// TODO Auto-generated method stub
		return cliDao.findById(id).orElse(null);
	}

	@Override
	public List<Cliente> recuperarClientePeloTelefone(String telefone) {
		// TODO Auto-generated method stub
		return (List<Cliente>)cliDao.findByTelefone(telefone);
	}

	@Override
	public List<Cliente> recuperarTodos() {
		// TODO Auto-generated method stub
		return (List<Cliente>)cliDao.findAll();
	}

}
