package model.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.FuncionarioVO;

public class FuncionarioDAO<VO extends FuncionarioVO> extends BaseDAO<VO> {

	// Métodos do funcionario

	// inserir um funcionario
	public void inserir(VO func) throws IOException {
		String sql = "insert into funcionario(id_proprietario, nome, cpf, login, senha) values(?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setLong(1, func.getId_Proprietario());
			ptst.setString(2, func.getNome());
			ptst.setString(3, func.getCpf());
			ptst.setString(4, func.getLogin());
			ptst.setString(5, func.getSenha());

			int affectedRows = ptst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi inserida.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// alterar um funcionario
	public void alterar(VO func) throws IOException {
		String sql = "UPDATE funcionario SET id_proprietario=? WHERE id_funcionario=?";
		String sql2 = "UPDATE funcionario SET nome=? WHERE id_funcionario=?";
		String sql3 = "UPDATE funcionario SET cpf=? WHERE id_funcionario=?";
		String sql4 = "UPDATE funcionario SET login=? WHERE id_funcionario=?";
		String sql5 = "UPDATE funcionario SET senha=? WHERE id_funcionario=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, func.getId_Proprietario());
			ptst.setLong(2, func.getId_Funcionario());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql2);
			ptst.setString(1, func.getNome());
			ptst.setLong(2, func.getId_Funcionario());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql3);
			ptst.setString(1, func.getCpf());
			ptst.setLong(2, func.getId_Funcionario());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql4);
			ptst.setString(1, func.getLogin());
			ptst.setLong(2, func.getId_Funcionario());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql5);
			ptst.setString(1, func.getSenha());
			ptst.setLong(2, func.getId_Funcionario());
			ptst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// remover um funcionario
	public void remover(VO func) throws IOException {
		String sql = "DELETE FROM funcionario WHERE id_funcionario=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, func.getId_Funcionario());

			ptst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Busca um funcionario pelo id_funcionario
	public ResultSet buscarById_Funcionario(VO func) throws SQLException, IOException {
		String sql = "SELECT * FROM funcionario WHERE id_funcionario=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, func.getId_Funcionario());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um funcionario pelo id_proprietario
	public ResultSet buscarById_Proprietario(VO func) throws SQLException, IOException {
		String sql = "SELECT * FROM funcionario WHERE Id_Proprietario=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, func.getId_Proprietario());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um funcionario pelo nome
	public ResultSet buscarByNome(VO func) throws SQLException, IOException {
		String sql = "SELECT * FROM funcionario WHERE nome=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, func.getNome());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um funcionario pelo cpf
	public ResultSet buscarByCpf(VO func) throws SQLException, IOException {
		String sql = "SELECT * FROM funcionario WHERE cpf=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, func.getCpf());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um funcionario pelo login
	public ResultSet buscarByLogin(VO func) throws SQLException, IOException {
		String sql = "SELECT * FROM funcionario WHERE login=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, func.getLogin());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Pesquisar e retornar um funcionario pelo id_funcionario
	public List<FuncionarioVO> pesquisarById_Funcionario(VO func) throws IOException {
		String sql = "SELECT * FROM funcionario WHERE id_funcionario=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, func.getId_Funcionario());
			resultado = st.executeQuery();
			while (resultado.next()) {
				FuncionarioVO funcionario = new FuncionarioVO();
				funcionario.setId_Funcionario(resultado.getLong("id_funcionario"));
				funcionario.setId_Proprietario(resultado.getLong("id_proprietario"));
				funcionario.setNome(resultado.getString("nome"));
				funcionario.setCpf(resultado.getString("cpf"));
				funcionario.setLogin(resultado.getString("login"));
				funcionario.setSenha(resultado.getString("senha"));
				funcionarios.add(funcionario);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return funcionarios;
	}

	// Pesquisar e retornar um funcionario pelo id_proprietario
	public List<FuncionarioVO> pesquisarById_Proprietario(VO func) throws IOException {
		String sql = "SELECT * FROM funcionario WHERE id_proprietario=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, func.getId_Proprietario());
			resultado = st.executeQuery();
			while (resultado.next()) {
				FuncionarioVO funcionario = new FuncionarioVO();
				funcionario.setId_Funcionario(resultado.getLong("id_funcionario"));
				funcionario.setId_Proprietario(resultado.getLong("id_proprietario"));
				funcionario.setNome(resultado.getString("nome"));
				funcionario.setCpf(resultado.getString("cpf"));
				funcionario.setLogin(resultado.getString("login"));
				funcionario.setSenha(resultado.getString("senha"));
				funcionarios.add(funcionario);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return funcionarios;
	}

	// Pesquisar e retornar um funcionario pelo nome
	public List<FuncionarioVO> pesquisarByNome(VO func) throws IOException {
		String sql = "SELECT * FROM funcionario WHERE nome=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, func.getNome());
			resultado = st.executeQuery();
			while (resultado.next()) {
				FuncionarioVO funcionario = new FuncionarioVO();
				funcionario.setId_Funcionario(resultado.getLong("id_funcionario"));
				funcionario.setId_Proprietario(resultado.getLong("id_proprietario"));
				funcionario.setNome(resultado.getString("nome"));
				funcionario.setCpf(resultado.getString("cpf"));
				funcionario.setLogin(resultado.getString("login"));
				funcionario.setSenha(resultado.getString("senha"));
				funcionarios.add(funcionario);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return funcionarios;
	}

	// Pesquisar e retornar um funcionario pelo cpf
	public List<FuncionarioVO> pesquisarByCpf(VO func) throws IOException {
		String sql = "SELECT * FROM funcionario WHERE cpf=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, func.getCpf());
			resultado = st.executeQuery();
			while (resultado.next()) {
				FuncionarioVO funcionario = new FuncionarioVO();
				funcionario.setId_Funcionario(resultado.getLong("id_funcionario"));
				funcionario.setId_Proprietario(resultado.getLong("id_proprietario"));
				funcionario.setNome(resultado.getString("nome"));
				funcionario.setCpf(resultado.getString("cpf"));
				funcionario.setLogin(resultado.getString("login"));
				funcionario.setSenha(resultado.getString("senha"));
				funcionarios.add(funcionario);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return funcionarios;
	}
	
	// Pesquisar e retornar um funcionario pelo login
		public List<FuncionarioVO> pesquisarByLogin(VO func) throws IOException {
			String sql = "SELECT * FROM funcionario WHERE login=?";
			PreparedStatement st;
			ResultSet resultado = null;
			List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
			try {
				st = getConnection().prepareStatement(sql);
				st.setString(1, func.getLogin());
				resultado = st.executeQuery();
				while (resultado.next()) {
					FuncionarioVO funcionario = new FuncionarioVO();
					funcionario.setId_Funcionario(resultado.getLong("id_funcionario"));
					funcionario.setId_Proprietario(resultado.getLong("id_proprietario"));
					funcionario.setNome(resultado.getString("nome"));
					funcionario.setCpf(resultado.getString("cpf"));
					funcionario.setLogin(resultado.getString("login"));
					funcionario.setSenha(resultado.getString("senha"));
					funcionarios.add(funcionario);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			return funcionarios;
		}

	// pretendo usar visao
	// listar o funcionario
	public List<FuncionarioVO> listar() throws IOException {
		String sql = "SELECT * FROM funcionario ORDER BY id_funcionario";
		Statement st;
		ResultSet resultado = null;
		List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
		try {
			st = getConnection().createStatement();
			resultado = st.executeQuery(sql);
			while (resultado.next()) {
				FuncionarioVO funcionario = new FuncionarioVO();
				funcionario.setId_Funcionario(resultado.getLong("id_funcionario"));
				funcionario.setId_Proprietario(resultado.getLong("id_proprietario"));
				funcionario.setNome(resultado.getString("nome"));
				funcionario.setCpf(resultado.getString("cpf"));
				funcionario.setLogin(resultado.getString("login"));
				funcionario.setSenha(resultado.getString("senha"));
				funcionarios.add(funcionario);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return funcionarios;
	}

	// inserir um pedido, no caso é selecionar um produto especifico e adicionalo a
	// compra que ainda está sendo feita

	// alterar um pedido, no caso é alterar a quantidade de produtos pedidos em uma
	// compra que ainda está sendo feita

	// remover um pedido, no cado é remover um pedido de uma compra que ainda está
	// sendo feita

	// selecionar um pedido

	// gerar uma nota em pdf

}
