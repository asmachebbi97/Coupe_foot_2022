package Qatar.com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import antlr.collections.List;


//import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Matche  implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)  
@Column(name="Matchid")
private Long idmatch;
private String nom;
private Date date;
private String heure;
private String lieu;
private String stade;

public Matche(){
	super();
}


//@JsonIgnore
@ManyToOne
Arbitre mk; 


@OneToMany(mappedBy="matchs",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
private Set<MatchEquipe> m = new HashSet<MatchEquipe>();



public Long getIdmatch() {
	return idmatch;
}
public void setIdmatch(Long idmatch) {
	this.idmatch = idmatch;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getHeure() {
	return heure;
}
public void setHeure(String heure) {
	this.heure = heure;
}
public String getLieu() {
	return lieu;
}
public void setLieu(String lieu) {
	this.lieu = lieu;
}
public String getStade() {
	return stade;
}
public void setStade(String stade) {
	this.stade = stade;
}


public Arbitre getMk() {
	return mk;
}
public void setMk(Arbitre mk) {
	this.mk = mk;
}


public Set<MatchEquipe> getM() {
	return m;
}
public void setM(Set<MatchEquipe> m) {
	this.m = m;
}


}
