package br.com.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.DAO.FornecedoresDAO;
import br.com.DAO.ProdutosDAO;
import br.com.util.JSFUtil;
import br.com.domain.Fornecedores;
import br.com.domain.Produtos;

@ManagedBean (name = "MBProdutos")
@ViewScoped 
public class ProdutosBean {
		
	//COMBOFORNECEDORES
	private ArrayList<Fornecedores>comboFornecedores;
	
	public ArrayList<Fornecedores> getComboFornecedores() {
		return comboFornecedores;
	}
	
	public void setComboFornecedores(ArrayList<Fornecedores> comboFornecedores) {
		this.comboFornecedores = comboFornecedores;
	}

	private Produtos produtos;
	
	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}
	
	//ITENS
	private ArrayList<Produtos>itens;
	
	public ArrayList<Produtos> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produtos> itens) {
		this.itens = itens;
	}
	
	//ITENSFILTRADOS
	private ArrayList<Produtos>itensFiltrados;
	
	public ArrayList<Produtos> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Produtos> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	@PostConstruct
	public void prepararPesquisa() {

		try {
			ProdutosDAO dao = new ProdutosDAO();	
			ArrayList<Produtos>lista = dao.listar();
			itens = new ArrayList<Produtos>(lista);				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void prepararNovo () {
		try {
			
			produtos = new Produtos();
			
			FornecedoresDAO dao = new FornecedoresDAO();
			comboFornecedores = dao.listar();
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");			
			e.printStackTrace();
		}
	}
	
	public void novo() {
		try {
			ProdutosDAO dao = new ProdutosDAO();
			dao.salvar(produtos);
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Produto Cadastrado com Sucesso!");

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
		
	public void editar() {
		try {
			ProdutosDAO dao = new ProdutosDAO();
			dao.editar(produtos);
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Produto Editado com Sucesso!");

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void excluir() {
		try {
			ProdutosDAO dao = new ProdutosDAO();
			dao.excluir(produtos);
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Produto Excluído com Sucesso!");

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}

}