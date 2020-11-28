package model.vo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TesteVO {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);

		ProprietarioVO propVO = new ProprietarioVO();
		GerenteVO gerVO = new GerenteVO();
		FuncionarioVO funcVO = new FuncionarioVO();
		ProdutoVO prodVO = new ProdutoVO();
		ClienteVO cliVO = new ClienteVO();
		CompraVO compVO = new CompraVO();
		PedidoVO pedVO = new PedidoVO();

		// --------------------------------------Propriet�rio----------------------------------------
		// Coletando os dados de um Propriet�rio
		System.out.println("Informe o Id de um propriet�rio:");
		Long id = leitura.nextLong();
		leitura.nextLine();// Limpando o buffer do teclado
		System.out.println("Informe o Nome de um propriet�rio:");
		String nome = leitura.nextLine();
		System.out.println("Informe o Cpf de um propriet�rio:");
		String cpf = leitura.nextLine();
		System.out.println("Informe o Login de um propriet�rio:");
		String login = leitura.nextLine();
		System.out.println("Informe o Senha de um propriet�rio:");
		String senha = leitura.nextLine();

		// Guardando os dados de um Propriet�rio
		propVO.setId_Proprietario(id);
		propVO.setNome(nome);
		propVO.setCpf(cpf);
		propVO.setLogin(login);
		propVO.setSenha(senha);

		// Mostrando os dados de um Propriet�rio
		System.out.println("-----------Dados de um propriet�rio----------");
		System.out.println("Id = " + propVO.getId_Proprietario());
		System.out.println("Nome = " + propVO.getNome());
		System.out.println("Cpf = " + propVO.getCpf());
		System.out.println("Login = " + propVO.getLogin());
		System.out.println("Senha = " + propVO.getSenha());
		System.out.println("---------------------------------------------");

		// --------------------------------------Gerente----------------------------------------
		// Coletando os dados de um Gerente
		System.out.println("\nInforme o Id de um gerente:");
		id = leitura.nextLong();
		System.out.println("Informe o Id do propriet�rio respons�vel desse gerente:");
		Long idprop = leitura.nextLong();
		leitura.nextLine();// Limpando o buffer do teclado
		System.out.println("Informe o Nome de um gerente:");
		nome = leitura.nextLine();
		System.out.println("Informe o Cpf de um gerente:");
		cpf = leitura.nextLine();
		System.out.println("Informe o Login de um gerente:");
		login = leitura.nextLine();
		System.out.println("Informe o Senha de um gerente:");
		senha = leitura.nextLine();

		// Guardando os dados de um Gerente
		gerVO.setId_Gerente(id);
		gerVO.setId_Proprietario(idprop);
		gerVO.setNome(nome);
		gerVO.setCpf(cpf);
		gerVO.setLogin(login);
		gerVO.setSenha(senha);

		// Mostrando os dados de um Gerente
		System.out.println("-----------Dados de um gerente----------");
		System.out.println("Id = " + gerVO.getId_Gerente());
		System.out.println("Id do propriet�rio respons�vel = " + gerVO.getId_Proprietario());
		System.out.println("Nome = " + gerVO.getNome());
		System.out.println("Cpf = " + gerVO.getCpf());
		System.out.println("Login = " + gerVO.getLogin());
		System.out.println("Senha = " + gerVO.getSenha());
		System.out.println("---------------------------------------------");

		// --------------------------------------Funcion�rio----------------------------------------
		// Coletando os dados de um Funcion�rio
		System.out.println("\nInforme o Id de um funcion�rio:");
		id = leitura.nextLong();
		System.out.println("Informe o Id do propriet�rio respons�vel desse funcion�rio:");
		idprop = leitura.nextLong();
		leitura.nextLine();// Limpando o buffer do teclado
		System.out.println("Informe o Nome de um funcion�rio:");
		nome = leitura.nextLine();
		System.out.println("Informe o Cpf de um funcion�rio:");
		cpf = leitura.nextLine();
		System.out.println("Informe o Login de um funcion�rio:");
		login = leitura.nextLine();
		System.out.println("Informe o Senha de um funcion�rio:");
		senha = leitura.nextLine();

		// Guardando os dados de um Funcion�rio
		funcVO.setId_Funcionario(id);
		funcVO.setId_Proprietario(idprop);
		funcVO.setNome(nome);
		funcVO.setCpf(cpf);
		funcVO.setLogin(login);
		funcVO.setSenha(senha);

		// Mostrando os dados de um Funcion�rio
		System.out.println("-----------Dados de um funcion�rio----------");
		System.out.println("Id = " + funcVO.getId_Funcionario());
		System.out.println("Id do propriet�rio respons�vel = " + funcVO.getId_Proprietario());
		System.out.println("Nome = " + funcVO.getNome());
		System.out.println("Cpf = " + funcVO.getCpf());
		System.out.println("Login = " + funcVO.getLogin());
		System.out.println("Senha = " + funcVO.getSenha());
		System.out.println("---------------------------------------------");

		// --------------------------------------Produto----------------------------------------
		// Coletando os dados de um Produto
		System.out.println("\nInforme o Id de um produto:");
		id = leitura.nextLong();
		leitura.nextLine();// Limpando o buffer do teclado
		System.out.println("Informe o valor de um produto:");
		Double valor = leitura.nextDouble();
		leitura.nextLine();// Limpando o buffer do teclado
		System.out.println("Informe a descri��o de um produto:");
		String descricao = leitura.nextLine();
		System.out.println("Informe o quantidade de um produto:");
		Integer quantidade = leitura.nextInt();
		leitura.nextLine();// Limpando o buffer do teclado

		// Guardando os dados de um Produto
		prodVO.setId_Produto(id);
		prodVO.setValor(valor);
		prodVO.setDescricao(descricao);
		prodVO.setQuantidade(quantidade);

		// Mostrando os dados de um Produto
		System.out.println("-----------Dados de um produto----------");
		System.out.println("Id = " + prodVO.getId_Produto());
		System.out.println("Valor = " + prodVO.getValor());
		System.out.println("Descri��o = " + prodVO.getDescricao());
		System.out.println("Quantidade = " + prodVO.getQuantidade());
		System.out.println("---------------------------------------------");

		// --------------------------------------Cliente----------------------------------------
		// Coletando os dados de um Cliente
		System.out.println("\nInforme o Id de um cliente:");
		id = leitura.nextLong();
		leitura.nextLine();// Limpando o buffer do teclado
		System.out.println("Informe o Nome de um cliente:");
		nome = leitura.nextLine();
		System.out.println("Informe o Cpf de um cliente:");
		cpf = leitura.nextLine();

		// Guardando os dados de um Cliente
		cliVO.setId_Cliente(id);
		cliVO.setNome(nome);
		cliVO.setCpf(cpf);

		// Mostrando os dados de um Cliente
		System.out.println("-----------Dados de um cliente----------");
		System.out.println("Id = " + cliVO.getId_Cliente());
		System.out.println("Nome = " + cliVO.getNome());
		System.out.println("Cpf = " + cliVO.getCpf());
		System.out.println("---------------------------------------------");

		// --------------------------------------Compra----------------------------------------
		// Coletando os dados de um Compra
		System.out.println("\nInforme o Id de um compra:");
		id = leitura.nextLong();
		leitura.nextLine();// Limpando o buffer do teclado
		System.out.println("Informe o Id do funcion�rio respons�vel dessa compra:");
		Long idfunc = leitura.nextLong();
		leitura.nextLine();// Limpando o buffer do teclado
		System.out.println("Informe o Id do cliente que fez essa compra:");
		Long idcli = leitura.nextLong();
		leitura.nextLine();// Limpando o buffer do teclado
		System.out.println("Informe o valor de uma compra:");
		valor = leitura.nextDouble();
		leitura.nextLine();// Limpando o buffer do teclado

		// Guardando os dados de um Compra
		Date date = new Date();
		// SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");

		compVO.setId_Compra(id);
		compVO.setId_Funcionario(idfunc);
		compVO.setId_Cliente(idcli);
		compVO.setValor(valor);
		// compVO.setData(data.format(date)); //alterado o setData
		compVO.setHora(hora.format(date));

		// Mostrando os dados de um Compra
		System.out.println("-----------Dados de um compra----------");
		System.out.println("Id = " + compVO.getId_Produto());
		System.out.println("Id do funcion�rio respons�vel = " + compVO.getId_Funcionario());
		System.out.println("Valor = " + compVO.getValor());
		System.out.println("Data = " + compVO.getData());
		System.out.println("Hora = " + compVO.getHora());
		System.out.println("---------------------------------------------");

		// --------------------------------------Pedido----------------------------------------
		// Coletando os dados de um Pedido
		System.out.println("\nInforme o Id de um pedido:");
		id = leitura.nextLong();
		leitura.nextLine();// Limpando o buffer do teclado
		System.out.println("Informe o Id de um produto pedido:");
		Long idprod = leitura.nextLong();
		leitura.nextLine();// Limpando o buffer do teclado
		System.out.println("Informe o Id da Compra que est� esse pedido:");
		Long idcomp = leitura.nextLong();
		leitura.nextLine();// Limpando o buffer do teclado
		System.out.println("Informe o valor de um pedido:");
		valor = leitura.nextDouble();
		leitura.nextLine();// Limpando o buffer do teclado
		System.out.println("Informe a quantidade de um pedido:");
		quantidade = leitura.nextInt();
		leitura.nextLine();// Limpando o buffer do teclado

		// Guardando os dados de um Pedido
		pedVO.setId_Pedido(id);
		pedVO.setId_Produto(idprod);
		pedVO.setId_Compra(idcomp);
		pedVO.setValor(valor);
		pedVO.setQuantidade(quantidade);

		// Mostrando os dados de um Pedido
		System.out.println("-----------Dados de um pedido----------");
		System.out.println("Id = " + pedVO.getId_Pedido());
		System.out.println("Id de um produto = " + pedVO.getId_Produto());
		System.out.println("Id da compra = " + pedVO.getId_Compra());
		System.out.println("Valor = " + pedVO.getValor());
		System.out.println("Quantidade = " + pedVO.getQuantidade());
		System.out.println("---------------------------------------------");

	}

}
