package br.com.truedev.ecommerce.service.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.truedev.ecommerce.dao.PedidoDAO;
import br.com.truedev.ecommerce.model.ItemPedido;
import br.com.truedev.ecommerce.model.Pedido;

@Component
class PedidoService implements IPedidoService{

	@Autowired
	private PedidoDAO pedidoDao;
	
	@Override
	public Pedido criarNovoPedido(Pedido pedido) {
		for (ItemPedido item: pedido.getItens()) {
			item.setPedido(pedido);
		}
		Double valor = 0.0;
		Double desconto = 0.0;
		Double total = 0.0;
		for (ItemPedido item: pedido.getItens()) {
			total += item.getValorTotal();
		}
		pedido.setValorBruto(total);
		if (total >= 30.00) {
				desconto = total * 0.10;
			}		
		total = total - desconto;
		pedido.setDesconto(desconto);
		pedido.setValorTotal(total);		
		return pedidoDao.save(pedido);
	}

	@Override
	public Pedido alterarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		return pedidoDao.save(pedido);
	}

	@Override
	public List<Pedido> recuperarPedidos() {
		// TODO Auto-generated method stub
		return (List<Pedido>)pedidoDao.findAll();
	}

	@Override
	public Pedido recuperaPeloNumero(Integer numPedido) {
		// TODO Auto-generated method stub
		return pedidoDao.findById(numPedido).orElse(null);
	}

	@Override
	public List<Pedido> recuperarPeloStatus(Integer status) {
		// TODO Auto-generated method stub
		return pedidoDao.findALLByStatus(status);
	}

}
