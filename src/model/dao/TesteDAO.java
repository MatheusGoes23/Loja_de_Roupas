package model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import model.vo.ClienteVO;
import model.vo.CompraVO;
import model.vo.FuncionarioVO;
import model.vo.PedidoVO;
import model.vo.ProdutoVO;
import model.vo.ProprietarioVO;

public class TesteDAO {

	public static void main(String[] args) throws IOException, SQLException, ParseException {

		// ------------------------Teste Proprietario----------------------------
		// ProprietarioDAO<ProprietarioVO> propdao = new
		// ProprietarioDAO<ProprietarioVO>();

		// ProprietarioVO prop = new ProprietarioVO();
		// prop.setId_Proprietario(1L);
		// prop.setNome("Matheus");
		// prop.setCpf("00000000000");
		// prop.setLogin("matheus123123");
		// prop.setSenha("matheus321321");

		// --------alterar proprietario---------
		// propdao.alterar(prop);

		// --------Ver se existe um proprietário com esse id_proprietario---------
		// System.out.println(propdao.buscarById_Proprietario(prop).next());

		// --------Ver se existe um proprietário com esse nome---------
		// System.out.println(propdao.buscarByNome(prop).next());

		// --------Ver se existe um proprietário com esse cpf---------
		// System.out.println(propdao.buscarByCpf(prop).next());

		// --------Ver se existe um proprietário com esse login---------
		// System.out.println(propdao.buscarByLogin(prop).next());

		// Pesquisar e retornar um proprietario pelo id_proprietario, nome, cpf ou login
		// List<ProprietarioVO> proprietarios = propdao.pesquisarByLogin(prop);
		// for (ProprietarioVO prop1 : proprietarios) {
		// System.out.println(prop1.getId_Proprietario() + "\t" + prop1.getNome() + "\t"
		// + prop1.getCpf());
		// }

		// --------Listar---------
		// List<ProprietarioVO> proprietarios = propdao.listar();

		// for (ProprietarioVO prop1 : proprietarios) {
		// System.out.println(prop1.getId_Proprietario() + "\t" + prop1.getNome() + "\t"
		// + prop1.getCpf());
		//
		// }

		// ------------------------Teste Gerente----------------------------
		// GerenteDAO<GerenteVO> gerdao = new GerenteDAO<GerenteVO>();

		// GerenteVO ger = new GerenteVO();
		// ger.setId_Gerente(14L);
		// ger.setId_Proprietario(1L);
		// ger.setNome("MatheUs");
		// ger.setCpf("01231234564");
		// ger.setLogin("MaTheus");
		// ger.setSenha("matheus");

		// -------- inserir um gerente---------
		// gerdao.inserir(ger);

		// --------alterar gerente---------
		// gerdao.alterar(ger);

		// -------- remover um gerente---------
		// gerdao.remover(ger);

		// --------Ver se existe um Gerente com esse id_gerente---------
		// System.out.println(gerdao.buscarById_Gerente(ger).next());

		// --------Ver se existe um Gerente com esse id_proprietario---------
		// System.out.println(gerdao.buscarById_Proprietario(ger).next());

		// --------Ver se existe um Gerente com esse nome---------
		// System.out.println(gerdao.buscarByNome(ger).next());

		// --------Ver se existe um Gerente com esse cpf---------
		// System.out.println(gerdao.buscarByCpf(ger).next());

		// --------Ver se existe um Gerente com esse login---------
		// System.out.println(gerdao.buscarByLogin(ger).next());

		// Pesquisar e retornar um Gerente pelo id_gerente, id_proprietario, nome, cpf
		// ou login
		// List<GerenteVO> gerentes = gerdao.pesquisarByLogin(ger);
		// for (GerenteVO ger1 : gerentes) {
		// System.out.println(ger1.getId_Gerente() + "\t" + ger1.getId_Proprietario() +
		// "\t" + ger1.getNome() + "\t"
		// + ger1.getCpf());
		// }

		// --------Listar---------
		// List<GerenteVO> gerentes = gerdao.listar();
		// for (GerenteVO ger1 : gerentes) {
		// System.out.println(ger1.getId_Gerente() + "\t" + ger1.getId_Proprietario() +
		// "\t" + ger1.getNome() + "\t"
		// + ger1.getCpf());
		// }

		// ------------------------Teste Funcionario----------------------------
		// FuncionarioDAO<FuncionarioVO> funcdao = new FuncionarioDAO<FuncionarioVO>();

		// FuncionarioVO func = new FuncionarioVO();
		// func.setId_Proprietario(1L);
		// func.setNome("MatheUs GoES");
		// func.setCpf("00000000000");
		// func.setLogin("MaTheus123");
		// func.setSenha("matheus123");

		// -------- inserir um funcionario---------
		// funcdao.inserir(func);

		// --------alterar funcionario---------
		// funcdao.alterar(func);

		// -------- remover um funcionario---------
		// funcdao.remover(func);

		// --------Ver se existe um funcionario com esse id_funcionario---------
		// System.out.println(funcdao.buscarById_Funcionario(func).next());

		// --------Ver se existe um funcionario com esse id_proprietario---------
		// System.out.println(funcdao.buscarById_Proprietario(func).next());

		// --------Ver se existe um funcionario com esse nome---------
		// System.out.println(funcdao.buscarByNome(func).next());

		// --------Ver se existe um funcionario com esse cpf---------
		// System.out.println(funcdao.buscarByCpf(func).next());

		// --------Ver se existe um funcionario com esse login---------
		// System.out.println(funcdao.buscarByLogin(func).next());

		// Pesquisar e retornar um funcionario pelo id_funcionario, id_proprietario,
		// nome, cpf ou login
		// List<FuncionarioVO> funcionarios = funcdao.pesquisarByNome(func);
		// for (FuncionarioVO func1 : funcionarios) {
		// System.out.println(func1.getId_Funcionario() + "\t" +
		// func1.getId_Proprietario() + "\t" + func1.getNome()
		// + "\t" + func1.getCpf());
		// }

		// --------Listar---------
		// List<FuncionarioVO> funcionarios = funcdao.listar();
		// for (FuncionarioVO ger1 : funcionarios) {
		// System.out.println(ger1.getId_Funcionario() + "\t" +
		// ger1.getId_Proprietario() + "\t" + ger1.getNome()
		// + "\t" + ger1.getCpf());
		// }

		// ------------------------Teste Produto----------------------------
		// ProdutoDAO<ProdutoVO> proddao = new ProdutoDAO<ProdutoVO>();

		// ProdutoVO prod = new ProdutoVO();
		// prod.setId_Produto(6L);
		// prod.setDescricao("502");
		// prod.setValor(100.0);
		// prod.setQuantidade(100);

		// -------- inserir um produto---------
		// proddao.inserir(prod);

		// --------alterar produto---------
		// proddao.alterar(prod);

		// -------- remover um produto---------
		// proddao.remover(prod);

		// --------Ver se existe um produto com esse id_produto---------
		// System.out.println(proddao.buscarById_Produto(prod).next());

		// --------Ver se existe um produto com essa descricao---------
		// System.out.println(proddao.buscarByDescricao(prod).next());

		// --------Ver se existe um produto com esse valor---------
		// System.out.println(proddao.buscarByValor(prod).next());

		// Pesquisar e retornar um produto pelo id_produto, descricao, valor
		// List<ProdutoVO> produtos = proddao.pesquisarByValor(prod);
		// for (ProdutoVO prod1 : produtos) {
		// System.out.println(prod1.getId_Produto() + "\t" + prod1.getDescricao() + "\t"
		// + prod1.getValor() + "\t"
		// + prod1.getQuantidade());
		// }

		// --------Listar---------
		// List<ProdutoVO> produtos = proddao.listar();
		// for (ProdutoVO prod1 : produtos) {
		// System.out.println(prod1.getId_Produto() + "\t" + prod1.getDescricao() + "\t"
		// + prod1.getValor() + "\t"
		// + prod1.getQuantidade());
		// }

		// ------------------------Teste Cliente----------------------------
		// ClienteDAO<ClienteVO> clidao = new ClienteDAO<ClienteVO>();

		// ClienteVO cli = new ClienteVO();
		// cli.setId_Cliente(4L);
		// cli.setNome("MatheUs");
		// cli.setCpf("00000010000");

		// -------- inserir um cliente---------
		// clidao.inserir(cli);

		// --------alterar cliente---------
		// clidao.alterar(cli);

		// -------- remover um cliente---------
		// clidao.remover(cli);

		// --------Ver se existe um cliente com esse id_cliente---------
		// System.out.println(clidao.buscarById_Cliente(cli).next());

		// --------Ver se existe um cliente com esse nome---------
		// System.out.println(clidao.buscarByNome(cli).next());

		// --------Ver se existe um cliente com esse cpf---------
		// System.out.println(clidao.buscarByCpf(cli).next());

		// Pesquisar e retornar um cliente pelo id_cliente, nome, cpf ou login
		// List<ClienteVO> clientes = clidao.pesquisarByCpf(cli);
		// for (ClienteVO cli1 : clientes) {
		// System.out.println(cli1.getId_Cliente() + "\t" + cli1.getNome() + "\t" +
		// cli1.getCpf());
		// }

		// --------Listar---------
		// List<ClienteVO> clientes = clidao.listar();
		// for (ClienteVO ger1 : clientes) {
		// System.out.println(ger1.getId_Cliente() + "\t" + ger1.getNome() + "\t" +
		// ger1.getCpf());
		// }

		// ------------------------Teste Compra----------------------------
		// CompraDAO<CompraVO> compdao = new CompraDAO<CompraVO>();

		// CompraVO comp = new CompraVO();
		// comp.setId_Compra(5L);
		// comp.setId_Funcionario(2L);
		// comp.setId_Cliente(1L);
		// comp.setValor(50.0);

		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// Calendar c = Calendar.getInstance();
		// c.setTime(sdf.parse("2020-11-28"));
		// comp.setData(new java.sql.Date(c.getTimeInMillis()));

		// -------- inserir uma compra---------
		// compdao.inserir(comp);

		// --------alterar compra---------
		// compdao.alterar(comp);

		// -------- remover uma compra---------
		// compdao.remover(comp);

		// --------Ver se existe uma compra com esse id_compra---------
		// System.out.println(compdao.buscarById_Compra(comp).next());

		// --------Ver se existe uma compra com essa id_funcionario---------
		// System.out.println(compdao.buscarById_Funcionario(comp).next());

		// --------Ver se existe uma compra com esse id_cliente---------
		// System.out.println(compdao.buscarById_Cliente(comp).next());

		// --------Ver se existe uma compra com esse valor---------
		// System.out.println(compdao.buscarByValor(comp).next());

		// --------Ver se existe uma compra com essa data---------
		// System.out.println(compdao.buscarByData(comp).next());

		// --------Ver se existe uma compra com esse hora---------
		// System.out.println(compdao.buscarByHora(comp).next());

		// Pesquisar e retornar uma compra pelo id_compra, id_funcionario, id_cliente,
		// valor, data
		// List<CompraVO> clientes = compdao.pesquisarByData(comp);
		// for (CompraVO cli1 : clientes) {
		// System.out.println(cli1.getId_Compra() + "\t" + cli1.getId_Funcionario() +
		// "\t" + cli1.getId_Cliente()
		// + "\t" + cli1.getValor() + "\t" + cli1.getData() + "\t" + cli1.getHora());
		// }

		// --------Listar---------
		// List<CompraVO> clientes = compdao.listar();
		// for (CompraVO cli1 : clientes) {
		// System.out.println(cli1.getId_Compra() + "\t" + cli1.getId_Funcionario() +
		// "\t" + cli1.getId_Cliente()
		// + "\t" + cli1.getValor() + "\t" + cli1.getData() + "\t" + cli1.getHora());
		// }

		// ------------------------Teste Pedido----------------------------
		// PedidoDAO<PedidoVO> peddao = new PedidoDAO<PedidoVO>();

		// PedidoVO ped = new PedidoVO();
		// ped.setId_Pedido(5L);
		// ped.setId_Produto(2L);
		// ped.setId_Compra(1L);
		// ped.setValor(45.0);
		// ped.setQuantidade(5);

		// -------- inserir um pedido---------
		// peddao.inserir(ped);

		// --------alterar pedido---------
		// peddao.alterar(ped);

		// -------- remover um pedido---------
		// peddao.remover(ped);

		// --------Ver se existe um pedido com esse id_pedido---------
		// System.out.println(peddao.buscarById_Pedido(ped).next());

		// --------Ver se existe um pedido com esse id_produto---------
		// System.out.println(peddao.buscarById_Produto(ped).next());

		// --------Ver se existe um pedido com esse id_compra---------
		// System.out.println(peddao.buscarById_Compra(ped).next());

		// --------Ver se existe um pedido com esse valor---------
		// System.out.println(peddao.buscarByValor(ped).next());

		// Pesquisar e retornar um pedido pelo id_pedido, id_produto, id_compra, valor
		// List<PedidoVO> pedidos = peddao.pesquisarByValor(ped);
		// for (PedidoVO ped1 : pedidos) {
		// System.out.println(ped1.getId_Pedido() + "\t" + ped1.getId_Produto() + "\t" +
		// ped1.getId_Compra() + "\t"
		// + ped1.getValor() + "\t" + ped1.getQuantidade());
		// }

		// --------Listar---------
		// List<PedidoVO> pedidos = peddao.listar();
		// for (PedidoVO ped1 : pedidos) {
		// System.out.println(ped1.getId_Pedido() + "\t" + ped1.getId_Produto() + "\t" +
		// ped1.getId_Compra() + "\t"
		// + ped1.getValor() + "\t" + ped1.getQuantidade());
		// }

		// --------Listar Produtos_Comprados_Cliente---------
		// List<PedidoVO> pedidos = peddao.listarComprados();
		// for (PedidoVO ped1 : pedidos) {
		// System.out.println(ped1.getNome() + "\t" + ped1.getCpf() + "\t" +
		// ped1.getDescricao() + "\t"
		// + ped1.getQuantidade() + "\t" + ped1.getValor() + "\t" + ped1.getData() +
		// "\t" + ped1.getHora());
		// }

		// PedidoVO ped = new PedidoVO();
		// ped.setNome("Jonas Marinho");
		// ped.setCpf("58974122365");
		// ped.setDescricao("Meia Masculina Grande");
		// ped.setQuantidade(3);
		// ped.setValor(30.0);

		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// Calendar c = Calendar.getInstance();
		// c.setTime(sdf.parse("2020-11-19"));

		// ped.setData(new java.sql.Date(c.getTimeInMillis()));
		// ped.setHora("20:33:23.510065");

		// Pesquisar e retornar um Produtos_Comprados_Cliente pelo nome, cpf, valor ou
		// data

		// List<PedidoVO> pedidos = peddao.pesquisarCompradosByData(ped);
		// for (PedidoVO ped1 : pedidos) {
		// System.out.println(ped1.getNome() + "\t" + ped1.getCpf() + "\t" +
		// ped1.getDescricao() + "\t"
		// + ped1.getQuantidade() + "\t" + ped1.getValor() + "\t" + ped1.getData() +
		// "\t" + ped1.getHora());
		// }

		// --------Listar Ex-Empregados---------
		// PedidoDAO<PedidoVO> peddao = new PedidoDAO<PedidoVO>();

		// List<PedidoVO> pedidos = peddao.listarEx();
		// for (PedidoVO ped1 : pedidos) {
		// System.out.println(ped1.getNome() + "\t" + ped1.getCpf() + "\t" +
		// ped1.getDescricao() + "\t"
		// + ped1.getData());
		// }

		PedidoDAO<PedidoVO> peddao = new PedidoDAO<PedidoVO>();

		PedidoVO ped = new PedidoVO();
		// ped.setId_Pedido(5L);
		ped.setId_Cliente(2L);
		ped.setNome("ClienteNome");
		ped.setCpf("ClienteCpf");

		ped.setId_Funcionario(12L);

		ped.setId_Produto(1L);
		ped.setDescricao("Blusa Masculina Grande");
		ped.setValor(30.0);
		ped.setQuantidade(3);

		//peddao.inserirComp(ped);
		peddao.inserirPed(ped);

		CompraDAO<CompraVO> compdao = new CompraDAO<CompraVO>();
		// Sabendo qual o id da compra que está aberta
				List<CompraVO> compras = compdao.listar();
				CompraVO compra = compras.get(compras.size() - 1);
		// --------Listar PEDIDOS NA TELA DE VENDER---------
		List<PedidoVO> produtos = peddao.listarVenda();
		for (PedidoVO prod1 : produtos) {
			System.out.println(prod1.getId_Pedido() + "\t" + prod1.getDescricao() + "\t" + prod1.getQuantidade() + "\t"
					+ prod1.getValor() + "\t" + prod1.getSubtotal() + "\t" + compra.getValor());
		}
	}
}
