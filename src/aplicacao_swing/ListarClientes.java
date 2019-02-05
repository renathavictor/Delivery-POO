package aplicacao_swing;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fachada.Fachada;
import modelo.Cliente;

import javax.swing.JTextArea;
import java.awt.ScrollPane;
import java.awt.event.HierarchyListener;

public class ListarClientes extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListarClientes() {
		setLayout(null);
		
		JLabel lblListarClientes = new JLabel("Listar Clientes");
		lblListarClientes.setBounds(229, 11, 192, 74);
		lblListarClientes.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblListarClientes);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 86, 628, 353);
		//add(textArea);
			
		
		try{
			String texto;
			Collection<Cliente> lista = Fachada.listarClientes();
			texto = "\n";
			if (lista.isEmpty())
				texto += "Não tem produto cadastrado\n";
			else 	
				for(Cliente c: lista) 
					texto +=  c + " \n";
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
