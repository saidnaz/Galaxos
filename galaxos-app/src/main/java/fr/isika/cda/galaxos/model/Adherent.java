package fr.isika.cda.galaxos.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Adherent implements Serializable {
	    private static final long serialVersionUID = 1L;

	    
	    @Id
	    private String email;
	    
	    @Column(name="motdepasse", nullable=false)
	    private String password;
	    
	    @Enumerated(value = EnumType.STRING)
	    private Role role = Role.ROLE_USER;
	    
	    @Column(name="Comptevalide", nullable=false)
	    private boolean isAccountNotExpired = true;
	    
	    @Column(name="Comptebloque", nullable=false)
	    private boolean isAccountNotLocked = true;

	    
	    public Adherent() {
			super();
			
		}
		@Override
		public int hashCode() {
			return Objects.hash(email);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Adherent other = (Adherent) obj;
			return Objects.equals(email, other.email);
		}
		public boolean isAccountNotExpired() {
			return isAccountNotExpired;
		}
		public void setAccountNotExpired(boolean isAccountNotExpired) {
			this.isAccountNotExpired = isAccountNotExpired;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public boolean isAccountNotLocked() {
			return isAccountNotLocked;
		}
		public void setAccountNotLocked(boolean isAccountNotLocked) {
			this.isAccountNotLocked = isAccountNotLocked;
		}
		
	    
	   

}
