package entities;

import java.util.List;

public interface Familia {
	
	String getNomeFamilia();
	
	List<Utente> getUtente();
	
	boolean temUtente(String nome);

	public void addUtente(Utente utente) throws UtenteExc;
	
	public boolean temMarcacao(Marcacoes marcacoes);
	
	public void remUtente(Utente utente) throws UtenteExc;
	
	String listarFamilia();
	
}
