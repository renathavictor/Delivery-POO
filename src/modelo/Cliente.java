 package modelo;
import java.time.LocalDateTime;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/
import java.util.ArrayList;


public class Cliente {

	private String telefone;
	private String nome;
	private String email;
	private String endereco;
	
	private ArrayList<Pedido> pedidos = new ArrayList<>();	
	public ArrayList<Cliente> listarClientes;

	
	
	public Cliente(String telefone, String nome, String email, String endereco) {
		super();
		this.telefone = telefone;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void adicionarPedidosCliente(Pedido p) {
		pedidos.add(p);
	}
	
	public void removerPedidosCliente() {
		int ultimo = pedidos.size()-1;
		pedidos.remove(ultimo);
	}
	
	public Pedido localizarPedidoUltimo(String telCli){
		int ult = 0;
		ult = this.getPedidos().size()-1;
		return this.getPedidos().get(ult);
	}

	public Pedido obterPedidoAberto() {
		if (pedidos.isEmpty()) 
			return null;
		int ultimo = pedidos.size()-1;
		Pedido p = pedidos.get(ultimo);
		if (p.getStatus() == false)
			return p;
		return null; // adicionar throw new Exception
	}

	@Override
	public String toString() {
		return "Nome cliente: " + nome + "\n  telefone=" + telefone +  "\n  email=" + email + "\n  endereco=" + endereco + "\n  Quantidade de pedidos: " + pedidos.size() + ".\n";
	}
	
	
	

}
	


