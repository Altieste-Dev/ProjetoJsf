package br.com.bean;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
//import javax.faces.model.ListDataModel;

import br.com.DAO.FornecedoresDAO;
import br.com.domain.Fornecedores;
import br.com.util.JSFUtil;

@ManagedBean (name = "MBFornecedores") //Serve para fazer o �link� entre as regras de neg�cio da sua aplica��o com a View
@ViewScoped // mant�m o estado do bean enquanto houver requisi��es da mesma p�gina

public class FornecedoresBean {
	
private Fornecedores fornecedores;
	
	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}
	
	//ITENS
	private ArrayList<Fornecedores>itens;
	
	public ArrayList<Fornecedores> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Fornecedores> itens) {
		this.itens = itens;
	}
	
	//ITENSFILTRADOS
	private ArrayList<Fornecedores>itensFiltrados;
	
	public ArrayList<Fornecedores> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Fornecedores> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	@PostConstruct
	public void prepararPesquisa() {

		try {
			FornecedoresDAO dao = new FornecedoresDAO();	
			itens = dao.listar();
		} catch (Exception e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void prepararNovo () {
		fornecedores = new Fornecedores();
	}
	
	public void novo() {
		try {
			FornecedoresDAO dao = new FornecedoresDAO();
			dao.salvar(fornecedores);
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Fornecedor Cadastrado com Sucesso!");

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
		
	public void editar() {
		try {
			FornecedoresDAO dao = new FornecedoresDAO();
			dao.editar(fornecedores);
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Fornecedor Editado com Sucesso!");

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void excluir() {
		try {
			FornecedoresDAO dao = new FornecedoresDAO();
			dao.excluir(fornecedores);
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Fornecedor Exclu�do com Sucesso!");

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("N�o � possivel excluir um fornecedor com produto associado a ele");
			e.printStackTrace();
		}
	}

}