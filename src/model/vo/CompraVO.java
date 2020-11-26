package model.vo;

public class CompraVO extends ClienteVO {

	private Long Id_Compra;
	private String Data;
	private String Hora;

	// Métodos Getters e Setters
	public Long getId_Compra() {
		return Id_Compra;
	}

	public void setId_Compra(Long id_Compra) {
		Id_Compra = id_Compra;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public String getHora() {
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}
}
