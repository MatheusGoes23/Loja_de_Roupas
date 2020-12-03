package controller;

import java.net.URL;
import java.util.ResourceBundle;

import exception.AutenticationException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
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
	@FXML
	private Button menuProdSele;
	@FXML
	private Label barraProdSele;
	@FXML
	private Button menuCompSele;
	@FXML
	private Label barraCompSele;
	@FXML
	private Pane paneGer;
	@FXML
	private Pane paneFunc;
	@FXML
	private Pane paneCli;
	@FXML
	private Pane paneProd;
	@FXML
	private Pane paneComp;
	@FXML
	private Label erroPropGer;
	@FXML
	private Label erroPropFunc;
	@FXML
	private Label erroPropCli;
	@FXML
	private Label erroPropProd;

	// Proprietário/Gerentes
	@FXML
	private TextField idGerente;
	@FXML
	private TextField idProprietarioGerente;
	@FXML
	private TextField nomeGerente;
	@FXML
	private TextField cpfGerente;
	@FXML
	private TextField loginGerente;
	@FXML
	private TextField senhaGerente;
	@FXML
	private TextField loginGerente2;
	@FXML
	private TextField senhaGerente2;

	@FXML
	private TableColumn<GerenteVO, Long> tableIdGer;
	@FXML
	private TableColumn<GerenteVO, Long> tableIdProp;
	@FXML
	private TableColumn<GerenteVO, String> tableNomeGerente;
	@FXML
	private TableColumn<GerenteVO, String> tableCpfGerente;
	@FXML
	private TableColumn<GerenteVO, String> tableLoginGerente;
	@FXML
	private TableColumn<GerenteVO, String> tableSenhaGerente;
	@FXML
	private TableView<GerenteVO> tableGerentes;

	@FXML
	private TextField pesquisarGer;

	// Proprietário/Funcionarios
	@FXML
	private TextField idFuncionario;
	@FXML
	private TextField idProprietarioFuncionario;
	@FXML
	private TextField nomeFuncionario;
	@FXML
	private TextField cpfFuncionario;
	@FXML
	private TextField loginFuncionario;
	@FXML
	private TextField senhaFuncionario;
	@FXML
	private TextField loginFuncionario2;
	@FXML
	private TextField senhaFuncionario2;

	@FXML
	private TableColumn<FuncionarioVO, Long> tableIdFunc;
	@FXML
	private TableColumn<FuncionarioVO, Long> tableIdPropFunc;
	@FXML
	private TableColumn<FuncionarioVO, String> tableNomeFuncionario;
	@FXML
	private TableColumn<FuncionarioVO, String> tableCpfFuncionario;
	@FXML
	private TableColumn<FuncionarioVO, String> tableLoginFuncionario;
	@FXML
	private TableColumn<FuncionarioVO, String> tableSenhaFuncionario;
	@FXML
	private TableView<FuncionarioVO> tableFuncionarios;

	@FXML
	private TextField pesquisarFunc;

	// Proprietário/Clientes
	@FXML
	private TextField idCliente;
	@FXML
	private TextField nomeCliente;
	@FXML
	private TextField cpfCliente;

	@FXML
	private TableColumn<ClienteVO, Long> tableIdCli;
	@FXML
	private TableColumn<ClienteVO, String> tableNomeCliente;
	@FXML
	private TableColumn<ClienteVO, String> tableCpfCliente;
	@FXML
	private TableView<ClienteVO> tableClientes;

	@FXML
	private TextField pesquisarCli;

	// Proprietário/Produtos
	@FXML
	private TextField idProduto;
	@FXML
	private TextField descricaoProduto;
	@FXML
	private TextField valorProduto;
	@FXML
	private TextField quantidadeProduto;

	@FXML
	private TableColumn<ProdutoVO, Long> tableIdProd;
	@FXML
	private TableColumn<ProdutoVO, String> tableDescricaoProduto;
	@FXML
	private TableColumn<ProdutoVO, Double> tableValorProduto;
	@FXML
	private TableColumn<ProdutoVO, Integer> tableQuantidadeProduto;
	@FXML
	private TableView<ProdutoVO> tableProdutos;

	@FXML
	private TextField pesquisarProd;

	// Tabelas
	private ObservableList<GerenteVO> listaGerentes = FXCollections.observableArrayList();
	private ObservableList<FuncionarioVO> listaFuncionarios = FXCollections.observableArrayList();
	private ObservableList<ClienteVO> listaClientes = FXCollections.observableArrayList();
	private ObservableList<ProdutoVO> listaProdutos = FXCollections.observableArrayList();

	private static GerenteVO gerenteSelecionado;
	private static FuncionarioVO funcionarioSelecionado;
	private static ClienteVO clienteSelecionado;
	private static ProdutoVO produtoSelecionado;

	// ------------------CHAMADAS----------------
	ProprietarioBO<ProprietarioVO> propbo = new ProprietarioBO<ProprietarioVO>();
	GerenteBO<GerenteVO> gerbo = new GerenteBO<GerenteVO>();
	FuncionarioBO<FuncionarioVO> funcbo = new FuncionarioBO<FuncionarioVO>();
	ProdutoBO<ProdutoVO> prodbo = new ProdutoBO<ProdutoVO>();
	ClienteBO<ClienteVO> clibo = new ClienteBO<ClienteVO>();
	CompraBO<CompraVO> compbo = new CompraBO<CompraVO>();
	PedidoBO<PedidoVO> pedbo = new PedidoBO<PedidoVO>();

	// ------------INICIALIZAÇÃO DE TABELAS E FUNÇÕES------------------
	public void initialize(URL url, ResourceBundle rb) {

		try {
			tableGerentes();

			tableGerentes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

				@Override
				public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
					gerenteSelecionado = (GerenteVO) newValue;
					idGerente.setText(String.valueOf(gerenteSelecionado.getId_Gerente()));
					idProprietarioGerente.setText(String.valueOf(gerenteSelecionado.getId_Proprietario()));
					nomeGerente.setText(gerenteSelecionado.getNome());
					cpfGerente.setText(gerenteSelecionado.getCpf());
					loginGerente.setText(gerenteSelecionado.getLogin());
					senhaGerente.setText(gerenteSelecionado.getSenha());

				}
			});

		} catch (Exception e) {
		}

		try {
			tableFuncionarios();

			tableFuncionarios.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

				@Override
				public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
					funcionarioSelecionado = (FuncionarioVO) newValue;
					idFuncionario.setText(String.valueOf(funcionarioSelecionado.getId_Funcionario()));
					idProprietarioFuncionario.setText(String.valueOf(funcionarioSelecionado.getId_Proprietario()));
					nomeFuncionario.setText(funcionarioSelecionado.getNome());
					cpfFuncionario.setText(funcionarioSelecionado.getCpf());
					loginFuncionario.setText(funcionarioSelecionado.getLogin());
					senhaFuncionario.setText(funcionarioSelecionado.getSenha());

				}
			});

		} catch (Exception e) {

		}

		try {
			tableClientes();

			tableClientes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

				@Override
				public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
					clienteSelecionado = (ClienteVO) newValue;
					idCliente.setText(String.valueOf(clienteSelecionado.getId_Cliente()));
					nomeCliente.setText(clienteSelecionado.getNome());
					cpfCliente.setText(clienteSelecionado.getCpf());

				}
			});

		} catch (Exception e) {

		}

		try {
			tableProdutos();

			tableProdutos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

				@Override
				public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
					produtoSelecionado = (ProdutoVO) newValue;
					idProduto.setText(String.valueOf(produtoSelecionado.getId_Produto()));
					descricaoProduto.setText(produtoSelecionado.getDescricao());
					valorProduto.setText(String.valueOf(produtoSelecionado.getValor()));
					quantidadeProduto.setText(String.valueOf(produtoSelecionado.getQuantidade()));

				}
			});

		} catch (Exception e) {
		}
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

	// ----------------------PROPRIETÁRIO/GERENTE-------------------------

	public void tableGerentes() throws Exception {
		tableIdGer.setCellValueFactory(new PropertyValueFactory<>("Id_Gerente"));
		tableIdProp.setCellValueFactory(new PropertyValueFactory<>("Id_Proprietario"));
		tableNomeGerente.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableCpfGerente.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tableLoginGerente.setCellValueFactory(new PropertyValueFactory<>("login"));
		tableSenhaGerente.setCellValueFactory(new PropertyValueFactory<>("senha"));

		GerenteBO<GerenteVO> bo = new GerenteBO<GerenteVO>();
		listaGerentes = FXCollections.observableList(bo.listar());
		tableGerentes.setItems(listaGerentes);
	}

	public void pesquisarGerente(ActionEvent event) throws Exception {
		tableGerentes.setItems(pesquisarGerente());
	}

	public ObservableList<GerenteVO> pesquisarGerente() {
		ObservableList<GerenteVO> gerentePesquisa = FXCollections.observableArrayList();
		for (int x = 0; x < listaGerentes.size(); x++) {
			if ((listaGerentes.get(x).getNome().contains(pesquisarGer.getText().toUpperCase()))
					| (listaGerentes.get(x).getCpf().contains(pesquisarGer.getText()))) {
				gerentePesquisa.add(listaGerentes.get(x));
			}
		}
		return gerentePesquisa;
	}

	public void refreshTableGerente(ActionEvent event) throws Exception {
		GerenteBO<GerenteVO> bo = new GerenteBO<GerenteVO>();
		listaGerentes = FXCollections.observableList(bo.listar());
		tableGerentes.setItems(listaGerentes);
	}

	public void refreshGerente() {
		idGerente.setText("");
		idProprietarioGerente.setText("");
		nomeGerente.setText("");
		cpfGerente.setText("");
		loginGerente2.setText("");
		senhaGerente2.setText("");
		erroPropGer.setVisible(false);
	}

	public void inserirGerente() {
		GerenteVO vo = new GerenteVO();

		if (idProprietarioGerente.getText().isEmpty()) {
			erroPropGer.setText("Id_Proprietario vazio!");
			erroPropGer.setVisible(true);
		} else if (nomeGerente.getText().isEmpty()) {
			erroPropGer.setText("Nome vazio!");
			erroPropGer.setVisible(true);
		} else if (cpfGerente.getText().isEmpty()) {
			erroPropGer.setText("Cpf vazio!");
			erroPropGer.setVisible(true);
		} else if (loginGerente2.getText().isEmpty()) {
			erroPropGer.setText("Login vazio!");
			erroPropGer.setVisible(true);
		} else if (senhaGerente2.getText().isEmpty()) {
			erroPropGer.setText("Senha vazia!");
			erroPropGer.setVisible(true);
		} else {
			try {
				vo.setId_Proprietario(Long.parseLong(idProprietarioGerente.getText()));
				vo.setNome(nomeGerente.getText());
				vo.setCpf(cpfGerente.getText());
				vo.setLogin(loginGerente2.getText());
				vo.setSenha(senhaGerente2.getText());

				gerbo.inserir(vo);
				erroPropGer.setVisible(false);
				idGerente.setText("");
				idProprietarioGerente.setText("");
				nomeGerente.setText("");
				cpfGerente.setText("");
				loginGerente2.setText("");
				senhaGerente2.setText("");

				gerentesProprietario(null);
			} catch (Exception e) {
				e.printStackTrace();
				erroPropGer.setText("Erro! Verifique os dados");
				erroPropGer.setVisible(true);

			}

		}
	}

	public void alterarGerente() {
		GerenteVO vo = new GerenteVO();

		if (idProprietarioGerente.getText().isEmpty()) {
			erroPropGer.setText("Id_Proprietario vazio!");
			erroPropGer.setVisible(true);
		} else if (nomeGerente.getText().isEmpty()) {
			erroPropGer.setText("Nome vazio!");
			erroPropGer.setVisible(true);
		} else if (cpfGerente.getText().isEmpty()) {
			erroPropGer.setText("Cpf vazio!");
			erroPropGer.setVisible(true);
		} else if (loginGerente.getText().isEmpty()) {
			erroPropGer.setText("Login vazio!");
			erroPropGer.setVisible(true);
		} else if (senhaGerente.getText().isEmpty()) {
			erroPropGer.setText("Senha vazia!");
			erroPropGer.setVisible(true);
		} else if (!loginGerente2.getText().isEmpty()) {
			erroPropGer.setText("Não é permitido alterar login!");
			erroPropGer.setVisible(true);
		} else if (!senhaGerente2.getText().isEmpty()) {
			erroPropGer.setText("Não é permitido alterar senha!");
			erroPropGer.setVisible(true);
		} else {
			try {
				vo.setId_Gerente(Long.parseLong(idGerente.getText()));
				vo.setId_Proprietario(Long.parseLong(idProprietarioGerente.getText()));
				vo.setNome(nomeGerente.getText());
				vo.setCpf(cpfGerente.getText());
				vo.setLogin(loginGerente2.getText());
				vo.setSenha(senhaGerente2.getText());

				gerbo.alterar(vo);
				erroPropGer.setVisible(false);
				idGerente.setText("");
				idProprietarioGerente.setText("");
				nomeGerente.setText("");
				cpfGerente.setText("");
				loginGerente2.setText("");
				senhaGerente2.setText("");

				gerentesProprietario(null);
			} catch (Exception e) {
				e.printStackTrace();
				erroPropGer.setText("Erro! Verifique os dados");
				erroPropGer.setVisible(true);

			}

		}
	}

	public void removerGerente() {
		GerenteVO vo = new GerenteVO();

		if (idProprietarioGerente.getText().isEmpty()) {
			erroPropGer.setText("Id_Proprietario vazio!");
			erroPropGer.setVisible(true);
		} else if (nomeGerente.getText().isEmpty()) {
			erroPropGer.setText("Nome vazio!");
			erroPropGer.setVisible(true);
		} else if (cpfGerente.getText().isEmpty()) {
			erroPropGer.setText("Cpf vazio!");
			erroPropGer.setVisible(true);
		} else if (loginGerente.getText().isEmpty()) {
			erroPropGer.setText("Login vazio!");
			erroPropGer.setVisible(true);
		} else if (senhaGerente.getText().isEmpty()) {
			erroPropGer.setText("Senha vazia!");
			erroPropGer.setVisible(true);
		} else {
			try {
				vo.setId_Gerente(Long.parseLong(idGerente.getText()));

				gerbo.remover(vo);
				erroPropGer.setVisible(false);
				idGerente.setText("");
				idProprietarioGerente.setText("");
				nomeGerente.setText("");
				cpfGerente.setText("");
				loginGerente2.setText("");
				senhaGerente2.setText("");

				gerentesProprietario(null);
			} catch (Exception e) {
				e.printStackTrace();
				erroPropGer.setText("Erro! Verifique os dados");

			}

		}
	}

