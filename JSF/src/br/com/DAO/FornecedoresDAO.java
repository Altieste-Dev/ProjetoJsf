package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.domain.Fornecedores;
import br.com.factory.ConnectionFactory;

public class FornecedoresDAO {

	public void salvar(Fornecedores fornecedor) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores ");
		sql.append("(descricao, telefone, email) ");
		sql.append("VALUES (?, ?, ?) ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		stmt.setString(1, fornecedor.getDescricao());
		stmt.setString(2, fornecedor.getTelefone());
		stmt.setString(3, fornecedor.getEmail());

		stmt.executeUpdate();

	}	
	public void excluir(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		stmt.setInt(1, f.getCodigo());

		stmt.executeUpdate();

	}
	
	public void editar(Fornecedores f) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fornecedores ");
		sql.append("SET descricao = ? , telefone = ?, email = ?");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		stmt.setString(1, f.getDescricao());
		stmt.setString(2, f.getTelefone());
		stmt.setString(3, f.getEmail());
		stmt.setInt(4, f.getCodigo());

		stmt.executeUpdate();
	}
	
	public Fornecedores buscaporcodigo(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		stmt.setInt(1, f.getCodigo());

		ResultSet resultado = stmt.executeQuery();
		Fornecedores retorno = null;

		if (resultado.next()) {

			retorno = new Fornecedores();
			retorno.setCodigo(resultado.getInt("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));

		}

		return retorno;

	}
	
	public ArrayList<Fornecedores> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao, telefone, email ");
		sql.append("FROM fornecedores ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		ResultSet resultado = stmt.executeQuery();

		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();

		while (resultado.next()) {
			Fornecedores f = new Fornecedores();
			f.setCodigo(resultado.getInt("codigo"));
			f.setDescricao(resultado.getString("descricao"));
			f.setTelefone(resultado.getString("telefone"));
			f.setEmail(resultado.getString("email"));
			
			lista.add(f);
		}
		return lista;

	}
	
	public ArrayList<Fornecedores> buscarPorDescricao(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = ConnectionFactory.conectar();

		PreparedStatement stmt = conexao.prepareStatement(sql.toString());

		stmt.setString(1, "%" + f.getDescricao() + "%");

		ResultSet resultado = stmt.executeQuery();

		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();

		while (resultado.next()) {
			Fornecedores item = new Fornecedores();
			item.setCodigo(resultado.getInt("codigo"));
			item.setDescricao(resultado.getString("descricao"));

			lista.add(item);
		}
		return lista;

	}

	public Fornecedores buscaPorCodigoFornecedor(int codigoFornecedor) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConnectionFactory.conectar();
		PreparedStatement stmt = conexao.prepareStatement(sql.toString());
		Fornecedores retorno = null;
		
		try {
			stmt.setInt(1, codigoFornecedor);
	
			ResultSet resultado = stmt.executeQuery();
			
			
	
			if (resultado.next()) {
	
				retorno = new Fornecedores();
				retorno.setCodigo(resultado.getInt("codigo"));
				retorno.setDescricao(resultado.getString("descricao"));
				
			}
		} catch (SQLException ex) {
			System.out.println(" Erro ao consultar fornecedor. Codigo: " + codigoFornecedor + " .Causa: " + ex.getMessage());
		}

		return retorno;
	}
}