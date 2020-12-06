package model.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.CompraVO;

public class CompraDAO<VO extends CompraVO> extends BaseDAO<VO> {
	// Métodos da compra

	// inserir uma compra
	public void inserir(VO comp) throws IOException {
		String sql = "insert into compra(id_funcionario, id_cliente, valor, data, hora) values(?,?,0, current_date, current_time)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setLong(1, comp.getId_Funcionario());
			ptst.setLong(2, comp.getId_Cliente());

			int affectedRows = ptst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi inserida.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// alterar uma compra
	public void alterar(VO comp) throws IOException {
		String sql = "UPDATE compra SET id_funcionario=? WHERE id_compra=?";
		String sql2 = "UPDATE compra SET id_cliente=? WHERE id_compra=?";
		String sql3 = "UPDATE compra SET valor=? WHERE id_compra=?";
		String sql4 = "UPDATE compra SET data=current_date WHERE id_compra=?";
		String sql5 = "UPDATE compra SET hora=current_time WHERE id_compra=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, comp.getId_Funcionario());
			ptst.setLong(2, comp.getId_Compra());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql2);
			ptst.setDouble(1, comp.getId_Cliente());
			ptst.setLong(2, comp.getId_Compra());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql3);
			ptst.setDouble(1, comp.getValor());
			ptst.setDouble(2, comp.getId_Compra());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql4);
			ptst.setDouble(1, comp.getId_Compra());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql5);
			ptst.setDouble(1, comp.getId_Compra());
			ptst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// remover uma compra
	public void remover(VO comp) throws IOException {
		String sql = "DELETE FROM compra WHERE id_compra=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, comp.getId_Compra());

			ptst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Busca uma compra pelo id_compra
	public ResultSet buscarById_Compra(VO comp) throws SQLException, IOException {
		String sql = "SELECT * FROM compra WHERE id_compra=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, comp.getId_Compra());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca uma compra pelo id_funcionario
	public ResultSet buscarById_Funcionario(VO comp) throws SQLException, IOException {
		String sql = "SELECT * FROM compra WHERE id_funcionario=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, comp.getId_Funcionario());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca uma compra pelo id_cliente
	public ResultSet buscarById_Cliente(VO comp) throws SQLException, IOException {
		String sql = "SELECT * FROM compra WHERE id_cliente=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, comp.getId_Cliente());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca uma compra pelo valor
	public ResultSet buscarByValor(VO comp) throws SQLException, IOException {
		String sql = "SELECT * FROM compra WHERE valor=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDouble(1, comp.getValor());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca uma compra pela data
	public ResultSet buscarByData(VO comp) throws SQLException, IOException {
		String sql = "SELECT * FROM compra WHERE data=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDate(1, comp.getData());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca uma compra pela hora
	public ResultSet buscarByHora(VO comp) throws SQLException, IOException {
		String sql = "SELECT * FROM compra WHERE hora=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, comp.getHora());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Pesquisar e retornar uma compra pelo id_compra
	public List<CompraVO> pesquisarById_Compra(VO comp) throws IOException {
		String sql = "SELECT * FROM compra WHERE id_compra=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<CompraVO> compras = new ArrayList<CompraVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, comp.getId_Compra());
			resultado = st.executeQuery();
			while (resultado.next()) {
				CompraVO compra = new CompraVO();
				compra.setId_Compra(resultado.getLong("id_compra"));
				compra.setId_Funcionario(resultado.getLong("id_funcionario"));
				compra.setId_Cliente(resultado.getLong("id_cliente"));
				compra.setValor(resultado.getDouble("valor"));
				compra.setData(resultado.getDate("data"));
				compra.setHora(resultado.getString("hora"));
				compras.add(compra);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return compras;
	}

	// Pesquisar e retornar uma compra pelo id_funcionario
	public List<CompraVO> pesquisarById_Funcionario(VO comp) throws IOException {
		String sql = "SELECT * FROM compra WHERE id_funcionario=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<CompraVO> compras = new ArrayList<CompraVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, comp.getId_Funcionario());
			resultado = st.executeQuery();
			while (resultado.next()) {
				CompraVO compra = new CompraVO();
				compra.setId_Compra(resultado.getLong("id_compra"));
				compra.setId_Funcionario(resultado.getLong("id_funcionario"));
				compra.setId_Cliente(resultado.getLong("id_cliente"));
				compra.setValor(resultado.getDouble("valor"));
				compra.setData(resultado.getDate("data"));
				compra.setHora(resultado.getString("hora"));
				compras.add(compra);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return compras;
	}

	// Pesquisar e retornar uma compra pelo id_cliente
	public List<CompraVO> pesquisarById_Cliente(VO comp) throws IOException {
		String sql = "SELECT * FROM compra WHERE id_cliente=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<CompraVO> compras = new ArrayList<CompraVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, comp.getId_Cliente());
			resultado = st.executeQuery();
			while (resultado.next()) {
				CompraVO compra = new CompraVO();
				compra.setId_Compra(resultado.getLong("id_compra"));
				compra.setId_Funcionario(resultado.getLong("id_funcionario"));
				compra.setId_Cliente(resultado.getLong("id_cliente"));
				compra.setValor(resultado.getDouble("valor"));
				compra.setData(resultado.getDate("data"));
				compra.setHora(resultado.getString("hora"));
				compras.add(compra);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return compras;
	}

	// Pesquisar e retornar uma compra pelo valor
	public List<CompraVO> pesquisarByValor(VO comp) throws IOException {
		String sql = "SELECT * FROM compra WHERE valor=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<CompraVO> compras = new ArrayList<CompraVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setDouble(1, comp.getValor());
			resultado = st.executeQuery();
			while (resultado.next()) {
				CompraVO compra = new CompraVO();
				compra.setId_Compra(resultado.getLong("id_compra"));
				compra.setId_Funcionario(resultado.getLong("id_funcionario"));
				compra.setId_Cliente(resultado.getLong("id_cliente"));
				compra.setValor(resultado.getDouble("valor"));
				compra.setData(resultado.getDate("data"));
				compra.setHora(resultado.getString("hora"));
				compras.add(compra);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return compras;
	}

	// Pesquisar e retornar uma compra pela data
	public List<CompraVO> pesquisarByData(VO comp) throws IOException {
		String sql = "SELECT * FROM compra WHERE data=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<CompraVO> compras = new ArrayList<CompraVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setDate(1, comp.getData());
			resultado = st.executeQuery();
			while (resultado.next()) {
				CompraVO compra = new CompraVO();
				compra.setId_Compra(resultado.getLong("id_compra"));
				compra.setId_Funcionario(resultado.getLong("id_funcionario"));
				compra.setId_Cliente(resultado.getLong("id_cliente"));
				compra.setValor(resultado.getDouble("valor"));
				compra.setData(resultado.getDate("data"));
				compra.setHora(resultado.getString("hora"));
				compras.add(compra);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return compras;
	}

	// Pesquisar e retornar uma compra pela hora
	/*
	 * public List<CompraVO> pesquisarByHora(VO comp) throws IOException { String
	 * sql = "SELECT * FROM compra WHERE hora=?"; PreparedStatement st; ResultSet
	 * resultado = null; List<CompraVO> compras = new ArrayList<CompraVO>(); try {
	 * st = getConnection().prepareStatement(sql); st.setString(1, comp.getHora());
	 * resultado = st.executeQuery(); while (resultado.next()) { CompraVO compra =
	 * new CompraVO(); compra.setId_Compra(resultado.getLong("id_compra"));
	 * compra.setId_Funcionario(resultado.getLong("id_funcionario"));
	 * compra.setId_Cliente(resultado.getLong("id_cliente"));
	 * compra.setValor(resultado.getDouble("valor"));
	 * compra.setData(resultado.getDate("data"));
	 * compra.setHora(resultado.getString("hora")); compras.add(compra); } } catch
	 * (SQLException ex) { ex.printStackTrace(); } return compras; }
	 */

	// pretendo usar visao
	// listar a compra
	public List<CompraVO> listar() throws IOException {
		String sql = "SELECT * FROM compra ORDER BY id_compra";
		Statement st;
		ResultSet resultado = null;
		List<CompraVO> compras = new ArrayList<CompraVO>();
		try {
			st = getConnection().createStatement();
			resultado = st.executeQuery(sql);
			while (resultado.next()) {
				CompraVO compra = new CompraVO();
				compra.setId_Compra(resultado.getLong("id_compra"));
				compra.setId_Funcionario(resultado.getLong("id_funcionario"));
				compra.setId_Cliente(resultado.getLong("id_cliente"));
				compra.setValor(resultado.getDouble("valor"));
				compra.setData(resultado.getDate("data"));
				compra.setHora(resultado.getString("hora"));
				compras.add(compra);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return compras;
	}
}