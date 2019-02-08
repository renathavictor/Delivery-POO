package modelo;

import java.util.ArrayList;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programacao Orientada a Objetos
 * Discente: Renatha Victor
 **********************************/

public class Produto {
	private int id;
	private String nome;
	private double preco;
	
	private ArrayList<Pedido> pedidos = new ArrayList<>();
	
	public Produto(int id, String nome,  double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public String getDescricao() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}	
	
	public int getId() {
		return id;
	}
	
	public void adicionarPedido(Pedido pedido) {
		pedidos.add(pedido);
		
	}	
	
	public void removerPedido(Pedido p) {
		pedidos.remove(p);
	}
	
	public int quantidadePedida() {
		return pedidos.size();
	}
	
	@Override
	public String toString() {
		return "Produto ID: " + getId() + "\n descricao: " + (nome != null ? "" + nome + "\n " : "")
				+ "preco: R$ " + preco + "\n "
				+ "Quantidade pedida: " + quantidadePedida() + "\n";
	}

		
	
}
