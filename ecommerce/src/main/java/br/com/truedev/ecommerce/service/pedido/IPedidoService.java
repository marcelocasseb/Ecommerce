package br.com.truedev.ecommerce.service.pedido;

import java.util.List;

import br.com.truedev.ecommerce.model.Pedido;

public interface IPedidoService {
	
	public Pedido criarNovoPedido(Pedido pedido);
	
	public Pedido alterarPedido(Pedido pedido);
	
	public List<Pedido> recuperarPedidos();
	
	public Pedido recuperaPeloNumero(Integer numPedido);
	
	public List<Pedido> recuperarPeloStatus(Integer status);
	

}
