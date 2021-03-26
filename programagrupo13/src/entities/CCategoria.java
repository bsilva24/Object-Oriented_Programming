package entities;

public class CCategoria implements Categoria {

	private String nomeCategoria;
	private int ordem;
	
	public String getNomeCategoria() {
		return this.nomeCategoria;
	}
	
	public CCategoria(String nome, int ordem) {
		this.nomeCategoria = nome;
		this.ordem = ordem;
	}
	
	public int getOrdem() {
		return ordem;
	}
	
	public String listarCategoria() {
		return ordem + " " + nomeCategoria + "\n";
	}

}
