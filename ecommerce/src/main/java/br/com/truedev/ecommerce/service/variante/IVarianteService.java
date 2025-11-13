package br.com.truedev.ecommerce.service.variante;

import java.util.List;

import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.model.Variante;

public interface IVarianteService {
	public Variante adicionarNova(Variante nova);
	public Variante alterarDados(Variante variante);
	public List<Variante> recuperarPorproduto(Produto produto);
	public Variante recuperarPorId(Integer id);
}
