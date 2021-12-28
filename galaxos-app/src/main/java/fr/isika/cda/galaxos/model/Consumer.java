package fr.isika.cda.galaxos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Consumer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idConsumer;
	
	private String email;
	
	private String password;
	
	@OneToMany(mappedBy="consumer")
	private List<Panier> panierId;
	
	
	public List<Panier> getPanierId() {
		return panierId;
	}

	public void setPanierId(List<Panier> panierId) {
		this.panierId = panierId;
	}

	public Consumer(String password) {
		super();
		this.password = password;
	}

	public Consumer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Consumer [idConsumer=");
		builder.append(idConsumer);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getIdConsumer() {
		return idConsumer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
