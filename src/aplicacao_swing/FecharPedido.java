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

public class FecharPedido extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldTel;
	private JTextField textFieldEntre;
	private JLabel labelConfirma;

	/**
	 * Create the panel.
	 */
	public FecharPedido() {

		setLayout(null);
		
		JLabel lblRetirarProduto = new JLabel("Fechar pedido");
		lblRetirarProduto.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRetirarProduto.setBounds(218, 11, 206, 78);
		add(lblRetirarProduto);
		
		JLabel lblNome = new JLabel("Telefone do Cliente:");
		lblNome.setBounds(80, 143, 183, 14);
		add(lblNome);
		
		JLabel lblEntrega = new JLabel("Nome entregador:");
		lblEntrega.setBounds(80, 199, 183, 14);
		add(lblEntrega);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(306, 136, 228, 30);
		add(textFieldTel);
		textFieldTel.setColumns(10);
		
		textFieldEntre = new JTextField();
		textFieldEntre.setColumns(10);
		textFieldEntre.setBounds(306, 192, 228, 30);
		add(textFieldEntre);
		
		JButton btnCadastrar = new JButton("Fechar");
		
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(253, 302, 108, 36);
		add(btnCadastrar);
		
		labelConfirma = new JLabel("");
		labelConfirma.setBounds(24, 418, 589, 21);
		add(labelConfirma);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Fachada.fecharPedido(textFieldTel.getText(), textFieldEntre.getText());
					textFieldTel.setText("");
					textFieldEntre.setText("");
					labelConfirma.setText("Pedido fechado com sucesso!");
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
