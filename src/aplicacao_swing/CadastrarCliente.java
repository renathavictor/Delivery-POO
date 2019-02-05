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

public class CadastrarCliente extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldTel;
	private JLabel labelConfirma;
	private JTextField textFieldEmail;
	private JTextField textFieldEnde;

	/**
	 * Create the panel.
	 */
	public CadastrarCliente() {

		setLayout(null);
		
		JLabel lblCadastrarCliente = new JLabel("Cadastrar Cliente");
		lblCadastrarCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCadastrarCliente.setBounds(228, 11, 184, 78);
		add(lblCadastrarCliente);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(135, 119, 83, 14);
		add(lblNome);
		
		JLabel lblTel = new JLabel("Telefone:");
		lblTel.setBounds(135, 175, 83, 14);
		add(lblTel);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(228, 111, 306, 30);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldTel = new JTextField();
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(228, 167, 306, 30);
		add(textFieldTel);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(273, 351, 108, 36);
		add(btnCadastrar);
		
		labelConfirma = new JLabel("");
		labelConfirma.setBounds(24, 418, 589, 21);
		add(labelConfirma);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(135, 232, 83, 14);
		add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(228, 224, 306, 30);
		add(textFieldEmail);
		
		textFieldEnde = new JTextField();
		textFieldEnde.setColumns(10);
		textFieldEnde.setBounds(228, 281, 306, 30);
		add(textFieldEnde);
		
		JLabel lblEnderecol = new JLabel("Endereco:");
		lblEnderecol.setBounds(135, 289, 83, 14);
		add(lblEnderecol);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					System.out.println("CADASTRO SWING");
					Fachada.cadastrarCliente(textFieldTel.getText(), textFieldNome.getText(), textFieldEmail.getText(), textFieldEnde.getText());
					textFieldNome.setText("");
					textFieldTel.setText("");
					textFieldEmail.setText("");
					textFieldEnde.setText("");
					labelConfirma.setText("Cliente cadastrado com sucesso!");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					labelConfirma.setText(e.getMessage());
					System.out.println(e.getMessage());
					
				}
			}
		});

	}
}
