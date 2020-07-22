
//HEROKU

package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person implements Serializable {

	@Id
	@GeneratedValue
	
	@Column (name = "idperson")
	private Long idPerson;
	private String name;
	
	@Column (name = "familyname")
	private String familyName;
	private String adresse;
	private String mail;
	private String phone;
	
	
	public Person() {
		super();
	}


	public Long getIdPerson() {
		return idPerson;
	}


	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFamilyName() {
		return familyName;
	}


	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
