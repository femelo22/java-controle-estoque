package lf.melo.com.controllers.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String error;
	private Integer status;
	private String message;
	private LocalDateTime date;
	private String path;
	

	public StandardError() {
		super();
	}
	
	public StandardError(LocalDateTime date, Integer status, String error, String message, String path) {
		super();
		this.error = error;
		this.status = status;
		this.message = message;
		this.date = date;
		this.path = path;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
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

}
