package com.Eletrodom.sticos.eletronicos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eletrodom.sticos.eletronicos.model.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long > {
	public List<CategoriaModel> findAllByDescriçãoContainingIgnoreCase (String descrição);
}
