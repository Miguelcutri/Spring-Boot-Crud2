package com.Eletrodom.sticos.eletronicos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Eletrodom.sticos.eletronicos.Repository.TipoEletroRepository;
import com.Eletrodom.sticos.eletronicos.model.TipoEletroModel;


@RestController
@RequestMapping("/TipoEletro")
@CrossOrigin("*")
public class TipoEletroController {
	
	@Autowired
	private TipoEletroRepository repository;
	
	@GetMapping
	public ResponseEntity<List<TipoEletroModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoEletroModel> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descrição/{descrição}")
	public ResponseEntity<List<TipoEletroModel>> GetByDescrição(@PathVariable String descrição){
		return ResponseEntity.ok(repository.findAllByDescriçãoContainingIgnoreCase(descrição));
	}
	
	@PostMapping
	public ResponseEntity<TipoEletroModel> TipoEletro(@RequestBody TipoEletroModel TipoEletro){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(TipoEletro));
	}
	@PutMapping
	public ResponseEntity<TipoEletroModel> put (@RequestBody TipoEletroModel TipoEletro){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(TipoEletro));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
	

}
