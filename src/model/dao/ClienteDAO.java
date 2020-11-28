package model.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.ClienteVO;

public class ClienteDAO<VO extends ClienteVO> extends BaseDAO<VO> {
	// Métodos do cliente

	// inserir um cliente
	public void inserir(VO cli) throws IOException {
		String sql = "insert into cliente(nome, cpf) values(?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, cli.getNome());
			ptst.setString(2, cli.getCpf());

			int affectedRows = ptst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi inserida.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// alterar um cliente
	public void alterar(VO cli) throws IOException {
		String sql1 = "UPDATE cliente SET nome=? WHERE id_cliente=?";
		String sql2 = "UPDATE cliente SET cpf=? WHERE id_cliente=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql1);
			ptst.setString(1, cli.getNome());
			ptst.setLong(2, cli.getId_Cliente());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql2);
			ptst.setString(1, cli.getCpf());
			ptst.setLong(2, cli.getId_Cliente());
			ptst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// remover um cliente
	public void remover(VO cli) throws IOException {
		String sql = "DELETE FROM cliente WHERE id_cliente=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, cli.getId_Cliente());

			ptst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Busca um cliente pelo id_cliente
	public ResultSet buscarById_Cliente(VO cli) throws SQLException, IOException {
		String sql = "SELECT * FROM cliente WHERE id_cliente=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, cli.getId_Cliente());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um cliente pelo nome
	public ResultSet buscarByNome(VO cli) throws SQLException, IOException {
		String sql = "SELECT * FROM cliente WHERE nome=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, cli.getNome());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um cliente pelo cpf
	public ResultSet buscarByCpf(VO cli) throws SQLException, IOException {
		String sql = "SELECT * FROM cliente WHERE cpf=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, cli.getCpf());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Pesquisar e retornar um cliente pelo id_cliente
	public List<ClienteVO> pesquisarById_Cliente(VO cli) throws IOException {
		String sql = "SELECT * FROM cliente WHERE id_cliente=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<ClienteVO> clientes = new ArrayList<ClienteVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, cli.getId_Cliente());
			resultado = st.executeQuery();
			while (resultado.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setId_Cliente(resultado.getLong("id_cliente"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setCpf(resultado.getString("cpf"));
				clientes.add(cliente);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return clientes;
	}

	// Pesquisar e retornar um cliente pelo nome
	public List<ClienteVO> pesquisarByNome(VO cli) throws IOException {
		String sql = "SELECT * FROM cliente WHERE nome=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<ClienteVO> clientes = new ArrayList<ClienteVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, cli.getNome());
			resultado = st.executeQuery();
			while (resultado.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setId_Cliente(resultado.getLong("id_cliente"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setCpf(resultado.getString("cpf"));
				clientes.add(cliente);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return clientes;
	}

	// Pesquisar e retornar um cliente pelo cpf
	public List<ClienteVO> pesquisarByCpf(VO cli) throws IOException {
		String sql = "SELECT * FROM cliente WHERE cpf=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<ClienteVO> clientes = new ArrayList<ClienteVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, cli.getCpf());
			resultado = st.executeQuery();
			while (resultado.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setId_Cliente(resultado.getLong("id_cliente"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setCpf(resultado.getString("cpf"));
				clientes.add(cliente);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return clientes;
	}

	// pretendo usar visao
	// listar o cliente
	public List<ClienteVO> listar() throws IOException {
		String sql = "SELECT * FROM cliente ORDER BY id_cliente";
		Statement st;
		ResultSet resultado = null;
		List<ClienteVO> clientes = new ArrayList<ClienteVO>();
		try {
			st = getConnection().createStatement();
			resultado = st.executeQuery(sql);
			while (resultado.next()) {
				ClienteVO cliente = new ClienteVO();
				cliente.setId_Cliente(resultado.getLong("id_cliente"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setCpf(resultado.getString("cpf"));
				clientes.add(cliente);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return clientes;
	}
}
