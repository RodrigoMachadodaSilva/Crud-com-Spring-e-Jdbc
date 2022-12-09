package br.com.imagemfilmes.desafio.service;

import br.com.imagemfilmes.desafio.dao.PessoaDAO;
import br.com.imagemfilmes.desafio.entity.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    DataSource dataSource;

    public List<Pessoa> getPessoas() throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            return new PessoaDAO(connection).findAll();
        }
    }
    
    public List<Pessoa> getPessoasPorNome() throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            return new PessoaDAO(connection).findByAZ();
        }
    }
    
    public Pessoa getPessoaPorId( Long clienteId) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            return new PessoaDAO(connection).findById(clienteId);
        }
    }
    	
    

}
