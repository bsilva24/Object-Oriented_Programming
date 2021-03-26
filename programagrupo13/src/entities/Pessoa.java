package entities;

import java.util.List;

public interface Pessoa {
	
	String getNome();
	
	List<Marcacoes> getMarcacao();
	
	boolean temMarcacao(Marcacoes marcacoes);
	
	void addMarcacao(Marcacoes marcacoes);
	
	void remMarcacao(Marcacoes marcacoes);
	
	void limparMarcacao(Marcacoes marcacoes);
	
}
