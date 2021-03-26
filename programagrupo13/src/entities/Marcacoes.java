package entities;

import java.util.List;

public interface Marcacoes {
	
	Utente getUtente(String nome, String faixaEtaria) throws UtenteExc;
	
	Profissional getProfissional(String nome, String categoria) throws ProfissionalExc;
	
	Servicos getServico(String nome) throws ServicosExc;
	
	void addProfissional(Profissional profissional) throws ProfissionalExc;
	
	public void addServico(Servicos servico) throws ServicosExc;
	
	public void addUtente(Utente utente) throws UtenteExc;
	
	List<Marcacoes> getMarcacoes();
}
