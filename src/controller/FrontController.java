package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import exception.AutenticationException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import model.dao.BaseDAO;
import model.dao.PedidoDAO;
import model.vo.ClienteVO;
import model.vo.CompraVO;
import model.vo.FuncionarioVO;
import model.vo.GerenteVO;
import model.vo.PedidoVO;
import model.vo.ProdutoVO;
import model.vo.ProprietarioVO;

import net.sf.jasperreports.view.JasperViewer;
import view.Telas;

public class FrontController extends BaseDAO implements Initializable {
	// Variáveis FXML

	// Tela de Login
	@FXML
	private TextField login;
	@FXML
	private PasswordField senha;
	@FXML
	private Label erroAut;

	// Telas
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
	private Button menuExSele;
	@FXML
	private Label barraExSele;
	@FXML
	private Button menuVendSele;
	@FXML
	private Label barraVendSele;
	@FXML
	private Button refreshVend;
	@FXML
	private Button menuProdLogSele;
	@FXML
	private Button buttonInserirComp;
	@FXML
	private Label barraProdLogSele;
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
	private Pane paneEx;
	@FXML
	private Pane paneProdLog;
	@FXML
	private Pane paneVend;
	@FXML
	private Pane paneVender;
	@FXML
	private Pane paneVender2;
	@FXML
	private Label erroPropGer;
	@FXML
	private Label erroPropFunc;
	@FXML
	private Label erroPropCli;
	@FXML
	private Label erroPropProd;
	@FXML
	private Label erroVenda;

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

	// Proprietário/View Compras
	@FXML
	private TableColumn<PedidoVO, String> tableNomeViewComp;
	@FXML
	private TableColumn<PedidoVO, String> tableCpfViewComp;
	@FXML
	private TableColumn<PedidoVO, String> tableNome2ViewComp;
	@FXML
	private TableColumn<PedidoVO, String> tableCpf2ViewComp;
	@FXML
	private TableColumn<PedidoVO, String> tableDescricaoViewComp;
	@FXML
	private TableColumn<PedidoVO, Integer> tableQuantidadeViewComp;
	@FXML
	private TableColumn<PedidoVO, Double> tableValorViewComp;
	@FXML
	private TableColumn<PedidoVO, Date> tableDataViewComp;
	@FXML
	private TableColumn<PedidoVO, String> tableHoraViewComp;
	@FXML
	private TableView<PedidoVO> tableViewComp;

	@FXML
	private TextField pesquisarViewComp;

	// Proprietário/EX-EMPREGADOS
	@FXML
	private TableColumn<PedidoVO, String> tableNomeEx;
	@FXML
	private TableColumn<PedidoVO, String> tableCpfEx;
	@FXML
	private TableColumn<PedidoVO, String> tableFuncaoEx;
	@FXML
	private TableColumn<PedidoVO, Date> tableDataEx;
	@FXML
	private TableView<PedidoVO> tableEx;

	@FXML
	private TextField pesquisarEx;

	// Proprietário/Logs dos Produtos

	@FXML
	private TableColumn<PedidoVO, String> tableDescricaoProdLog;
	@FXML
	private TableColumn<PedidoVO, Double> tableValorProdLog;
	@FXML
	private TableColumn<PedidoVO, Integer> tableQuantidadeProdLog;
	@FXML
	private TableColumn<PedidoVO, String> tableModificacaoProdLog;
	@FXML
	private TableColumn<PedidoVO, Date> tableDataProdLog;
	@FXML
	private TableView<PedidoVO> tableProdLog;

	@FXML
	private TextField pesquisarProdL;

	// Funcionários/Vender
	@FXML
	private ComboBox<ClienteVO> selectClienteVenda;
	@FXML
	private ComboBox<ProdutoVO> selectProdutoVenda;
	@FXML
	private TextField quantidadeVenda;
	@FXML
	private TextField subtotalVenda;
	@FXML
	private TextField totalVenda;

	@FXML
	private TableColumn<PedidoVO, Long> tableIdPedidoVenda;
	@FXML
	private TableColumn<PedidoVO, Long> tableIdCompraVenda;
	@FXML
	private TableColumn<PedidoVO, String> tableDescricaoVenda;
	@FXML
	private TableColumn<PedidoVO, Integer> tableQuantidadeVenda;
	@FXML
	private TableColumn<PedidoVO, Double> tableValorUniVenda;
	@FXML
	private TableColumn<PedidoVO, Double> tableTotVenda;
	@FXML
	private TableView<PedidoVO> tableVendas;

