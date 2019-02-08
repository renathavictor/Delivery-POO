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

public class Arrecadacao extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldDia;
	private JLabel labelConfirma;
	private JTextField textFieldResult;

	/**
	 * Create the panel.
	 */
	public Arrecadacao() {

		setLayout(null);
		
		JLabel lblAbrirPedido = new JLabel("Arrecada\u00E7\u00E3o");
		lblAbrirPedido.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAbrirPedido.setBounds(241, 11, 184, 78);
		add(lblAbrirPedido);
		
		JLabel lblTel = new JLabel("Dia:");
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTel.setBounds(81, 156, 158, 14);
		add(lblTel);
		
		textFieldDia = new JTextField();
		textFieldDia.setBounds(145, 150, 170, 30);
		add(textFieldDia);
		textFieldDia.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(255, 333, 108, 36);
		add(btnConsultar);
		
		labelConfirma = new JLabel("");
		labelConfirma.setBounds(24, 418, 589, 21);
		add(labelConfirma);
		
		textFieldResult = new JTextField();
		textFieldResult.setEditable(false);
		textFieldResult.setBounds(80, 239, 471, 65);
		add(textFieldResult);
		textFieldResult.setColumns(10);
		
		JLabel lblArrecadao = new JLabel("Arrecadacao");
		lblArrecadao.setBounds(81, 217, 95, 14);
		add(lblArrecadao);
		
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int d = Integer.parseInt(textFieldDia.getText());
					textFieldResult.setText("R$ " + Fachada.calcularArrecadacao(d) + "");
					textFieldDia.setText("");
					labelConfirma.setText("");
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
