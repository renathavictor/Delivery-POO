package aplicacao_swing;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fachada.Fachada;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AbrirPedido extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldTel;
	private JLabel labelConfirma;

	/**
	 * Create the panel.
	 */
	public AbrirPedido() {

		setLayout(null);
		
		JLabel lblAbrirPedido = new JLabel("Abrir Pedido");
		lblAbrirPedido.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAbrirPedido.setBounds(241, 11, 184, 78);
		add(lblAbrirPedido);
		
		JLabel lblTel = new JLabel("Telefone do Cliente:");
		lblTel.setBounds(81, 156, 158, 14);
		add(lblTel);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(316, 148, 221, 30);
		add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JButton btnAbrir = new JButton("Abrir");
		
		btnAbrir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAbrir.setBounds(256, 310, 108, 36);
		add(btnAbrir);
		
		labelConfirma = new JLabel("");
		labelConfirma.setBounds(24, 418, 589, 21);
		add(labelConfirma);
		
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Fachada.abrirPedido(textFieldTel.getText());
					textFieldTel.setText("");
					labelConfirma.setText("Pedido aberto com sucesso!");
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