// ----------------------PROPRIETÁRIO/FUNCIONÁRIO-------------------------

	public void tableFuncionarios() throws Exception {
		tableIdFunc.setCellValueFactory(new PropertyValueFactory<>("Id_Funcionario"));
		tableIdPropFunc.setCellValueFactory(new PropertyValueFactory<>("Id_Proprietario"));
		tableNomeFuncionario.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableCpfFuncionario.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tableLoginFuncionario.setCellValueFactory(new PropertyValueFactory<>("login"));
		tableSenhaFuncionario.setCellValueFactory(new PropertyValueFactory<>("senha"));

		FuncionarioBO<FuncionarioVO> bo = new FuncionarioBO<FuncionarioVO>();
		listaFuncionarios = FXCollections.observableList(bo.listar());
		tableFuncionarios.setItems(listaFuncionarios);
	}

	public void pesquisarFuncionario(ActionEvent event) throws Exception {
		tableFuncionarios.setItems(pesquisarFuncionario());
	}

	public ObservableList<FuncionarioVO> pesquisarFuncionario() {
		ObservableList<FuncionarioVO> funcionarioPesquisa = FXCollections.observableArrayList();
		for (int x = 0; x < listaFuncionarios.size(); x++) {
			if ((listaFuncionarios.get(x).getNome().contains(pesquisarFunc.getText().toUpperCase()))
					| (listaFuncionarios.get(x).getCpf().contains(pesquisarFunc.getText()))) {
				funcionarioPesquisa.add(listaFuncionarios.get(x));
			}
		}
		return funcionarioPesquisa;
	}

	public void refreshTableFuncionario(ActionEvent event) throws Exception {
		FuncionarioBO<FuncionarioVO> bo = new FuncionarioBO<FuncionarioVO>();
		listaFuncionarios = FXCollections.observableList(bo.listar());
		tableFuncionarios.setItems(listaFuncionarios);
	}

	public void refreshFuncionario() {
		idFuncionario.setText("");
		idProprietarioFuncionario.setText("");
		nomeFuncionario.setText("");
		cpfFuncionario.setText("");
		loginFuncionario2.setText("");
		senhaFuncionario2.setText("");
		erroPropFunc.setVisible(false);
	}

	public void inserirFuncionario() {
		FuncionarioVO vo = new FuncionarioVO();

		if (idProprietarioFuncionario.getText().isEmpty()) {
			erroPropFunc.setText("Id_Proprietario vazio!");
			erroPropFunc.setVisible(true);
		} else if (nomeFuncionario.getText().isEmpty()) {
			erroPropFunc.setText("Nome vazio!");
			erroPropFunc.setVisible(true);
		} else if (cpfFuncionario.getText().isEmpty()) {
			erroPropFunc.setText("Cpf vazio!");
			erroPropFunc.setVisible(true);
		} else if (loginFuncionario2.getText().isEmpty()) {
			erroPropFunc.setText("Login vazio!");
			erroPropFunc.setVisible(true);
		} else if (senhaFuncionario2.getText().isEmpty()) {
			erroPropFunc.setText("Senha vazia!");
			erroPropFunc.setVisible(true);
		} else {
			try {
				vo.setId_Proprietario(Long.parseLong(idProprietarioFuncionario.getText()));
				vo.setNome(nomeFuncionario.getText());
				vo.setCpf(cpfFuncionario.getText());
				vo.setLogin(loginFuncionario2.getText());
				vo.setSenha(senhaFuncionario2.getText());

				funcbo.inserir(vo);
				erroPropFunc.setVisible(false);
				idFuncionario.setText("");
				idProprietarioFuncionario.setText("");
				nomeFuncionario.setText("");
				cpfFuncionario.setText("");
				loginFuncionario2.setText("");
				senhaFuncionario2.setText("");

				funcionariosProprietario(null);
			} catch (Exception e) {
				e.printStackTrace();
				erroPropFunc.setText("Erro! Verifique os dados");
				erroPropFunc.setVisible(true);

			}

		}
	}

	public void alterarFuncionario() {
		FuncionarioVO vo = new FuncionarioVO();

		if (idProprietarioFuncionario.getText().isEmpty()) {
			erroPropFunc.setText("Id_Proprietario vazio!");
			erroPropFunc.setVisible(true);
		} else if (nomeFuncionario.getText().isEmpty()) {
			erroPropFunc.setText("Nome vazio!");
			erroPropFunc.setVisible(true);
		} else if (cpfFuncionario.getText().isEmpty()) {
			erroPropFunc.setText("Cpf vazio!");
			erroPropFunc.setVisible(true);
		} else if (loginFuncionario.getText().isEmpty()) {
			erroPropFunc.setText("Login vazio!");
			erroPropFunc.setVisible(true);
		} else if (senhaFuncionario.getText().isEmpty()) {
			erroPropFunc.setText("Senha vazia!");
			erroPropFunc.setVisible(true);
		} else if (!loginFuncionario2.getText().isEmpty()) {
			erroPropFunc.setText("Não é permitido alterar login!");
			erroPropFunc.setVisible(true);
		} else if (!senhaFuncionario2.getText().isEmpty()) {
			erroPropFunc.setText("Não é permitido alterar senha!");
			erroPropFunc.setVisible(true);
		} else {
			try {
				vo.setId_Funcionario(Long.parseLong(idFuncionario.getText()));
				vo.setId_Proprietario(Long.parseLong(idProprietarioFuncionario.getText()));
				vo.setNome(nomeFuncionario.getText());
				vo.setCpf(cpfFuncionario.getText());
				vo.setLogin(loginFuncionario2.getText());
				vo.setSenha(senhaFuncionario2.getText());

				funcbo.alterar(vo);
				erroPropFunc.setVisible(false);
				idFuncionario.setText("");
				idProprietarioFuncionario.setText("");
				nomeFuncionario.setText("");
				cpfFuncionario.setText("");
				loginFuncionario2.setText("");
				senhaFuncionario2.setText("");

				funcionariosProprietario(null);
			} catch (Exception e) {
				e.printStackTrace();
				erroPropFunc.setText("Erro! Verifique os dados");
				erroPropFunc.setVisible(true);

			}

		}
	}

	public void removerFuncionario() {
		FuncionarioVO vo = new FuncionarioVO();

		if (idProprietarioFuncionario.getText().isEmpty()) {
			erroPropFunc.setText("Id_Proprietario vazio!");
			erroPropFunc.setVisible(true);
		} else if (nomeFuncionario.getText().isEmpty()) {
			erroPropFunc.setText("Nome vazio!");
			erroPropFunc.setVisible(true);
		} else if (cpfFuncionario.getText().isEmpty()) {
			erroPropFunc.setText("Cpf vazio!");
			erroPropFunc.setVisible(true);
		} else if (loginFuncionario.getText().isEmpty()) {
			erroPropFunc.setText("Login vazio!");
			erroPropFunc.setVisible(true);
		} else if (senhaFuncionario.getText().isEmpty()) {
			erroPropFunc.setText("Senha vazia!");
			erroPropFunc.setVisible(true);
		} else {
			try {
				vo.setId_Funcionario(Long.parseLong(idFuncionario.getText()));

				funcbo.remover(vo);
				erroPropFunc.setVisible(false);
				idFuncionario.setText("");
				idProprietarioFuncionario.setText("");
				nomeFuncionario.setText("");
				cpfFuncionario.setText("");
				loginFuncionario2.setText("");
				senhaFuncionario2.setText("");

				funcionariosProprietario(null);
			} catch (Exception e) {
				e.printStackTrace();
				erroPropFunc.setText("Erro! Verifique os dados");
				erroPropFunc.setVisible(true);

			}

		}
	}

	// ----------------------PROPRIETÁRIO/CLIENTE-------------------------

	public void tableClientes() throws Exception {
		tableIdCli.setCellValueFactory(new PropertyValueFactory<>("Id_Cliente"));
		tableNomeCliente.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableCpfCliente.setCellValueFactory(new PropertyValueFactory<>("cpf"));

		ClienteBO<ClienteVO> bo = new ClienteBO<ClienteVO>();
		listaClientes = FXCollections.observableList(bo.listar());
		tableClientes.setItems(listaClientes);
	}

	public void pesquisarCliente(ActionEvent event) throws Exception {
		tableClientes.setItems(pesquisarCliente());
	}

	public ObservableList<ClienteVO> pesquisarCliente() {
		ObservableList<ClienteVO> clientePesquisa = FXCollections.observableArrayList();
		for (int x = 0; x < listaClientes.size(); x++) {
			if ((listaClientes.get(x).getNome().contains(pesquisarCli.getText().toUpperCase()))
					| (listaClientes.get(x).getCpf().contains(pesquisarCli.getText()))) {
				clientePesquisa.add(listaClientes.get(x));
			}
		}
		return clientePesquisa;
	}

	public void refreshTableCliente(ActionEvent event) throws Exception {
		ClienteBO<ClienteVO> bo = new ClienteBO<ClienteVO>();
		listaClientes = FXCollections.observableList(bo.listar());
		tableClientes.setItems(listaClientes);
	}

	public void refreshCliente() {
		idCliente.setText("");
		nomeCliente.setText("");
		cpfCliente.setText("");
		erroPropCli.setVisible(false);
	}

	public void inserirCliente() {
		ClienteVO vo = new ClienteVO();

		if (nomeCliente.getText().isEmpty()) {
			erroPropCli.setText("Nome vazio!");
			erroPropCli.setVisible(true);
		} else if (cpfCliente.getText().isEmpty()) {
			erroPropCli.setText("Cpf vazio!");
			erroPropCli.setVisible(true);
		} else {
			try {

				vo.setNome(nomeCliente.getText());
				vo.setCpf(cpfCliente.getText());

				clibo.inserir(vo);
				erroPropCli.setVisible(false);
				idCliente.setText("");
				nomeCliente.setText("");
				cpfCliente.setText("");

				clientesProprietario(null);
			} catch (Exception e) {
				e.printStackTrace();
				erroPropCli.setText("Erro! Verifique os dados");
				erroPropCli.setVisible(true);

			}

		}
	}

	public void alterarCliente() {
		ClienteVO vo = new ClienteVO();

		if (nomeCliente.getText().isEmpty()) {
			erroPropCli.setText("Nome vazio!");
			erroPropCli.setVisible(true);
		} else if (cpfCliente.getText().isEmpty()) {
			erroPropCli.setText("Cpf vazio!");
			erroPropCli.setVisible(true);
		} else {
			try {
				vo.setId_Cliente(Long.parseLong(idCliente.getText()));
				vo.setNome(nomeCliente.getText());
				vo.setCpf(cpfCliente.getText());

				clibo.alterar(vo);
				erroPropCli.setVisible(false);
				idCliente.setText("");
				nomeCliente.setText("");
				cpfCliente.setText("");

				clientesProprietario(null);
			} catch (Exception e) {
				e.printStackTrace();
				erroPropCli.setText("Erro! Verifique os dados");
				erroPropCli.setVisible(true);

			}

		}
	}

	public void removerCliente() {
		ClienteVO vo = new ClienteVO();

		if (nomeCliente.getText().isEmpty()) {
			erroPropCli.setText("Nome vazio!");
			erroPropCli.setVisible(true);
		} else if (cpfCliente.getText().isEmpty()) {
			erroPropCli.setText("Cpf vazio!");
			erroPropCli.setVisible(true);
		} else {
			try {
				vo.setId_Cliente(Long.parseLong(idCliente.getText()));

				clibo.remover(vo);
				erroPropCli.setVisible(false);
				idCliente.setText("");
				nomeCliente.setText("");
				cpfCliente.setText("");

				clientesProprietario(null);
			} catch (Exception e) {
				e.printStackTrace();
				erroPropCli.setText("Erro! Verifique os dados");
				erroPropCli.setVisible(true);

			}

		}
	}

	// ----------------------PROPRIETÁRIO/PRODUTOS-------------------------

	public void tableProdutos() throws Exception {
		tableIdProd.setCellValueFactory(new PropertyValueFactory<>("Id_Produto"));
		tableDescricaoProduto.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
		tableValorProduto.setCellValueFactory(new PropertyValueFactory<>("Valor"));
		tableQuantidadeProduto.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));

		ProdutoBO<ProdutoVO> bo = new ProdutoBO<ProdutoVO>();
		listaProdutos = FXCollections.observableList(bo.listar());
		tableProdutos.setItems(listaProdutos);
	}

	public void pesquisarProduto(ActionEvent event) throws Exception {
		tableProdutos.setItems(pesquisarProduto());
	}

	public ObservableList<ProdutoVO> pesquisarProduto() {
		ObservableList<ProdutoVO> produtoPesquisa = FXCollections.observableArrayList();
		for (int x = 0; x < listaProdutos.size(); x++) {
			if ((listaProdutos.get(x).getDescricao().contains(pesquisarProd.getText().toUpperCase()))
					| (String.valueOf(listaProdutos.get(x).getValor()).contains(pesquisarProd.getText()))) {
				produtoPesquisa.add(listaProdutos.get(x));
			}
		}
		return produtoPesquisa;
	}

	public void refreshTableProduto(ActionEvent event) throws Exception {
		ProdutoBO<ProdutoVO> bo = new ProdutoBO<ProdutoVO>();
		listaProdutos = FXCollections.observableList(bo.listar());
		tableProdutos.setItems(listaProdutos);
	}

	public void refreshProduto() {
		idProduto.setText("");
		descricaoProduto.setText("");
		valorProduto.setText("");
		quantidadeProduto.setText("");
		erroPropProd.setVisible(false);
	}

	public void inserirProduto() {
		ProdutoVO vo = new ProdutoVO();

		if (descricaoProduto.getText().isEmpty()) {
			erroPropProd.setText("Descrição vazia!");
			erroPropProd.setVisible(true);
		} else if (valorProduto.getText().isEmpty()) {
			erroPropProd.setText("Valor vazio!");
			erroPropProd.setVisible(true);
		} else if (quantidadeProduto.getText().isEmpty()) {
			erroPropProd.setText("Quantidade vazia!");
			erroPropProd.setVisible(true);
		} else {
			try {
				vo.setDescricao(descricaoProduto.getText());
				vo.setValor(Double.parseDouble(valorProduto.getText()));
				vo.setQuantidade(Integer.parseInt(quantidadeProduto.getText()));

				prodbo.inserir(vo);
				erroPropProd.setVisible(false);
				idProduto.setText("");
				descricaoProduto.setText("");
				valorProduto.setText("");
				quantidadeProduto.setText("");

				produtosProprietario(null);
			} catch (Exception e) {
				e.printStackTrace();
				erroPropProd.setText("Erro! Verifique os dados");
				erroPropProd.setVisible(true);

			}

		}
	}

	public void alterarProduto() {
		ProdutoVO vo = new ProdutoVO();

		if (descricaoProduto.getText().isEmpty()) {
			erroPropProd.setText("Descrição vazia!");
			erroPropProd.setVisible(true);
		} else if (valorProduto.getText().isEmpty()) {
			erroPropProd.setText("Valor vazio!");
			erroPropProd.setVisible(true);
		} else if (quantidadeProduto.getText().isEmpty()) {
			erroPropProd.setText("Quantidade vazia!");
			erroPropProd.setVisible(true);
		} else {
			try {
				vo.setId_Produto(Long.parseLong(idProduto.getText()));
				vo.setDescricao(descricaoProduto.getText());
				vo.setValor(Double.parseDouble(valorProduto.getText()));
				vo.setQuantidade(Integer.parseInt(quantidadeProduto.getText()));

				prodbo.alterar(vo);
				erroPropProd.setVisible(false);
				idProduto.setText("");
				descricaoProduto.setText("");
				valorProduto.setText("");
				quantidadeProduto.setText("");

				produtosProprietario(null);
			} catch (Exception e) {
				e.printStackTrace();
				erroPropProd.setText("Erro! Verifique os dados");
				erroPropProd.setVisible(true);

			}

		}
	}

	public void removerProduto() {
		ProdutoVO vo = new ProdutoVO();

		if (descricaoProduto.getText().isEmpty()) {
			erroPropProd.setText("Descrição vazia!");
			erroPropProd.setVisible(true);
		} else if (valorProduto.getText().isEmpty()) {
			erroPropProd.setText("Valor vazio!");
			erroPropProd.setVisible(true);
		} else if (quantidadeProduto.getText().isEmpty()) {
			erroPropProd.setText("Quantidade vazia!");
			erroPropProd.setVisible(true);
		} else {
			try {
				vo.setId_Produto(Long.parseLong(idProduto.getText()));

				prodbo.remover(vo);
				erroPropProd.setVisible(false);
				idProduto.setText("");
				descricaoProduto.setText("");
				valorProduto.setText("");
				quantidadeProduto.setText("");

				produtosProprietario(null);
			} catch (Exception e) {
				e.printStackTrace();
				erroPropProd.setText("Erro! Verifique os dados");
				erroPropProd.setVisible(true);

			}

		}
	}

