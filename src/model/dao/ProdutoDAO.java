package model.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.ProdutoVO;

public class ProdutoDAO<VO extends ProdutoVO> extends BaseDAO<VO> {
	// Métodos do produto

	// inserir um produto
	public void inserir(VO prod) throws IOException {
		String sql = "insert into produto(descricao, valor, quantidade) values(?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, prod.getDescricao());
			ptst.setDouble(2, prod.getValor());
			ptst.setInt(3, prod.getQuantidade());

			int affectedRows = ptst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi inserida.");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// alterar um produto
	public void alterar(VO prod) throws IOException {
		String sql = "UPDATE produto SET descricao=? WHERE id_produto=?";
		String sql2 = "UPDATE produto SET valor=? WHERE id_produto=?";
		String sql3 = "UPDATE produto SET quantidade=? WHERE id_produto=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, prod.getDescricao());
			ptst.setLong(2, prod.getId_Produto());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql2);
			ptst.setDouble(1, prod.getValor());
			ptst.setLong(2, prod.getId_Produto());
			ptst.executeUpdate();
			ptst = getConnection().prepareStatement(sql3);
			ptst.setInt(1, prod.getQuantidade());
			ptst.setLong(2, prod.getId_Produto());
			ptst.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// remover um produto
	public void remover(VO prod) throws IOException {
		String sql = "DELETE FROM produto WHERE id_produto=?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, prod.getId_Produto());

			ptst.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Busca um produto pelo id_produto
	public ResultSet buscarById_Produto(VO prod) throws SQLException, IOException {
		String sql = "SELECT * FROM produto WHERE id_produto=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setLong(1, prod.getId_Produto());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um produto pela descricao
	public ResultSet buscarByDescricao(VO prod) throws SQLException, IOException {
		String sql = "SELECT * FROM produto WHERE descricao=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, prod.getDescricao());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um produto pelo valor
	public ResultSet buscarByValor(VO prod) throws SQLException, IOException {
		String sql = "SELECT * FROM produto WHERE valor=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDouble(1, prod.getValor());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Pesquisar e retornar um produto pelo id_produto
	public List<ProdutoVO> pesquisarById_Produto(VO prod) throws IOException {
		String sql = "SELECT * FROM produto WHERE id_produto=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, prod.getId_Produto());
			resultado = st.executeQuery();
			while (resultado.next()) {
				ProdutoVO produto = new ProdutoVO();
				produto.setId_Produto(resultado.getLong("id_produto"));
				produto.setDescricao(resultado.getString("descricao"));
				produto.setValor(resultado.getDouble("valor"));
				produto.setQuantidade(resultado.getInt("quantidade"));
				produtos.add(produto);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return produtos;
	}

	// Pesquisar e retornar um produto pela descricao
	public List<ProdutoVO> pesquisarByDescricao(VO prod) throws IOException {
		String sql = "SELECT * FROM produto WHERE descricao=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, prod.getDescricao());
			resultado = st.executeQuery();
			while (resultado.next()) {
				ProdutoVO produto = new ProdutoVO();
				produto.setId_Produto(resultado.getLong("id_produto"));
				produto.setDescricao(resultado.getString("descricao"));
				produto.setValor(resultado.getDouble("valor"));
				produto.setQuantidade(resultado.getInt("quantidade"));
				produtos.add(produto);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return produtos;
	}

	// Pesquisar e retornar um produto pelo valor
	public List<ProdutoVO> pesquisarByValor(VO prod) throws IOException {
		String sql = "SELECT * FROM produto WHERE valor=?";
		PreparedStatement st;
		ResultSet resultado = null;
		List<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setDouble(1, prod.getValor());
			resultado = st.executeQuery();
			while (resultado.next()) {
				ProdutoVO produto = new ProdutoVO();
				produto.setId_Produto(resultado.getLong("id_produto"));
				produto.setDescricao(resultado.getString("descricao"));
				produto.setValor(resultado.getDouble("valor"));
				produto.setQuantidade(resultado.getInt("quantidade"));
				produtos.add(produto);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return produtos;
	}

	// pretendo usar visao
	// listar os produtos
	public List<ProdutoVO> listar() throws IOException {
		String sql = "SELECT * FROM produto ORDER BY id_produto";
		Statement st;
		ResultSet resultado = null;
		List<ProdutoVO> produtos = new ArrayList<ProdutoVO>();
		try {
			st = getConnection().createStatement();
			resultado = st.executeQuery(sql);
			while (resultado.next()) {
				ProdutoVO produto = new ProdutoVO();
				produto.setId_Produto(resultado.getLong("id_produto"));
				produto.setDescricao(resultado.getString("descricao"));
				produto.setValor(resultado.getDouble("valor"));
				produto.setQuantidade(resultado.getInt("quantidade"));
				produtos.add(produto);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return produtos;
	}
}
