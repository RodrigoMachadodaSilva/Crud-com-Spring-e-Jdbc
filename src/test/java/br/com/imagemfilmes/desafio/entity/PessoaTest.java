package br.com.imagemfilmes.desafio.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.imagemfilmes.desafio.dao.PessoaDAO;

@SpringBootTest
@WebAppConfiguration
class PessoaTest {
	
	private Long id;
	
	private String cpf;
	
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	public PessoaTest(Long id, String cpf, String nome) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
	}
	

	@Autowired
	private PessoaDAO pessoaDAO;

	@Test
	public void findByIdTest() throws Exception {
		Pessoa pessoa = pessoaDAO.findById(1L);
		assertEquals(1, pessoa.getId());
		assertEquals("56637927082", pessoa.getCpf());
		assertEquals("Pessoa1", pessoa.getNome());

	}

	@Test
	public void testToString() {
		Assertions.assertEquals("Pessoa{id=666, cpf='0123456789', nome='Pessoa Teste'}", new Pessoa());
	}
	
	@Test
	public void findAllTeste () throws Exception {
		List<Pessoa> pessoa = pessoaDAO.findAll();
		List<PessoaTest> pessoaTeste = new ArrayList<>();
		PessoaTest p1 = new PessoaTest((long) 1,"56637927082","Pessoa 1");
		PessoaTest p2 = new PessoaTest((long) 2,"56637927082","Pessoa 2");
		PessoaTest p3 = new PessoaTest((long) 3,"56637927089","Admir");
		pessoaTeste.add(p1);
		pessoaTeste.add(p2);
		pessoaTeste.add(p3);
		assertIterableEquals(pessoa, pessoaTeste);
		
		
	}
	

}