package model.bo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.InsertException;
import model.dao.FuncionarioDAO;
import model.vo.FuncionarioVO;

public class FuncionarioBO<VO extends FuncionarioVO> {
	static private FuncionarioDAO<FuncionarioVO> dao = new FuncionarioDAO<FuncionarioVO>();

	// Métodos

	public void inserir(VO vo) throws InsertException, IOException {
		try {
			ResultSet rs = dao.buscarByCpf(vo);
			ResultSet rs2 = dao.buscarByLogin(vo);
			if (rs.next() | rs2.next()) {
				throw new InsertException("Impossível adicionar, pois já existe esse funcionario");
			} else {
				dao.inserir(vo);
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void alterar(VO vo) throws InsertException, IOException {
		try {
			ResultSet rs = dao.buscarById_Funcionario(vo);
			ResultSet rs2 = dao.buscarById_Proprietario(vo);
			ResultSet rs3 = dao.buscarByNome(vo);
			ResultSet rs4 = dao.buscarByCpf(vo);
			ResultSet rs5 = dao.buscarByLogin(vo);

			if (rs.next() | rs2.next() | rs3.next() | rs4.next() | rs5.next()) {
				dao.alterar(vo);
			} else {
				throw new InsertException("Impossível alterar, pois não existe esse funcionario");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void remover(VO vo) throws InsertException, IOException {
		try {
			ResultSet rs = dao.buscarById_Funcionario(vo);

			if (rs.next()) {
				dao.remover(vo);
			} else {
				throw new InsertException("Impossível remover, pois não existe esse funcionario");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public List<FuncionarioVO> pesquisar(VO vo) throws InsertException, IOException {
		List<FuncionarioVO> func = new ArrayList<FuncionarioVO>();
		try {
			ResultSet rs = dao.buscarById_Funcionario(vo);
			ResultSet rs2 = dao.buscarByNome(vo);
			ResultSet rs3 = dao.buscarByCpf(vo);

			if (rs.next()) {
				func = dao.pesquisarById_Funcionario(vo);
			} else if (rs2.next()) {
				func = dao.pesquisarByNome(vo);
			} else if (rs3.next()) {
				func = dao.pesquisarByCpf(vo);
			} else {
				throw new InsertException("Impossível encontrar, pois não existe esse funcionario");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return func;
	}

	public List<FuncionarioVO> listar() throws IOException {
		List<FuncionarioVO> func = dao.listar();

		return func;
	}
}
