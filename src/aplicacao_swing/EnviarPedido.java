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

public class EnviarPedido extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldTel;
	private JTextField textFieldEmail;
	private JLabel labelConfirma;

	/**
	 * Create the panel.
	 */
	public EnviarPedido() {

		setLayout(null);
		
		JLabel lblRetirarProduto = new JLabel("Enviar email do pedido");
		lblRetirarProduto.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRetirarProduto.setBounds(181, 11, 343, 78);
		add(lblRetirarProduto);
		
		JLabel lblNome = new JLabel("Telefone do Cliente:");
		lblNome.setBounds(80, 143, 184, 14);
		add(lblNome);
		
		JLabel lblPreo = new JLabel("Senha do email:");
		lblPreo.setBounds(80, 199, 122, 14);
		add(lblPreo);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(296, 136, 228, 30);
		add(textFieldTel);
		textFieldTel.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(296, 192, 228, 30);
		add(textFieldEmail);
		
		JButton btnCadastrar = new JButton("Enviar");
		
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(253, 302, 108, 36);
		add(btnCadastrar);
		
		labelConfirma = new JLabel("");
		labelConfirma.setBounds(24, 418, 589, 21);
		add(labelConfirma);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Fachada.enviarPedido(textFieldTel.getText(), textFieldEmail.getText());
					textFieldTel.setText("");
					textFieldEmail.setText("");
					labelConfirma.setText("Email enviado com sucesso!");
				} catch (Exception e) {
					labelConfirma.setText(e.getMessage());
					//System.out.println(e.getMessage());
					JOptionPane.showMessageDialog(null, e.getMessage());
					
				}
			}
		});

	}

}
