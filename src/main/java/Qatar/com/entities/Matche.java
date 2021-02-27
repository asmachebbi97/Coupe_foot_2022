package Qatar.com.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Matche{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)  
@Column(name="Matchid")
private Long idmatch;
private String nom;
private Date date;
private int heure;
private Long lieu;
private String stade;
private Long idequipe1;
private Long idequipe2;
private Long idarbitre;
public Matche(){
	super();
}

public Matche(Long idmatch, String nom, Date date, int heure, Long lieu, String stade, Long idequipe1, Long idequipe2,
		Long idarbitre) {
	super();
	this.idmatch = idmatch;
	this.nom = nom;
	this.date = date;
	this.heure = heure;
	this.lieu = lieu;
	this.stade = stade;
	this.idequipe1 = idequipe1;
	this.idequipe2 = idequipe2;
	this.idarbitre = idarbitre;
}

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
public int getHeure() {
	return heure;
}
public void setHeure(int heure) {
	this.heure = heure;
}
public Long getLieu() {
	return lieu;
}
public void setLieu(Long lieu) {
	this.lieu = lieu;
}
public String getStade() {
	return stade;
}
public void setStade(String stade) {
	this.stade = stade;
}
public Long getIdequipe1() {
	return idequipe1;
}
public void setIdequipe1(Long idequipe1) {
	this.idequipe1 = idequipe1;
}
public Long getIdequipe2() {
	return idequipe2;
}
public void setIdequipe2(Long idequipe2) {
	this.idequipe2 = idequipe2;
}
public Long getIdarbitre() {
	return idarbitre;
}
public void setIdarbitre(Long idarbitre) {
	this.idarbitre = idarbitre;
}

}
