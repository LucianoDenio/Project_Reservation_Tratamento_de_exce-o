package model.exceptions;

public class DomainExceptions extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DomainExceptions(String msg) {
		super(msg); // aqui sera passado a mensagem para o construtor da super classe, isso serve para poder instanciar a Exceção personalizada passando uma mensagem para ela.
	}

}
