package model.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.CompraVO;
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
			ptst.setDouble(3, ped.getSubtotal());
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

	// Busca um Produtos comprados por cada cliente pelo nome
	public ResultSet buscarCompradosByNome(VO ped) throws SQLException, IOException {
		String sql = "SELECT * FROM produtos_comprados_cliente WHERE Nome_Cliente=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, ped.getNome());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um Produtos comprados por cada cliente pelo cpf
	public ResultSet buscarCompradosByCpf(VO ped) throws SQLException, IOException {
		String sql = "SELECT * FROM produtos_comprados_cliente WHERE Cpf_Cliente=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, ped.getCpf());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um Produtos comprados por cada cliente pela descricao
	public ResultSet buscarCompradosByDescricao(VO ped) throws SQLException, IOException {
		String sql = "SELECT * FROM produtos_comprados_cliente WHERE descricao=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, ped.getDescricao());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca um Produtos comprados por cada cliente pelo valor
	public ResultSet buscarCompradosByValor(VO ped) throws SQLException, IOException {
		String sql = "SELECT * FROM produtos_comprados_cliente WHERE valor_total=?";
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

	// Busca um Produtos comprados por cada cliente pela data
	public ResultSet buscarCompradosByData(VO ped) throws SQLException, IOException {
		String sql = "SELECT * FROM produtos_comprados_cliente WHERE data=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setDate(1, ped.getData());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// listar Produtos comprados por cada cliente
	public List<PedidoVO> listarComprados() throws IOException {
		String sql = "SELECT * FROM produtos_comprados_cliente ORDER BY data";
		Statement st;
		ResultSet resultado = null;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		try {
			st = getConnection().createStatement();
			resultado = st.executeQuery(sql);
			while (resultado.next()) {
				PedidoVO pedido = new PedidoVO();
				pedido.setNome(resultado.getString("Nome_Cliente"));
				pedido.setCpf(resultado.getString("Cpf_Cliente"));
				pedido.setLogin(resultado.getString("Nome_Funcionario"));
				pedido.setSenha(resultado.getString("Cpf_Funcionario"));
				pedido.setDescricao(resultado.getString("descricao"));
				pedido.setQuantidade(resultado.getInt("quantidade"));
				pedido.setValor(resultado.getDouble("valor_total"));
				pedido.setData(resultado.getDate("data"));
				pedido.setHora(resultado.getString("hora"));
				pedidos.add(pedido);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}

	// Pesquisar e retornar um Produtos comprados por cada cliente pelo nome
	public List<PedidoVO> pesquisarCompradosByNome(VO ped) throws IOException {
		String sql = "SELECT * FROM produtos_comprados_cliente WHERE Nome_Cliente=? ORDER BY data";
		PreparedStatement st;
		ResultSet resultado = null;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, ped.getNome());
			resultado = st.executeQuery();
			while (resultado.next()) {
				PedidoVO pedido = new PedidoVO();
				pedido.setNome(resultado.getString("Nome_Cliente"));
				pedido.setCpf(resultado.getString("Cpf_Cliente"));
				pedido.setLogin(resultado.getString("Nome_Funcionario"));
				pedido.setSenha(resultado.getString("Cpf_Funcionario"));
				pedido.setDescricao(resultado.getString("descricao"));
				pedido.setQuantidade(resultado.getInt("quantidade"));
				pedido.setValor(resultado.getDouble("valor_total"));
				pedido.setData(resultado.getDate("data"));
				pedido.setHora(resultado.getString("hora"));
				pedidos.add(pedido);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}

	// Pesquisar e retornar um Produtos comprados por cada cliente pelo cpf
	public List<PedidoVO> pesquisarCompradosByCpf(VO ped) throws IOException {
		String sql = "SELECT * FROM produtos_comprados_cliente WHERE Cpf_Cliente=? ORDER BY data";
		PreparedStatement st;
		ResultSet resultado = null;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, ped.getCpf());
			resultado = st.executeQuery();
			while (resultado.next()) {
				PedidoVO pedido = new PedidoVO();
				pedido.setNome(resultado.getString("Nome_Cliente"));
				pedido.setCpf(resultado.getString("Cpf_Cliente"));
				pedido.setLogin(resultado.getString("Nome_Funcionario"));
				pedido.setSenha(resultado.getString("Cpf_Funcionario"));
				pedido.setDescricao(resultado.getString("descricao"));
				pedido.setQuantidade(resultado.getInt("quantidade"));
				pedido.setValor(resultado.getDouble("valor_total"));
				pedido.setData(resultado.getDate("data"));
				pedido.setHora(resultado.getString("hora"));
				pedidos.add(pedido);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}

	// Pesquisar e retornar um Produtos comprados por cada cliente pela descrição
	public List<PedidoVO> pesquisarCompradosByDescricao(VO ped) throws IOException {
		String sql = "SELECT * FROM produtos_comprados_cliente WHERE descricao=? ORDER BY data";
		PreparedStatement st;
		ResultSet resultado = null;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, ped.getDescricao());
			resultado = st.executeQuery();
			while (resultado.next()) {
				PedidoVO pedido = new PedidoVO();
				pedido.setNome(resultado.getString("Nome_Cliente"));
				pedido.setCpf(resultado.getString("Cpf_Cliente"));
				pedido.setLogin(resultado.getString("Nome_Funcionario"));
				pedido.setSenha(resultado.getString("Cpf_Funcionario"));
				pedido.setDescricao(resultado.getString("descricao"));
				pedido.setQuantidade(resultado.getInt("quantidade"));
				pedido.setValor(resultado.getDouble("valor_total"));
				pedido.setData(resultado.getDate("data"));
				pedido.setHora(resultado.getString("hora"));
				pedidos.add(pedido);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}

	// Pesquisar e retornar um Produtos comprados por cada cliente pelo valor
	public List<PedidoVO> pesquisarCompradosByValor(VO ped) throws IOException {
		String sql = "SELECT * FROM produtos_comprados_cliente WHERE valor_total=? ORDER BY data";
		PreparedStatement st;
		ResultSet resultado = null;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setDouble(1, ped.getValor());
			resultado = st.executeQuery();
			while (resultado.next()) {
				PedidoVO pedido = new PedidoVO();
				pedido.setNome(resultado.getString("Nome_Cliente"));
				pedido.setCpf(resultado.getString("Cpf_Cliente"));
				pedido.setLogin(resultado.getString("Nome_Funcionario"));
				pedido.setSenha(resultado.getString("Cpf_Funcionario"));
				pedido.setDescricao(resultado.getString("descricao"));
				pedido.setQuantidade(resultado.getInt("quantidade"));
				pedido.setValor(resultado.getDouble("valor_total"));
				pedido.setData(resultado.getDate("data"));
				pedido.setHora(resultado.getString("hora"));
				pedidos.add(pedido);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}

	// Pesquisar e retornar um Produtos comprados por cada cliente pela data
	public List<PedidoVO> pesquisarCompradosByData(VO ped) throws IOException {
		String sql = "SELECT * FROM produtos_comprados_cliente WHERE data=? ORDER BY data";
		PreparedStatement st;
		ResultSet resultado = null;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setDate(1, ped.getData());
			resultado = st.executeQuery();
			while (resultado.next()) {
				PedidoVO pedido = new PedidoVO();
				pedido.setNome(resultado.getString("Nome_Cliente"));
				pedido.setCpf(resultado.getString("Cpf_Cliente"));
				pedido.setLogin(resultado.getString("Nome_Funcionario"));
				pedido.setSenha(resultado.getString("Cpf_Funcionario"));
				pedido.setDescricao(resultado.getString("descricao"));
				pedido.setQuantidade(resultado.getInt("quantidade"));
				pedido.setValor(resultado.getDouble("valor_total"));
				pedido.setData(resultado.getDate("data"));
				pedido.setHora(resultado.getString("hora"));
				pedidos.add(pedido);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}

	// listar ex_empregados
	public List<PedidoVO> listarEx() throws IOException {
		String sql = "SELECT * FROM ex_empregados ORDER BY data_demissao";
		Statement st;
		ResultSet resultado = null;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		try {
			st = getConnection().createStatement();
			resultado = st.executeQuery(sql);
			while (resultado.next()) {
				PedidoVO pedido = new PedidoVO();
				pedido.setNome(resultado.getString("nome"));
				pedido.setCpf(resultado.getString("cpf"));
				pedido.setDescricao(resultado.getString("funcao"));
				pedido.setData(resultado.getDate("data_demissao"));
				pedidos.add(pedido);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}

	// Busca os ex_empregados pelo nome
	public ResultSet buscarExByNome(VO ped) throws SQLException, IOException {
		String sql = "SELECT * FROM ex_empregados WHERE nome=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, ped.getNome());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca os ex_empregados pelo cpf
	public ResultSet buscarExByCpf(VO ped) throws SQLException, IOException {
		String sql = "SELECT * FROM ex_empregados WHERE cpf=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, ped.getCpf());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Busca os ex_empregados pela funcao
	public ResultSet buscarExByFuncao(VO ped) throws SQLException, IOException {
		String sql = "SELECT * FROM ex_empregados WHERE funcao=?";
		PreparedStatement ptst;
		ResultSet resultado = null;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, ped.getDescricao());
			resultado = ptst.executeQuery();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return resultado;
	}

	// Pesquisar e retornar os ex_empregados pelo nome
	public List<PedidoVO> pesquisarExByNome(VO ped) throws IOException {
		String sql = "SELECT * FROM ex_empregados WHERE nome=? ORDER BY data_demissao";
		PreparedStatement st;
		ResultSet resultado = null;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, ped.getNome());
			resultado = st.executeQuery();
			while (resultado.next()) {
				PedidoVO pedido = new PedidoVO();
				pedido.setNome(resultado.getString("nome"));
				pedido.setCpf(resultado.getString("cpf"));
				pedido.setDescricao(resultado.getString("funcao"));
				pedido.setData(resultado.getDate("data_demissao"));
				pedidos.add(pedido);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}

	// Pesquisar e retornar os ex_empregados pelo cpf
	public List<PedidoVO> pesquisarExByCpf(VO ped) throws IOException {
		String sql = "SELECT * FROM ex_empregados WHERE cpf=? ORDER BY data_demissao";
		PreparedStatement st;
		ResultSet resultado = null;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, ped.getCpf());
			resultado = st.executeQuery();
			while (resultado.next()) {
				PedidoVO pedido = new PedidoVO();
				pedido.setNome(resultado.getString("nome"));
				pedido.setCpf(resultado.getString("cpf"));
				pedido.setDescricao(resultado.getString("funcao"));
				pedido.setData(resultado.getDate("data_demissao"));
				pedidos.add(pedido);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}

	// Pesquisar e retornar os ex_empregados pela funcao
	public List<PedidoVO> pesquisarExByFuncao(VO ped) throws IOException {
		String sql = "SELECT * FROM ex_empregados WHERE funcao=? ORDER BY data_demissao";
		PreparedStatement st;
		ResultSet resultado = null;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setString(1, ped.getDescricao());
			resultado = st.executeQuery();
			while (resultado.next()) {
				PedidoVO pedido = new PedidoVO();
				pedido.setNome(resultado.getString("nome"));
				pedido.setCpf(resultado.getString("cpf"));
				pedido.setDescricao(resultado.getString("funcao"));
				pedido.setData(resultado.getDate("data_demissao"));
				pedidos.add(pedido);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}

	// listar arquivo de log de Produtos inseridos, alterados ou deletados
	public List<PedidoVO> listarProdLog() throws IOException {
		String sql = "select * from produtos_log ORDER BY data";
		Statement st;
		ResultSet resultado = null;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		try {
			st = getConnection().createStatement();
			resultado = st.executeQuery(sql);
			while (resultado.next()) {
				PedidoVO pedido = new PedidoVO();
				pedido.setDescricao(resultado.getString("descricao"));
				pedido.setValor(resultado.getDouble("valor"));
				pedido.setQuantidade(resultado.getInt("quantidade"));
				pedido.setNome(resultado.getString("modificacao"));
				pedido.setData(resultado.getDate("data"));
				pedidos.add(pedido);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}

	static private CompraDAO<CompraVO> dao = new CompraDAO<CompraVO>();

	public void inserirComp(VO ped) throws IOException {
		dao.inserir(ped);
	}

	// inserir um pedido de uma nova compra
	public void inserirPed(VO ped) throws IOException {
		// Sabendo qual o id da compra que está aberta
		List<CompraVO> compras = dao.listar();
		CompraVO compra = compras.get(compras.size() - 1);
		ped.setId_Compra(compra.getId_Compra());

		// Calculando o SubTotal do pedido
		ped.setSubtotal(ped.getValor() * ped.getQuantidade());

		inserir(ped);

		// Atualizar o Total da Compra
		ped.setValor(ped.getSubtotal() + compra.getValor());
		dao.alterar(ped);
	}

	// listar os pedidos de uma nova compra
	public List<PedidoVO> listarVenda() throws IOException {
		// Sabendo qual o id da compra que está aberta
		List<CompraVO> compras = dao.listar();
		CompraVO compra = compras.get(compras.size() - 1);

		String sql = "SELECT * FROM vendas WHERE Id_Compra=? ORDER BY Id_Pedido";
		PreparedStatement st;
		ResultSet resultado = null;
		List<PedidoVO> pedidos = new ArrayList<PedidoVO>();
		try {
			st = getConnection().prepareStatement(sql);
			st.setLong(1, compra.getId_Compra());
			resultado = st.executeQuery();
			while (resultado.next()) {
				PedidoVO pedido = new PedidoVO();
				pedido.setId_Pedido(resultado.getLong("Id_Pedido"));
				pedido.setDescricao(resultado.getString("Descricao"));
				pedido.setQuantidade(resultado.getInt("Quantidade"));
				pedido.setValor(resultado.getDouble("Preco_Unitario"));
				pedido.setSubtotal(resultado.getDouble("Preco_Total"));
				pedidos.add(pedido);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}
}
