package model.bo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.InsertException;
import model.dao.ClienteDAO;
import model.vo.ClienteVO;

public class ClienteBO<VO extends ClienteVO> {
	static private ClienteDAO<ClienteVO> dao = new ClienteDAO<ClienteVO>();

	// Métodos

	public void inserir(VO vo) throws InsertException, IOException {
		try {
			ResultSet rs = dao.buscarByCpf(vo);

			if (rs.next()) {
				throw new InsertException("Impossível adicionar, pois já existe esse cliente");
			} else {
				dao.inserir(vo);
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void alterar(VO vo) throws InsertException, IOException {
		try {
			ResultSet rs = dao.buscarById_Cliente(vo);
			ResultSet rs2 = dao.buscarByNome(vo);
			ResultSet rs3 = dao.buscarByCpf(vo);

			if (rs.next() | rs2.next() | rs3.next()) {
				dao.alterar(vo);
			} else {
				throw new InsertException("Impossível alterar, pois não existe esse cliente");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void remover(VO vo) throws InsertException, IOException {
		try {
			ResultSet rs = dao.buscarById_Cliente(vo);

			if (rs.next()) {
				dao.remover(vo);
			} else {
				throw new InsertException("Impossível remover, pois não existe esse cliente");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public List<ClienteVO> pesquisar(VO vo) throws InsertException, IOException {
		List<ClienteVO> cli = new ArrayList<ClienteVO>();
		try {
			ResultSet rs = dao.buscarById_Cliente(vo);
			ResultSet rs2 = dao.buscarByNome(vo);
			ResultSet rs3 = dao.buscarByCpf(vo);

			if (rs.next()) {
				cli = dao.pesquisarById_Cliente(vo);
			} else if (rs2.next()) {
				cli = dao.pesquisarByNome(vo);
			} else if (rs3.next()) {
				cli = dao.pesquisarByCpf(vo);
			} else {
				throw new InsertException("Impossível encontrar, pois não existe esse cliente");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return cli;
	}

	public List<ClienteVO> listar() throws IOException {
		List<ClienteVO> cli = dao.listar();

		return cli;
	}
}
