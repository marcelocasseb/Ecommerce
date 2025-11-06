package br.com.truedev.ecommerce.service.categoria.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.truedev.ecommerce.dao.ProdutoDAO;
import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.model.Produto;

@Component
public class ProdutoService implements IProdutoService {

	@Autowired
	private ProdutoDAO prodDao;	
	
	@Override
	public Produto cadastrarNovo(Produto novo) {
		// TODO Auto-generated method stub
		return prodDao.save(novo);
	}

	@Override
	public Produto alterarProduto(Produto produto) {
		// TODO Auto-generated method stub
		return prodDao.save(produto);
	}

	@Override
	public List<Produto> recuperarTodos() {
		// TODO Auto-generated method stub
		return prodDao.findByOrderByNomeAsc();
	}

	@Override
	public List<Produto> recuperarPorPalavraChave(String palavraChave) {
		// TODO Auto-generated method stub
		return prodDao.findByNomeContaining(palavraChave);
	}

	@Override
	public Produto recuperarPorId(Integer id) {
		// TODO Auto-generated method stub
		return prodDao.findById(id).orElse(null);
	}

	@Override
	public List<Produto> recuperarPorCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return prodDao.findByCategoriasContaining(categoria);
	}

}
