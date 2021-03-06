package br.com.usuario.exceptions;

public class ResourceFoundException extends RuntimeException {

	private Long resourceId;

	public ResourceFoundException(Long resourceId, String message) {
		super(message);
		this.resourceId = resourceId;
	}

}