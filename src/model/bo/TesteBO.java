package model.bo;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import model.bo.GerenteBO;
import model.vo.ClienteVO;
import model.vo.CompraVO;
import model.vo.FuncionarioVO;
import model.vo.GerenteVO;
import model.vo.PedidoVO;
import model.vo.ProdutoVO;
import model.vo.ProprietarioVO;

public class TesteBO {

	public static void main(String[] args) throws IOException, SQLException, ParseException {

		// ------------------------Teste Proprietario----------------------------
		// ProprietarioBO<ProprietarioVO> propbo = new ProprietarioBO<ProprietarioVO>();

		// ProprietarioVO prop = new ProprietarioVO();
		// prop.setId_Proprietario(1L);
		// prop.setNome("Matheus Goes");
		// prop.setCpf("11111111111");
		// prop.setLogin("MatHeus");
		// prop.setSenha("goes");

		// --------alterar proprietario---------
		// propbo.alterar(prop);

		// Pesquisar e retornar um proprietario pelo id_proprietario ou nome ou cpf
		// List<ProprietarioVO> proprietarios = propbo.pesquisar(prop);
		// for (ProprietarioVO cli2 : proprietarios) {
		// System.out.println(cli2.getId_Proprietario() + "\t" + cli2.getNome() + "\t" +
		// cli2.getCpf());
		// }

		// --------Listar---------
		// List<ProprietarioVO> proprietarios = propbo.listar();
		// for (ProprietarioVO prop1 : proprietarios) {
		// System.out.println(prop1.getId_Proprietario() + "\t" + prop1.getNome() + "\t"
		// + prop1.getSenha());
		// }

		// ------------------------Teste Gerente----------------------------
		// GerenteBO<GerenteVO> gerbo = new GerenteBO<GerenteVO>();
		// GerenteVO ger = new GerenteVO();
		// ger.setId_Gerente(14L);
		// ger.setId_Proprietario(1L);
		// ger.setNome("MatheUs");
		// ger.setCpf("32165498796");
		// ger.setLogin("MaTheus");
		// ger.setSenha("matheus");

		// -------- inserir um gerente---------
		// gerbo.inserir(ger);

		// --------alterar gerente---------
		// gerbo.alterar(ger);

		// -------- remover um gerente---------
		// gerbo.remover(ger);

		// Pesquisar e retornar um Gerente pelo id_gerente, nome, cpf
		// List<GerenteVO> gerentes = gerbo.pesquisar(ger);
		// for (GerenteVO ger1 : gerentes) {
		// System.out.println(ger1.getId_Gerente() + "\t" + ger1.getId_Proprietario() +
		// "\t" + ger1.getNome() + "\t"
		// + ger1.getCpf());
		// }

		// --------Listar---------
		// List<GerenteVO> gerentes = gerbo.listar();
		// for (GerenteVO ger1 : gerentes) {
		// System.out.println(ger1.getId_Gerente() + "\t" + ger1.getId_Proprietario() +
		// "\t" + ger1.getNome() + "\t"
		// + ger1.getCpf());
		// }

		// ------------------------Teste Funcionario----------------------------
		// FuncionarioBO<FuncionarioVO> funcbo = new FuncionarioBO<FuncionarioVO>();

		// FuncionarioVO func = new FuncionarioVO();
		// func.setId_Funcionario(5L);
		// func.setId_Proprietario(1L);
		// func.setNome("MatheUs GoES");
		// func.setCpf("00000000008");
		// func.setLogin("MaThs123");
		// func.setSenha("matheus123");

		// -------- inserir um funcionario---------
		// funcbo.inserir(func);

		// --------alterar funcionario---------
		// funcbo.alterar(func);

		// -------- remover um funcionario---------
		// funcbo.remover(func);

		// Pesquisar e retornar um funcionario pelo id_funcionario, nome, cpf
		// List<FuncionarioVO> funcionarios = funcbo.pesquisar(func);
		// for (FuncionarioVO func1 : funcionarios) {
		// System.out.println(func1.getId_Funcionario() + "\t" +
		// func1.getId_Proprietario() + "\t" + func1.getNome()
		// + "\t" + func1.getCpf());
		// }

		// --------Listar---------
		// List<FuncionarioVO> funcionarios = funcbo.listar();
		// for (FuncionarioVO func1 : funcionarios) {
		// System.out.println(func1.getId_Funcionario() + "\t" +
		// func1.getId_Proprietario() + "\t" + func1.getNome()
		// + "\t" + func1.getCpf());
		// }

		// ------------------------Teste Produto----------------------------
		// ProdutoBO<ProdutoVO> prodbo = new ProdutoBO<ProdutoVO>();

		// ProdutoVO prod = new ProdutoVO();
		// prod.setId_Produto(6L);
		// prod.setDescricao("CuEca MeDiA");
		// prod.setValor(50.0);
		// prod.setQuantidade(100);

		// -------- inserir um produto---------
		// prodbo.inserir(prod);

		// --------alterar produto---------
		// prodbo.alterar(prod);

		// -------- remover um produto---------
		// prodbo.remover(prod);

		// Pesquisar e retornar um produto pelo id_produto, descricao, valor
		// List<ProdutoVO> produtos = prodbo.pesquisar(prod);
		// for (ProdutoVO prod1 : produtos) {
		// System.out.println(prod1.getId_Produto() + "\t" + prod1.getDescricao() + "\t"
		// + prod1.getValor() + "\t"
		// + prod1.getQuantidade());
		// }

		// --------Listar---------
		// List<ProdutoVO> produtos = prodbo.listar();
		// for (ProdutoVO prod1 : produtos) {
		// System.out.println(prod1.getId_Produto() + "\t" + prod1.getDescricao() + "\t"
		// + prod1.getValor() + "\t"
		// + prod1.getQuantidade());
		// }

		// ------------------------Teste Cliente----------------------------
		// ClienteBO<ClienteVO> clibo = new ClienteBO<ClienteVO>();

		// ClienteVO cli = new ClienteVO();
		// cli.setId_Cliente(4L);
		// cli.setNome("MatheUs");
		// cli.setCpf("00000010000");

		// -------- inserir um cliente---------
		// clibo.inserir(cli);

		// --------alterar cliente---------
		// clibo.alterar(cli);

		// -------- remover um cliente---------
		// clibo.remover(cli);

		// Pesquisar e retornar um cliente pelo id_cliente, nome, cpf
		// List<ClienteVO> clientes = clibo.pesquisar(cli);
		// for (ClienteVO cli1 : clientes) {
		// System.out.println(cli1.getId_Cliente() + "\t" + cli1.getNome() + "\t" +
		// cli1.getCpf());
		// }

		// --------Listar---------
		// List<ClienteVO> clientes = clibo.listar();
		// for (ClienteVO cli1 : clientes) {
		// System.out.println(cli1.getId_Cliente() + "\t" + cli1.getNome() + "\t" +
		// cli1.getCpf());
		// }

		// ------------------------Teste Compra----------------------------
		// CompraBO<CompraVO> compbo = new CompraBO<CompraVO>();

		// CompraVO comp = new CompraVO();
		// comp.setId_Compra(5L);
		// comp.setId_Funcionario(1L);
		// comp.setId_Cliente(1L);
		// comp.setValor(50.0);

		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// Calendar c = Calendar.getInstance();
		// c.setTime(sdf.parse("2020-11-28"));
		// comp.setData(new java.sql.Date(c.getTimeInMillis()));

		// -------- inserir uma compra---------
		// compbo.inserir(comp);

		// --------alterar compra---------
		// compbo.alterar(comp);

		// -------- remover uma compra---------
		// compbo.remover(comp);

		// Pesquisar e retornar uma compra pelo id_cliente, valor, data
		// List<CompraVO> compras = compbo.pesquisar(comp);
		// for (CompraVO comp1 : compras) {
		// System.out.println(comp1.getId_Compra() + "\t" + comp1.getId_Funcionario() +
		// "\t" + comp1.getId_Cliente()
		// + "\t" + comp1.getValor() + "\t" + comp1.getData() + "\t" + comp1.getHora());
		// }

		// --------Listar---------
		// List<CompraVO> compras = compbo.listar();
		// for (CompraVO comp1 : compras) {
		// System.out.println(comp1.getId_Compra() + "\t" + comp1.getId_Funcionario() +
		// "\t" + comp1.getId_Cliente()
		// + "\t" + comp1.getValor() + "\t" + comp1.getData() + "\t" + comp1.getHora());
		// }

		// ------------------------Teste Pedido----------------------------
		// PedidoBO<PedidoVO> pedbo = new PedidoBO<PedidoVO>();

		// PedidoVO ped = new PedidoVO();
		// ped.setId_Pedido(5L);
		// ped.setId_Produto(2L);
		// ped.setId_Compra(1L);
		// ped.setValor(45.0);
		// ped.setQuantidade(5);

		// -------- inserir um pedido---------
		// pedbo.inserir(ped);

		// --------alterar pedido---------
		// pedbo.alterar(ped);

		// -------- remover um pedido---------
		// pedbo.remover(ped);

		// Pesquisar e retornar um pedido pelo id_compra, id_produto, valor
		// List<PedidoVO> pedidos = pedbo.pesquisarByValor(ped);
		// for (PedidoVO ped1 : pedidos) {
		// System.out.println(ped1.getId_Pedido() + "\t" + ped1.getId_Produto() + "\t" +
		// ped1.getId_Compra() + "\t"
		// + ped1.getValor() + "\t" + ped1.getQuantidade());
		// }

		// --------Listar---------
		// List<PedidoVO> pedidos = pedbo.listar();
		// for (PedidoVO ped1 : pedidos) {
		// System.out.println(ped1.getId_Pedido() + "\t" + ped1.getId_Produto() + "\t" +
		// ped1.getId_Compra() + "\t"
		// + ped1.getValor() + "\t" + ped1.getQuantidade());
		// }
	}
}
