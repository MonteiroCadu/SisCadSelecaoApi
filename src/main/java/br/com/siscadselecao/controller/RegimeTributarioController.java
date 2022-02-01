package br.com.siscadselecao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.siscadselecao.model.RegimeTributarioModel;
import br.com.siscadselecao.repository.RegimeTributarioRepository;

@RestController
@RequestMapping(value = "/rest/regime-tributario")
public class RegimeTributarioController {
	
	@Autowired
	private RegimeTributarioRepository repositorio;
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<RegimeTributarioModel>> list() {
		
		List<RegimeTributarioModel> result = repositorio.findAll();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/find/{id}")
	public Optional<RegimeTributarioModel> find(@PathVariable("id") Integer id) {		
		 
		return repositorio.findById(id);
	}
	
	@PostMapping(value = "/save")
	public RegimeTributarioModel save(@RequestBody RegimeTributarioModel regime) {	
		
		return repositorio.save(regime);
	}
}
