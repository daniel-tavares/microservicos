package br.com.usuario.response;

import org.springframework.stereotype.Component;

@Component
public class ResponseException{

	protected int status;
	protected String title;
	protected String message;
	protected long  timestamp;
	protected String developerMessage;
	
	

	public ResponseException title(String title) {
		this.title = title;
		return this;
	}

	public ResponseException status(int status) {
		this.status = status;
		return this;
	}

	public ResponseException message(String message) {
		this.message = message;
		return this;
	}

	public ResponseException timestamp(long timestamp) {
		this.timestamp = timestamp;
		return this;
	}
	

	public ResponseException developerMessage(String developerMessage) {
		this.developerMessage = developerMessage;
		return this;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
	
	

}