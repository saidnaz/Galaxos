package fr.isika.cda.galaxos.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String appName = "Galaxos App";
	private String test;

	public UUID getId() {
		return id;
	}

	public String getAppName() {
		return appName;
	}

}
