package br.com.siscadselecao.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.siscadselecao.model.RegimeTributarioModel;

public interface RegimeTributarioRepository extends JpaRepository<RegimeTributarioModel, Integer>{	//JpaRepository<RegimeTributarioModel, Integer>
}
