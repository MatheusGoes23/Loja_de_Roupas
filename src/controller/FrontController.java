package controller;

import java.net.URL;
import java.util.ResourceBundle;

import exception.AutenticationException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import model.bo.ClienteBO;
import model.bo.CompraBO;
import model.bo.FuncionarioBO;
import model.bo.GerenteBO;
import model.bo.PedidoBO;
import model.bo.ProdutoBO;
import model.bo.ProprietarioBO;
import model.vo.ClienteVO;
import model.vo.CompraVO;
import model.vo.FuncionarioVO;
import model.vo.GerenteVO;
import model.vo.PedidoVO;
import model.vo.ProdutoVO;
import model.vo.ProprietarioVO;
import view.Telas;

public class FrontController implements Initializable {
	// Variáveis FXML

	// ------------------CHAMADAS----------------
	ProprietarioBO<ProprietarioVO> propbo = new ProprietarioBO<ProprietarioVO>();
	GerenteBO<GerenteVO> gerbo = new GerenteBO<GerenteVO>();
	FuncionarioBO<FuncionarioVO> funcbo = new FuncionarioBO<FuncionarioVO>();
	ProdutoBO<ProdutoVO> prodbo = new ProdutoBO<ProdutoVO>();
	ClienteBO<ClienteVO> clibo = new ClienteBO<ClienteVO>();
	CompraBO<CompraVO> compbo = new CompraBO<CompraVO>();
	PedidoBO<PedidoVO> pedbo = new PedidoBO<PedidoVO>();

	// Tela de Login
	@FXML
	private TextField login;
	@FXML
	private PasswordField senha;
	@FXML
	private Label erroAut;

	// Tela do Proprietário
	@FXML
	private Button menuGerSele;
	@FXML
	private Label barraGerSele;
	@FXML
	private Button menuFuncSele;
	@FXML
	private Label barraFuncSele;
	@FXML
	private Button menuCliSele;
	@FXML
	private Label barraCliSele;

	// ------------INICIALIZAÇÃO DE TABELAS E FUNÇÕES------------------
	public void initialize(URL url, ResourceBundle rb) {
	}

	// ----------------------INICIO-------------------------
	public void telaInicial(ActionEvent event) throws Exception {
		try {
			Telas.telaInicial();
		} catch (AutenticationException e) {
		}
	}

	// ----------------------PROPRIETÁRIO-------------------------

	public void autenticarProprietario(ActionEvent event) throws Exception {
		ProprietarioVO vo = new ProprietarioVO();
		vo.setLogin(login.getText());
		vo.setSenha(senha.getText());

		try {
			propbo.autenticar(vo);
			Telas.telaProprietarioInicial();
		} catch (AutenticationException e) {
			erroAut.setVisible(true);
		}
	}

	public void gerentesProprietario(ActionEvent event) throws Exception {
		menuGerSele.setTextFill(Color.valueOf("#087326"));
		barraGerSele.setVisible(true);
		menuFuncSele.setTextFill(Color.valueOf("black"));
		barraFuncSele.setVisible(false);
		menuCliSele.setTextFill(Color.valueOf("black"));
		barraCliSele.setVisible(false);
	}

	public void funcionariosProprietario(ActionEvent event) throws Exception {
		menuGerSele.setTextFill(Color.valueOf("black"));
		barraGerSele.setVisible(false);
		menuFuncSele.setTextFill(Color.valueOf("#087326"));
		barraFuncSele.setVisible(true);
		menuCliSele.setTextFill(Color.valueOf("black"));
		barraCliSele.setVisible(false);
	}

	public void clientesProprietario(ActionEvent event) throws Exception {
		menuGerSele.setTextFill(Color.valueOf("black"));
		barraGerSele.setVisible(false);
		menuFuncSele.setTextFill(Color.valueOf("black"));
		barraFuncSele.setVisible(false);
		menuCliSele.setTextFill(Color.valueOf("#087326"));
		barraCliSele.setVisible(true);
	}

	public void telaLoginProprietario(ActionEvent event) throws Exception {
		try {
			Telas.telaLoginProprietario();
		} catch (AutenticationException e) {
		}
	}

	public void telaProprietarioInicial(ActionEvent event) throws Exception {
		try {
			Telas.telaProprietarioInicial();
		} catch (AutenticationException e) {
		}
	}

	// ----------------------GERENTE-------------------------

	public void autenticarGerente(ActionEvent event) throws Exception {
		GerenteVO vo = new GerenteVO();
		vo.setLogin(login.getText());
		vo.setSenha(senha.getText());

		try {
			gerbo.autenticar(vo);
			Telas.telaGerenteInicial();
		} catch (AutenticationException e) {
			erroAut.setVisible(true);
		}
	}

	public void telaLoginGerente(ActionEvent event) throws Exception {
		try {
			Telas.telaLoginGerente();
		} catch (AutenticationException e) {
		}
	}

	public void telaGerenteInicial(ActionEvent event) throws Exception {
		try {
			Telas.telaGerenteInicial();
		} catch (AutenticationException e) {
		}
	}

	// ----------------------FUNCIONÁRIO-------------------------

	public void autenticarFuncionario(ActionEvent event) throws Exception {
		FuncionarioVO vo = new FuncionarioVO();
		vo.setLogin(login.getText());
		vo.setSenha(senha.getText());

		try {
			funcbo.autenticar(vo);
			Telas.telaFuncionarioInicial();
		} catch (AutenticationException e) {
			erroAut.setVisible(true);
		}
	}

	public void telaLoginFuncionario(ActionEvent event) throws Exception {
		try {
			Telas.telaLoginFuncionario();
		} catch (AutenticationException e) {
		}
	}

	public void telaFuncionarioInicial(ActionEvent event) throws Exception {
		try {
			Telas.telaFuncionarioInicial();
		} catch (AutenticationException e) {
		}
	}

}
