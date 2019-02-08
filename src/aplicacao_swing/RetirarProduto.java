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

public class RetirarProduto extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldTel;
	private JTextField textFieldID;
	private JLabel labelConfirma;

	/**
	 * Create the panel.
	 */
	public RetirarProduto() {

		setLayout(null);
		
		JLabel lblRetirarProduto = new JLabel("Retirar produto do pedido");
		lblRetirarProduto.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRetirarProduto.setBounds(181, 11, 343, 78);
		add(lblRetirarProduto);
		
		JLabel lblNome = new JLabel("Telefone do Cliente:");
		lblNome.setBounds(80, 143, 183, 14);
		add(lblNome);
		
		JLabel lblPreo = new JLabel("ID do Produto:");
		lblPreo.setBounds(80, 199, 122, 14);
		add(lblPreo);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(296, 136, 228, 30);
		add(textFieldTel);
		textFieldTel.setColumns(10);
		
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		textFieldID.setBounds(296, 192, 228, 30);
		add(textFieldID);
		
		JButton btnCadastrar = new JButton("Retirar");
		
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(253, 302, 108, 36);
		add(btnCadastrar);
		
		labelConfirma = new JLabel("");
		labelConfirma.setBounds(24, 418, 589, 21);
		add(labelConfirma);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(textFieldID.getText());
				try {
					Fachada.removerProdutoPedido(textFieldTel.getText(), id);
					textFieldTel.setText("");
					textFieldID.setText("");
					labelConfirma.setText("Produto retirado com sucesso!");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					labelConfirma.setText(e.getMessage());
					//System.out.println(e.getMessage());
					JOptionPane.showMessageDialog(null, e.getMessage());
					
				}
			}
		});

	}

}
