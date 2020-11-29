package model.bo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.InsertException;
import model.dao.CompraDAO;
import model.vo.CompraVO;

public class CompraBO<VO extends CompraVO> {
	static private CompraDAO<CompraVO> dao = new CompraDAO<CompraVO>();

	// Métodos

	public void inserir(VO vo) throws IOException {
		dao.inserir(vo);
	}

	public void alterar(VO vo) throws InsertException, IOException {
		try {
			ResultSet rs = dao.buscarById_Compra(vo);
			ResultSet rs2 = dao.buscarById_Funcionario(vo);
			ResultSet rs3 = dao.buscarById_Cliente(vo);
			ResultSet rs4 = dao.buscarByValor(vo);
			ResultSet rs5 = dao.buscarByData(vo);
			ResultSet rs6 = dao.buscarByHora(vo);

			if (rs.next() | rs2.next() | rs3.next() | rs4.next() | rs5.next() | rs6.next()) {
				dao.alterar(vo);
			} else {
				throw new InsertException("Impossível alterar, pois não existe essa compra");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void remover(VO vo) throws InsertException, IOException {
		try {
			ResultSet rs = dao.buscarById_Compra(vo);

			if (rs.next()) {
				dao.remover(vo);
			} else {
				throw new InsertException("Impossível remover, pois não existe essa compra");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public List<CompraVO> pesquisar(VO vo) throws InsertException, IOException {
		List<CompraVO> comp = new ArrayList<CompraVO>();
		try {
			ResultSet rs = dao.buscarById_Cliente(vo);
			ResultSet rs2 = dao.buscarByValor(vo);
			ResultSet rs3 = dao.buscarByData(vo);

			if (rs.next()) {
				comp = dao.pesquisarById_Cliente(vo);
			} else if (rs2.next()) {
				comp = dao.pesquisarByValor(vo);
			} else if (rs3.next()) {
				comp = dao.pesquisarByData(vo);
			} else {
				throw new InsertException("Impossível encontrar, pois não existe essa compra");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return comp;
	}

	public List<CompraVO> listar() throws IOException {
		List<CompraVO> comp = dao.listar();

		return comp;
	}

}
