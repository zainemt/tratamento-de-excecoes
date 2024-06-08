package model.exceptions;

public class DomainException extends Exception {

	//O NOME DOMAIN SE DÁ POR CONTA DA EXCEÇÃO SER LANÇADA POR UMA ENTIDADE DE DOMÍNIO (CONVENÇÃO)
		//CLASSES PARA A CRIAÇÃO DE EXCEÇÕES PERSONALIZADAS, SEGUE COM O EXCEPTION NO NOME (CONVENÇÃO)
	
	//a herança pode ser feita de duas maneiras - a partir da classe "Exception" - sendo obrigatório o tratamento
		//a partir da classe "RuntimeException" - não sendo obrigatório o tratamento		
	
	//é obrigatório a inserção de uma versão para classes que precisam de versão, diante aplicação (versão gerada automáticamente)
	private static final long serialVersionUID = 1L;
	
	//contrutor para que seja possível o armazenamento da mensagem na exceção
	public DomainException(String msg) {
		super(msg);
	}
	
}
