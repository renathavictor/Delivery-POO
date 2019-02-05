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

public class ListarProdutos extends JPanel {
	public ListarProdutos() {

		setLayout(null);
		
		JLabel lblListarProdutos = new JLabel("Listar Produtos");
		lblListarProdutos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblListarProdutos.setBounds(225, 11, 204, 74);
		add(lblListarProdutos);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 77, 598, 362);
		//add(textArea);
	
		
		try{
			String texto;
			ArrayList<Produto> lista = Fachada.listarProdutos("");
			texto = "\n";
			if (lista.isEmpty())
				texto += "Não tem produto cadastrado\n";
			else 	
				for(Produto p: lista) 
					texto +=  p + " \n"; 

			textArea.setText(texto);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 86, 628, 353);
			scrollPane.setViewportView(textArea);
			add(scrollPane);
			
		}
		catch(Exception erro){
			JOptionPane.showMessageDialog(null,erro.getMessage());
		}
			
	}
}
