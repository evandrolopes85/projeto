package dev.evandro.projeto.modelo;

import java.time.LocalDate;

public class Servico {
	private String descricao;
	private int quantidade;
	private LocalDate dataDoPedido;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public LocalDate getDataDoPedido() {
		return dataDoPedido;
	}
	public void setDataDoPedido(LocalDate dataDoPedido) {
		this.dataDoPedido = dataDoPedido;
	}
	
	
}
