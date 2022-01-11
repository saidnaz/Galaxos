package fr.isika.cda.galaxos.viewmodel;

import java.io.Serializable;

import fr.isika.cda.galaxos.model.Domaine;

public class CatalogueAssoForm implements Serializable {

	private static final long serialVersionUID = 7869037247746806889L;

	private String search;

	private String localisation;

	private Domaine domaines;

	public CatalogueAssoForm() {
		super();
	}

	public CatalogueAssoForm(String search, String localisation, Domaine domaine) {
		super();
		this.search = search;
		this.localisation = localisation;
		this.domaines = domaine;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public Domaine getDomaine() {
		return domaines;
	}

	public void setDomaine(Domaine domaine) {
		this.domaines = domaine;
	}

}
