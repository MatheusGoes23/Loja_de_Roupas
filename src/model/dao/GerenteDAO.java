package model.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.GerenteVO;

public class GerenteDAO<VO extends GerenteVO> extends BaseDAO<VO> {
	// Métodos do gerente

	// inserir um gerente
	public void inserir(VO ger) throws IOException {
		String sql = "insert into gerente(id_proprietario, nome, cpf, login, senha) values(?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setLong(1, ger.getId_Proprietario());
			ptst.setString(2, ger.getNome());
			ptst.setString(3, ger.getCpf());
			ptst.setString(4, ger.getLogin());
			ptst.setString(5, ger.getSenha());

			int affectedRows = ptst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi inserida.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// alterar um gerente
	public void alterar(VO ger) throws IOException {
		String sql = "UPDATE gerente SET id_proprietario=? WHERE id_gerente=?";
		String sql2 = "UPDATE gerente SET nome=? WHERE id_gerente=?";
		String sql3 = "UPDATE gerente SET cpf=? WHERE id_gerente=?";
		String sql4 = "UPDATE gerente SET login=? WHERE id_gerente=?";
		String sql5 = "UPDATE gerente SET senha=? WHERE id_gerente=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, ger.getId_Proprietario());
			ptst.setLong(2, ger.getId_Gerente());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql2);
			ptst.setString(1, ger.getNome());
			ptst.setLong(2, ger.getId_Gerente());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql3);
			ptst.setString(1, ger.getCpf());
			ptst.setLong(2, ger.getId_Gerente());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql4);
			ptst.setString(1, ger.getLogin());
			ptst.setLong(2, ger.getId_Gerente());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql5);
			ptst.setString(1, ger.getSenha());
			ptst.setLong(2, ger.getId_Gerente());
			ptst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// remover um gerente
	public void remover(VO ger) throws IOException {
		String sql = "DELETE FROM gerente WHERE id_gerente=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, ger.getId_Gerente());

			ptst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Busca um gerente pelo id_gerente
	public ResultSet buscarById_Gerente(VO ger) throws SQLException, IOException {
		String sql = "SELECT * FROM gerente WHERE id_gerente=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, ger.getId_Gerente());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um gerente pelo id_proprietario
	public ResultSet buscarById_Proprietario(VO ger) throws SQLException, IOException {
		String sql = "SELECT * FROM gerente WHERE id_proprietario=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, ger.getId_Proprietario());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um gerente pelo nome
	public ResultSet buscarByNome(VO ger) throws SQLException, IOException {
		String sql = "SELECT * FROM gerente WHERE nome=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, ger.getNome());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um gerente pelo cpf
	public ResultSet buscarByCpf(VO ger) throws SQLException, IOException {
		String sql = "SELECT * FROM gerente WHERE cpf=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, ger.getCpf());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um gerente pelo login
	public ResultSet buscarByLogin(VO ger) throws SQLException, IOException {
		String sql = "SELECT * FROM gerente WHERE login=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, ger.getLogin());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Pesquisar e retornar um gerente pelo id_gerente
	public List<GerenteVO> pesquisarById_Gerente(VO ger) throws IOException {
		String sql = "SELECT * FROM gerente WHERE id_gerente=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<GerenteVO> gerentes = new ArrayList<GerenteVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, ger.getId_Gerente());
			resultado = st.executeQuery();
			while (resultado.next()) {
				GerenteVO gerente = new GerenteVO();
				gerente.setId_Gerente(resultado.getLong("id_gerente"));
				gerente.setId_Proprietario(resultado.getLong("id_proprietario"));
				gerente.setNome(resultado.getString("nome"));
				gerente.setCpf(resultado.getString("cpf"));
				gerente.setLogin(resultado.getString("login"));
				gerente.setSenha(resultado.getString("senha"));
				gerentes.add(gerente);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return gerentes;
	}

	// Pesquisar e retornar um gerente pelo id_proprietario
	public List<GerenteVO> pesquisarById_Proprietario(VO ger) throws IOException {
		String sql = "SELECT * FROM gerente WHERE id_proprietario=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<GerenteVO> gerentes = new ArrayList<GerenteVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, ger.getId_Proprietario());
			resultado = st.executeQuery();
			while (resultado.next()) {
				GerenteVO gerente = new GerenteVO();
				gerente.setId_Gerente(resultado.getLong("id_gerente"));
				gerente.setId_Proprietario(resultado.getLong("id_proprietario"));
				gerente.setNome(resultado.getString("nome"));
				gerente.setCpf(resultado.getString("cpf"));
				gerente.setLogin(resultado.getString("login"));
				gerente.setSenha(resultado.getString("senha"));
				gerentes.add(gerente);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return gerentes;
	}

	// Pesquisar e retornar um gerente pelo nome
	public List<GerenteVO> pesquisarByNome(VO ger) throws IOException {
		String sql = "SELECT * FROM gerente WHERE nome=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<GerenteVO> gerentes = new ArrayList<GerenteVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, ger.getNome());
			resultado = st.executeQuery();
			while (resultado.next()) {
				GerenteVO gerente = new GerenteVO();
				gerente.setId_Gerente(resultado.getLong("id_gerente"));
				gerente.setId_Proprietario(resultado.getLong("id_proprietario"));
				gerente.setNome(resultado.getString("nome"));
				gerente.setCpf(resultado.getString("cpf"));
				gerente.setLogin(resultado.getString("login"));
				gerente.setSenha(resultado.getString("senha"));
				gerentes.add(gerente);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return gerentes;
	}

	// Pesquisar e retornar um gerente pelo cpf
	public List<GerenteVO> pesquisarByCpf(VO ger) throws IOException {
		String sql = "SELECT * FROM gerente WHERE cpf=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<GerenteVO> gerentes = new ArrayList<GerenteVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, ger.getCpf());
			resultado = st.executeQuery();
			while (resultado.next()) {
				GerenteVO gerente = new GerenteVO();
				gerente.setId_Gerente(resultado.getLong("id_gerente"));
				gerente.setId_Proprietario(resultado.getLong("id_proprietario"));
				gerente.setNome(resultado.getString("nome"));
				gerente.setCpf(resultado.getString("cpf"));
				gerente.setLogin(resultado.getString("login"));
				gerente.setSenha(resultado.getString("senha"));
				gerentes.add(gerente);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return gerentes;
	}

	// Pesquisar e retornar um gerente pelo login
	public List<GerenteVO> pesquisarByLogin(VO ger) throws IOException {
		String sql = "SELECT * FROM gerente WHERE login=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<GerenteVO> gerentes = new ArrayList<GerenteVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, ger.getLogin());
			resultado = st.executeQuery();
			while (resultado.next()) {
				GerenteVO gerente = new GerenteVO();
				gerente.setId_Gerente(resultado.getLong("id_gerente"));
				gerente.setId_Proprietario(resultado.getLong("id_proprietario"));
				gerente.setNome(resultado.getString("nome"));
				gerente.setCpf(resultado.getString("cpf"));
				gerente.setLogin(resultado.getString("login"));
				gerente.setSenha(resultado.getString("senha"));
				gerentes.add(gerente);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return gerentes;
	}

	// pretendo usar visao
	// listar o gerente
	public List<GerenteVO> listar() throws IOException {
		String sql = "SELECT * FROM gerente ORDER BY id_gerente";
		Statement st;
		ResultSet resultado = null;
		List<GerenteVO> gerentes = new ArrayList<GerenteVO>();
		try {
			st = getConnection().createStatement();
			resultado = st.executeQuery(sql);
			while (resultado.next()) {
				GerenteVO gerente = new GerenteVO();
				gerente.setId_Gerente(resultado.getLong("id_gerente"));
				gerente.setId_Proprietario(resultado.getLong("id_proprietario"));
				gerente.setNome(resultado.getString("nome"));
				gerente.setCpf(resultado.getString("cpf"));
				gerente.setLogin(resultado.getString("login"));
				gerente.setSenha(resultado.getString("senha"));
				gerentes.add(gerente);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return gerentes;
	}
}
