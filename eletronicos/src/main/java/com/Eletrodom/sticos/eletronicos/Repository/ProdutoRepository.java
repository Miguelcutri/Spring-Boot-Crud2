package com.Eletrodom.sticos.eletronicos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eletrodom.sticos.eletronicos.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{
	public List<ProdutoModel> findAllByNomeContainingIgnoreCase(String descrição);
}
