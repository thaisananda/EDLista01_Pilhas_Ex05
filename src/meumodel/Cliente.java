package meumodel;

public class Cliente {
	
	private int numero;
	private String nome;
	
	public Cliente(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return "Senha: " + numero + " | Nome: " + nome;
	}

}
