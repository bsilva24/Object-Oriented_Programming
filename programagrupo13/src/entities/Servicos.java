package entities;

import java.util.List;

public interface Servicos {
	
	String getNome();
	
	int getOrdem();
	
	boolean temMarcacao(Marcacoes marcacoes);
	
	void addCategoria(Categoria categoria);
	
	List<Marcacoes> getMarcacao();
	
	List<Categoria> getCategoria();
	
	void addMarcacao(Marcacoes marcacoes);
	
	void removeMarcacao(Marcacoes marcacoes);
	
	boolean acceptCategoria(String cat);	
	
}

