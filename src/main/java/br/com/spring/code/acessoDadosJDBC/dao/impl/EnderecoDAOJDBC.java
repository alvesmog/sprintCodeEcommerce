package br.com.spring.code.acessoDadosJDBC.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.spring.code.acessoDadosJDBC.dao.EnderecoDAO;
import br.com.spring.code.acessoDadosJDBC.db.DB;
import br.com.spring.code.acessoDadosJDBC.db.DBException;
import br.com.spring.code.ecommerce.gestaopessoas.Endereco;

public class EnderecoDAOJDBC implements EnderecoDAO {

	private Connection conn = null;

	public EnderecoDAOJDBC(Connection conn) {
		this.conn = conn;
	}

	public void insert(Endereco end) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("INSERT INTO endereco "
					+ "(Logradouro, Numero, Bairro, Municipio, Estado, Ref, Cep, Pais, CaixaPostal) " + "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, end.getLogradouro());
			ps.setString(2, end.getNumero());
			ps.setString(3, end.getBairro());
			ps.setString(4, end.getMunicipio());
			ps.setString(5, end.getEstado());
			ps.setString(6, end.getRef());
			ps.setString(7, end.getCep());
			ps.setString(8, end.getPais());
			ps.setString(9, end.getCaixaPostal());

			int nLinhasAlteradas = ps.executeUpdate();

			if (nLinhasAlteradas > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					end.setId(id);
				}
				DB.closeResultSet(rs);
			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatment(ps);
		}
	}

	public void update(Endereco end) {
		// TODO Auto-generated method stub

	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	public Endereco findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Endereco> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
