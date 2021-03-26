package entities;
import java.util.ArrayList;
import java.util.List;

public class CFamilia implements Familia {
	
	private List<Marcacoes> marcacao;
	private List<Utente> membros;
	private String nomeFamilia;
	
	public CFamilia(String nomeFamilia) {
		this.nomeFamilia = nomeFamilia;
		this.membros = new ArrayList<Utente>();
		
	}
	
	public String getNomeFamilia() {
		return this.nomeFamilia;
	}

	public List<Utente> getUtente() {
		return membros; 
	}
	
	public boolean temUtente(String nome) {
		for(Utente obterUtente : this.getUtente()) {
			if(obterUtente.getNome() == nome) {
				return true;
			}
		}
		return false;
	}
	

	public void addUtente(Utente utente) throws UtenteExc{
		if(this.temUtente(utente.getNome())) {
			throw new UtenteExc("Utente Existente");
		}
		else {
			this.getUtente().add(utente);
		}
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
	
	
	public void remUtente(Utente utente) throws UtenteExc {
		if(!this.temUtente(utente.getNome())) {
			throw new UtenteExc("Utente inexistente");
		}
		else {
			this.getUtente().remove(utente);
		}
	}

	public String listarFamilia() {
		return nomeFamilia +  "\n";
	}
	
	public String listarAgregado() {
		return this.getUtente() + nomeFamilia +  "\n";
	}


	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Familia) {
			return ((Familia)obj).getNomeFamilia() == this.getNomeFamilia();
		}
		else {
			return super.equals(obj);
		}
	}

}

