package fr.isika.cda.galaxos.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entité de test qui peut être supprimée.
 */
@Entity
public class Application {

	@Id
	private UUID id = UUID.randomUUID();
	private String appName = "Galaxos App";
	private String test;

	public UUID getId() {
		return id;
	}

	public String getAppName() {
		return appName;
	}

}
