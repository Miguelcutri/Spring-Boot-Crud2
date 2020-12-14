package com.Eletrodom.sticos.eletronicos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Categoria")
public class CategoriaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String descrição;
	
	@OneToMany(mappedBy = "Categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("Categoria")
	private List<ProdutoModel> Produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public List<ProdutoModel> getProduto() {
		return Produto;
	}

	public void setProduto(List<ProdutoModel> produto) {
		Produto = produto;
	}
	
	

	
	
	

}
