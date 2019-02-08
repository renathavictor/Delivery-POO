package aplicacao_swing;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fachada.Fachada;
import modelo.Produto;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class CriarCombo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldID;
	private JLabel labelConfirma;
	private List<Integer> ids = new ArrayList<>();
	/**
	 * Create the panel.
	 */
	public CriarCombo() {

		setLayout(null);
		
		JLabel lblCriarCombo = new JLabel("Criar Combo");
		lblCriarCombo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCriarCombo.setBounds(253, 12, 172, 43);
		add(lblCriarCombo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(30, 104, 99, 14);
		add(lblNome);
		
		JLabel lblPreo = new JLabel("ID do Produto:");
		lblPreo.setBounds(30, 175, 122, 14);
		add(lblPreo);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(147, 97, 228, 30);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		textFieldID.setBounds(147, 168, 228, 30);
		add(textFieldID);
		
		JButton btnAdicionar = new JButton("Adicionar");
		
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdicionar.setBounds(407, 165, 108, 36);
		add(btnAdicionar);
		
		labelConfirma = new JLabel("");
		labelConfirma.setBounds(24, 418, 589, 21);
		add(labelConfirma);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 238, 350, 176);
		add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnCriarCombo = new JButton("Criar Combo");
		btnCriarCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String text = "";
					Produto combo = Fachada.criarCombo(textFieldNome.getText(), ids);
					textArea.setText(combo + "");
					labelConfirma.setText("Combo criado com sucesso!");
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		btnCriarCombo.setBounds(407, 371, 149, 43);
		add(btnCriarCombo);
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = Integer.parseInt(textFieldID.getText());
				try {
					ids.add(id);
					textFieldID.setText("");
					textArea.setText(ids + "");
					labelConfirma.setText("Produto adicionado com sucesso!");
				} catch (Exception e) {
					labelConfirma.setText(e.getMessage());
					//System.out.println(e.getMessage());
					JOptionPane.showMessageDialog(null, e.getMessage());
					
				}
			}
		});

	}
}
