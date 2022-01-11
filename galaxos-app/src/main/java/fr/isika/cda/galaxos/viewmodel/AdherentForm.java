package fr.isika.cda.galaxos.viewmodel;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import fr.isika.cda.galaxos.model.roles.Role;

public class AdherentForm implements Serializable{

	private static final long serialVersionUID = 4583619115761926156L;
	
	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir des chiffres")
	private String nom;

	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir des chiffres")
	private String prenom;
	
	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Email
	private String email;
	
	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Size(min = 1, max = 25, message = "entre 1 et 25 caractères")
	private String password;
	
	// confirmation du mot de passe
	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Size(min = 1, max = 25, message = "entre 1 et 25 caractères")
	private String confirmPassword;
	
	private List<Role> roles;
	
	private String role;
	
//	@NotEmpty(message = "Ne doit pas être vide")
//	@NotNull(message = "Ne doit pas être null")
//	private String pseudo;
	
	public AdherentForm() {
		super();
		role = "User";
	}
	
	/**
	 * Vérifie si les champs "password" et "confirmPassword" correspondent
	 */
	public boolean passwordsAreSame() {
		return password.equals(confirmPassword);
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public AdherentForm(String email, String password, String nom, String prenom, String role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public void addRoles(Role role)
	{
		this.roles.add(role);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
