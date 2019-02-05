package repositorio;

import java.util.Comparator;

import modelo.Produto;

public class Criterio implements Comparator<Produto>{

	@Override
	public int compare(Produto prod1, Produto prod2) {
		return prod1.getDescricao().compareTo(prod2.getDescricao());
	}
	
}
