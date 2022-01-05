package fr.isika.cda.galaxos.viewmodel;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class AssociationFinalisationForm implements Serializable {

	private static final long serialVersionUID = 4205239488412544230L;
	
	@NotEmpty(message = "Ce champs doit être rempli")
	@NotNull(message = "Ce champs doit être rempli")
	private String slogan;
	
	@NotEmpty(message = "Ce champs doit être rempli")
	@NotNull(message = "Ce champs doit être rempli")
	private String description;
	
	@NotEmpty(message = "Ce champs doit être rempli")
	@NotNull(message = "Ce champs doit être rempli")
	private String logo;
	
	@NotEmpty(message = "Ce champs doit être rempli")
	@NotNull(message = "Ce champs doit être rempli")
	private String pieceIdentite;
	
	@NotEmpty(message = "Ce champs doit être rempli")
	@NotNull(message = "Ce champs doit être rempli")
	private String RIB;
	
	//@NotEmpty(message = "Ce champs doit être rempli")
	@NotNull(message = "Ce champs doit être rempli")
	private Double commission;

	
	
	public AssociationFinalisationForm() {
		super();
	}

	public AssociationFinalisationForm(String slogan, String description, String logo, String pieceIdentite, String rIB,
			Double commission) {
		super();
		this.slogan = slogan;
		this.description = description;
		this.logo = logo;
		this.pieceIdentite = pieceIdentite;
		RIB = rIB;
		this.commission = commission;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getPieceIdentite() {
		return pieceIdentite;
	}

	public void setPieceIdentite(String pieceIdentite) {
		this.pieceIdentite = pieceIdentite;
	}

	public String getRIB() {
		return RIB;
	}

	public void setRIB(String rIB) {
		RIB = rIB;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
