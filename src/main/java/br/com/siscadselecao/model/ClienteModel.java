package br.com.siscadselecao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "cliente")
public class ClienteModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 45, unique = true)	
	@NotBlank(message = "Obrigatório")
	//@CNPJ(message = "Inválido")
	private String cnpj;
	
	@Column(nullable = false, length = 150)
	@NotBlank(message = "Obrigatório")
	private String razaoSocial;
	
	@Column(nullable = false, length = 150)
	@Email(message = "Inválido")
	private String email;
	
		
	@ManyToOne
	@NotNull(message = "Obrigatório")
	private RegimeTributarioModel regimeTributario;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public RegimeTributarioModel getRegimeTributario() {
		return regimeTributario;
	}
	public void setRegimeTributario(RegimeTributarioModel regimeTributario) {
		this.regimeTributario = regimeTributario;
	}
	
}
