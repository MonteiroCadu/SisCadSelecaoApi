package br.com.siscadselecao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.siscadselecao.model.ClienteModel;
import br.com.siscadselecao.service.ClienteService;

@RestController
@RequestMapping(value ="/rest/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value = "/list")
	public ResponseEntity<Page<ClienteModel>> list(Pageable page) {
		
		return clienteService.list(page);
	}
	
	@GetMapping(value = "/find/{id}")
	public ClienteModel find(@PathVariable("id") Integer id) {		
		 
		return clienteService.find(id);
	}
	@GetMapping(value = "/findByCnpj/{cnpj}")
	public ClienteModel find(@PathVariable("cnpj") String cnpj) {		
		 
		return clienteService.find(cnpj);
	}
	
	@GetMapping(value = "/search/{razaoSocial}")
	@ResponseBody
	public ResponseEntity<List<ClienteModel>> search(@PathVariable("razaoSocial") String razaoSocial) {		
		 
		try {
			List<ClienteModel> listaCliente = clienteService.seachByRazaoSocial(razaoSocial);
			return new ResponseEntity<List<ClienteModel>>(listaCliente,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<ClienteModel>>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping(value = "/save")
	@CrossOrigin(origins = "http://localhost:3000")
	public ClienteModel save(@Valid @RequestBody ClienteModel cliente) {	
		
		return clienteService.save(cliente);
	}
	
	@PostMapping(value = "/update")
	@ResponseBody
	public ResponseEntity<ClienteModel> update(@Valid @RequestBody ClienteModel cliente) {	
		
		return new ResponseEntity<ClienteModel>(cliente,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {	
		
		 clienteService.delete(id);
	}
	 
	
	
}
