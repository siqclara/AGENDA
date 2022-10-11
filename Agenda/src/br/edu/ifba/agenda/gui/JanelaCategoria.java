package br.edu.ifba.agenda.gui;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import br.edu.ifba.agenda.exception.CadastroCategoriaException;
import br.edu.ifba.agenda.tableModel.CategoriaTableModel;
import br.edu.ifbfa.agenda.basicas.Categoria;
import br.edu.ifbfa.agenda.cadastros.CadastroCategoria;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JanelaCategoria extends JPanel {
	private JTextField textField;
	private JTable tabelaCategoria;
	CategoriaTableModel modelo = new CategoriaTableModel();
	CadastroCategoria c = new CadastroCategoria();
	/**
	 * Create the panel.
	 */
	public JanelaCategoria() {
		
		preencherTabelaCategoria();
		setBackground(new Color(204, 204, 255));
		setForeground(Color.WHITE);
		setBounds(10,11,674,520);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 654, 158);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE));
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Categoria cat = new Categoria();
				cat.setNome(textField.getText());
		try {
			c.adicionarCategoria(cat);
		}catch(CadastroCategoriaException e2) {
			return;
		}
				
			}
			
		});
		
		btnNewButton.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(75, 0, 130));
		btnNewButton.setBounds(86, 32, 138, 91);
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("../../../../../../Resource/atualizar.png")));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Adicionar\r\n");
		btnNewButton_1.setForeground(new Color(75, 0, 130));
		btnNewButton_1.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(getClass().getResource("../../../../../../Resource/adicionar.png")));
		btnNewButton_1.setBounds(206, 32, 138, 91);
		panel.add(btnNewButton_1);
	
		JButton btnNewButton_3 = new JButton("Editar");
		btnNewButton_3.setForeground(new Color(75, 0, 130));
		btnNewButton_3.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		btnNewButton_3.setIcon(new ImageIcon(getClass().getResource("../../../../../../Resource/editar.png")));
		btnNewButton_3.setBounds(458, 32, 118, 91);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_1_1 = new JButton("Remover");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Workspace\\Fabiano\\Java\\2020.1\\Agenda\\Resource\\excluir.png"));
		btnNewButton_1_1.setForeground(new Color(75, 0, 130));
		btnNewButton_1_1.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
		btnNewButton_1_1.setBounds(330, 32, 138, 91);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNomeCategoria = new JLabel("Nome Categoria");
		lblNomeCategoria.setBounds(20, 180, 226, 20);
		lblNomeCategoria.setForeground(new Color(75, 0, 130));
		lblNomeCategoria.setFont(new Font("DejaVu Sans", Font.BOLD, 15));
		add(lblNomeCategoria);
		
		textField = new JTextField();
		textField.setBounds(30, 200, 462, 20);
		add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 0, 204));
		panel_1.setBounds(20, 247, 594, 180);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 571, 158);
		panel_1.add(scrollPane);
		if(this.tabelaCategoria == null) {
			this.tabelaCategoria = new JTable(this.modelo);
		}
		scrollPane.setViewportView(this.tabelaCategoria);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	
	private void preencherTabelaCategoria() {	
		List<Categoria> categorias = this.c.listarCategoria();
		
		for(Categoria temp: categorias) {
			modelo.addCategoria(temp);
		}
	}
	
}
