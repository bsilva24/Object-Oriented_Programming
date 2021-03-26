package entities;

import java.util.ArrayList;
import java.util.List;

public class CProfissional extends CPessoa implements Profissional {

	private String categoria;
	private List<Marcacoes> marcacao;
	
	public CProfissional(String categoria, String nome) {
		this.categoria = categoria;
		this.nome = nome;
		this.marcacao = new ArrayList<Marcacoes>();
	}

	public String getCategoria() {
		return categoria;
	}
	
	
	public String listarProfissional() {
		return categoria + " " + nome + "\n";
	}
	
	
	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public boolean temMarcacao(Marcacoes marcacoes) {
		for(Marcacoes marc : this.getMarcacao()) {
			if(marc.equals(marcacoes)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public List<Marcacoes> getMarcacao() {
		return marcacao;
	}

	@Override
	public void addMarcacao(Marcacoes marcacoes) {
		this.getMarcacao().add(marcacoes);
		
	}

	@Override
	public void remMarcacao(Marcacoes marcacoes) {
		this.getMarcacao().remove(marcacoes);
		
	}

	@Override
	public void limparMarcacao(Marcacoes marcacoes) {
		this.getMarcacao().clear();
	
	}
	
	
}
