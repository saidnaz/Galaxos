package fr.isika.cda.galaxos.app;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AppStatus {

	private String message;
	
	@PostConstruct
	private void init() {
		message = "Application is up and running !";
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
