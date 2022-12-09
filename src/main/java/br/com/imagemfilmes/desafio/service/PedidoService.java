package br.com.imagemfilmes.desafio.service;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.imagemfilmes.desafio.Exception.ClienteNaoEncontradoException;
import br.com.imagemfilmes.desafio.dao.PedidoDAO;
import br.com.imagemfilmes.desafio.entity.Pedido;
import br.com.imagemfilmes.desafio.entity.Pessoa;

@Service
public class PedidoService {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	public PessoaService pessoaService;
	


	public List<Pedido> getPedidos() throws Exception {
		try (Connection connection = dataSource.getConnection()) {
			return new PedidoDAO(connection).findAll();
		}
	}
	
	public List<Pedido> getPedidosPorCliente(Long idCliente) throws Exception {
		Pessoa cliente = pessoaService.getPessoaPorId(idCliente);
		if(cliente != null) {
			Connection connection = dataSource.getConnection();
				return new PedidoDAO(connection).findPedidosbyClienteId(idCliente);
			
			}throw new ClienteNaoEncontradoException(idCliente);
			
	}
	
	public List<Pedido> getPedidosPorValor() throws Exception {
		try (Connection connection = dataSource.getConnection()) {
			return new PedidoDAO(connection).findPedidosOrderByValor();
		}
	}


}
	
	
	

    