// ----------------------PROPRIETÁRIO/MENU-------------------------

	public void gerentesProprietario(ActionEvent event) throws Exception {
		paneGer.setVisible(true);
		paneFunc.setVisible(false);
		paneCli.setVisible(false);
		paneProd.setVisible(false);
		paneComp.setVisible(false);
		menuGerSele.setTextFill(Color.valueOf("#087326"));
		barraGerSele.setVisible(true);
		menuFuncSele.setTextFill(Color.valueOf("black"));
		barraFuncSele.setVisible(false);
		menuCliSele.setTextFill(Color.valueOf("black"));
		barraCliSele.setVisible(false);
		menuProdSele.setTextFill(Color.valueOf("black"));
		barraProdSele.setVisible(false);
		menuCompSele.setTextFill(Color.valueOf("black"));
		barraCompSele.setVisible(false);
		loginGerente.setVisible(false);
		senhaGerente.setVisible(false);
		loginGerente2.setVisible(true);
		senhaGerente2.setVisible(true);
		erroPropGer.setVisible(false);
		refreshTableGerente(null);
		refreshGerente();
		pesquisarGer.setText("");
	}

	public void funcionariosProprietario(ActionEvent event) throws Exception {
		paneGer.setVisible(false);
		paneFunc.setVisible(true);
		paneCli.setVisible(false);
		paneProd.setVisible(false);
		paneComp.setVisible(false);
		menuGerSele.setTextFill(Color.valueOf("black"));
		barraGerSele.setVisible(false);
		menuFuncSele.setTextFill(Color.valueOf("#087326"));
		barraFuncSele.setVisible(true);
		menuCliSele.setTextFill(Color.valueOf("black"));
		barraCliSele.setVisible(false);
		menuProdSele.setTextFill(Color.valueOf("black"));
		barraProdSele.setVisible(false);
		menuCompSele.setTextFill(Color.valueOf("black"));
		barraCompSele.setVisible(false);
		erroPropFunc.setVisible(false);
		refreshTableFuncionario(null);
		refreshFuncionario();
		pesquisarFunc.setText("");
	}

	public void clientesProprietario(ActionEvent event) throws Exception {
		paneGer.setVisible(false);
		paneFunc.setVisible(false);
		paneCli.setVisible(true);
		paneProd.setVisible(false);
		paneComp.setVisible(false);
		menuGerSele.setTextFill(Color.valueOf("black"));
		barraGerSele.setVisible(false);
		menuFuncSele.setTextFill(Color.valueOf("black"));
		barraFuncSele.setVisible(false);
		menuCliSele.setTextFill(Color.valueOf("#087326"));
		barraCliSele.setVisible(true);
		menuProdSele.setTextFill(Color.valueOf("black"));
		barraProdSele.setVisible(false);
		menuCompSele.setTextFill(Color.valueOf("black"));
		barraCompSele.setVisible(false);
		erroPropCli.setVisible(false);
		refreshTableCliente(null);
		refreshCliente();
		pesquisarCli.setText("");
	}

	public void produtosProprietario(ActionEvent event) throws Exception {
		paneGer.setVisible(false);
		paneFunc.setVisible(false);
		paneCli.setVisible(false);
		paneProd.setVisible(true);
		paneComp.setVisible(false);
		menuGerSele.setTextFill(Color.valueOf("black"));
		barraGerSele.setVisible(false);
		menuFuncSele.setTextFill(Color.valueOf("black"));
		barraFuncSele.setVisible(false);
		menuCliSele.setTextFill(Color.valueOf("black"));
		barraCliSele.setVisible(false);
		menuProdSele.setTextFill(Color.valueOf("#087326"));
		barraProdSele.setVisible(true);
		menuCompSele.setTextFill(Color.valueOf("black"));
		barraCompSele.setVisible(false);
		refreshTableProduto(null);
		refreshProduto();
		pesquisarProd.setText("");
	}

	public void comprasProprietario(ActionEvent event) throws Exception {
		paneGer.setVisible(false);
		paneFunc.setVisible(false);
		paneCli.setVisible(false);
		paneProd.setVisible(false);
		paneComp.setVisible(true);
		menuGerSele.setTextFill(Color.valueOf("black"));
		barraGerSele.setVisible(false);
		menuFuncSele.setTextFill(Color.valueOf("black"));
		barraFuncSele.setVisible(false);
		menuCliSele.setTextFill(Color.valueOf("black"));
		barraCliSele.setVisible(false);
		menuProdSele.setTextFill(Color.valueOf("black"));
		barraProdSele.setVisible(false);
		menuCompSele.setTextFill(Color.valueOf("#087326"));
		barraCompSele.setVisible(true);
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
