package br.com.siscadselecao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.siscadselecao.model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel,Integer>{
	@Query("SELECT obj FROM ClienteModel obj where obj.razaoSocial like %:razaoSocial%")
	public Optional< List<ClienteModel>> seachByRazaoSocial(String razaoSocial);
	
	@Query("SELECT obj FROM ClienteModel obj where obj.cnpj = :cnpj")
	public Optional<ClienteModel> finByCnpj(String cnpj);
}