	@FXML
	private TextField idClienteVenda;
	@FXML
	private TextField nomeClienteVenda;
	@FXML
	private TextField cpfClienteVenda;
	@FXML
	private TextField pesquisarVend;
	@FXML
	private Button pesquisarVendaButton;

	@FXML
	private TableColumn<ClienteVO, Long> tableIdCliVenda;
	@FXML
	private TableColumn<ClienteVO, String> tableNomeClienteVenda;
	@FXML
	private TableColumn<ClienteVO, String> tableCpfClienteVenda;
	@FXML
	private TableView<ClienteVO> tableClientesVenda;

	@FXML
	private TextField idProdutoVenda;
	@FXML
	private TextField descricaoProdutoVenda;
	@FXML
	private TextField valorProdutoVenda;
	@FXML
	private TextField quantidadeProdutoVenda;
	@FXML
	private TextField pesquisarClienteVend;
	@FXML
	private Button pesquisarClienteVendaButton;

	@FXML
	private TableColumn<ProdutoVO, Long> tableIdProdVenda;
	@FXML
	private TableColumn<ProdutoVO, String> tableDescricaoProdutoVenda;
	@FXML
	private TableColumn<ProdutoVO, Double> tableValorProdutoVenda;
	@FXML
	private TableColumn<ProdutoVO, Integer> tableQuantidadeProdutoVenda;
	@FXML
	private TableView<ProdutoVO> tableProdutosVenda;
	@FXML
	private TextField pesquisarProdutoVend;
	@FXML
	private Button pesquisarProdutoVendaButton;

	// Tabelas
	private ObservableList<GerenteVO> listaGerentes = FXCollections.observableArrayList();
	private ObservableList<FuncionarioVO> listaFuncionarios = FXCollections.observableArrayList();
	private ObservableList<ClienteVO> listaClientes = FXCollections.observableArrayList();
	private ObservableList<ProdutoVO> listaProdutos = FXCollections.observableArrayList();
	private ObservableList<PedidoVO> listaViewComp = FXCollections.observableArrayList();
	private ObservableList<PedidoVO> listaEx = FXCollections.observableArrayList();
	private ObservableList<PedidoVO> listaProdLog = FXCollections.observableArrayList();
	private ObservableList<PedidoVO> listaVenda = FXCollections.observableArrayList();

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
	PedidoDAO<PedidoVO> peddao = new PedidoDAO<PedidoVO>();

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

		try {
			tableViewComp();
		} catch (Exception e) {

		}

		try {
			tableEx();
		} catch (Exception e) {

		}

		try {
			tableProdLog();
		} catch (Exception e) {

		}

		try {
			tableVendas();
		} catch (Exception e) {

		}

