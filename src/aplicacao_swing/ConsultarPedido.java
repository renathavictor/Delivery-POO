package aplicacao_swing;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fachada.Fachada;
import modelo.Pedido;
import modelo.Produto;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ConsultarPedido extends JPanel {
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
	public ConsultarPedido() {

		setLayout(null);
		
		JLabel lblAbrirPedido = new JLabel("Consultar Pedido");
		lblAbrirPedido.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAbrirPedido.setBounds(171, 11, 254, 78);
		add(lblAbrirPedido);
		
		JLabel lblTel = new JLabel("Telefone do Cliente:");
		lblTel.setBounds(82, 119, 158, 14);
		add(lblTel);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(47, 173, 221, 30);
		add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JButton btnConsultar = new JButton("Todos");
		
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(24, 273, 108, 36);
		add(btnConsultar);
		
		labelConfirma = new JLabel("");
		labelConfirma.setBounds(24, 451, 589, 21);
		add(labelConfirma);
		
		textArea = new JTextArea();
		textArea.setBounds(300, 90, 313, 317);
		//add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(322, 86, 316, 353);
		scrollPane.setViewportView(textArea);
		add(scrollPane);
		
		JButton btnPedidoAberto = new JButton("Pedido Aberto");
		btnPedidoAberto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String consultaPedido = "";			
				try {
					Pedido p = Fachada.consultarPedido(textFieldTel.getText());
					consultaPedido += "Nome do Cliente: " + p.verClientePedido().getNome() + "\n "+ p; 
					textArea.setText(consultaPedido);	
					
				} catch (Exception e1) {
					labelConfirma.setText(e1.getMessage());
					JOptionPane.showMessageDialog(null, e1.getMessage());
					
				}
			}
		});
		btnPedidoAberto.setBounds(144, 272, 135, 36);
		add(btnPedidoAberto);
		
		// ARRUMAR ESSE AQUI!!!
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String consultaPedido = "";
				try {
					ArrayList<Pedido> todos = Fachada.listarPedidos(textFieldTel.getText());
					for (Pedido p : todos) {
						consultaPedido += "Nome do Cliente: " + p.verClientePedido().getNome() + " \n " + p;
							
					}
					textArea.setText(consultaPedido);
				} catch (Exception e) {
					labelConfirma.setText(e.getMessage());
					JOptionPane.showMessageDialog(null, e.getMessage());
					
				}
			}
		});

	}
}
