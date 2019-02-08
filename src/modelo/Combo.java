package modelo;

import java.util.ArrayList;

public class Combo extends Produto {
	
	private String descricao;
	private int id;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();

	public Combo(int id, ArrayList<Produto> prods, String nome, double preco) {
		super(id, nome, preco);
		this.descricao = nome;
		for (Produto p : prods)	{
			produtos.add(p);
		}
		this.setPreco(preco);
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public double getPreco() {
		return super.getPreco();
	}
	
	
	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		String text =  "Combo ID: " + getId() + "\n Descricao combo: " + descricao + "\n preco total: R$" + getPreco() + "\n produtos: |\n";
		for (Produto p : produtos) {
			text += " " + p.getDescricao() + " | ";
		}
		return text + "\n Quantidade pedida: " + super.quantidadePedida() + "\n";
	}
	
	
}
