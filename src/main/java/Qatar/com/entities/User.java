package Qatar.com.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class User  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="userid")
	private Long id;
	private String email;
	private String pwd;
	private String fname;
	private String lname;
	private String imageuser;
	
	//@ManyToMany(mappedBy="users",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
		//@ManyToMany(mappedBy="users",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
		@JsonIgnore
		
	
	
	public Long getId() {
		return id;
	}
	
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}



	public String getImageuser() {
		return imageuser;
	}



	public void setImageuser(String imageuser) {
		this.imageuser = imageuser;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", pwd=" + pwd + ", fname=" + fname + ", lname=" + lname
				+ ", imageuser=" + imageuser + "]";
	}
	
	
	
	
	

}
