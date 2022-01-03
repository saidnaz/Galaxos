package fr.isika.cda.galaxos.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import fr.isika.cda.galaxos.model.roles.Role;

@Entity
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(name = "type")
public class Adherent implements Serializable {
	    private static final long serialVersionUID = 1L;

	    
	    @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
	    

//	    @Enumerated(value = EnumType.STRING)
//	    private Role role = Role.ROLE_USER;
	    
	    @OneToMany @JoinColumn(name="adherent_id")
	    private List<Role> roles;
	    
	    @OneToOne
		@JoinColumn(name = "fkUser")
		private ComptUser user;
	    
	    @OneToOne
		@JoinColumn(name = "fkProfil")
		private Profil profil;
	    
	    @OneToOne
		@JoinColumn(name = "fkDashboard")
		private Dashboard board;

	    
	    public Long getId() {
			return id;
		}

		public Role getRole() {
			return role;
		}

		public ComptUser getUser() {
			return user;
		}

		public Profil getProfil() {
			return profil;
		}

		public Dashboard getBoard() {
			return board;
		}
		

		public Adherent() {
		}
	    
		@Override
		public int hashCode() {
			return Objects.hash(id, user);
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
			return Objects.equals(id, other.id) && Objects.equals(user, other.user);
		}

			@Override
			public String toString() {
				StringBuilder builder = new StringBuilder();
				
				builder.append("Profil [id=");
				builder.append(id);
				
				builder.append(", user=");
				builder.append(user);
				
				builder.append(", profil=");
				builder.append(profil);
				
				builder.append(", dashBoard=");
				builder.append(board);
				
				builder.append("]");
				
				return builder.toString();
			}
		
		
	   

}
