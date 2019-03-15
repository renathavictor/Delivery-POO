package aplicacao_swing;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
	private JTextField textFieldSenha;
	private JLabel labelConfirma;
	private JTextField textFieldEmail;

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
		lblPreo.setBounds(80, 226, 122, 14);
		add(lblPreo);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(296, 136, 228, 30);
		add(textFieldTel);
		textFieldTel.setColumns(10);
		
		textFieldSenha = new JPasswordField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(296, 218, 228, 30);
		add(textFieldSenha);
		
		JButton btnCadastrar = new JButton("Enviar");
		
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(253, 302, 108, 36);
		add(btnCadastrar);
		
		labelConfirma = new JLabel("");
		labelConfirma.setBounds(24, 418, 589, 21);
		add(labelConfirma);
		
		JLabel lblEmail = new JLabel("Email Loja:");
		lblEmail.setBounds(82, 185, 108, 14);
		add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(296, 177, 228, 30);
		add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Fachada.enviarPedido(textFieldTel.getText(), textFieldEmail.getText(), textFieldSenha.getText());
					textFieldTel.setText("");
					textFieldSenha.setText("");
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
