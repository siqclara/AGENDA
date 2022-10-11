package principal;

import br.edu.ifbfa.agenda.basicas.Categoria;
import br.edu.ifbfa.agenda.basicas.Contato;
import br.edu.ifbfa.agenda.colecao.ColecaoCategoria;
import br.edu.ifbfa.agenda.colecao.ColecaoContato;

public class Principal {
	
	public static void main(String[] args) {
		ColecaoCategoria cj = new ColecaoCategoria();
		ColecaoContato cg = new ColecaoContato();
		/* ADICIONAR
		 * Categoria c = new Categoria("Teste");
		ColecaoCategoria cj = new ColecaoCategoria();
		
		cj.adicionarContato(c);*/
		
		/* ATUALIZAR
		 * Categoria c = new Categoria(1,"Colegas");
		ColecaoCategoria cj = new ColecaoCategoria();
		
		cj.atualizarContato(c);*/
		
		//Categoria c = new Categoria(5);
		//ColecaoCategoria cj = new ColecaoCategoria();
		//cj.deletarContato(c);
		
		
		
		 Contato c = new Contato();
		 c.setNome("Clara");
		 c.setEmail("clarasiqr@gmail.com");
		 c.setCelular("75988785887");
		 c.setFone("32817521");
		 c.setCategoria(cj.procurarCategoriaId(1));		 
		 
		cg.adicionarContato(c);
		cg.listarContato().forEach(System.out::println);

		 
	}

}
