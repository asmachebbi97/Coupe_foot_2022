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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import antlr.collections.List;




@Entity
public class Equibe implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="equipeid")
	private Long id;
	private String nomEquipe;
	private String pays;
	private int nbreJoueur;
	private int nbrePoint;
	private int rang;
	@Lob
	private String imageequipe;
	private int nbMatchJoues;
	private int nbVictoires;
	private int nbPertes;
	private int nbEgalites;
	private TypePool pool;

	@JsonIgnore
	@OneToMany(mappedBy="equipes",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<MatchEquipe> mk = new HashSet<MatchEquipe>();

	public Equibe() {
		super();
	}

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNomEquipe() {
		return nomEquipe;
	}



	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}



	public String getPays() {
		return pays;
	}



	public void setPays(String pays) {
		this.pays = pays;
	}



	public int getNbreJoueur() {
		return nbreJoueur;
	}



	public void setNbreJoueur(int nbreJoueur) {
		this.nbreJoueur = nbreJoueur;
	}



	public int getNbrePoint() {
		return nbrePoint;
	}



	public void setNbrePoint(int nbrePoint) {
		this.nbrePoint = nbrePoint;
	}



	public int getRang() {
		return rang;
	}



	public void setRang(int rang) {
		this.rang = rang;
	}



	public String getImageequipe() {
		return imageequipe;
	}



	public void setImageequipe(String imageequipe) {
		this.imageequipe = imageequipe;
	}



	public int getNbMatchJoues() {
		return nbMatchJoues;
	}



	public void setNbMatchJoues(int nbMatchJoues) {
		this.nbMatchJoues = nbMatchJoues;
	}



	public int getNbVictoires() {
		return nbVictoires;
	}



	public void setNbVictoires(int nbVictoires) {
		this.nbVictoires = nbVictoires;
	}



	public int getNbPertes() {
		return nbPertes;
	}



	public void setNbPertes(int nbPertes) {
		this.nbPertes = nbPertes;
	}



	public int getNbEgalites() {
		return nbEgalites;
	}



	public void setNbEgalites(int nbEgalites) {
		this.nbEgalites = nbEgalites;
	}



	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public TypePool getPool() {
		return pool;
	}



	public void setPool(TypePool pool) {
		this.pool = pool;
	}



	@Override
	public String toString() {
		return "Equibe [id=" + id + ", nomEquipe=" + nomEquipe + ", pays=" + pays + ", nbreJoueur=" + nbreJoueur
				+ ", nbrePoint=" + nbrePoint + ", rang=" + rang + ", imageequipe=" + imageequipe + ", nbMatchJoues="
				+ nbMatchJoues + ", nbVictoires=" + nbVictoires + ", nbPertes=" + nbPertes + ", nbEgalites="
				+ nbEgalites + ", pool=" + pool + ", mk=" + mk + "]";
	}



	}

