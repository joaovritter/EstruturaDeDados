package Avaliacao;

import java.util.Objects;

public class Atleta {
	public String fone;
	public String nome;
	public String apelido;
	public String dataNascimento;
	public String pontuacao;
	
	
	public Atleta (String nome, String apelido, String fone, String dataNascimento, String pontuacao) {
		this.nome = nome;
		this.apelido = apelido;
		this.fone = fone;
		this.dataNascimento = dataNascimento;
		this.pontuacao = pontuacao;
	}
	
	public Atleta() {
		
	}
	
	
	@Override
	public String toString() {
		return "Atleta: "+ nome + ", Apelido: " + apelido + ", Fone: " + fone + ", Data de nascimento: " + dataNascimento
				+ ", Pontuacao: " + pontuacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fone);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atleta other = (Atleta) obj;
		return Objects.equals(nome, other.nome);
	}

	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(String pontuacao) {
		this.pontuacao = pontuacao;
	}


}


