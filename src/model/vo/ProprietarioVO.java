package model.vo;

public class ProprietarioVO {
	private Long Id_Proprietario;
	private String Nome;
	private String Cpf;
	private String Login;
	private String Senha;

	// Métodos Getters e Setters
	public Long getId_Proprietario() {
		return Id_Proprietario;
	}

	public void setId_Proprietario(Long id_Proprietario) {
		this.Id_Proprietario = id_Proprietario;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		if (nome.equals(""))
			nome = null;
		else
			nome = nome.toUpperCase();
		this.Nome = nome;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		if (cpf.equals(""))
			cpf = null;
		this.Cpf = cpf;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		if (login.equals(""))
			login = null;
		else
			login = login.toUpperCase();
		this.Login = login;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		if (senha.equals(""))
			senha = null;
		this.Senha = senha;
	}
}
