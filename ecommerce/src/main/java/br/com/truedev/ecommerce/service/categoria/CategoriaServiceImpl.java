package br.com.truedev.ecommerce.service.categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.truedev.ecommerce.dao.CategoriaDAO;
import br.com.truedev.ecommerce.model.Categoria;

@Component
public class CategoriaServiceImpl  implements ICategoriaService{

	@Autowired
	private CategoriaDAO catDAO;

	@Override
	public Categoria CadastrarNovaCategoria(Categoria novo) {
		// TODO Auto-generated method stub
		return catDAO.save(novo);
	}

	@Override
	public Categoria AlterarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return catDAO.save(categoria);
	}

	@Override
	public List<Categoria> RecuperarTodasCategorias() {
		// TODO Auto-generated method stub
		return (List<Categoria>)catDAO.findAll();
	}

	@Override
	public void ApagarCategoria(Integer id) {
		// TODO Auto-generated method stub
		 catDAO.deleteById(id);
	}

	@Override
	public Categoria RecuperarByID(Integer id) {
		// TODO Auto-generated method stub
		return catDAO.findById(id).orElse(null);
	}
	
}
