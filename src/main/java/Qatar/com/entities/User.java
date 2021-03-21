package Qatar.com.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;





@Entity
public class User  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="userid")
	private Long id;
	private String username;
	private String email;
	private String pwd;
	private String fname;
	private String lname;
	private String imageuser;
	
	//@ManyToMany(mappedBy="users",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
		//@ManyToMany(mappedBy="users",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
		@JsonIgnore
		
		 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(name = "USER_ROLES", joinColumns = {
	            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
	            @JoinColumn(name = "ROLE_ID") })
	    private Set<Role> roles;
	
	public Long getId() {
		return id;
	}
	
	public User() {
		super();
	}
	
	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
	public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
	
	
	
	
	

}
