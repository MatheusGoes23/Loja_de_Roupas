package model.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.ProprietarioVO;

public class ProprietarioDAO<VO extends ProprietarioVO> extends BaseDAO<VO> {

	// Métodos do proprietário

	// alterar um proprietario
	public void alterar(VO prop) throws IOException {
		String sql = "UPDATE proprietario SET nome=? WHERE id_proprietario=?";
		String sql2 = "UPDATE proprietario SET cpf=? WHERE id_proprietario=?";
		String sql3 = "UPDATE proprietario SET login=? WHERE id_proprietario=?";
		String sql4 = "UPDATE proprietario SET senha=? WHERE id_proprietario=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, prop.getNome());
			ptst.setLong(2, prop.getId_Proprietario());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql2);
			ptst.setString(1, prop.getCpf());
			ptst.setLong(2, prop.getId_Proprietario());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql3);
			ptst.setString(1, prop.getLogin());
			ptst.setLong(2, prop.getId_Proprietario());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql4);
			ptst.setString(1, prop.getSenha());
			ptst.setLong(2, prop.getId_Proprietario());
			ptst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Busca um prorietário pelo id_proprietario
	public ResultSet buscarById_Proprietario(VO prop) throws SQLException, IOException {
		String sql = "SELECT * FROM proprietario WHERE id_proprietario=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, prop.getId_Proprietario());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um prorietário pelo nome
	public ResultSet buscarByNome(VO prop) throws SQLException, IOException {
		String sql = "SELECT * FROM proprietario WHERE nome=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, prop.getNome());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um prorietário pelo cpf
	public ResultSet buscarByCpf(VO prop) throws SQLException, IOException {
		String sql = "SELECT * FROM proprietario WHERE cpf=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, prop.getCpf());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um prorietário pelo login
	public ResultSet buscarByLogin(VO prop) throws SQLException, IOException {
		String sql = "SELECT * FROM proprietario WHERE login=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, prop.getLogin());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Pesquisar e retornar um proprietario pelo id_proprietario
	public List<ProprietarioVO> pesquisarById_Proprietario(VO prop) throws IOException {
		String sql = "SELECT * FROM proprietario WHERE id_proprietario=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<ProprietarioVO> proprietarios = new ArrayList<ProprietarioVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, prop.getId_Proprietario());
			resultado = st.executeQuery();
			while (resultado.next()) {
				ProprietarioVO proprietario = new ProprietarioVO();
				proprietario.setId_Proprietario(resultado.getLong("id_proprietario"));
				proprietario.setNome(resultado.getString("nome"));
				proprietario.setCpf(resultado.getString("cpf"));
				proprietario.setLogin(resultado.getString("login"));
				proprietario.setSenha(resultado.getString("senha"));
				proprietarios.add(proprietario);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return proprietarios;
	}

	// Pesquisar e retornar um proprietario pelo nome
	public List<ProprietarioVO> pesquisarByNome(VO prop) throws IOException {
		String sql = "SELECT * FROM proprietario WHERE nome=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<ProprietarioVO> proprietarios = new ArrayList<ProprietarioVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, prop.getNome());
			resultado = st.executeQuery();
			while (resultado.next()) {
				ProprietarioVO proprietario = new ProprietarioVO();
				proprietario.setId_Proprietario(resultado.getLong("id_proprietario"));
				proprietario.setNome(resultado.getString("nome"));
				proprietario.setCpf(resultado.getString("cpf"));
				proprietario.setLogin(resultado.getString("login"));
				proprietario.setSenha(resultado.getString("senha"));
				proprietarios.add(proprietario);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return proprietarios;
	}

	// Pesquisar e retornar um proprietario pelo cpf
	public List<ProprietarioVO> pesquisarByCpf(VO prop) throws IOException {
		String sql = "SELECT * FROM proprietario WHERE cpf=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<ProprietarioVO> proprietarios = new ArrayList<ProprietarioVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, prop.getCpf());
			resultado = st.executeQuery();
			while (resultado.next()) {
				ProprietarioVO proprietario = new ProprietarioVO();
				proprietario.setId_Proprietario(resultado.getLong("id_proprietario"));
				proprietario.setNome(resultado.getString("nome"));
				proprietario.setCpf(resultado.getString("cpf"));
				proprietario.setLogin(resultado.getString("login"));
				proprietario.setSenha(resultado.getString("senha"));
				proprietarios.add(proprietario);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return proprietarios;
	}

	// Pesquisar e retornar um proprietario pelo login
	public List<ProprietarioVO> pesquisarByLogin(VO prop) throws IOException {
		String sql = "SELECT * FROM proprietario WHERE login=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<ProprietarioVO> proprietarios = new ArrayList<ProprietarioVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, prop.getLogin());
			resultado = st.executeQuery();
			while (resultado.next()) {
				ProprietarioVO proprietario = new ProprietarioVO();
				proprietario.setId_Proprietario(resultado.getLong("id_proprietario"));
				proprietario.setNome(resultado.getString("nome"));
				proprietario.setCpf(resultado.getString("cpf"));
				proprietario.setLogin(resultado.getString("login"));
				proprietario.setSenha(resultado.getString("senha"));
				proprietarios.add(proprietario);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return proprietarios;
	}

	// pretendo usar visao
	// listar o proprietario
	public List<ProprietarioVO> listar() throws IOException {
		String sql = "SELECT * FROM proprietario ORDER BY id_proprietario";
		Statement st;
		ResultSet resultado = null;
		List<ProprietarioVO> proprietarios = new ArrayList<ProprietarioVO>();
		try {
			st = getConnection().createStatement();
			resultado = st.executeQuery(sql);
			while (resultado.next()) {
				ProprietarioVO proprietario = new ProprietarioVO();
				proprietario.setId_Proprietario(resultado.getLong("id_proprietario"));
				proprietario.setNome(resultado.getString("nome"));
				proprietario.setCpf(resultado.getString("cpf"));
				proprietario.setLogin(resultado.getString("login"));
				proprietario.setSenha(resultado.getString("senha"));
				proprietarios.add(proprietario);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return proprietarios;
	}

	// tornar um gerente funcionário: regras

	// tornar um funcionario gerente: regras
}
