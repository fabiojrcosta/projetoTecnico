package com.fabiojr.projetoTecnico.dto;

import java.io.Serializable;

import com.fabiojr.projetoTecnico.domain.Produto;

public class ProdutoDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String fornecedor;
	private Double preco;
	
	public ProdutoDTO() {
	
	}
	
	public ProdutoDTO (Produto obj) {
		id = obj.getId();
		nome = obj.getNome();
		fornecedor = obj.getFornecedor();
		preco = obj.getPreco();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	

}
