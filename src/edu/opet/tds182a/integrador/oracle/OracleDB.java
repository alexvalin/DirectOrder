package edu.opet.tds182a.integrador.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;

import edu.opet.tds182a.integrador.cliente.Cliente;
import edu.opet.tds182a.integrador.cliente.Usuario;



public class OracleDB {

	/*
	 * constantes da clase
	 */
	/**
	 * 
	 */
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";

	/**
	 * 
	 */
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";

	/**
	 * 
	 */
	private static final String DB_USER = "system";

	/**
	 * 
	 */
	private static final String DB_PASSWORD = "system";

	/*
	 * variaveis da instancia
	 */
	/**
	 * 
	 */
	private String dbUrl = null;
	/**
	 * 
	 */
	private String dbUser = null;
	/**
	 * 
	 */
	private String dbPassword = null;
	/**
	 * 
	 */
	private Connection connection = null;

	/*
	 * metodo construtor
	 */
	/**
	 * 
	 * @throws ClassNotFoundException
	 */
	public OracleDB() {
		// carrega driver do oracle
		try {
			Class.forName(OracleDB.DB_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// atribui variaveis de conexao com o bd
		this.dbUrl = OracleDB.DB_URL;
		this.dbUser = OracleDB.DB_USER;
		this.dbPassword = OracleDB.DB_PASSWORD;
	}

	/*
	 * métodos de ações da classe
	 */
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	}

	/**
	 * 
	 * @throws SQLException
	 */
	public void disconnect() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean inserir(Cliente cliente) {
		PreparedStatement pstmt = null;
		try {
			connection = connect();

			String query = "insert into EMPRESAS(CNPJ,RAZAOSOCIAL, ENDERECO, TELEFONE,  EMAIL) values ("
					+ cliente.cnpj + ", '" + cliente.razaoSocial + "', '" + cliente.endereco
					+ "','"+cliente.telefone +"','" +cliente.email +"')";

			System.out.println(query);

			pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();
			if (pstmt != null)
				pstmt.close();

			disconnect();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Cliente[] listarTodosClientes() {
		PreparedStatement pstmt = null;

		Cliente[] listaClientesRetorno = new Cliente[100];
		int contador = 0;

		try {
			connection = connect();
			String query = "SELECT CNPJ, RAZAOSOCIAL,ENDEREO, TELEFONE, EMAIL  FROM EMPRESAS";
			pstmt = connection.prepareStatement(query);
			// executa a clausula e armazena o resultado no ResultSet
			ResultSet rs = pstmt.executeQuery();
			// popular a estrutura (lista) a partir do ResultSet
			while (rs.next()) {
				Cliente clienteRetornado = new Cliente();
				clienteRetornado.cnpj = rs.getString("CNPJ");
				clienteRetornado.razaoSocial = rs.getString("RAZAOSOCIAL");
				clienteRetornado.endereco = rs.getString("ENDERECO");
				clienteRetornado.telefone = rs.getString("TELEFONE");
				clienteRetornado.email = rs.getString("EMAIL");
				
				
			listaClientesRetorno[contador++] = clienteRetornado;

			}

			if (pstmt != null)
				pstmt.close();

			disconnect();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return listaClientesRetorno;
	}

	public Cliente listarCliente(int id) {
		PreparedStatement pstmt = null;

		Cliente clienteRetorno = new Cliente();

		try {
			connection = connect();
			String query = "SELECT CNPJ, RAZAOSOCIAL,ENDERECO, TELEFONE, EMAIL  FROM EMPRESAS WHERE ID=" + id;
			pstmt = connection.prepareStatement(query);
			// executa a clausula e armazena o resultado no ResultSet
			ResultSet rs = pstmt.executeQuery();
			// popular a estrutura (lista) a partir do ResultSet
			while (rs.next()) {
				clienteRetorno.cnpj = rs.getString("CNPJ");
				clienteRetorno.razaoSocial = rs.getString("RAZAOSOCIAL");
				clienteRetorno.endereco = rs.getString("ENDERECO");
				clienteRetorno.telefone = rs.getString("TELEFONE");
				clienteRetorno.email = rs.getString("EMAIL");
			
			}

			if (pstmt != null)
				pstmt.close();

			disconnect();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return clienteRetorno;
	}

	public boolean inserir(Usuario usuario ) {
		PreparedStatement pstmt = null;
		try {
			connection = connect();

			String query = "insert into EMPREGADO (LOGIN, SENHA) values ('"
					+ usuario.login + "', '" + usuario.senha + "')";

			//System.out.println(query);

			pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();
			if (pstmt != null)
				pstmt.close();

			disconnect();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public Usuario[] listarTodosUsuarios() {
		PreparedStatement pstmt = null;

		Usuario[] listaUsuariosRetorno = new Usuario[100];
		int contador = 0;

		try {
			connection = connect();
			String query = "SELECT login, senha  FROM EMPREGADO";
			pstmt = connection.prepareStatement(query);
			// executa a clausula e armazena o resultado no ResultSet
			ResultSet rs = pstmt.executeQuery();
			// popular a estrutura (lista) a partir do ResultSet
			while (rs.next()) {
				Usuario usuarioRetornado = new Usuario();
				usuarioRetornado.login = rs.getString("LOGIN");
				usuarioRetornado.senha = rs.getString("SENHA");
				
				
				listaUsuariosRetorno[contador++] = usuarioRetornado;

			}

			if (pstmt != null)
				pstmt.close();

			disconnect();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return listaUsuariosRetorno;
	}
	
	public Usuario listarUsuario(int id) {
		PreparedStatement pstmt = null;

		Usuario usuarioRetorno = new Usuario();

		try {
			connection = connect();
			String query = "SELECT LOGIN, SENHA FROM  WHERE ID=" + id;
			pstmt = connection.prepareStatement(query);
			// executa a clausula e armazena o resultado no ResultSet
			ResultSet rs = pstmt.executeQuery();
			// popular a estrutura (lista) a partir do ResultSet
			while (rs.next()) {
				usuarioRetorno.login = rs.getString("LOGIN");
				usuarioRetorno.senha = rs.getString("SENHA");
				
			}

			if (pstmt != null)
				pstmt.close();

			disconnect();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return usuarioRetorno;
	}
	
}
