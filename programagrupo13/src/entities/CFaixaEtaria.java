package entities;

public class CFaixaEtaria implements FaixaEtaria {

	private String nome;
	private int ordem;
	
	public CFaixaEtaria(String nome, int ordem) {
		this.nome = nome;
		this.ordem = ordem;
	}

	public String getNome() {
		return this.nome;
		
	}
	public int getOrdem() {
		return ordem;
	}

}
