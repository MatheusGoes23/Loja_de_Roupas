package model.bo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.InsertException;
import model.dao.PedidoDAO;
import model.vo.PedidoVO;

public class PedidoBO<VO extends PedidoVO> {
	static private PedidoDAO<PedidoVO> dao = new PedidoDAO<PedidoVO>();

	// Métodos

	public void inserir(VO vo) throws IOException {
		dao.inserir(vo);
	}

	public void alterar(VO vo) throws InsertException, IOException {
		try {
			ResultSet rs = dao.buscarById_Pedido(vo);
			ResultSet rs2 = dao.buscarById_Produto(vo);
			ResultSet rs3 = dao.buscarById_Compra(vo);
			ResultSet rs4 = dao.buscarByValor(vo);

			if (rs.next() | rs2.next() | rs3.next() | rs4.next()) {
				dao.alterar(vo);
			} else {
				throw new InsertException("Impossível alterar, pois não existe esse pedido");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void remover(VO vo) throws InsertException, IOException {
		try {
			ResultSet rs = dao.buscarById_Pedido(vo);

			if (rs.next()) {
				dao.remover(vo);
			} else {
				throw new InsertException("Impossível remover, pois não existe esse pedido");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public List<PedidoVO> pesquisar(VO vo) throws InsertException, IOException {
		List<PedidoVO> ped = new ArrayList<PedidoVO>();
		try {
			ResultSet rs = dao.buscarById_Compra(vo);
			ResultSet rs2 = dao.buscarById_Produto(vo);
			ResultSet rs3 = dao.buscarByValor(vo);

			if (rs.next()) {
				ped = dao.pesquisarById_Compra(vo);
			} else if (rs2.next()) {
				ped = dao.pesquisarById_Produto(vo);
			} else if (rs3.next()) {
				ped = dao.pesquisarByValor(vo);
			} else {
				throw new InsertException("Impossível encontrar, pois não existe esse pedido");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return ped;
	}

	public List<PedidoVO> listar() throws IOException {
		List<PedidoVO> ped = dao.listar();

		return ped;
	}
}
