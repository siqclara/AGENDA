package br.edu.ifbfa.agenda.colecao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifbfa.agenda.basicas.Categoria;

public class ColecaoCategoria {
	
	public void adicionarCategoria(Categoria c) {
		try {
			PreparedStatement stmt = Conexao.getConnection().prepareStatement("insert into Categoria (nome) values (?)");
			stmt.setString(1, c.getNome());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
		
		public void atualizarCategoria(Categoria c) {
			try {
				PreparedStatement stmt = Conexao.getConnection().prepareStatement("UPDATE Categoria SET nome = ? WHERE id = ?");
				stmt.setString(1, c.getNome());
				stmt.setInt(2, c.getId());
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		
		public void deletarCategoria(Categoria c) {
			try {
				PreparedStatement stmt = Conexao.getConnection().prepareStatement("DELETE FROM Categoria WHERE id = ?");
				stmt.setInt(1, c.getId());
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
			public List<Categoria> listarCategoria () {
				List<Categoria> categorias = new ArrayList<Categoria>();
				try {
					PreparedStatement stmt = Conexao.getConnection().prepareStatement("Select * from Categoria");
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					Categoria c = new Categoria();
					c.setId(rs.getInt("id"));
					c.setNome(rs.getString("nome"));
					categorias.add(c);
					
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				return categorias;
			}
			
			public Categoria procurarCategoriaId(int id) {
				try {
					PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from Categoria WHERE id =?");
							stmt.setInt(1,  id);
					ResultSet rs = stmt.executeQuery();
					if(rs.next()) {
						Categoria c = new Categoria();
						c.setId(rs.getInt("id"));
						c.setNome(rs.getNString("nome"));
					
						return c;
					}
					}catch (Exception e) {
						e.printStackTrace();
				}	
					return null;
				}
		
			public Categoria procurarCategoriaNome(String string) {
				try {
		PreparedStatement stmt = Conexao.getConnection().prepareStatement("select * from Categoria WHERE nome =?");
				stmt.setString(1,  string);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			Categoria c = new Categoria();
			c.setId(rs.getInt("id"));
			c.setNome(rs.getNString("nome"));
		
			return c;
		}
		}catch (Exception e) {
			e.printStackTrace();
	}	
		return null;
	}

			
}



