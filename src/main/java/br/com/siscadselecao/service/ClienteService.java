package br.com.siscadselecao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.siscadselecao.model.ClienteModel;
import br.com.siscadselecao.repository.ClienteRepository;
import br.com.siscadselecao.service.exceptions.EntityNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repositorio;
	
	
	public ResponseEntity<Page<ClienteModel>> list(Pageable page) {
		Page<ClienteModel> result = repositorio.findAll(page);
		return ResponseEntity.ok(result);
	}
	
	
	public ClienteModel find(Integer id) {		
		 
		return repositorio.findById(id).orElseThrow(
				()-> new EntityNotFoundException("Cliente não encontrado, id: " + id));
	}
	
	public ClienteModel find(String cnpj) {		
		 
		return repositorio.finByCnpj(cnpj).orElseThrow(
				()-> new EntityNotFoundException("Cliente não encontrado, CNPJ: " + cnpj));
	}
	
	public List<ClienteModel> seachByRazaoSocial(String razaoSocial) {		
		 
		return repositorio.seachByRazaoSocial(razaoSocial).orElseThrow(
				()-> new EntityNotFoundException("Nada foi encontrado"));
	}
	
	
	public ClienteModel save(ClienteModel cliente) {	
		
		//java.sql.SQLIntegrityConstraintViolationException
		try {
			 repositorio.save(cliente);
		} catch (Exception e) {
			
		}
		return cliente;
	}
	
	
	public ClienteModel update( ClienteModel cliente) {	
		
		ClienteModel updatede = repositorio.findById(cliente.getId()).orElseThrow(
				()-> new EntityNotFoundException("Cliente não encontrado, id: "+cliente.getId()));
		
		updatede.setCnpj(cliente.getCnpj());
		updatede.setRazaoSocial(cliente.getRazaoSocial());
		updatede.setEmail(cliente.getEmail());
		updatede.setRegimeTributario(cliente.getRegimeTributario());
		repositorio.save(updatede);
		
		return updatede;
	}
	
	
	
	public void delete(@PathVariable("id") Integer id) {			 		
		repositorio.findById(id).orElseThrow(
				()-> new EntityNotFoundException("Cliente não encontrado, id: "+id));
		repositorio.deleteById(id);
	}
}
