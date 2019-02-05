package modelo;

import java.util.ArrayList;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

public class Produto {
		private int id;
		private String nome;
		private double preco;
		
		private ArrayList<Pedido> pedidos = new ArrayList<>();
		
		public Produto(int id, String nome,  double preco) {
			super();
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
		
		//---------------------------------------
		@Override
		public String toString() {
			return "Produto [" + (nome != null ? "nome=" + nome + ", " : "")
					+ "preco=" + preco + ", "
					+ "]";
		}
		
	
}
