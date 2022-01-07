package fr.isika.cda.galaxos.model;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class DataDomaine {
	
	public Domaine[] getDomaines() {
		return Domaine.values();
	}
	
}
