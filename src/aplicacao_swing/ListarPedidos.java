package aplicacao_swing;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import fachada.Fachada;
import modelo.Pedido;
import modelo.Produto;

import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ListarPedidos extends JPanel {
	public ListarPedidos() {

		setLayout(null);
		
		JLabel lblListarPedidos = new JLabel("Lista de Pedidos");
		lblListarPedidos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblListarPedidos.setBounds(225, 11, 204, 74);
		add(lblListarPedidos);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 77, 598, 362);
		//add(textArea);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 628, 3532);
		scrollPane.setViewportView(textArea);
		add(scrollPane);
	
		try{
			String texto;
			ArrayList<Pedido> lista = Fachada.listarPedidos();
			texto = "\n";
			if (lista.isEmpty())
				texto += "Nao tem produto cadastrado\n";
			else 	
				for(Pedido p: lista) 
					texto +=  p +" -- Pedido fechado? " + p.isFechado() + " \n\n"; 

			textArea.setText(texto);
			
			
		}
		catch(Exception erro){
			JOptionPane.showMessageDialog(null,erro.getMessage());
		}
			
	}
}
