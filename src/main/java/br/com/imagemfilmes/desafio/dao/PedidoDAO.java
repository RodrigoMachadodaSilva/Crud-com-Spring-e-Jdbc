package br.com.imagemfilmes.desafio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.imagemfilmes.desafio.entity.Pedido;
import br.com.imagemfilmes.desafio.entity.PedidoItem;
import br.com.imagemfilmes.desafio.entity.Pessoa;
import br.com.imagemfilmes.desafio.entity.Produto;

public class PedidoDAO extends DAO {

	public PedidoDAO(final Connection connection) {
		super(connection);
	}

	public List<Pedido> findAll() throws SQLException {

		try (PreparedStatement psmt = getConnection().prepareStatement("SELECT pedido.*, pessoa.*, pedido_item.*,produto.*"
				+ "FROM pedido INNER JOIN pessoa ON pedido.pessoa_id = pessoa.id \r\n"
				+ "INNER JOIN pedido_item ON pedido.pedido_item_id = pedido.id INNER JOIN produto ON  pedido_item.produto_id = produto.registro;")) {
			try (ResultSet rs = psmt.executeQuery()) {
				final List<Pedido> pedidos = buildPedido(rs);
				return pedidos;
			}
		}
	}

	public List<Pedido> findPedidosOrderByValor() throws SQLException {

		try (PreparedStatement psmt = getConnection().prepareStatement("SELECT pedido.*, pessoa.*, pedido_item.*,produto.* FROM pedido INNER JOIN pessoa ON pedido.pessoa_id = pessoa.id \r\n"
				+ "INNER JOIN pedido_item ON pedido.pedido_item_id = pedido.id INNER JOIN produto ON  pedido_item.produto_id = produto.registro order by valor_total;")) {
			try (ResultSet rs = psmt.executeQuery()) {
				final List<Pedido> pedidos = buildPedido(rs);
				return pedidos;
			}
		}
	}

	public List<Pedido> findPedidosbyClienteId(Long ClienteId) throws SQLException {

		try (PreparedStatement psmt = getConnection().prepareStatement("SELECT pedido.*, pessoa.*, pedido_item.*,produto.* FROM pedido INNER JOIN pessoa ON pedido.pessoa_id = pessoa.id \r\n"
				+ "INNER JOIN pedido_item ON pedido.pedido_item_id = pedido.id INNER JOIN produto ON  pedido_item.produto_id = produto.registro WHERE pessoa_id = ?;")) {
			psmt.setLong(1, ClienteId);
			try (ResultSet rs = psmt.executeQuery()) {
				final List<Pedido> pedidos = buildPedido(rs);
				return pedidos;
			}

		}
	}

	private List<Pedido> buildPedido(ResultSet rs) throws SQLException {
		final List<Pedido> pedidos = new ArrayList<>();

		while (rs.next()) {
			final List<PedidoItem> pedidoitens = new ArrayList<>();
			
			final Produto produto = new Produto()
					.setRegistro(rs.getInt("registro"))
					.setDescricao(rs.getString("descricao"))
					.setValorUnitario(rs.getBigDecimal("valor_unitario"));
			
			

			
			final PedidoItem pedidoItem = new PedidoItem()
					.setId(rs.getLong("produto_id"))
					.setQuantidade(rs.getInt("quantidade"))
					.setPrecoTotal(rs.getBigDecimal("preco_total"))
					.setProduto(produto);

			
			pedidoitens.add(pedidoItem);

			final Pessoa pessoa = new Pessoa()
					.setId(rs.getLong("pessoa_id"))
					.setNome(rs.getString("nome"))
					.setCpf(rs.getString("cpf"));
			

			final Pedido pedido = new Pedido()
					.setId(rs.getLong("id"))
					.setItens(pedidoitens)
					.setPessoa(pessoa)
					.setValorTotal(rs.getBigDecimal("valor_total"));

			pedidos.add(pedido);
		}
		return pedidos;
	}

}
