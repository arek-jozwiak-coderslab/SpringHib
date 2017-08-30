package pl.coderslab.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import pl.coderslab.validator.StartWith;

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

	@OneToOne
	private PersonDetails personDetails;

	@ManyToOne
	@JoinColumn(name = "person_group_id")
	private PersonGroup personGroup;

	public PersonGroup getPersonGroup() {
		return personGroup;
	}

	public void setPersonGroup(PersonGroup personGroup) {
		this.personGroup = personGroup;
	}
	@StartWith
	private String login;
	@NotNull
	@Size(min = 2, max = 30)
	private String password;
	@NotBlank
	private String email;

	public PersonDetails getPersonDetails() {
		return personDetails;
	}

	public void setPersonDetails(PersonDetails personDetails) {
		this.personDetails = personDetails;
	}

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
