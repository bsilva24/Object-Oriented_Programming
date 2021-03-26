package entities;
import java.util.ArrayList;
import java.util.List;

public class CMarcacoes implements Marcacoes {
	
	private List<Servicos> servico;
	private List<Profissional> profissional;
	private List<Utente> utente;
	private List<Marcacoes> marcacao;
	
	public CMarcacoes() {
		this.servico = new ArrayList<Servicos>();
		this.profissional = new ArrayList<Profissional>();
		this.utente = new ArrayList<Utente>();
	}
	
	public List<Utente> getNomeUtente() {
		return this.utente;
	}
	
	public List<Servicos> getNomeServico() {
		return this.servico;
	}
	
	public List<Profissional> getNomeProfissional() {
		return this.profissional;
	}
	
	public List<Marcacoes> getMarcacoes() {
		return this.marcacao;
	}
	
	public boolean temUtente(String nome) {
		for(Utente paciente : this.getNomeUtente()) {
			if(paciente.getNome() == nome) {
				return true;
			}
		}
		return false;
	}

	public Utente getUtente(String nome, String faixaEtaria) throws UtenteExc {
		if(!this.temUtente(nome)) {
			throw new UtenteExc("Utente inexistente.");
		}
		Utente resposta = null;
		Utente utente = new CUtente(nome, faixaEtaria);
		for(Utente paciente : this.getNomeUtente()) {
			if(paciente.equals(utente)) {
				resposta = paciente;
				break;
			}
		}
		return resposta;
	}

	public void addUtente(Utente utente) throws UtenteExc {
		if(this.temUtente(utente.getNome())) {
			throw new UtenteExc("Utente existente.");
		}
		else {
			this.getNomeUtente().add(utente);
		}
	}
	
	public boolean temProfissional(String nome) {
		for(Profissional profissional : this.getNomeProfissional()) {
			if(profissional.getNome() == nome) {
				return true;
			}
		}
		return false;
	}
	
	public Profissional getProfissional(String nome, String categoria) throws ProfissionalExc {
		if(!this.temProfissional(nome)) {
			throw new ProfissionalExc("Profissional inexistente.");
		}
		Profissional resposta = null;
		Profissional pro = new CProfissional(nome, categoria);
		for(Profissional prof : this.getNomeProfissional()) {
			if(prof.equals(pro)) {
				resposta = prof;
				break;
			}
		}
		return resposta;
	}
	
	public void addProfissional(Profissional profissional) throws ProfissionalExc {
		if(this.temProfissional(profissional.getNome())) {
			throw new ProfissionalExc("Profissional existente.");
		}
		else {
			this.getNomeProfissional().add(profissional);
		}
	}
	
	public boolean temServico(String nome) {
		for(Servicos servico : this.getNomeServico()) {
			if(servico.getNome() == nome) {
				return true;
			}
		}
		return false;
	}
	
	public Servicos getServico(String nome) throws ServicosExc {
		if(!this.temServico(nome)) {
			throw new ServicosExc("Serviço inexistente.");
		}
		Servicos resposta = null;
		Servicos serv = new CServicos(1, nome);
		for(Servicos servicoMarc : this.getNomeServico()) {
			if(servicoMarc.equals(serv)) {
				resposta = servicoMarc;
				break;
			}
		}
		return resposta;
	}
	
	public void addServico(Servicos servico) throws ServicosExc {
		if(this.temServico(servico.getNome())) {
			throw new ServicosExc("Servico existente.");
		}
		else {
			this.getNomeServico().add(servico);
		}
	}

	
}