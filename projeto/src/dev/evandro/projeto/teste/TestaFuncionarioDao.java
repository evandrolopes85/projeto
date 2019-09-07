package dev.evandro.projeto.teste;

import java.io.Console;
import java.time.LocalDate;
import java.util.Scanner;

import dev.evandro.projeto.dao.FuncionarioDAO;
import dev.evandro.projeto.modelo.Endereco;
import dev.evandro.projeto.modelo.Funcionario;
import dev.evandro.projeto.modelo.Login;

public class TestaFuncionarioDao {
	public enum Cargo{
		TECINFO, GERENTE, ASSISTADMIN, OUTRO;
	}
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		//String nome, String sobreNome, String cargo, Endereco endereco, 
		//LocalDate dataAdmissao, boolean status, Login login
		/*System.out.println("Nome: ");
		String nome = teclado.nextLine();
		System.out.println("Sobrenome: ");
		String sobrenome = teclado.nextLine();
		System.out.println("Cargo: ");
		String cargo = teclado.nextLine();
		System.out.println();
		System.out.println("Rua: ");
		String rua = teclado.nextLine();
		System.out.println("Numero: ");
		int numero = Integer.parseInt(teclado.nextLine());
		System.out.println("Complemento: ");
		String complemento = teclado.nextLine();
		System.out.println("CEP: ");
		String cep = teclado.nextLine();
		System.out.println("Bairro: ");
		String bairro = teclado.nextLine();
		System.out.println("Cidade: ");
		String cidade = teclado.nextLine();
		System.out.println("Estado: ");
		String estado = teclado.nextLine();
		System.out.println("Usuario ");
		String usuario = teclado.nextLine();
		System.out.println("Senha: ");
		String senha = teclado.nextLine();
		Funcionario funcionario = new Funcionario(nome, sobrenome,cargo,
				new Endereco(rua, numero, complemento, cep, bairro, cidade, estado),
				LocalDate.now(), true, new Login(usuario, senha));*/
		Funcionario funcionario = new Funcionario("Evandro", "Lopes","Tecnico em Informática",
				new Endereco("Leandro", 3, "A", "08348024", "Jd. Roseli", "São Paulo", "SP"),
				LocalDate.now(), true, new Login("evandro", "evandro"));
		
		FuncionarioDAO daoFuncionario = new FuncionarioDAO();
		
		daoFuncionario.cadastrar(funcionario);
	}

}
