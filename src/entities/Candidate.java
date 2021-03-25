package entities;

public class Candidate {

	private String nome;
	private Integer votosTotais;
	
	public Candidate(String nome, Integer votosTotais) {
		this.nome = nome;
		this.votosTotais = votosTotais;
	}
	public String getNome() {
		return nome;
	}
	public Integer getVotosTotais() {
		return votosTotais;
	}
	@Override
	public String toString() {
		return "Candidate [nome=" + nome + ", votosTotais=" + votosTotais + "]";
	}
}
