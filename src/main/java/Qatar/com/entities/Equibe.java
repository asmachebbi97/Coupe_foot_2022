package Qatar.com.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//import Qatar.com.entities.Joueur;
//import Qatar.com.entities.Match;


@Entity
public class Equibe implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="equibeid")
	private Long id;
	private String nomEquibe;
	private String pays;
	private int nbreJoueur;
	private int nbrePoint;
	private int rang;
	
	/*@ManyToOne//(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
	//@JsonIgnore
	private Joueur joueur;*/
	//@OneToMany(mappedBy="Equibe",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	//private Set<Joueur> joueurs;
	//private Set<Match> matchs;
	
	public Equibe(Long id, String nomeEquibe,String pays, int nbreJoueur, int nbrePoint, int rang  /*Set<Joueur> joueurs ,Set<Match> matchs*/) {
		super();
		this.id = id;
		this.nomEquibe = nomEquibe;
		this.pays = pays;
		this.nbreJoueur = nbreJoueur;
		this.nbrePoint = nbrePoint;
		this.rang = rang;
		
		//this.joueurs = joueurs;
		//this.matchs = matchs ;
	}

	public Equibe() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomEquibe() {
		return nomEquibe;
	}

	public void setNomEquibe(String nomEquibe) {
		this.nomEquibe= nomEquibe;
	}

	
	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	
	
	public int getNbrePoint() {
		return nbrePoint;
	}

	public void setNbrePoint(int nbrePoint) {
		this.nbrePoint =nbrePoint;
	}

	
	public int getRang() {
		return nbreJoueur;
	}

	public void setRang(int rang) {
		this.rang =rang;
	}
	
	
	public int getnbreJoueur() {
		return nbreJoueur;
	}

	public void setnbreJoueur(int nbreJoueur) {
		this.nbreJoueur =nbreJoueur;
	}
	
	
	
	/*public Set<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(Set<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	
	public Set<Match> getMatchs() {
		return matchs;
	}

	public void setMatchs(Set<Match> matchs) {
		this.matchs = matchs;
	}
	*/

	@Override
	public String toString() {
		return "Categorie [id=" + id + ",nomequibe=" + nomEquibe + ",pays=" + pays + ",nbreJoueur=" + nbreJoueur + ",nbrePoint=" + nbrePoint +",rang=" + rang + /*matchs =" + matchs + ", joueurs=" + joueurs +*/ "]";
	}

	
	

}
