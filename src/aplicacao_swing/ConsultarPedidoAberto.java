package aplicacao_swing;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fachada.Fachada;
import modelo.Pedido;
import modelo.Produto;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ConsultarPedidoAberto extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldTel;
	private JLabel labelConfirma;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public ConsultarPedidoAberto() {

		setLayout(null);
		
		JLabel lblAbrirPedido = new JLabel("Consultar Pedido Aberto");
		lblAbrirPedido.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAbrirPedido.setBounds(185, 11, 296, 78);
		add(lblAbrirPedido);
		
		JLabel lblTel = new JLabel("Telefone do Cliente:");
		lblTel.setBounds(82, 119, 158, 14);
		add(lblTel);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(47, 173, 221, 30);
		add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(89, 278, 108, 36);
		add(btnConsultar);
		
		labelConfirma = new JLabel("");
		labelConfirma.setBounds(24, 418, 589, 21);
		add(labelConfirma);
		
		textArea = new JTextArea();
		textArea.setBounds(300, 90, 313, 317);
		//add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(322, 86, 316, 353);
		scrollPane.setViewportView(textArea);
		add(scrollPane);
		
		// ARRUMAR ESSE AQUI!!!
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String consultaPedido = "";
				try {
					Pedido p = Fachada.consultarPedido(textFieldTel.getText());
					if (p != null) {
						consultaPedido += "Nome do Cliente: " + p.verClientePedido().getNome()
								+ " \n\n " + "ID Pedido: " + p.getId() + "\nData pedido: " + p.getData().format(formatador) + " \n\n Produtos: \n"; 
						for (Produto prod : p.produtosPedido()) {
							consultaPedido += "Descrição: " + prod.getDescricao() + " - Preço: " + prod.getPreco() + "\n";
						}
						
						textArea.setText(consultaPedido);	
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					labelConfirma.setText(e.getMessage());
					System.out.println(e.getMessage());
					JOptionPane.showMessageDialog(null, e.getMessage());
					
				}
			}
		});

	}
}
