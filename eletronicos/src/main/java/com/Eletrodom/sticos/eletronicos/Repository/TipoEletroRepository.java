package com.Eletrodom.sticos.eletronicos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Eletrodom.sticos.eletronicos.model.TipoEletroModel;

@Repository
public interface TipoEletroRepository extends JpaRepository<TipoEletroModel, Long> {
	public List<TipoEletroModel> findAllByDescriçãoContainingIgnoreCase(String descrição);
}
