package entities;

import java.util.List;

public class CPessoa implements Pessoa {

	public String nome;
	private List<Marcacoes> marcacao;
	
	public CPessoa() {

	}
	
	public CPessoa(String nome) {
		this.nome = nome;	
	}
	
	public String getNome() {
		return nome;
	}
	
	public boolean temMarcacao(Marcacoes marcacoes) {
		for(Marcacoes marc : this.getMarcacao()) {
			if(marc.equals(marcacoes)) {
				return true;
			}
		}
		return false;
	}
	
	public List<Marcacoes> getMarcacao() {
		return this.marcacao;
	}

	public void addMarcacao(Marcacoes marcacoes) {
		this.getMarcacao().add(marcacoes);
		
	}

	public void remMarcacao(Marcacoes marcacoes) {
		this.getMarcacao().remove(marcacoes);
		
	}

	public void limparMarcacao(Marcacoes marcacoes) {
		this.getMarcacao().clear();
	
	}

}
