package Qatar.com.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Arbitre implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="Arbitreid")
	private Long id;
	private String nom;
	private String role;
	private String salaire;
	@Lob
	private String imageArbitre;
	
	@JsonIgnore
	@OneToMany(mappedBy="mk",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Matche> mats = new HashSet<Matche>();
	

	

	public Arbitre() {
		
	}
	
	public Arbitre(Long id, String nom, String role, String salaire, String imageArbitre, Set<Matche> mats) {
		super();
		this.id = id;
		this.nom = nom;
		this.role = role;
		this.salaire = salaire;
		this.imageArbitre = imageArbitre;
		this.mats = mats;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSalaire() {
		return salaire;
	}
	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}
	public String getImageArbitre() {
		return imageArbitre;
	}
	public void setImageArbitre(String imageArbitre) {
		this.imageArbitre = imageArbitre;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Arbitre [id=" + id + ", nom=" + nom + ", role=" + role + ", salaire=" + salaire + ", imageArbitre="
				+ imageArbitre + ", matchs=" + mats + "]";
	}
	public Set<Matche> getMats() {
		return mats;
	}
	public void setMats(Set<Matche> mats) {
		this.mats = mats;
	}


	

}
