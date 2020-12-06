package model.vo;

public class PedidoVO extends CompraVO {
	private Long Id_Pedido;
	private Double Subtotal;
	private Double Total;
	private ProdutoVO Produto;
	private ClienteVO Cliente;

	// Métodos Getters e Setters
	public Long getId_Pedido() {
		return Id_Pedido;
	}

	public void setId_Pedido(Long id_Pedido) {
		Id_Pedido = id_Pedido;
	}

	public Double getSubtotal() {
		return Subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.Subtotal = subtotal;
	}

	public Double getTotal() {
		return Total;
	}

	public void setTotal(Double total) {
		this.Total = total;
	}

	public ProdutoVO getProduto() {
		return Produto;
	}

	public void setProduto(ProdutoVO produto) {
		Produto = produto;
	}

	public ClienteVO getCliente() {
		return Cliente;
	}

	public void setCliente(ClienteVO cliente) {
		Cliente = cliente;
	}
}
