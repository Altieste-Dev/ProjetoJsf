package br.com.domain;

public class Produtos {
	
	private int codigo;
	private String descricao;
	private Double valor;
	private Long quantidade;
	private Fornecedores fornecedor = new Fornecedores();


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Fornecedores getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedores fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		String saida = codigo + " - " + descricao + " - " + valor + " - " + quantidade + " - " + fornecedor.getDescricao();
		return saida;
	}
	
}
