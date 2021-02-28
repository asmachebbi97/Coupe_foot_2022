package Qatar.com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
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
	private String imageArbitre;
	public Arbitre(String nom, String role, String salaire, String imageArbitre) {
		super();
		this.nom = nom;
		this.role = role;
		this.salaire = salaire;
		this.imageArbitre = imageArbitre;
	}
	public Arbitre save(@Valid Arbitre arbitre) {
		// TODO Auto-generated method stub
		return null;
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
				+ imageArbitre + "]";
	}
	

}
