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

public class CadastrarProduto extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldPreco;
	private JLabel labelConfirma;

	/**
	 * Create the panel.
	 */
	public CadastrarProduto() {

		setLayout(null);
		
		JLabel lblCadastrarProduto = new JLabel("Cadastrar Produto");
		lblCadastrarProduto.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCadastrarProduto.setBounds(228, 11, 184, 78);
		add(lblCadastrarProduto);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(80, 143, 46, 14);
		add(lblNome);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(80, 199, 46, 14);
		add(lblPreo);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(166, 135, 200, 30);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setColumns(10);
		textFieldPreco.setBounds(166, 191, 200, 30);
		add(textFieldPreco);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(285, 309, 108, 36);
		add(btnCadastrar);
		
		labelConfirma = new JLabel("");
		labelConfirma.setBounds(24, 418, 589, 21);
		add(labelConfirma);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double preco = Double.parseDouble(textFieldPreco.getText());
				try {
					Fachada.cadastrarProduto(textFieldNome.getText(), preco);
					textFieldNome.setText("");
					textFieldPreco.setText("");
					labelConfirma.setText("Produto cadastrado com sucesso!");
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
