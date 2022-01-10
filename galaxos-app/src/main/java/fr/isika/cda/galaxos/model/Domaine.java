package fr.isika.cda.galaxos.model;

public enum Domaine {

	//	Spiritualite,
	//	Reseaux,
	Animation_Evenement("Animation et Evenement"),	//Activités
	Art_et_Culture("Art et Culture"),	
	Artisanat("Artisanat"),
	Cuisine_Restauration("Cuisine et Restauration"),
	Cours_Formation("Cours et Formation"),
	Environnement("Environnement"),		// Ecologie
	Loisirs("Loisirs"),		// Sport	
	Patrimoine("Patrimoine"),		
	Bien_etre("Bien être"),		// Mode_Sante_
	Sciences("Sciences"),
	Technologie("Technologie"),
	Entraide("Entraide"),		// Action Sociale // Entraide // Services // ex : Yoojo, allovoisin, Bricoco
	Projet("projet");	// Demande de Financement pour un projet, 
	// ou faire une classe "Projet" à part, pour permettre de choisir après le domaine du projet
	

    private String label;

    private Domaine(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

	public void setLabel(String label) {
		this.label = label;
	}
    
    
	
}
