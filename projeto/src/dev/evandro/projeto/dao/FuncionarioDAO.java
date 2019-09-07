package dev.evandro.projeto.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dev.evandro.projeto.jdbc.ConnectionFactory;
import dev.evandro.projeto.modelo.Endereco;
import dev.evandro.projeto.modelo.Funcionario;
import dev.evandro.projeto.modelo.Login;

public class FuncionarioDAO {
	private Connection connection;
	
	public FuncionarioDAO() {
		connection = new ConnectionFactory().getConnection();
	}
	
	public void cadastrar(Funcionario funcionario) {
		String sql = "insert into funcionario (nome,sobreNome, cargo, dataAdmissao, status, endereco,"
				+ "numero, complemento, cep,bairro,cidade,estado, usuario, senha) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getSobreNome());
			stmt.setString(3, funcionario.getCargo());
			stmt.setDate(4, Date.valueOf(funcionario.getDataAdmissao()));
			stmt.setBoolean(5, funcionario.isStatus());
			stmt.setString(6, funcionario.getEndereco().getRua());
			stmt.setInt(7, funcionario.getEndereco().getNumero());
			stmt.setString(8, funcionario.getEndereco().getComplemento());
			stmt.setString(9, funcionario.getEndereco().getCep());
			stmt.setString(10, funcionario.getEndereco().getBairro());
			stmt.setString(11, funcionario.getEndereco().getCidade());
			stmt.setString(12, funcionario.getEndereco().getEstado());
			stmt.setString(13, funcionario.getLogin().getUsuario());
			stmt.setString(14, funcionario.getLogin().getSenha());
			
			
			stmt.execute();
			stmt.close();
			
			System.out.println("Usuario Funcionario com Sucesso!");
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Funcionario> getLista(){
		ArrayList<Funcionario> lista = new ArrayList<>();
		
		String sql = "select * from funcionario";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Funcionario f = new Funcionario();
				f.setNome(rs.getString("nome"));
				f.setSobreNome(rs.getString("sobrenome"));
				f.setDataAdmissao(rs.getDate("dataAdmissao").toLocalDate());
				f.setStatus(rs.getBoolean("status"));
				Endereco endereco = new Endereco();
				endereco.setRua(rs.getString("endereco"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setComplemento(rs.getString("complemento"));
				endereco.setCep(rs.getString("cep"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(rs.getString("estado"));
				f.setEndereco(endereco);
				Login login = new Login();
				login.setUsuario(rs.getString("usuario"));
				login.setSenha(rs.getString("senha"));
				
				lista.add(f);
			}
			
			rs.close();
			stmt.close();
			return lista;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Funcionario> consulta(String usuario, String senha){
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		
		String sql = "select * from funcionario where usuario=? and senha=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Funcionario f = new Funcionario();
				f.setNome(rs.getString("nome"));
				f.setSobreNome(rs.getString("sobrenome"));
				f.setDataAdmissao(rs.getDate("dataAdmissao").toLocalDate());
				f.setStatus(rs.getBoolean("status"));
				Endereco endereco = new Endereco();
				endereco.setRua(rs.getString("endereco"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setComplemento(rs.getString("complemento"));
				endereco.setCep(rs.getString("cep"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(rs.getString("estado"));
				f.setEndereco(endereco);
				Login login = new Login();
				login.setUsuario(rs.getString("usuario"));
				login.setSenha(rs.getString("senha"));
				f.setLogin(login);
				
				funcionarios.add(f);
			}
			
			rs.close();
			stmt.close();
			return funcionarios;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deleta(String nome) {
		String sql = "delete from funcionario where nome=?";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, nome);
			System.out.println(stmt.execute());
				
			stmt.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*public void update(String nome) {
		Funcionario funcionario = consulta(nome);
		String sql = "update funcionario set nome=?, sobrenome=?, dataAdmissao=?"
				+ "status=?, endereco=?, numero=? complemento=?, cep=?, bairro=?"
				+ "cidade=?, estado=?, usuario=?, senha=?";
	}*/
	
	
}
