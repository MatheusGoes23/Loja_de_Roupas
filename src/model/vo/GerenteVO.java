package model.vo;

public class GerenteVO extends ProprietarioVO {
	private Long Id_Gerente;

	// M�todos Getters e Setters
	public Long getId_Gerente() {
		return Id_Gerente;
	}

	public void setId_Gerente(Long id_Gerente) {
		// Id_Gerente = Long.valueOf(id_Gerente);
		Id_Gerente = id_Gerente;
	}
}
