package entities;

import java.util.List;

public class CServicos implements Servicos {

	private String nome;
	private int ordem;
	private List<Marcacoes> marcacoes;
	private List<Categoria> categoria;
	
	public CServicos(int ordem, String nome) {
		this.ordem = ordem;
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getOrdem() {
		return this.ordem;
	}
	
	public List<Marcacoes> getMarcacao() {
		return this.marcacoes;
	}
	
	public List<Categoria> getCategoria() {
		return this.categoria;
	}
	
	public boolean temMarcacao(Marcacoes marcacoes) {
		for(Marcacoes marcServ : this.getMarcacao()){
			if(marcServ.equals(marcacoes)) {
				return true;
			}
		}
		return false;
	}

	public void addMarcacao(Marcacoes marcacoes) {
		this.getMarcacao().add(marcacoes);
	}

	public void removeMarcacao(Marcacoes marcacoes) {
		this.getMarcacao().remove(marcacoes);
	}
	
	
	public void addCategoria(Categoria categoria) {
		this.getCategoria().add(categoria);
	}
	
	public boolean acceptCategoria(String cat) {
		if (cat == "Medicina" || cat == "Enfermagem" || cat == "Auxiliar") {
		return true;
	}
	return false;
	}
}
