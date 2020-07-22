package com.example.entities;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OP",
discriminatorType = DiscriminatorType.STRING, length=1)

public abstract class Operation implements Serializable {
	@Id @GeneratedValue
	private Long numero;
	private Date dateCreation;
	private double montant;
	
	@ManyToOne
	@JoinColumn(name="CODE_CPTE")
	private Compte compte ;
	
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(Date dateCreation, double montant, Compte compte) {
		super();
		this.dateCreation = dateCreation;
		this.montant = montant;
		this.compte = compte;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	

}
