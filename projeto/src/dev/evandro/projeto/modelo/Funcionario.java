package dev.evandro.projeto.modelo;

import java.time.LocalDate;

public class Funcionario {
	private String nome;
	private String sobreNome;
	private String cargo;
	private Endereco endereco;
	private LocalDate dataAdmissao;
	private boolean status;
	private Login login;
	
	public Funcionario(String nome, String sobreNome, String cargo, Endereco endereco, 
			LocalDate dataAdmissao, boolean status, Login login) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.cargo = cargo;
		this.endereco = endereco;
		this.dataAdmissao = dataAdmissao;
		this.status = status;
		this.login = login;
	}
	
	public Funcionario() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	
}