		try {
			tableClientesVenda();

			tableClientesVenda.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

				@Override
				public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
					clienteSelecionado = (ClienteVO) newValue;
					idClienteVenda.setText(String.valueOf(clienteSelecionado.getId_Cliente()));
					nomeClienteVenda.setText(clienteSelecionado.getNome());
					cpfClienteVenda.setText(clienteSelecionado.getCpf());

				}
			});
		} catch (Exception e) {

		}

		try {
			tableProdutosVenda();

			tableProdutosVenda.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

				@Override
				public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
					produtoSelecionado = (ProdutoVO) newValue;
					idProdutoVenda.setText(String.valueOf(produtoSelecionado.getId_Produto()));
					descricaoProdutoVenda.setText(produtoSelecionado.getDescricao());
					valorProdutoVenda.setText(String.valueOf(produtoSelecionado.getValor()));
					quantidadeProdutoVenda.setText(String.valueOf(produtoSelecionado.getQuantidade()));

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

	// ----------------------LOGIN PROPRIETÁRIO-------------------------
	public static ProprietarioVO propaut;
	public static FuncionarioVO funcaut;

	public void autenticarProprietario(ActionEvent event) throws Exception {
		ProprietarioVO vo = new ProprietarioVO();
		vo.setLogin(login.getText());
		vo.setSenha(senha.getText());

		try {
			propaut = propbo.autenticar(vo);
			Telas.telaProprietarioInicial();
		} catch (AutenticationException e) {
			erroAut.setVisible(true);
		}
	}

	// ----------------------LOGIN FUNCIONÁRIO-------------------------

	public void autenticarFuncionario(ActionEvent event) throws Exception {
		FuncionarioVO vo = new FuncionarioVO();
		vo.setLogin(login.getText());
		vo.setSenha(senha.getText());

		try {
			funcaut = funcbo.autenticar(vo);
			Telas.telaFuncionarioInicial();
		} catch (AutenticationException e) {
			erroAut.setVisible(true);
		}
	}

	// ----------------------LOGIN GERENTE-------------------------

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

	// ----------------------PROPRIETÁRIO-------------------------

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
		pesquisarGer.setText("");
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

		if (nomeGerente.getText().isEmpty()) {
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
				vo.setId_Proprietario(propaut.getId_Proprietario());
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

		if (nomeGerente.getText().isEmpty()) {
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
				vo.setId_Proprietario(propaut.getId_Proprietario());
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

		if (nomeGerente.getText().isEmpty()) {
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

	public void imprimirGerentes(ActionEvent event) {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a impressão da lista dos gerentes?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			// IMPRIMINDO O RELATÓRIO
			try {
				JasperPrint print = JasperFillManager.fillReport(
						"C:/Users/Matheus/repositorios/Loja_de_Roupas/src/resources/Reports/Gerentes.jasper", null,
						getConnection());
				JasperViewer.viewReport(print, false);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}

// ----------------------PROPRIETÁRIO/GERENTE-------------------------

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
		pesquisarFunc.setText("");
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

		if (nomeFuncionario.getText().isEmpty()) {
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
				vo.setId_Proprietario(propaut.getId_Proprietario());
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

		if (nomeFuncionario.getText().isEmpty()) {
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
				vo.setId_Proprietario(propaut.getId_Proprietario());
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

		if (nomeFuncionario.getText().isEmpty()) {
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

	// ----------------------PROPRIETÁRIO/GERENTE-------------------------

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
		pesquisarCli.setText("");
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

				clientesFuncionario(null);
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

				clientesFuncionario(null);
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

				clientesFuncionario(null);
			} catch (Exception e) {
				e.printStackTrace();
				erroPropCli.setText("Erro! Verifique os dados");
				erroPropCli.setVisible(true);

			}

		}
	}

	// ----------------------PROPRIETÁRIO/GERENTE-------------------------

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
		pesquisarProd.setText("");
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

				try {
					produtosProprietario(null);
				} catch (Exception e) {
					produtosGerente(null);
				}
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

				try {
					produtosProprietario(null);
				} catch (Exception e) {
					produtosGerente(null);
				}
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

				try {
					produtosProprietario(null);
				} catch (Exception e) {
					produtosGerente(null);
				}
			} catch (Exception e) {
				e.printStackTrace();
				erroPropProd.setText("Erro! Verifique os dados");
				erroPropProd.setVisible(true);

			}

		}
	}

	// ----------------------PROPRIETÁRIO/GERENTE-------------------------

	public void tableViewComp() throws Exception {
		tableNomeViewComp.setCellValueFactory(new PropertyValueFactory<>("login"));
		tableCpfViewComp.setCellValueFactory(new PropertyValueFactory<>("senha"));
		tableNome2ViewComp.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableCpf2ViewComp.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tableDescricaoViewComp.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		tableQuantidadeViewComp.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		tableValorViewComp.setCellValueFactory(new PropertyValueFactory<>("valor"));
		tableDataViewComp.setCellValueFactory(new PropertyValueFactory<>("data"));
		tableHoraViewComp.setCellValueFactory(new PropertyValueFactory<>("hora"));

		PedidoBO<PedidoVO> bo = new PedidoBO<PedidoVO>();
		listaViewComp = FXCollections.observableList(bo.listarComprados());
		tableViewComp.setItems(listaViewComp);
	}

	public void pesquisarViewComp(ActionEvent event) throws Exception {
		tableViewComp.setItems(pesquisarViewComp());
	}

	public ObservableList<PedidoVO> pesquisarViewComp() {
		ObservableList<PedidoVO> viewCompPesquisa = FXCollections.observableArrayList();
		for (int x = 0; x < listaViewComp.size(); x++) {
			if ((listaViewComp.get(x).getNome().contains(pesquisarViewComp.getText().toUpperCase()))
					| (listaViewComp.get(x).getCpf().contains(pesquisarViewComp.getText()))
					| (listaViewComp.get(x).getDescricao().contains(pesquisarViewComp.getText().toUpperCase()))
					| (listaViewComp.get(x).getLogin().contains(pesquisarViewComp.getText().toUpperCase()))
					| (listaViewComp.get(x).getSenha().contains(pesquisarViewComp.getText().toUpperCase()))
					| (String.valueOf(listaViewComp.get(x).getValor()).contains(pesquisarViewComp.getText()))) {
				viewCompPesquisa.add(listaViewComp.get(x));
			}
		}
		return viewCompPesquisa;
	}

	public void refreshTableViewComp(ActionEvent event) throws Exception {
		PedidoBO<PedidoVO> bo = new PedidoBO<PedidoVO>();
		listaViewComp = FXCollections.observableList(bo.listarComprados());
		tableViewComp.setItems(listaViewComp);
		pesquisarViewComp.setText("");
	}

	// ----------------------PROPRIETÁRIO-------------------------

	public void tableEx() throws Exception {
		tableNomeEx.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableCpfEx.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tableFuncaoEx.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		tableDataEx.setCellValueFactory(new PropertyValueFactory<>("data"));

		PedidoBO<PedidoVO> bo = new PedidoBO<PedidoVO>();
		listaEx = FXCollections.observableList(bo.listarEx());
		tableEx.setItems(listaEx);
	}

	public void pesquisarEx(ActionEvent event) throws Exception {
		tableEx.setItems(pesquisarEx());
	}

	public ObservableList<PedidoVO> pesquisarEx() {
		ObservableList<PedidoVO> exPesquisa = FXCollections.observableArrayList();
		for (int x = 0; x < listaEx.size(); x++) {
			if ((listaEx.get(x).getNome().contains(pesquisarEx.getText().toUpperCase()))
					| (listaEx.get(x).getCpf().contains(pesquisarEx.getText()))
					| (listaEx.get(x).getDescricao().contains(pesquisarEx.getText()))) {
				exPesquisa.add(listaEx.get(x));
			}
		}
		return exPesquisa;
	}

	public void refreshTableEx(ActionEvent event) throws Exception {
		PedidoBO<PedidoVO> bo = new PedidoBO<PedidoVO>();
		listaEx = FXCollections.observableList(bo.listarEx());
		tableEx.setItems(listaEx);
		pesquisarEx.setText("");
	}

	// ----------------------PROPRIETÁRIO-------------------------

	public void tableProdLog() throws Exception {
		tableDescricaoProdLog.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		tableValorProdLog.setCellValueFactory(new PropertyValueFactory<>("valor"));
		tableQuantidadeProdLog.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		tableModificacaoProdLog.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableDataProdLog.setCellValueFactory(new PropertyValueFactory<>("data"));

		PedidoBO<PedidoVO> bo = new PedidoBO<PedidoVO>();
		listaProdLog = FXCollections.observableList(bo.listarProdLog());
		tableProdLog.setItems(listaProdLog);
	}

	public void pesquisarProdLog(ActionEvent event) throws Exception {
		tableProdLog.setItems(pesquisarProdLog());
	}

	public ObservableList<PedidoVO> pesquisarProdLog() {
		ObservableList<PedidoVO> prodLogPesquisa = FXCollections.observableArrayList();
		for (int x = 0; x < listaEx.size(); x++) {
			if ((listaProdLog.get(x).getNome().contains(pesquisarProdL.getText().toUpperCase()))
					| (String.valueOf(listaProdLog.get(x).getValor()).contains(pesquisarProdL.getText()))
					| (listaProdLog.get(x).getDescricao().contains(pesquisarProdL.getText()))) {
				prodLogPesquisa.add(listaProdLog.get(x));
			}
		}
		return prodLogPesquisa;
	}

	public void refreshTableProdLog(ActionEvent event) throws Exception {
		PedidoBO<PedidoVO> bo = new PedidoBO<PedidoVO>();
		listaProdLog = FXCollections.observableList(bo.listarProdLog());
		tableProdLog.setItems(listaProdLog);
		pesquisarProdL.setText("");
	}

	// ----------------------FUNCIONÁRIO-------------------------

	public void tableVendas() throws Exception {
		tableIdPedidoVenda.setCellValueFactory(new PropertyValueFactory<>("Id_Pedido"));
		tableIdCompraVenda.setCellValueFactory(new PropertyValueFactory<>("Id_Produto"));
		tableDescricaoVenda.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
		tableQuantidadeVenda.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
		tableValorUniVenda.setCellValueFactory(new PropertyValueFactory<>("Valor"));
		tableTotVenda.setCellValueFactory(new PropertyValueFactory<>("Subtotal"));

		PedidoDAO<PedidoVO> dao = new PedidoDAO<PedidoVO>();
		listaVenda = FXCollections.observableList(dao.listarVenda());
		tableVendas.setItems(listaVenda);
	}

	public void tableClientesVenda() throws Exception {
		tableIdCliVenda.setCellValueFactory(new PropertyValueFactory<>("Id_Cliente"));
		tableNomeClienteVenda.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableCpfClienteVenda.setCellValueFactory(new PropertyValueFactory<>("cpf"));

		ClienteBO<ClienteVO> bo = new ClienteBO<ClienteVO>();
		listaClientes = FXCollections.observableList(bo.listar());
		tableClientesVenda.setItems(listaClientes);
	}

	public void tableProdutosVenda() throws Exception {
		tableIdProdVenda.setCellValueFactory(new PropertyValueFactory<>("Id_Produto"));
		tableDescricaoProdutoVenda.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
		tableValorProdutoVenda.setCellValueFactory(new PropertyValueFactory<>("Valor"));
		tableQuantidadeProdutoVenda.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));

		ProdutoBO<ProdutoVO> bo = new ProdutoBO<ProdutoVO>();
		listaProdutos = FXCollections.observableList(bo.listar());
		tableProdutosVenda.setItems(listaProdutos);
	}

	public void pesquisarVenda(ActionEvent event) throws Exception {
		tableVendas.setItems(pesquisarVenda());
	}

	public ObservableList<PedidoVO> pesquisarVenda() {
		ObservableList<PedidoVO> vendaPesquisa = FXCollections.observableArrayList();
		for (int x = 0; x < listaVenda.size(); x++) {
			if ((listaVenda.get(x).getDescricao().contains(pesquisarVend.getText().toUpperCase()))
					| (String.valueOf(listaVenda.get(x).getValor()).contains(pesquisarVend.getText()))) {
				vendaPesquisa.add(listaVenda.get(x));
			}
		}
		return vendaPesquisa;
	}

	public ObservableList<ProdutoVO> pesquisarProdutoVenda() {
		ObservableList<ProdutoVO> produtoVendaPesquisa = FXCollections.observableArrayList();
		for (int x = 0; x < listaProdutos.size(); x++) {
			if ((listaProdutos.get(x).getDescricao().contains(pesquisarProdutoVend.getText().toUpperCase()))
					| (String.valueOf(listaProdutos.get(x).getValor()).contains(pesquisarProdutoVend.getText()))) {
				produtoVendaPesquisa.add(listaProdutos.get(x));
			}
		}
		return produtoVendaPesquisa;
	}

	public ObservableList<ClienteVO> pesquisarClienteVenda() {
		ObservableList<ClienteVO> clienteVendaPesquisa = FXCollections.observableArrayList();
		for (int x = 0; x < listaProdutos.size(); x++) {
			if ((listaClientes.get(x).getDescricao().contains(pesquisarClienteVend.getText().toUpperCase()))
					| (String.valueOf(listaClientes.get(x).getValor()).contains(pesquisarClienteVend.getText()))) {
				clienteVendaPesquisa.add(listaClientes.get(x));
			}
		}
		return clienteVendaPesquisa;
	}

	public void refreshTableVendas(ActionEvent event) throws Exception {
		PedidoDAO<PedidoVO> dao = new PedidoDAO<PedidoVO>();
		listaVenda = FXCollections.observableList(dao.listarVenda());
		tableVendas.setItems(listaVenda);
		pesquisarVend.setText("");

		ClienteBO<ClienteVO> bo = new ClienteBO<ClienteVO>();
		listaClientes = FXCollections.observableList(bo.listar());
		tableClientesVenda.setItems(listaClientes);
		pesquisarCli.setText("");

		ProdutoBO<ProdutoVO> pbo = new ProdutoBO<ProdutoVO>();
		listaProdutos = FXCollections.observableList(pbo.listar());
		tableProdutosVenda.setItems(listaProdutos);
		pesquisarProd.setText("");
	}

	public void refreshVenda() {
		nomeClienteVenda.setText("");
		quantidadeVenda.setText("");
		subtotalVenda.setText("");
		totalVenda.setText("");
		descricaoProdutoVenda.setText("");
		erroVenda.setVisible(false);
	}

	public void inserirComp() {
		PedidoVO ped = new PedidoVO();
		try {
			if (nomeClienteVenda.getText().isEmpty()) {
				erroVenda.setText("Selecione um cliente!");
				erroVenda.setVisible(true);
			} else {
				ped.setId_Funcionario(funcaut.getId_Funcionario());
				ped.setId_Cliente(Long.parseLong(idClienteVenda.getText()));
				ped.setNome(nomeClienteVenda.getText());
				ped.setCpf(cpfClienteVenda.getText());
				System.out.println(ped.getId_Cliente() + " " + ped.getNome() + " " + ped.getCpf());
				peddao.inserirComp(ped);

				tableClientesVenda.setVisible(false);
				tableProdutosVenda.setVisible(true);
				tableVendas.setVisible(false);
				buttonInserirComp.setDisable(true);
				erroVenda.setVisible(false);
				refreshTableVendas(null);

				pesquisarVend.setVisible(false);
				pesquisarVendaButton.setVisible(false);
				pesquisarProdutoVend.setVisible(true);
				pesquisarProdutoVendaButton.setVisible(true);
				pesquisarClienteVend.setVisible(false);
				pesquisarClienteVendaButton.setVisible(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			erroVenda.setText("Erro! Verifique os dados");
			erroVenda.setVisible(true);

		}

	}

	public void inserirPedido() {

		PedidoVO ped = new PedidoVO();
		PedidoVO vo = new PedidoVO();
		try {
			if (nomeClienteVenda.getText().isEmpty()) {
				erroVenda.setText("Selecione um cliente!");
				erroVenda.setVisible(true);
			} else if (descricaoProdutoVenda.getText().isEmpty()) {
				erroVenda.setText("Selecione um produto!");
				erroVenda.setVisible(true);
			} else if (quantidadeVenda.getText().isEmpty()) {
				erroVenda.setText("Digite a quantidade de produtos!");
				erroVenda.setVisible(true);
			} else if (Integer.parseInt(quantidadeVenda.getText()) > Integer
					.parseInt(quantidadeProdutoVenda.getText())) {
				erroVenda.setText("Só há " + quantidadeProdutoVenda.getText() + " unidades desse produto!");
				erroVenda.setVisible(true);
			} else {
				ped.setId_Funcionario(funcaut.getId_Funcionario());
				ped.setId_Cliente(Long.parseLong(idClienteVenda.getText()));
				ped.setNome(nomeClienteVenda.getText());
				ped.setCpf(cpfClienteVenda.getText());
				ped.setId_Produto(Long.parseLong(idProdutoVenda.getText()));
				ped.setDescricao(descricaoProdutoVenda.getText());
				ped.setValor(Double.parseDouble(valorProdutoVenda.getText()));
				ped.setQuantidade(Integer.parseInt(quantidadeVenda.getText()));

				peddao.inserirPed(ped);

				vo.setId_Produto(ped.getId_Produto());
				vo.setDescricao(ped.getDescricao());
				vo.setValor(ped.getValor());
				vo.setQuantidade(Integer.parseInt(quantidadeProdutoVenda.getText()) - ped.getQuantidade());
				prodbo.alterar(vo);

				// Sabendo qual o id da compra que está aberta
				List<CompraVO> compras = compbo.listar();
				CompraVO compra = compras.get(compras.size() - 1);

				subtotalVenda.setText(valorProdutoVenda.getText());
				totalVenda.setText(String.valueOf(compra.getValor()));
				tableClientesVenda.setVisible(false);
				tableProdutosVenda.setVisible(false);
				tableVendas.setVisible(true);
				refreshTableVendas(null);
				erroVenda.setVisible(false);

				pesquisarVend.setVisible(true);
				pesquisarVendaButton.setVisible(true);
				pesquisarProdutoVend.setVisible(false);
				pesquisarProdutoVendaButton.setVisible(false);
				pesquisarClienteVend.setVisible(false);
				pesquisarClienteVendaButton.setVisible(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			erroVenda.setText("Erro! Verifique os dados");
			erroVenda.setVisible(true);

		}
	}

	public void pagarVenda(ActionEvent event) {

		try {
			int confirma = JOptionPane.showConfirmDialog(null, "CONFIRMA O PAGAMENTO?", "ATENÇÃO!",
					JOptionPane.YES_NO_OPTION);
			if (confirma == JOptionPane.YES_OPTION) {
				tableClientesVenda.setVisible(true);
				tableProdutosVenda.setVisible(false);
				tableVendas.setVisible(false);
				refreshVenda();
				nomeClienteVenda.setText("");
				buttonInserirComp.setDisable(false);
				pesquisarVend.setVisible(false);
				pesquisarVendaButton.setVisible(false);
				pesquisarProdutoVend.setVisible(false);
				pesquisarProdutoVendaButton.setVisible(false);
				pesquisarClienteVend.setVisible(true);
				pesquisarClienteVendaButton.setVisible(true);
			}

		} catch (Exception e) {
			erroVenda.setText("Erro! Compra inválida");
			erroVenda.setVisible(true);
		}

	}

	public void cancelarVenda(ActionEvent event) {
		int confirma = JOptionPane.showConfirmDialog(null, "CONFIRMA O CANCELAMENTO?", "ATENÇÃO!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			try {
				// Sabendo qual o id da compra que está aberta
				List<CompraVO> compras = compbo.listar();
				CompraVO compra = compras.get(compras.size() - 1);
				if (Long.parseLong(idClienteVenda.getText()) == compra.getId_Cliente()) {
					compbo.remover(compra);
					tableClientesVenda.setVisible(true);
					tableProdutosVenda.setVisible(false);
					tableVendas.setVisible(false);
					refreshVenda();
					buttonInserirComp.setDisable(false);
					nomeClienteVenda.setText("");
					pesquisarVend.setVisible(false);
					pesquisarVendaButton.setVisible(false);
					pesquisarProdutoVend.setVisible(false);
					pesquisarProdutoVendaButton.setVisible(false);
					pesquisarClienteVend.setVisible(true);
					pesquisarClienteVendaButton.setVisible(true);
				} else {
					erroVenda.setText("Essa compra não existe!");
					erroVenda.setVisible(true);
				}
			} catch (Exception e) {
				erroVenda.setText("Essa compra não existe!");
				erroVenda.setVisible(true);
			}
		}
	}

	public void verProdutos() {
		tableClientesVenda.setVisible(false);
		tableProdutosVenda.setVisible(true);
		tableVendas.setVisible(false);
		descricaoProdutoVenda.setText("");
		quantidadeVenda.setText("");
		buttonInserirComp.setDisable(false);
		pesquisarVend.setVisible(false);
		pesquisarVendaButton.setVisible(false);
		pesquisarProdutoVend.setVisible(true);
		pesquisarProdutoVendaButton.setVisible(true);
		pesquisarClienteVend.setVisible(false);
		pesquisarClienteVendaButton.setVisible(false);
	}

	public static String pdfCpfCliente() throws IOException {
		// String cpf = cpfClienteVenda.getText();
		String cpf = "12345678910";

		String bloco1 = cpf.substring(0, 3);
		String bloco2 = cpf.substring(3, 6);
		String bloco3 = cpf.substring(6, 9);
		String bloco4 = cpf.substring(9, 11);

		cpf = bloco1 + "." + bloco2 + "." + bloco3 + "-" + bloco4;
		return cpf;
	}

// ----------------------PROPRIETÁRIO/MENU-------------------------

	public void gerentesProprietario(ActionEvent event) throws Exception {
		paneGer.setVisible(true);
		paneFunc.setVisible(false);
		paneCli.setVisible(false);
		paneProd.setVisible(false);
		paneComp.setVisible(false);
		paneEx.setVisible(false);
		paneProdLog.setVisible(false);
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
		menuExSele.setTextFill(Color.valueOf("black"));
		barraExSele.setVisible(false);
		menuProdLogSele.setTextFill(Color.valueOf("black"));
		barraProdLogSele.setVisible(false);
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
		paneEx.setVisible(false);
		paneProdLog.setVisible(false);
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
		menuExSele.setTextFill(Color.valueOf("black"));
		barraExSele.setVisible(false);
		menuProdLogSele.setTextFill(Color.valueOf("black"));
		barraProdLogSele.setVisible(false);
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
		paneEx.setVisible(false);
		paneProdLog.setVisible(false);
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
		menuExSele.setTextFill(Color.valueOf("black"));
		barraExSele.setVisible(false);
		menuProdLogSele.setTextFill(Color.valueOf("black"));
		barraProdLogSele.setVisible(false);
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
		paneEx.setVisible(false);
		paneProdLog.setVisible(false);
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
		menuExSele.setTextFill(Color.valueOf("black"));
		barraExSele.setVisible(false);
		menuProdLogSele.setTextFill(Color.valueOf("black"));
		barraProdLogSele.setVisible(false);
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
		paneEx.setVisible(false);
		paneProdLog.setVisible(false);
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
		menuExSele.setTextFill(Color.valueOf("black"));
		barraExSele.setVisible(false);
		menuProdLogSele.setTextFill(Color.valueOf("black"));
		barraProdLogSele.setVisible(false);
		refreshTableViewComp(null);
		pesquisarViewComp.setText("");
	}

	public void exEmpregadosProprietario(ActionEvent event) throws Exception {
		paneGer.setVisible(false);
		paneFunc.setVisible(false);
		paneCli.setVisible(false);
		paneProd.setVisible(false);
		paneComp.setVisible(false);
		paneEx.setVisible(true);
		paneProdLog.setVisible(false);
		menuGerSele.setTextFill(Color.valueOf("black"));
		barraGerSele.setVisible(false);
		menuFuncSele.setTextFill(Color.valueOf("black"));
		barraFuncSele.setVisible(false);
		menuCliSele.setTextFill(Color.valueOf("black"));
		barraCliSele.setVisible(false);
		menuProdSele.setTextFill(Color.valueOf("black"));
		barraProdSele.setVisible(false);
		menuCompSele.setTextFill(Color.valueOf("black"));
		barraCompSele.setVisible(false);
		menuExSele.setTextFill(Color.valueOf("#087326"));
		barraExSele.setVisible(true);
		menuProdLogSele.setTextFill(Color.valueOf("black"));
		barraProdLogSele.setVisible(false);
		refreshTableEx(null);
		pesquisarEx.setText("");
	}

	public void prodLogProprietario(ActionEvent event) throws Exception {
		paneGer.setVisible(false);
		paneFunc.setVisible(false);
		paneCli.setVisible(false);
		paneProd.setVisible(false);
		paneComp.setVisible(false);
		paneEx.setVisible(false);
		paneProdLog.setVisible(true);
		menuGerSele.setTextFill(Color.valueOf("black"));
		barraGerSele.setVisible(false);
		menuFuncSele.setTextFill(Color.valueOf("black"));
		barraFuncSele.setVisible(false);
		menuCliSele.setTextFill(Color.valueOf("black"));
		barraCliSele.setVisible(false);
		menuProdSele.setTextFill(Color.valueOf("black"));
		barraProdSele.setVisible(false);
		menuCompSele.setTextFill(Color.valueOf("black"));
		barraCompSele.setVisible(false);
		menuExSele.setTextFill(Color.valueOf("black"));
		barraExSele.setVisible(false);
		menuProdLogSele.setTextFill(Color.valueOf("#087326"));
		barraProdLogSele.setVisible(true);
		refreshTableProdLog(null);
		pesquisarProdL.setText("");
	}

	// ----------------------GERENTE/MENU-------------------------

	public void funcionariosGerente(ActionEvent event) throws Exception {
		paneFunc.setVisible(true);
		paneCli.setVisible(false);
		paneProd.setVisible(false);
		paneComp.setVisible(false);
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

	public void clientesGerente(ActionEvent event) throws Exception {
		paneFunc.setVisible(false);
		paneCli.setVisible(true);
		paneProd.setVisible(false);
		paneComp.setVisible(false);
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

	public void produtosGerente(ActionEvent event) throws Exception {
		paneFunc.setVisible(false);
		paneCli.setVisible(false);
		paneProd.setVisible(true);
		paneComp.setVisible(false);
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

	public void comprasGerente(ActionEvent event) throws Exception {
		paneFunc.setVisible(false);
		paneCli.setVisible(false);
		paneProd.setVisible(false);
		paneComp.setVisible(true);
		menuFuncSele.setTextFill(Color.valueOf("black"));
		barraFuncSele.setVisible(false);
		menuCliSele.setTextFill(Color.valueOf("black"));
		barraCliSele.setVisible(false);
		menuProdSele.setTextFill(Color.valueOf("black"));
		barraProdSele.setVisible(false);
		menuCompSele.setTextFill(Color.valueOf("#087326"));
		barraCompSele.setVisible(true);
		refreshTableViewComp(null);
		pesquisarViewComp.setText("");
	}

	// ----------------------FUNCIONÁRIO/MENU-------------------------

	public void vendasFuncionario(ActionEvent event) throws Exception {
		paneVend.setVisible(true);
		paneCli.setVisible(false);
		paneProd.setVisible(false);
		menuVendSele.setTextFill(Color.valueOf("#087326"));
		barraVendSele.setVisible(true);
		menuCliSele.setTextFill(Color.valueOf("black"));
		barraCliSele.setVisible(false);
		menuProdSele.setTextFill(Color.valueOf("black"));
		barraProdSele.setVisible(false);
		refreshTableVendas(null);
		pesquisarVend.setText("");
	}

	public void clientesFuncionario(ActionEvent event) throws Exception {
		paneVend.setVisible(false);
		paneCli.setVisible(true);
		paneProd.setVisible(false);
		menuVendSele.setTextFill(Color.valueOf("black"));
		barraVendSele.setVisible(false);
		menuCliSele.setTextFill(Color.valueOf("#087326"));
		barraCliSele.setVisible(true);
		menuProdSele.setTextFill(Color.valueOf("black"));
		barraProdSele.setVisible(false);
		erroPropCli.setVisible(false);
		refreshTableCliente(null);
		refreshCliente();
		pesquisarCli.setText("");
	}

	public void produtosFuncionario(ActionEvent event) throws Exception {
		paneVend.setVisible(false);
		paneCli.setVisible(false);
		paneProd.setVisible(true);
		menuVendSele.setTextFill(Color.valueOf("black"));
		barraVendSele.setVisible(false);
		menuCliSele.setTextFill(Color.valueOf("black"));
		barraCliSele.setVisible(false);
		menuProdSele.setTextFill(Color.valueOf("#087326"));
		barraProdSele.setVisible(true);
		refreshTableProduto(null);
		refreshProduto();
		pesquisarProd.setText("");
	}

	// ------------------------------TELAS-----------------------------------

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
