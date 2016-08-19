package org.gvaireth.goeuro.server;

public class InvalidFileException extends RuntimeException {

	public InvalidFileException(String msg) {
		super("file problem: " + msg);
	}

	private static final long serialVersionUID = 1L;

}
