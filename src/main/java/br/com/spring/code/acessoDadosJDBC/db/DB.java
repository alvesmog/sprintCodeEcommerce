package br.com.spring.code.acessoDadosJDBC.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * Esta classe tem a função de criar e gerenciar as conexões com o banco de dados
 * usando a tecnologia JDBC - api padrão do Java para conexão com DB
 *
 */

public class DB {
	
	private static Connection conn = null;

	/*
	 * Retorna a conexão aberta com o banco, caso não exista conexão, é criada uma.
	 * @return Este método retorna a conexão aberta
	 * @throws DBException 
	 */
	public static Connection getConnection() {

		if (conn == null) {
			try {
				Properties prop = DB.loadProperties();
				String dburl = prop.getProperty("dburl");
				conn = DriverManager.getConnection(dburl, prop);
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
		return conn;
	}
	
	/*
	 * Fecha a conexão aberta com o banco.
	 * @throws DBException 
	 */
	public static void closeConnection() {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}

	}

	/*
	 * Fecha a declaração de consulta como banco.
	 * @param st
	 * @throws DBException 
	 */
	public static void closeStatment(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}

	/*
	 * Fecha o resultado da execução da declaração de consulta como banco.
	 * @param rt
	 * @throws DBException 
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}

	/*
	 * Carrega as propriedades de conexão com o banco.
	 * @return Retorna as propriedades
	 * @throws DBException 
	 */
	private static Properties loadProperties() {
		try {
			FileInputStream fs = new FileInputStream("db.properties");
			Properties prop = new Properties();
			prop.load(fs);
			return prop;
		} catch (FileNotFoundException e) {
			throw new DBException(e.getMessage());
		} catch (IOException e) {
			throw new DBException(e.getMessage());
		}
	}

}
