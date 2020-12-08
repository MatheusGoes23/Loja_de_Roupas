package model.vo;

import java.sql.Date;

public class CompraVO extends ClienteVO {
	private Long Id_Compra;
	private Date Data;
	private String Hora;

	// Métodos Getters e Setters
	public Long getId_Compra() {
		return Id_Compra;
	}

	public void setId_Compra(Long id_Compra) {
		Id_Compra = id_Compra;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date date) {
		Data = date;
	}

	public String getHora() {
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}
}
