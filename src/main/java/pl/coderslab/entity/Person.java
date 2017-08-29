package pl.coderslab.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Person")
public class Person {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    public Person() {
	}
        
	public Person(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
	}

	private String login;
	private String password;
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
	
}
