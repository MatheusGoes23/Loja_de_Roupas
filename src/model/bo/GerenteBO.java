package model.bo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.AutenticationException;
import exception.InsertException;
import model.dao.GerenteDAO;
import model.vo.GerenteVO;

public class GerenteBO<VO extends GerenteVO> {
	static private GerenteDAO<GerenteVO> dao = new GerenteDAO<GerenteVO>();

	// Métodos

	public boolean autenticar(VO vo) throws AutenticationException, IOException {
		boolean aut = false;
		try {
			ResultSet rs = dao.buscarByLogin(vo);
			if (rs.next()) {
				if (!rs.getString("senha").equals(vo.getSenha())) {
					throw new AutenticationException();
				} else {
					aut = true;
				}
			} else {
				throw new AutenticationException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AutenticationException();
		}
		return aut;
	}

	public void inserir(VO vo) throws InsertException, IOException {
		try {
			ResultSet rs = dao.buscarByCpf(vo);
			ResultSet rs2 = dao.buscarByLogin(vo);
			if (rs.next() | rs2.next()) {
				throw new InsertException("Impossível adicionar, pois já existe esse gerente");
			} else {
				dao.inserir(vo);
			}
		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void alterar(VO vo) throws InsertException, IOException {
		try {
			ResultSet rs = dao.buscarById_Gerente(vo);
			ResultSet rs2 = dao.buscarById_Proprietario(vo);
			ResultSet rs3 = dao.buscarByNome(vo);
			ResultSet rs4 = dao.buscarByCpf(vo);
			ResultSet rs5 = dao.buscarByLogin(vo);

			if (rs.next() | rs2.next() | rs3.next() | rs4.next() | rs5.next()) {
				dao.alterar(vo);
			} else {
				throw new InsertException("Impossível alterar, pois não existe esse gerente");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public void remover(VO vo) throws InsertException, IOException {
		try {
			ResultSet rs = dao.buscarById_Gerente(vo);

			if (rs.next()) {
				dao.remover(vo);
			} else {
				throw new InsertException("Impossível remover, pois não existe esse gerente");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public List<GerenteVO> pesquisar(VO vo) throws InsertException, IOException {
		List<GerenteVO> ger = new ArrayList<GerenteVO>();
		try {
			ResultSet rs = dao.buscarById_Gerente(vo);
			ResultSet rs2 = dao.buscarByNome(vo);
			ResultSet rs3 = dao.buscarByCpf(vo);

			if (rs.next()) {
				ger = dao.pesquisarById_Gerente(vo);
			} else if (rs2.next()) {
				ger = dao.pesquisarByNome(vo);
			} else if (rs3.next()) {
				ger = dao.pesquisarByCpf(vo);
			} else {
				throw new InsertException("Impossível encontrar, pois não existe esse gerente");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return ger;
	}

	public List<GerenteVO> listar() throws IOException {
		List<GerenteVO> ger = dao.listar();

		return ger;
	}
}
