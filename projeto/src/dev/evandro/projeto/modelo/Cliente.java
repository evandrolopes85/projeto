package dev.evandro.projeto.modelo;

public class Cliente {
	private String razaoSocial;
	private String cpfOucnpf;
	private Endereco endereco;
	private Contato contato;
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCpfOucnpf() {
		return cpfOucnpf;
	}
	public void setCpfOucnpf(String cpfOucnpf) {
		this.cpfOucnpf = cpfOucnpf;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
}
