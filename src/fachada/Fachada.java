package fachada;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import modelo.Cliente;
import modelo.Combo;
import modelo.Pedido;
import modelo.Produto;
import repositorio.Restaurante;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POO - Programa��o Orientada a Objetos
 * Prof. Fausto Ayres
 *
 */

public class Fachada {
	private static Restaurante restaurante = new Restaurante();
	private static int idPedido=0;	
	private static int idProduto=0;
	
	
	public static ArrayList<Produto> listarProdutos(String prod) {
		ArrayList<Produto> produtos = restaurante.getProdutos();
		ArrayList<Produto> todos = new ArrayList<Produto>();
		if (prod.equals("")) 
			return produtos;
		else {
			for(Produto p : produtos){
				if(p.getDescricao().toLowerCase().contains(prod.toLowerCase()))
					todos.add(p);
			}
			return todos;			
		}
	}
	
	public static Collection<Cliente> listarClientes() {
		return restaurante.getClientes();
	}
	
	public static ArrayList<Pedido> listarPedidos() {
		return restaurante.getPedidos();
	}
	
	public static Pedido listarPedido(int p) { 		// para teste
		return restaurante.localizarPedido(p);
	}
	
	public static ArrayList<Pedido> listarPedidos(String tel) throws Exception {
		Cliente c = restaurante.localizarCliente(tel);
		if (c == null)
			throw new Exception("Cliente nao realizou nenhum pedido ainda!");
		else
			return c.getPedidos();
	}

	public static Produto cadastrarProduto(String nome, double preco) throws  Exception{
		Produto p = restaurante.localizarProduto(nome);
		if (p!=null)
			throw new Exception("cadastrar produto: produto ja cadastrado: " + nome);		
		//criar produto e adicionar na restaurante
		idProduto++;
		p = new Produto(idProduto, nome,preco);
		restaurante.adicionarProduto(p);
		return p;
	}

	public static Pedido abrirPedido(String telCli) throws Exception{
		Pedido p = restaurante.localizarPedido(telCli);
		if (p != null)
			throw new Exception("Abertura de pedido invalida, pedido ja aberto!");
		
		Cliente cli = restaurante.localizarCliente(telCli);
		if(cli == null) 
			throw new Exception("inclusao no pedido - cliente nao cadastrado:" + telCli);
		
		// abrir pedido
		idPedido++;
		p = new Pedido(idPedido);	
		restaurante.abrirPedido(p);
		
	    cli.adicionarPedidosCliente(p);
	    p.adicionarClientePedido(cli);
		return p;
	}
	
	public static Cliente cadastrarCliente(String telefone, String nome, String email, String endereco) throws Exception {
		Cliente c = restaurante.localizarCliente(telefone);
		if (c != null)
			throw new Exception("cadastro de cliente: cliente ja cadastrado: " + c.getNome());
		
		// criar cliente e adicionar no restaurante
		c = new Cliente(telefone, nome, email, endereco);
		restaurante.adicionarCliente(c);
		return c;
	}

	public static void adicionarProdutoPedido(String tele_cliente, int id_produto) throws  Exception {	
		Cliente cli = restaurante.localizarCliente(tele_cliente);
		if(cli == null) 
			throw new Exception("inclusao no pedido - cliente nao cadastrado: " + tele_cliente);
	
		Pedido pedido = cli.obterPedidoAberto();
		if(pedido == null) 
			throw new Exception("inclusao no pedido - nao existe pedido aberto do cliente:");

		Produto produto = restaurante.localizarProduto(id_produto);
		if(produto == null)
			throw new Exception("inclusao no pedido - produto nao cadastrado:" + cli.getNome() + id_produto);

		pedido.adicionarProduto(produto); 	
		produto.adicionarPedido(pedido);
		
	}

