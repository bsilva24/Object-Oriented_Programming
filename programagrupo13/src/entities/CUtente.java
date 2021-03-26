package entities;

import java.util.ArrayList;
import java.util.List;

public class CUtente extends CPessoa implements Utente{
	
	private Familia familia;
	private String faixaEtaria;
	private List<Marcacoes> marcacao;
	
	public CUtente(String nome, String faixaEtaria) {
		super(nome);
		this.faixaEtaria = faixaEtaria;
		this.marcacao = new ArrayList<Marcacoes>();
	
	}

	public CUtente(String nome, Familia familia) {
		super(nome);
		this.familia = familia;
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}
	
	public Familia getFamilia() {
		return this.familia;
	}
	
	public String listarUtente() {
		return nome + " " + faixaEtaria + "\n";
	}
	
	public String getfaixaEtaria() {
		return this.faixaEtaria;
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
		return this.marcacao;
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
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Utente) {
			return ((Utente)obj).getNome() == this.getNome() &&
					((Utente)obj).getfaixaEtaria() == this.getfaixaEtaria();
		}
		else {
			return super.equals(obj);
		}
	}
	
}


