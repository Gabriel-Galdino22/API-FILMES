package br.com.fiap.connectionFactory;

import java.sql.*;

public class ConnectionFactory {
	

	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private String user = "RM550711";
	private String senha = "221004";

	public Connection getConnection() throws SQLException {

		try {
			Class.forName(driver);
			System.out.println("Conexão realizada!");
			return DriverManager.getConnection(url, user, senha);

		} catch (ClassNotFoundException erro) {
			System.out.print("Não foi possível encontrar: " + erro.toString());
			throw new RuntimeException(erro);

		
	}
	
}

	
	
}