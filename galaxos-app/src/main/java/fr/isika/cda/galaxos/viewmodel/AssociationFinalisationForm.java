package fr.isika.cda.galaxos.viewmodel;

import java.io.Serializable;

import javax.servlet.http.Part;
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

	@NotNull(message = "Ce champs doit être rempli")
	private Part logo;

	@NotNull(message = "Ce champs doit être rempli")
	private Part pieceIdentite;

	@NotNull(message = "Ce champs doit être rempli")
	private Part RIB;

	// @NotEmpty(message = "Ce champs doit être rempli")
	@NotNull(message = "Ce champs doit être rempli")
	private Double commission;

	public AssociationFinalisationForm() {
		super();
	}

	public AssociationFinalisationForm(String slogan, String description, Part logo, Part pieceIdentite, Part RIB,
			Double commission) {
		super();
		this.slogan = slogan;
		this.description = description;
		this.logo = logo;
		this.pieceIdentite = pieceIdentite;
		this.RIB = RIB;
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

	public Part getPart() {
		return logo;
	}

	public void setPart(Part logo) {
		this.logo = logo;
	}

	public Part getPieceIdentite() {
		return pieceIdentite;
	}

	public void setPieceIdentite(Part pieceIdentite) {
		this.pieceIdentite = pieceIdentite;
	}

	public Part getRIB() {
		return RIB;
	}

	public void setRIB(Part RIB) {
		this.RIB = RIB;
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
