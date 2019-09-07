package dev.evandro.projeto.teste;

import java.sql.Connection;

import dev.evandro.projeto.jdbc.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) {
		Connection con = new ConnectionFactory().getConnection();
		
		System.out.println("Conexao Realizada com Sucesso!");
	}

}
