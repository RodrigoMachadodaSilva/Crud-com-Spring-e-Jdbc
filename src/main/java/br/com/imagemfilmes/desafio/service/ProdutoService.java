package br.com.imagemfilmes.desafio.service;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.imagemfilmes.desafio.dao.ProdutoDAO;
import br.com.imagemfilmes.desafio.entity.Produto;

@Service
public class ProdutoService {

	@Autowired
	DataSource dataSource;
	

	public List<Produto> getProdutos() throws Exception {
		try (Connection connection = dataSource.getConnection()) {
			return new ProdutoDAO(connection).findAll();
		}
	}

	public List<Produto> getProdutosPorPreco() throws Exception {
		try (Connection connection = dataSource.getConnection()) {
			return new ProdutoDAO(connection).findAllByPreco();
		}

	}

}

