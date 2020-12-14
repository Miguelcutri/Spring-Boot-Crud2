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

import com.Eletrodom.sticos.eletronicos.Repository.CategoriaRepository;
import com.Eletrodom.sticos.eletronicos.model.CategoriaModel;


public class CategoriaController {
	@RestController
	@RequestMapping("/Categoria")
	@CrossOrigin("*")
	public class AlunosController {
		@Autowired
		private CategoriaRepository repository;
		
		@GetMapping
		public ResponseEntity<List<CategoriaModel>> GetAll(){
			return ResponseEntity.ok(repository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<CategoriaModel> GetById(@PathVariable long id){
			return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/descrição/{descrição}")
		public ResponseEntity<List<CategoriaModel>> GetByDescrição(@PathVariable String descrição){
			return ResponseEntity.ok(repository.findAllByDescriçãoContainingIgnoreCase(descrição));
		}
		
		@PostMapping
		public ResponseEntity<CategoriaModel> Categoria(@RequestBody CategoriaModel Categoria){
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Categoria));
		}
		@PutMapping
		public ResponseEntity<CategoriaModel> put (@RequestBody CategoriaModel Categoria){
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(Categoria));
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable long id) {
			repository.deleteById(id);
		}
}
}