	public static void removerProdutoPedido(String telCli, int idProduto) throws Exception{
		Cliente cli = restaurante.localizarCliente(telCli);
		if(cli == null) 
			throw new Exception("remocao no pedido - cliente nao cadastrado: " + telCli);
	
		Pedido pedido = cli.obterPedidoAberto();
		if(pedido == null) 
			throw new Exception("remocao no pedido - nao existe pedido aberto do cliente:");

		Produto produto = restaurante.localizarProduto(idProduto);
		if(produto == null)
			throw new Exception("remocao no pedido - produto nao cadastrado:" + cli.getNome() + idProduto);
		produto.removerPedido(pedido);
		pedido.removerProduto(produto);
	}
	
	public static Pedido consultarPedido(String telCli) throws Exception {   
		Cliente c = restaurante.localizarCliente(telCli);
		Pedido p = c.localizarPedidoUltimo(telCli);
		if (p == null) {			
			throw new Exception("Cliente nao realizou nenhum pedido ainda!");
		} else if (p.isFechado() == true) {
			throw new Exception("O cliente nao possui pedido aberto!");
		}
		return p;
	}
	
	public static void cancelarPedido(String telCli) throws Exception {
		Pedido p = restaurante.localizarPedido(telCli);
		if (p == null)
			throw new Exception("Não é possivel cancelar o pedido, pedido inexistente!");
		restaurante.removerPedido(p, telCli);
	}
	
	public static void excluirPedido(int IdPedido) throws Exception {
		Pedido p = restaurante.localizarPedido(IdPedido);
		if (p == null)
			throw new Exception("Não é possivel excluir o pedido, pedido inexistente!");
		Boolean fechado = p.isFechado();
		if (fechado == false)
			throw new Exception("O pedido ainda está aberto, tente cancelar");
		restaurante.removerPedido(p, p.verClientePedido().getTelefone());
		
	}
	
	public static void fecharPedido(String telCli, String entregador) throws Exception {
		Cliente cli = restaurante.localizarCliente(telCli);
		if(cli == null) 
			throw new Exception("fechamento de pedido - cliente nao cadastrado: " + telCli);
		Pedido ped = restaurante.localizarCliente(telCli).obterPedidoAberto();
		ped.setFechado(true);
		ped.setEntregador(entregador);
	}
	
	public static void fecharPedido(String telCli) throws Exception {
		Cliente cli = restaurante.localizarCliente(telCli);
		if(cli == null) 
			throw new Exception("fechamento de pedido - cliente nao cadastrado: " + telCli);
		restaurante.localizarCliente(telCli).obterPedidoAberto().setFechado(true);  
	}
	
	public static void enviarPedido(String telCli, String senha) throws Exception {
		Cliente c = restaurante.localizarCliente(telCli);
		if(c == null) 
			throw new Exception("envio de pedido - cliente nao cadastrado: " + telCli);
		Pedido p = c.localizarPedidoUltimo(telCli);
		if (p == null) {
			throw new Exception("Nao é possivel enviar nota, pedido inexistente!");	
		}
		if (p.isFechado() == true) {
			restaurante.criarPdf(p);
			restaurante.enviarEmail(c.getEmail(), senha);			
		}
		else
			throw new Exception("Cliente não possui pedido fechado");
	}
	
	public static double calcularArrecadacao(int dia) {
		double total = 0.0;
		ArrayList<Pedido> todosP = restaurante.getPedidos();
		for(Pedido p : todosP) {
			if (p.getData().getDayOfMonth() == dia)
				total += p.totalPedido();
		}
		return total;
	}
	
	public static Produto criarCombo(String nome, List<Integer> listaid) throws Exception {
		double off = 0.90;
		double preco = 0.0;
		ArrayList<Produto> auxProds = new ArrayList<>();
		for (int id : listaid) {
			Produto prod = restaurante.localizarProduto(id);
			if (prod == null)
				throw new Exception("Produto de ID " + id + " nao encontrado");
			auxProds.add(prod);
			preco += prod.getPreco();
		}
		idProduto++;
		Combo combo = new Combo(idProduto, auxProds, nome, preco*off);
		
		restaurante.adicionarProduto(combo); 
		return combo;
	}
	
	

}//class
