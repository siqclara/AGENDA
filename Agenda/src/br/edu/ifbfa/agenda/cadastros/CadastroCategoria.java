package br.edu.ifbfa.agenda.cadastros;

import java.util.List;

import br.edu.ifba.agenda.exception.CadastroCategoriaException;
import br.edu.ifbfa.agenda.basicas.Categoria;
import br.edu.ifbfa.agenda.colecao.ColecaoCategoria;

public class CadastroCategoria {
	
	
	ColecaoCategoria col = new ColecaoCategoria();
	 
	public void adicionarCategoria(Categoria c) throws CadastroCategoriaException {
		
		if(col.procurarCategoriaNome(c.getNome()) !=null) {
		CadastroCategoriaException ex = new CadastroCategoriaException(c.getNome());
		throw(ex);
	}
		this.col.adicionarCategoria(c);
	}
	
	public void atualizarCategoria(Categoria c) {
		col.atualizarCategoria(c);
	}
	
	public List<Categoria> listarCategoria() {
		return col.listarCategoria();
	}
	
	public Categoria procurarCategoriaId(int id) {
		return col.procurarCategoriaId(id);
	}
	
	public Categoria procurarCategoriaNome(String nome) {
		return col.procurarCategoriaNome(nome);
	}
	
	public void deletarCategoria(Categoria c) {
		col.deletarCategoria(c);
	}
	
}
	
