package aplicacao_swing;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fachada.Fachada;
import modelo.Produto;

import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarProdutos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	public ListarProdutos() {

		setLayout(null);
		
		JLabel lblListarProdutos = new JLabel("Listar Produtos");
		lblListarProdutos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblListarProdutos.setBounds(227, 0, 204, 52);
		add(lblListarProdutos);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 77, 598, 362);
		//add(textArea);
	
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 120, 628, 318);
		scrollPane.setViewportView(textArea);
		add(scrollPane);
		
		textField = new JTextField();
		textField.setBounds(316, 81, 204, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblDescricao = new JLabel("Descricao:");
		lblDescricao.setBounds(230, 83, 83, 20);
		add(lblDescricao);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String texto;
					ArrayList<Produto> lista = Fachada.listarProdutos(textField.getText());
					System.out.println(lista);
					texto = "\n";
					if (lista.isEmpty())
						texto += "Nao tem produto cadastrado\n";
					else 	
						for(Produto p: lista) 
							texto +=  p + " \n"; 

					textArea.setText(texto);
				} 
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		btnBuscar.setBounds(521, 81, 117, 25);
		add(btnBuscar);
		
		JButton btnTodos = new JButton("Mostrar Todos");
		btnTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String texto;
					ArrayList<Produto> lista = Fachada.listarProdutos("");
					texto = "\n";
					if (lista.isEmpty())
						texto += "Nao tem produto cadastrado\n";
					else 	
						for(Produto p: lista) 
							texto +=  p + " \n"; 

					textArea.setText(texto);
					
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnTodos.setBounds(12, 81, 144, 25);
		add(btnTodos);
			
			
	}
}
