package Qatar.com.entities;


import java.io.Serializable;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class MatchEquipe {


	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="meid")
	private Long id;
    
	@ManyToOne
	
    private Matche matchs;
 


    @ManyToOne
     private Equibe equipes;

 
    @Column
    private int nbbut;
    public Matche getMatch() {
		return matchs;
	}

	public void setMatch(Matche matchs) {
		this.matchs = matchs;
	}

	public Equibe getEquipe() {
		return equipes;
	}

	public void setEquipe(Equibe equipes) {
		this.equipes = equipes;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNbbut() {
		return nbbut;
	}



	public void setNbbut(int nbbut) {
		this.nbbut = nbbut;
	}
 
    

    



	
}
