package aplicacao_swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.Dimension;
import javax.swing.SwingConstants;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

import javax.swing.JSeparator;

public class DeliveryMain {

	private JFrame frame;
	private JPanel panel;
	private JPanel panelMain;
	private JButton btnVoltar;
	private JLabel img;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeliveryMain window = new DeliveryMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeliveryMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Beyond Food Administrator");
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try{
					//  pre-cadastro
					
					Cliente joao = Fachada.cadastrarCliente("98745-0643", "joao", "poo.projeto.delivery@gmail.com","Rua dos Tronos, 3");
		            System.out.println("cadastrou cliente = "+joao.getNome());
		            Cliente maria = Fachada.cadastrarCliente("98820-0222", "maria", "poo.projeto.delivery@gmail.com","Rua da Justiça, 12");          
		            System.out.println("cadastrou cliente = "+maria.getNome());
					Cliente renatha = Fachada.cadastrarCliente("98821-2994", "Renatha", "poo.projeto.delivery@gmail.com","Rua dos Tronos, 3");
		            System.out.println();
		            Fachada.cadastrarCliente("98821-2944", "Renatha", "poo.projeto.delivery@gmail.com","Rua dos Tronos, 3");
		            Fachada.cadastrarCliente("98821-0994", "Renatha", "poo.projeto.delivery@gmail.com","Rua dos Tronos, 3");
		            Fachada.cadastrarCliente("98821-1994", "Renatha", "poo.projeto.delivery@gmail.com","Rua dos Tronos, 3");
		            Fachada.cadastrarCliente("98821-3994", "Renatha", "poo.projeto.delivery@gmail.com","Rua dos Tronos, 3");
		            Fachada.cadastrarCliente("98821-4994", "Renatha", "poo.projeto.delivery@gmail.com","Rua dos Tronos, 3");
		            Fachada.cadastrarCliente("98821-5994", "Renatha", "poo.projeto.delivery@gmail.com","Rua dos Tronos, 3");
		            Fachada.cadastrarCliente("98821-6994", "Renatha", "poo.projeto.delivery@gmail.com","Rua dos Tronos, 3");
		            Fachada.cadastrarCliente("98821-7994", "Renatha", "poo.projeto.delivery@gmail.com","Rua dos Tronos, 3");
		            
		            Produto pizza = Fachada.cadastrarProduto("Pizza", 30);
		            System.out.println("cadastrou produto = "+pizza.getDescricao() + " " + pizza.getId());
		            Produto sushi = Fachada.cadastrarProduto("Sushi", 40);
		            System.out.println("cadastrou produto = "+sushi.getDescricao() + " " + sushi.getId());
		            Produto cocaCola = Fachada.cadastrarProduto("Coca-cola", 10);
		            System.out.println("cadastrou produto = "+cocaCola.getDescricao() + " " + cocaCola.getId());
		            Produto guarana = Fachada.cadastrarProduto("Guarana", 5);   
		            System.out.println("cadastrou produto = "+guarana.getDescricao() + " " + guarana.getId());     
		            
		            System.out.println("\nAbrir pedidos");          
		            Pedido pedido1 = Fachada.abrirPedido("98745-0643");
		            System.out.println("abrir pedido = "+pedido1.getId());
		            Pedido pedido2 = Fachada.abrirPedido("98820-0222");
		            System.out.println("abrir pedido = "+pedido2.getId());
		            
		            System.out.println("\nconsultar pedido = "+ Fachada.consultarPedido("98745-0643"));
		            System.out.println("\nconsultar pedido = "+ Fachada.consultarPedido("98820-0222"));
		             
		            System.out.println("\n adicao dos produtos ao Pedido");         
		            Fachada.adicionarProdutoPedido("98745-0643", 1);
		            Fachada.adicionarProdutoPedido("98745-0643", 1);
		            Fachada.adicionarProdutoPedido("98745-0643", 3);            
		            Fachada.adicionarProdutoPedido("98820-0222", 2);    
		            Fachada.adicionarProdutoPedido("98820-0222", 4);    
		            Fachada.removerProdutoPedido("98820-0222", 4);  
					
		            System.out.println("\nconsultar pedido = "+ Fachada.consultarPedido("98745-0643"));
		            System.out.println("\nconsultar pedido = "+ Fachada.consultarPedido("98820-0222"));
		            
					System.out.println("pre-cadastro concluido");

				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "Sistema encerrado, até breve!");
			}
		});
		
		// configura��es padroes
		frame.setBounds(500, 200, 850, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		img = new JLabel("");
		img.setIcon(new ImageIcon(DeliveryMain.class.getResource("/imagens/BEYOND-FOOD2.png")));
		img.setBounds(0,-30,850,700);
		frame.getContentPane().add(img);
		
		panel = new JPanel();
		panel.setBounds(58, 112, 711, 467);
		frame.getContentPane().add(panel);
		panel.setBackground(Color.DARK_GRAY);
		
		panelMain = new JPanel();
		panelMain.setBounds(58, 112, 711, 467);
		
		// BOT�O DE VOLTAR A TELA PADR�O
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBounds(10, 11, 91, 28);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.setVisible(false);
				img.setVisible(true);
			}
		});
		
		btnVoltar.setVisible(false);
		
		
		// MENU
				
		JMenuBar menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(0, 40));
		menuBar.setBorderPainted(false);
		menuBar.setForeground(new Color(255, 255, 255));
		frame.setJMenuBar(menuBar);
		menuBar.setBackground(new Color(0, 100, 0));
		
		// MENU DOS PRODUTOS
		JMenu mnProdutos = new JMenu("Produtos");
		//mnProdutos.setPreferredSize(new Dimension(150, 22));
		menuBar.add(mnProdutos);
		mnProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
		JMenuItem mntmCadastrarProd = new JMenuItem("5. Cadastrar");
		mntmCadastrarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarProduto cadastraProd = new CadastrarProduto();
				setarPainel(); 
				panel.add(cadastraProd);
				cadastraProd.setBounds(65, 100, 700, 500);
			}
		});
		mnProdutos.add(mntmCadastrarProd);
		
		JMenuItem mntmListarProd = new JMenuItem("1. Listar");
		mntmListarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProdutos listarProd = new ListarProdutos();
				setarPainel();
				panel.add(listarProd);
				listarProd.setBounds(65, 100, 700, 500);				
			}
		});
		mnProdutos.add(mntmListarProd);
		
		JSeparator separator = new JSeparator();
		separator.setMaximumSize(new Dimension(2, 77));
		separator.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator);
		
		
		// MENU DOS CLIENTES
		JMenu mnClientes = new JMenu("Clientes");
		//mnClientes.setPreferredSize(new Dimension(150, 22));
		menuBar.add(mnClientes);
		mnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JMenuItem mntmCadastrarCli = new JMenuItem("6. Cadastrar");
		mntmCadastrarCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarCliente cadastraCli = new CadastrarCliente();
				setarPainel();
				panel.add(cadastraCli);
				cadastraCli.setBounds(65, 100, 700, 500);
			}
		});
		mnClientes.add(mntmCadastrarCli);
		
		JMenuItem mntmListarCli = new JMenuItem("2. Listar");
		mntmListarCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarClientes listaCli = new ListarClientes();
				setarPainel();
				panel.add(listaCli);
				listaCli.setBounds(65, 100, 700, 500);
			}
		});
		mnClientes.add(mntmListarCli);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setMaximumSize(new Dimension(2, 77));
		menuBar.add(separator_1);
		
		
		// MENU DOS PEDIDOS
		JMenu mnPedidos = new JMenu("Pedidos");
		//mnPedidos.setPreferredSize(new Dimension(150, 22));
		menuBar.add(mnPedidos);
		mnPedidos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JMenuItem mntmAbrirPed = new JMenuItem("7. Abrir");
		mntmAbrirPed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbrirPedido abrirPed = new AbrirPedido();
				setarPainel();
				panel.add(abrirPed);
				abrirPed.setBounds(65, 100, 700, 500);
			}
		});
		mnPedidos.add(mntmAbrirPed);
		
		JMenuItem mntmListarPed = new JMenuItem("3. Listar todos");
		mntmListarPed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarPedidos listaPed = new ListarPedidos();
				setarPainel();
				panel.add(listaPed);
				listaPed.setBounds(65, 100, 700, 500);
			}
		});
		mnPedidos.add(mntmListarPed);
		
		JMenuItem mntmConsultarPed = new JMenuItem("4. Consultar Pedido");
		mntmConsultarPed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarPedidoAberto consultaPedido = new ConsultarPedidoAberto();
				setarPainel();
				panel.add(consultaPedido);
				consultaPedido.setBounds(65, 100, 700, 500);
			}
		});
		mnPedidos.add(mntmConsultarPed);
		
		JMenuItem mntmExcluirPedido = new JMenuItem("16. Excluir Pedido");
		mntmExcluirPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirPedido excluirPedido = new ExcluirPedido();
				setarPainel();
				panel.add(excluirPedido);
				excluirPedido.setBounds(65, 100, 700, 500);
			}
		});
		mnPedidos.add(mntmExcluirPedido);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setMaximumSize(new Dimension(2, 77));
		menuBar.add(separator_2);
		
		
		// MENU PEDIDOS RELACIONADOS AOS CLIENTES
		JMenu mnPedidocliente = new JMenu("Pedido/Cliente");
		//mnPedidocliente.setPreferredSize(new Dimension(150, 22));
		menuBar.add(mnPedidocliente);
		mnPedidocliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JMenuItem mntmPedidosCli = new JMenuItem("10. Pedido Aberto");
		mntmPedidosCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarPedidoAberto pedidoAberto = new ConsultarPedidoAberto();
				setarPainel();
				panel.add(pedidoAberto);
				pedidoAberto.setBounds(65, 100, 700, 500);
			}
		});
		mnPedidocliente.add(mntmPedidosCli);
		
		JMenuItem mntmAdcionarProd = new JMenuItem("8. Adcionar Produto");
		mntmAdcionarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdicionarProduto addProduto = new AdicionarProduto();
				setarPainel();
				panel.add(addProduto);
				addProduto.setBounds(65, 100, 700, 500);
			}
		});
		mnPedidocliente.add(mntmAdcionarProd);
		
		JMenuItem mntmRemoverProd = new JMenuItem("9. Retirar Produto");
		mntmRemoverProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RetirarProduto retiraProduto = new RetirarProduto();
				setarPainel();
				panel.add(retiraProduto);
				retiraProduto.setBounds(65, 100, 700, 500);
			}
		});
		mnPedidocliente.add(mntmRemoverProd);
		
		JMenuItem mntmFecharPed = new JMenuItem("12. Fechar Pedido");
		mntmFecharPed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FecharPedido fecharPedido = new FecharPedido();
				setarPainel();
				panel.add(fecharPedido);
				fecharPedido.setBounds(65, 100, 700, 500);
			}
		});
		mnPedidocliente.add(mntmFecharPed);
		
		JMenuItem mntmCancelarPed = new JMenuItem("11. Cancelar Pedido");
		mntmCancelarPed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelarPedido cancelarPedido = new CancelarPedido();
				setarPainel();
				panel.add(cancelarPedido);
				cancelarPedido.setBounds(65, 100, 700, 500);
			}
		});
		mnPedidocliente.add(mntmCancelarPed);
		
		JMenuItem mntmEnviarPedido = new JMenuItem("13. Enviar Pedido");
		mntmEnviarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnviarPedido enviarEmail = new EnviarPedido();
				setarPainel();
				panel.add(enviarEmail);
				enviarEmail.setBounds(65, 100, 700, 500);
			}
		});
		mnPedidocliente.add(mntmEnviarPedido);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setMaximumSize(new Dimension(2, 77));
		menuBar.add(separator_3);
		
		
		// MENU DA ARRECADA��O
		JMenuItem mntmArrecadacao = new JMenuItem("14. Arrecada\u00E7\u00E3o");
		mntmArrecadacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Arrecadacao arrecada = new Arrecadacao();
				setarPainel();
				panel.add(arrecada);
				arrecada.setBounds(65, 100, 700, 500);
			}
		});
		
		JMenu mnCombo = new JMenu("Combo");
		menuBar.add(mnCombo);
		
		JMenuItem mntmCriarCombo = new JMenuItem("Criar Combo");
		mnCombo.add(mntmCriarCombo);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setMaximumSize(new Dimension(2, 77));
		menuBar.add(separator_5);
		menuBar.add(mntmArrecadacao);
		mntmArrecadacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		mntmArrecadacao.setBorderPainted(false);
		mntmArrecadacao.setBackground(new Color(0, 100, 0));
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setMaximumSize(new Dimension(2, 77));
		menuBar.add(separator_4);
			
		
	}
	
	// METODO PARA ARRUMAR O PAINEL PARA RECEBER OS JPANELS
	private void setarPainel() {
		panel.removeAll();
		panel.setLayout(null);
		panel.add(btnVoltar);
		panel.setVisible(true);
		img.setVisible(false);
		btnVoltar.setVisible(true);
	}
	
}
