package br.edu.ifba.agenda.exception;

public class CadastroCategoriaException extends Exception{
	
	public CadastroCategoriaException(String nome) {
		super("A categoria "+nome+" j� existe!");
		 
		
		
		
	}

}
