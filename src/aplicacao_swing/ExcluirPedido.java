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

public class ExcluirPedido extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldID;
	private JLabel labelConfirma;

	/**
	 * Create the panel.
	 */
	public ExcluirPedido() {

		setLayout(null);
		
		JLabel lblCancelarPedido = new JLabel("Excluir pedido");
		lblCancelarPedido.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCancelarPedido.setBounds(218, 11, 206, 78);
		add(lblCancelarPedido);
		
		JLabel lblNome = new JLabel("ID Pedido:");
		lblNome.setBounds(80, 143, 122, 14);
		add(lblNome);
		
		textFieldID = new JTextField();
		textFieldID.setBounds(212, 135, 228, 30);
		add(textFieldID);
		textFieldID.setColumns(10);
		
		JButton btnCancelar = new JButton("Excluir");
		
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(253, 302, 108, 36);
		add(btnCancelar);
		
		labelConfirma = new JLabel("");
		labelConfirma.setBounds(24, 418, 589, 21);
		add(labelConfirma);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("qyuia si");
				try {
					int id = Integer.parseInt(textFieldID.getText());
					Fachada.excluirPedido(id);
					textFieldID.setText("");
					labelConfirma.setText("Pedido excluido com sucesso!");
				} catch (Exception e) {
					labelConfirma.setText(e.getMessage());
					JOptionPane.showMessageDialog(null, e.getMessage());
					
				}
			}
		});

	}

}
