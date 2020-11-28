package model.vo;

public class ProdutoVO extends FuncionarioVO {
	private Long Id_Produto;
	private String Descricao;
	private Double Valor;
	private int Quantidade;

	// Métodos Getters e Setters
	public Long getId_Produto() {
		return Id_Produto;
	}

	public void setId_Produto(Long id_Produto) {
		Id_Produto = id_Produto;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		if (descricao.equals(""))
			descricao = null;
		else
			descricao = descricao.toUpperCase();
		this.Descricao = descricao;
	}

	public Double getValor() {
		return Valor;
	}

	public void setValor(Double Valor) {
		this.Valor = Valor;
	}

	public int getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}
}
