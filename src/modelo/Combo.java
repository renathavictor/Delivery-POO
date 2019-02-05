package modelo;

import java.util.ArrayList;

public class Combo extends Produto {
	
	private String descricao;
	private double preco;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();

	public Combo(ArrayList<Produto> prods, String nome) {
		for (Produto p : prods)	{
			preco += super.getPreco();
		}
	}
}
