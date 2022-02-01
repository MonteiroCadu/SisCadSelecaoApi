package br.com.siscadselecao.service.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandartError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Instant timestemp;
	private String status;
	private String error;
	
	public StandartError() {
		
	}
	
	public Instant getTimestemp() {
		return timestemp;
	}
	public void setTimestemp(Instant timestemp) {
		this.timestemp = timestemp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	private String message;
	private String path;
	
	
}
