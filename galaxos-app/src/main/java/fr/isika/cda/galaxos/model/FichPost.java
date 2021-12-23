package fr.isika.cda.galaxos.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FichPost {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPost;

    private String Description;
	
    private LocalDate DateStart;
	
    public FichPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	private LocalDate DateEnd;
    
    @Column(nullable=false)
    private Double price;

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public LocalDate getDateStart() {
		return DateStart;
	}

	public void setDateStart(LocalDate dateStart) {
		DateStart = dateStart;
	}

	public LocalDate getDateEnd() {
		return DateEnd;
	}

	public void setDateEnd(LocalDate dateEnd) {
		DateEnd = dateEnd;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getIdPost() {
		return idPost;
	}
    
    
}
