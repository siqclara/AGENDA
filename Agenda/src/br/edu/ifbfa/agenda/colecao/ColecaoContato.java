package br.edu.ifbfa.agenda.colecao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifbfa.agenda.basicas.Categoria;
import br.edu.ifbfa.agenda.basicas.Contato;

public class ColecaoContato {
	
	public void adicionarContato(Contato c) {
			try {
				PreparedStatement stmt = Conexao.getConnection()
						.prepareStatement("insert into Contato (nome, email, fone, celular, id_Categoria) values (?,?,?,?,?)");
				stmt.setString(1, c.getNome());
				stmt.setString(2, c.getEmail());
				stmt.setString(3, c.getFone());
				stmt.setString(4, c.getCelular());
				stmt.setInt(5, c.getCategoria().getId());
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		public List<Contato> listarContato(){
			ColecaoCategoria cc = new ColecaoCategoria();

			List<Contato> contatos = new ArrayList<Contato>();
			try {
				PreparedStatement stmt =
				Conexao.getConnection().prepareStatement("Select * from Contato");
				ResultSet rs = stmt.executeQuery();

				while(rs.next()) {
					Contato c = new Contato();
					c.setId(rs.getInt("id"));
					c.setNome(rs.getString("nome"));
					c.setEmail(rs.getString("email"));
					c.setFone(rs.getString("fone"));
					c.setCelular(rs.getString("celular"));
					c.setCategoria(cc.procurarCategoriaId(rs.getInt("id_categoria")));
					contatos.add(c);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return contatos;
		}

		public List<Contato> listarContatoPorCategoria(Categoria cat){
			ColecaoCategoria cc = new ColecaoCategoria();

			List<Contato> contatos = new ArrayList<Contato>();
			try {
				PreparedStatement stmt =
				Conexao.getConnection().prepareStatement("Select * from Contato where id_categoria = ?");
				stmt.setInt(1, cat.getId());
				ResultSet rs = stmt.executeQuery();

				while(rs.next()) {
					Contato c = new Contato();
					c.setId(rs.getInt("id"));
					c.setNome(rs.getString("nome"));
					c.setEmail(rs.getString("email"));
					c.setFone(rs.getString("fone"));
					c.setCelular(rs.getString("celular"));
					c.setCategoria(cc.procurarCategoriaId(rs.getInt("id_categoria")));
					contatos.add(c);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return contatos;
		}

		public void atualizarContato(Contato c) {

			try {

				PreparedStatement stmt = Conexao.getConnection().prepareStatement("update contato set nome=?, email=?, fone=?, celular=?, id_categoria=? where id=?");
				stmt.setString(1, c.getNome());
				stmt.setString(2, c.getEmail());
				stmt.setString(3, c.getFone());
				stmt.setString(4, c.getCelular());
				stmt.setInt(5, c.getCategoria().getId());
				stmt.setInt(6, c.getId());
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		public Contato procurarId(int id) {
			ColecaoCategoria cc = new ColecaoCategoria();
			try {
				PreparedStatement stmt =
				Conexao.getConnection().prepareStatement("Select * from Contato where id = ?");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();

				if(rs.next()) {
					Contato c = new Contato();
					c.setId(rs.getInt("id"));
					c.setNome(rs.getString("nome"));
					c.setEmail(rs.getString("email"));
					c.setFone(rs.getString("fone"));
					c.setCelular(rs.getString("celular"));
					c.setCategoria(cc.procurarCategoriaId(rs.getInt("id_categoria")));
					return c;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

		public Contato procurarNome(String nome) {
			ColecaoCategoria cc = new ColecaoCategoria();
			try {
				PreparedStatement stmt =
				Conexao.getConnection().prepareStatement("Select * from Contato where nome = ?");
				stmt.setString(1, nome);
				ResultSet rs = stmt.executeQuery();

				if(rs.next()) {
					Contato c = new Contato();
					c.setId(rs.getInt("id"));
					c.setNome(rs.getString("nome"));
					c.setEmail(rs.getString("email"));
					c.setFone(rs.getString("fone"));
					c.setCelular(rs.getString("celular"));
					c.setCategoria(cc.procurarCategoriaId(rs.getInt("id_categoria")));
					return c;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public void removerContato( Contato c ) {
			try {
				PreparedStatement stmt = Conexao.getConnection().prepareStatement("delete from Contato where id=?");
				stmt.setInt(1, c.getId());
				stmt.executeUpdate();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				// TODO: handle exception
			}
			
		}	
			
	}
