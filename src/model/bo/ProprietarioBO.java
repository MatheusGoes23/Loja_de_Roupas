package model.bo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.AutenticationException;
import exception.InsertException;
import model.dao.ProprietarioDAO;
import model.vo.ProprietarioVO;

public class ProprietarioBO<VO extends ProprietarioVO> {
	static private ProprietarioDAO<ProprietarioVO> dao = new ProprietarioDAO<ProprietarioVO>();

	// Métodos

	public ProprietarioVO autenticar(VO vo) throws AutenticationException, IOException {
		ProprietarioVO propaut = new ProprietarioVO();
		try {
			ResultSet rs = dao.buscarByLogin(vo);
			if (rs.next()) {
				if (!rs.getString("senha").equals(vo.getSenha())) {
					throw new AutenticationException();
				} else {
					List<ProprietarioVO> prop = dao.pesquisarByLogin(vo);
					propaut = prop.get(0);
				}
			} else {
				throw new AutenticationException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AutenticationException();
		}
		return propaut;
	}

	public void alterar(VO vo) throws InsertException, IOException {
		try {
			ResultSet rs = dao.buscarById_Proprietario(vo);
			ResultSet rs2 = dao.buscarByNome(vo);
			ResultSet rs3 = dao.buscarByCpf(vo);
			ResultSet rs4 = dao.buscarByLogin(vo);

			if (rs.next() | rs2.next() | rs3.next() | rs4.next()) {
				dao.alterar(vo);
			} else {
				throw new InsertException("Impossível alterar, pois não existe esse proprietário");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
	}

	public List<ProprietarioVO> pesquisar(VO vo) throws InsertException, IOException {
		List<ProprietarioVO> prop = new ArrayList<ProprietarioVO>();
		try {
			ResultSet rs = dao.buscarById_Proprietario(vo);
			ResultSet rs2 = dao.buscarByNome(vo);
			ResultSet rs3 = dao.buscarByCpf(vo);

			if (rs.next()) {
				prop = dao.pesquisarById_Proprietario(vo);
			} else if (rs2.next()) {
				prop = dao.pesquisarByNome(vo);
			} else if (rs3.next()) {
				prop = dao.pesquisarByCpf(vo);
			} else {
				throw new InsertException("Impossível encontrar, pois não existe esse proprietário");
			}

		} catch (SQLException e) {
			throw new InsertException(e.getMessage());
		}
		return prop;
	}

	public List<ProprietarioVO> listar() throws IOException {
		List<ProprietarioVO> prop = dao.listar();

		return prop;
	}
}
