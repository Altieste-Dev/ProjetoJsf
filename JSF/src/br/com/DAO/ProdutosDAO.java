package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.domain.Fornecedores;
import br.com.domain.Produtos;
import br.com.factory.ConnectionFactory;

public class ProdutosDAO {

	public void salvar(Produtos produtos) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO produtos ");
		sql.append("(descricao, valor, quantidade, fornecedores_codigo) ");
		sql.append("VALUES (?,?,?,?) ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.setString(1, produtos.getDescricao());
		stmt.setDouble(2, produtos.getValor());
		stmt.setLong(3, produtos.getQuantidade());
		stmt.setInt(4, produtos.getFornecedor().getCodigo());

		stmt.executeUpdate();

	}
	
	public void excluir(Produtos produtos) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM produtos ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		stmt.setInt(1, produtos.getCodigo());

		stmt.executeUpdate();

	}
	
	public void editar(Produtos produtos) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE produtos ");
		sql.append("SET descricao = ?,  valor = ? , quantidade = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		stmt.setString(1, produtos.getDescricao());
		stmt.setDouble(2, produtos.getValor());
		stmt.setLong(3, produtos.getQuantidade());
		
		stmt.setInt(4, produtos.getCodigo());

		stmt.executeUpdate();

	}
	
	public Produtos buscaporcodigo(Produtos produtos) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao, valor, quantidade, fornecedores_codigo ");
		sql.append("FROM produtos ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		stmt.setInt(1, produtos.getCodigo());

		ResultSet resultado = stmt.executeQuery();
		Produtos retorno = null;

		if (resultado.next()) {

			retorno = new Produtos();
			retorno.setCodigo(resultado.getInt("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
			retorno.setValor(resultado.getDouble("valor"));
			retorno.setQuantidade(resultado.getLong("quantidade"));
			
			FornecedoresDAO fornecdoresDAO = new FornecedoresDAO();
			Fornecedores fornecedoresDOMAIN = fornecdoresDAO.buscaPorCodigoFornecedor(resultado.getInt("fornecedores_codigo"));
			retorno.setFornecedor(fornecedoresDOMAIN);

		}

		return retorno;

	}
	
	public ArrayList<Produtos> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao, valor, quantidade, fornecedores_codigo ");
		sql.append("FROM produtos ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		ResultSet resultado = stmt.executeQuery();

		ArrayList<Produtos> lista = new ArrayList<Produtos>();

		while (resultado.next()) {
			Produtos retorno = new Produtos();
			retorno.setCodigo(resultado.getInt("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
			retorno.setValor(resultado.getDouble("valor"));
			retorno.setQuantidade(resultado.getLong("quantidade"));
			
			FornecedoresDAO fornecedoresDAO = new FornecedoresDAO();
			Fornecedores fornecedoresDOMAIN = fornecedoresDAO.buscaPorCodigoFornecedor(resultado.getInt("fornecedores_codigo"));
			retorno.setFornecedor(fornecedoresDOMAIN);
		
			lista.add(retorno);
		}
		return lista;

	}
	
}
