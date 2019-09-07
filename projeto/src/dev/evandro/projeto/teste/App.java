package dev.evandro.projeto.teste;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dev.evandro.projeto.jdbc.ConnectionFactory;

public class App {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Testanto");

		JButton button = new JButton("Login");
		JPanel painel = new JPanel();
		JLabel labelUsuario = new JLabel("Usuario: ");
		JTextField usuario = new JTextField(20);
		JLabel labelSenha = new JLabel("Senha: ");
		JTextField senha = new JTextField(20);

		painel.add(labelUsuario);
		painel.add(usuario);
		painel.add(labelSenha);
		painel.add(senha);
		painel.add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				boolean found = false;
				String sql = "select * from funcionario where usuario=? and senha=?";

				try {
					PreparedStatement stmt = new ConnectionFactory().getConnection().prepareStatement(sql);
					stmt.setString(1, usuario.getText());
					stmt.setString(2, senha.getText());
					ResultSet rs = stmt.executeQuery();

					while (rs.next()) {
						found = true;
						System.out.println("Teste");
					}

					rs.close();
					stmt.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
				
				if(found == true) {
					JOptionPane.showMessageDialog(null, "Usuario Cadastrado!");
				}else {
					JOptionPane.showMessageDialog(null, "Usuario não Cadastrado!");
				}
			}
		});

		

		frame.getContentPane().add(BorderLayout.CENTER, painel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(300, 300);

		frame.setVisible(true);
	}

}
