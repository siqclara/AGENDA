package br.edu.ifbfa.agenda.basicas;

public class Categoria {
	
	private int id;
	private String nome;
	public Categoria() {
		super();
	}
	public Categoria(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public Categoria(String nome) {
		super();
		this.nome = nome;
	}
	
    public Categoria(int id) {
		super();
		this.id = id;
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}
	

}
