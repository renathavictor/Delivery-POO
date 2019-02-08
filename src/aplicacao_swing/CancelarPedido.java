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

public class CancelarPedido extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldTel;
	private JLabel labelConfirma;

	/**
	 * Create the panel.
	 */
	public CancelarPedido() {

		setLayout(null);
		
		JLabel lblRetirarProduto = new JLabel("Cancelar pedido");
		lblRetirarProduto.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRetirarProduto.setBounds(218, 11, 206, 78);
		add(lblRetirarProduto);
		
		JLabel lblNome = new JLabel("Telefone do Cliente:");
		lblNome.setBounds(80, 143, 188, 14);
		add(lblNome);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(312, 136, 228, 30);
		add(textFieldTel);
		textFieldTel.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cancelar");
		
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(253, 302, 108, 36);
		add(btnCadastrar);
		
		labelConfirma = new JLabel("");
		labelConfirma.setBounds(24, 418, 589, 21);
		add(labelConfirma);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Fachada.cancelarPedido(textFieldTel.getText());
					textFieldTel.setText("");
					labelConfirma.setText("Pedido cancelado com sucesso!");
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
