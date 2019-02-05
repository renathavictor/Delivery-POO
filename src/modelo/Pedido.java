package modelo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/
import java.util.ArrayList;


public class Pedido {
	private int id;
	private LocalDateTime data = LocalDateTime.now();
	private double total;
	private String entregador;
	private boolean fechado = true; // está fechado
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private Cliente cliente;
	
	public Pedido(int id) {
		super();
		this.id = id;
		setStatus(false);
	}
	
	public void adicionarProduto(Produto p){
		produtos.add(p);
	}
	
	public void removerProduto(Produto p){
		produtos.remove(p);
	}

	public Produto localizarProduto(String nome){
		for(Produto p : produtos){
			if(p.getDescricao().equalsIgnoreCase(nome))
				return p;
		}
		return null;
	}
	
	public ArrayList<Produto> produtosPedido() {
		return produtos;
	}
	

	public int getTotalProdutos(){
		return produtos.size();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public void setStatus(boolean s) {
		fechado = s;
	}
	
	public boolean getStatus() {
		return fechado;
	}
	
	public void adicionarClientePedido(Cliente cli) {
		cliente = cli;
	}
	
	public Cliente verClientePedido() {
		return cliente;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	
	public double totalPedido() {
		for(Produto p : produtos) {
			total += p.getPreco();
		}
		return total;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String texto = "Pedido ID=" + id + "\n -- data: " + this.getData().format(formatador) + "\n -- " + produtos.size() + " produtos.";
		texto += "\n -- produtos:";
		if (produtos.isEmpty())
			texto += " vazia";
		else 	
			for(Produto p: produtos) 
				texto += " " + p.getDescricao();

		return texto + ".\n";
	}

}
	


