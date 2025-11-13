package br.com.truedev.ecommerce.service.variante;

import java.util.List;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.truedev.ecommerce.dao.VarianteDAO;
import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.model.Variante;

@Component
public class VarianteService implements IVarianteService{

	@Autowired
	private VarianteDAO varDao;
	
	@Override
	public Variante adicionarNova(Variante nova) {
		// TODO Auto-generated method stub
		return varDao.save(nova);
	}

	@Override
	public Variante alterarDados(Variante variante) {
		// TODO Auto-generated method stub
		return varDao.save(variante);
	}

	@Override
	public List<Variante> recuperarPorproduto(Produto produto) {
		// TODO Auto-generated method stub
		return varDao.findByProduto(produto);
	}

	@Override
	public Variante recuperarPorId(Integer id) {
		// TODO Auto-generated method stub
		return varDao.findById(id).orElse(null);
	}

}
