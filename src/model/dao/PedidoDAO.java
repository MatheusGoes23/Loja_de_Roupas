package model.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.PedidoVO;

public class PedidoDAO<VO extends PedidoVO> extends BaseDAO<VO> {
	// Métodos do pedido

	// inserir um pedido
	public void inserir(VO ped) throws IOException {
		String sql = "insert into pedido(id_produto, id_compra, valor, quantidade) values(?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setLong(1, ped.getId_Produto());
			ptst.setLong(2, ped.getId_Compra());
			ptst.setDouble(3, ped.getValor());
			ptst.setInt(4, ped.getQuantidade());

			int affectedRows = ptst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi inserida.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// alterar um pedido
	public void alterar(VO ped) throws IOException {
		String sql = "UPDATE pedido SET id_produto=? WHERE id_pedido=?";
		String sql2 = "UPDATE pedido SET id_compra=? WHERE id_pedido=?";
		String sql3 = "UPDATE pedido SET valor=? WHERE id_pedido=?";
		String sql4 = "UPDATE pedido SET quantidade=? WHERE id_pedido=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, ped.getId_Produto());
			ptst.setLong(2, ped.getId_Pedido());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql2);
			ptst.setLong(1, ped.getId_Compra());
			ptst.setLong(2, ped.getId_Pedido());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql3);
			ptst.setDouble(1, ped.getValor());
			ptst.setLong(2, ped.getId_Pedido());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql4);
			ptst.setInt(1, ped.getQuantidade());
			ptst.setLong(2, ped.getId_Pedido());
			ptst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// remover um pedido
	public void remover(VO ped) throws IOException {
		String sql = "DELETE FROM pedido WHERE id_pedido=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, ped.getId_Pedido());

			ptst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Busca um pedido pelo id_pedido
	public ResultSet buscarById_Pedido(VO ped) throws SQLException, IOException {
		String sql = "SELECT * FROM pedido WHERE id_pedido=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, ped.getId_Pedido());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um pedido pelo id_produto
	public ResultSet buscarById_Produto(VO ped) throws SQLException, IOException {
		String sql = "SELECT * FROM pedido WHERE id_produto=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, ped.getId_Produto());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um pedido pelo id_compra
	public ResultSet buscarById_Compra(VO ped) throws SQLException, IOException {
		String sql = "SELECT * FROM pedido WHERE id_compra=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, ped.getId_Compra());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um pedido pela valor
	public ResultSet buscarByValor(VO ped) throws SQLException, IOException {
		String sql = "SELECT * FROM pedido WHERE valor=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDouble(1, ped.getValor());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Pesquisar e retornar um pedido pelo id_pedido
	public List<PedidoVO> pesquisarById_Pedido(VO ped) throws IOException {
		String sql = "SELECT * FROM pedido WHERE id_pedido=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, ped.getId_Pedido());
			resultado = st.executeQuery();
			while (resultado.next()) {
				PedidoVO pedido = new PedidoVO();
				pedido.setId_Pedido(resultado.getLong("id_pedido"));
				pedido.setId_Produto(resultado.getLong("id_produto"));
				pedido.setId_Compra(resultado.getLong("id_compra"));
				pedido.setValor(resultado.getDouble("valor"));
				pedido.setQuantidade(resultado.getInt("quantidade"));
				pedidos.add(pedido);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}

	// Pesquisar e retornar um pedido pelo id_produto
	public List<PedidoVO> pesquisarById_Produto(VO ped) throws IOException {
		String sql = "SELECT * FROM pedido WHERE id_produto=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, ped.getId_Produto());
			resultado = st.executeQuery();
			while (resultado.next()) {
				PedidoVO pedido = new PedidoVO();
				pedido.setId_Pedido(resultado.getLong("id_pedido"));
				pedido.setId_Produto(resultado.getLong("id_produto"));
				pedido.setId_Compra(resultado.getLong("id_compra"));
				pedido.setValor(resultado.getDouble("valor"));
				pedido.setQuantidade(resultado.getInt("quantidade"));
				pedidos.add(pedido);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}

	// Pesquisar e retornar um pedido pelo id_compra
	public List<PedidoVO> pesquisarById_Compra(VO ped) throws IOException {
		String sql = "SELECT * FROM pedido WHERE id_compra=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, ped.getId_Compra());
			resultado = st.executeQuery();
			while (resultado.next()) {
				PedidoVO pedido = new PedidoVO();
				pedido.setId_Pedido(resultado.getLong("id_pedido"));
				pedido.setId_Produto(resultado.getLong("id_produto"));
				pedido.setId_Compra(resultado.getLong("id_compra"));
				pedido.setValor(resultado.getDouble("valor"));
				pedido.setQuantidade(resultado.getInt("quantidade"));
				pedidos.add(pedido);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}

	// Pesquisar e retornar um pedido pelo valor
	public List<PedidoVO> pesquisarByValor(VO ped) throws IOException {
		String sql = "SELECT * FROM pedido WHERE valor=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setDouble(1, ped.getValor());
			resultado = st.executeQuery();
			while (resultado.next()) {
				PedidoVO pedido = new PedidoVO();
				pedido.setId_Pedido(resultado.getLong("id_pedido"));
				pedido.setId_Produto(resultado.getLong("id_produto"));
				pedido.setId_Compra(resultado.getLong("id_compra"));
				pedido.setValor(resultado.getDouble("valor"));
				pedido.setQuantidade(resultado.getInt("quantidade"));
				pedidos.add(pedido);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}

	// pretendo usar visao
	// listar os pedidos
	public List<PedidoVO> listar() throws IOException {
		String sql = "SELECT * FROM pedido ORDER BY id_pedido";
		Statement st;
		ResultSet resultado = null;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		try {
			st = getConnection().createStatement();
			resultado = st.executeQuery(sql);
			while (resultado.next()) {
				PedidoVO pedido = new PedidoVO();
				pedido.setId_Pedido(resultado.getLong("id_pedido"));
				pedido.setId_Produto(resultado.getLong("id_produto"));
				pedido.setId_Compra(resultado.getLong("id_compra"));
				pedido.setValor(resultado.getDouble("valor"));
				pedido.setQuantidade(resultado.getInt("quantidade"));
				pedidos.add(pedido);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}
}
