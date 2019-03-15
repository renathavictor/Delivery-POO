package aplicacao_swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

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
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try{
					//  pre-cadastro
					
					// clientes
					Cliente joao = Fachada.cadastrarCliente("98000-0000", "joao", "joao@gmail.com","Rua dos Tronos, 3");
		            System.out.println("cadastrou cliente = "+joao.getNome());
					Cliente renatha = Fachada.cadastrarCliente("981111-0000", "Renatha", "poo.projeto.delivery@gmail.com","Rua da Justica, 12");
		            System.out.println();
		            
		            // produtos
		            Produto pizza = Fachada.cadastrarProduto("Pizza", 30);
		            System.out.println("cadastrou produto = "+pizza.getDescricao() + " " + pizza.getId());
		            Produto sushi = Fachada.cadastrarProduto("Sushi", 40);
		            System.out.println("cadastrou produto = "+sushi.getDescricao() + " " + sushi.getId());
		            Produto cocaCola = Fachada.cadastrarProduto("Coca-cola", 10);
		            System.out.println("cadastrou produto = "+cocaCola.getDescricao() + " " + cocaCola.getId());
		            Produto guarana = Fachada.cadastrarProduto("Guarana", 5);   
		            System.out.println("cadastrou produto = "+guarana.getDescricao() + " " + guarana.getId());     
		            Produto pizzaDoce = Fachada.cadastrarProduto("Pizza doce", 35);
		            System.out.println("cadastrou produto = "+ pizzaDoce.getDescricao() + " " + pizzaDoce.getId());
		            
		            // abrir pedidos
		            System.out.println("\nAbrir pedidos");          
		            Pedido pedido1 = Fachada.abrirPedido("98000-0000");
		            System.out.println("abrir pedido = " + pedido1.getId());
		            Pedido pedido2 = Fachada.abrirPedido("98821-2994");
		            System.out.println("abrir pedido = " + pedido2.getId());
		            
		            System.out.println("\nconsultar pedido = "+ Fachada.consultarPedido("98000-0000"));
		            System.out.println("\nconsultar pedido = "+ Fachada.consultarPedido("98821-2994"));
		            
		            // adicao de produtos
		            System.out.println("\n adicao dos produtos ao Pedido");         
		            Fachada.adicionarProdutoPedido("98000-0000", 1);
		            Fachada.adicionarProdutoPedido("98000-0000", 1);
		            Fachada.adicionarProdutoPedido("98000-0000", 3);            
		            Fachada.adicionarProdutoPedido("98821-2994", 2);    
		            Fachada.adicionarProdutoPedido("98821-2994", 4);   
		            
		            // adicao de combos
		            List<Integer> listaid = new ArrayList<>();
					listaid.add(pizza.getId());
					listaid.add(pizza.getId());
					listaid.add(cocaCola.getId());
					Produto combo1 = Fachada.criarCombo("Combo Pizzas", listaid);	
					System.out.println("criou combo="+combo1);	
					
					listaid.clear();
					listaid.add(sushi.getId());
					listaid.add(guarana.getId());
					Produto combo2 = Fachada.criarCombo("Combo Sushi", listaid);	
					System.out.println("criou combo="+combo2);
					System.out.println(Fachada.listarProdutos(""));
		            
		            
		            // remocao de produto
		            Fachada.removerProdutoPedido("98821-2994", 4);  
					
		            System.out.println("\nconsultar pedido = "+ Fachada.consultarPedido("98000-0000"));
		            System.out.println("\nconsultar pedido = "+ Fachada.consultarPedido("98821-2994"));
		            
					System.out.println("pre-cadastro concluido");

				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "Sistema encerrado, ate breve!");
			}
		});
		
		// configuracoes padroes
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
		
		// BOTAO DE VOLTAR A TELA PADRAO
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
		menuBar.add(mnProdutos);
		mnProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			// CADASTRAR PRODUTO		
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
			// LISTAR PRODUTOS
		JMenuItem mntmListar = new JMenuItem("1. Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProdutos buscarProd = new ListarProdutos();
				setarPainel();
				panel.add(buscarProd);
				buscarProd.setBounds(65, 100, 700, 500);	
			}
		});
		mnProdutos.add(mntmListar);
		
		JSeparator separator = new JSeparator();
		separator.setMaximumSize(new Dimension(2, 77));
		separator.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator);
		
		
		// MENU DOS CLIENTES
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		mnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			// CADASTRAR CLIENTES
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
			// LISTAR CLIENTES
		JMenuItem mntmListarCli = new JMenuItem("2. Listar todos");
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
		menuBar.add(mnPedidos);
		mnPedidos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			// ABRIR PEDIDOS
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
			// LISTAR TODOS OS PEDIDOS
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
			// EXCLUIR PEDIDO
		JMenuItem mntmExcluirPedido = new JMenuItem("16. Excluir Pedido");
		mnPedidos.add(mntmExcluirPedido);
		mntmExcluirPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirPedido excluirPedido = new ExcluirPedido();
				setarPainel();
				panel.add(excluirPedido);
				excluirPedido.setBounds(65, 100, 700, 500);
			}
		});
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setMaximumSize(new Dimension(2, 77));
		menuBar.add(separator_2);
		
		
		// MENU PEDIDOS RELACIONADOS AOS CLIENTES
		JMenu mnPedidocliente = new JMenu("Pedido/Cliente");
		//mnPedidocliente.setPreferredSize(new Dimension(150, 22));
		menuBar.add(mnPedidocliente);
		mnPedidocliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			// ADICIONAR PRODUTO NO PEDIDO
		JMenuItem mntmAdcionarProd = new JMenuItem("8. Adcionar Produto");
		mntmAdcionarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdicionarProduto addProduto = new AdicionarProduto();
				setarPainel();
				panel.add(addProduto);
				addProduto.setBounds(65, 100, 700, 500);
			}
		});
			// CONSULTAR PEDIDOS
		JMenuItem mntmConsultarPed = new JMenuItem("4. Consultar Pedidos");
		mnPedidocliente.add(mntmConsultarPed);
		mntmConsultarPed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarPedido consultaPedido = new ConsultarPedido();
				setarPainel();
				panel.add(consultaPedido);
				consultaPedido.setBounds(65, 100, 700, 500);
			}
		});
		mnPedidocliente.add(mntmAdcionarProd);
			// RETIRAR PRODUTO DO PEDIDO
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
			// FECHAR PEDIDO
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
			// CANCELAR PEDIDO
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
		
		
		// MENU DA ARRECADACAO
		JMenuItem mntmArrecadacao = new JMenuItem("Arrecadacao");
		mntmArrecadacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Arrecadacao arrecada = new Arrecadacao();
				setarPainel();
				panel.add(arrecada);
				arrecada.setBounds(65, 100, 700, 500);
			}
		});
		
		// MENU COMBO
		JMenu mnCombo = new JMenu("Combo");
		menuBar.add(mnCombo);
		
		JMenuItem mntmCriarCombo = new JMenuItem("15. Criar Combo");
		mntmCriarCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CriarCombo criarCombo = new CriarCombo();
				setarPainel();
				panel.add(criarCombo);
				criarCombo.setBounds(65, 100, 700, 500);
			}
		});
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
