package br.com.truedev.ecommerce.service.categoria;



import java.util.List;

import br.com.truedev.ecommerce.model.Categoria;

public interface ICategoriaService {
	
	public Categoria CadastrarNovaCategoria(Categoria novo);
	public Categoria AlterarCategoria(Categoria categoria);
	public List<Categoria> RecuperarTodasCategorias();
	public void ApagarCategoria(Integer id);
	public Categoria RecuperarByID(Integer id);
	
}
