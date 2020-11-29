package model.bo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.InsertException;
import model.dao.ProdutoDAO;
import model.vo.ProdutoVO;

public class ProdutoBO<VO extends ProdutoVO> {
	static private ProdutoDAO<ProdutoVO> dao = new ProdutoDAO<ProdutoVO>();

	// Métodos

	public void inserir(VO vo) throws InsertException, IOException {
		try {
			ResultSet rs = dao.buscarById_Produto(vo);
			ResultSet rs2 = dao.buscarByDescricao(vo);

			if (rs.next() | rs2.next()) {
				throw new InsertException("Impossível adicionar, pois já existe esse produto");
			} else {
				dao.inserir(vo);
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void alterar(VO vo) throws InsertException, IOException {
		try {
			ResultSet rs = dao.buscarById_Produto(vo);
			ResultSet rs2 = dao.buscarByDescricao(vo);
			ResultSet rs3 = dao.buscarByValor(vo);

			if (rs.next() | rs2.next() | rs3.next()) {
				dao.alterar(vo);
			} else {
				throw new InsertException("Impossível alterar, pois não existe esse produto");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void remover(VO vo) throws InsertException, IOException {
		try {
			ResultSet rs = dao.buscarById_Produto(vo);

			if (rs.next()) {
				dao.remover(vo);
			} else {
				throw new InsertException("Impossível remover, pois não existe esse produto");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public List<ProdutoVO> pesquisar(VO vo) throws InsertException, IOException {
		List<ProdutoVO> prod = new ArrayList<ProdutoVO>();
		try {
			ResultSet rs = dao.buscarById_Produto(vo);
			ResultSet rs2 = dao.buscarByDescricao(vo);
			ResultSet rs3 = dao.buscarByValor(vo);

			if (rs.next()) {
				prod = dao.pesquisarById_Produto(vo);
			} else if (rs2.next()) {
				prod = dao.pesquisarByDescricao(vo);
			} else if (rs3.next()) {
				prod = dao.pesquisarByValor(vo);
			} else {
				throw new InsertException("Impossível encontrar, pois não existe esse produto");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return prod;
	}

	public List<ProdutoVO> listar() throws IOException {
		List<ProdutoVO> prod = dao.listar();

		return prod;
	}
}
