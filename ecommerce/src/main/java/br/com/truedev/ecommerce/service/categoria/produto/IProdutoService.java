package br.com.truedev.ecommerce.service.categoria.produto;

import java.util.List;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.model.Produto;

public interface IProdutoService {
	
	public Produto cadastrarNovo (Produto novo);
	public Produto alterarProduto (Produto produto);
	public List<Produto> recuperarTodos();
	public List<Produto> recuperarPorPalavraChave(String palavraChave);
	public Produto recuperarPorId(Integer id);
	public List<Produto> recuperarPorCategoria(Categoria categoria);

}
