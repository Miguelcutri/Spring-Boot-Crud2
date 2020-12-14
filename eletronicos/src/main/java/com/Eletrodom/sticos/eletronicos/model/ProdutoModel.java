package com.Eletrodom.sticos.eletronicos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Produto")
public class ProdutoModel {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=4, max= 16)
	private String nome;
	
	@NotNull
	private double preço;
	
	@NotNull
	private double quantidade;
	
	@NotNull
	private String marca;
	
	@ManyToOne
	@JsonIgnoreProperties("Produto")
	private TipoEletroModel TipoEletro;
	
	@ManyToOne
	@JsonIgnoreProperties("Produto")
	private CategoriaModel Categoria;
	

}
