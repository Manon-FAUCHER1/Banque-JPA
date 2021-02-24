
package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author manon
 *
 */
@Entity
@Table(name = "Operation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type")
public class Operation {
	
	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Date_Operation", nullable = false)
	private LocalDate date;
	
	@Column(name = "Montant", nullable = false)
	private double montant;
	
	@Column(name = "Motif", length = 50, nullable = true)
	private String motif;
	
	
	//////////RELATION ///////////
	
	@ManyToOne
	@JoinColumn(name = "Id_Compte")
	private Compte compte;


	/**
	 * Constructor
	 */
	public Operation() {
		super();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		
		this.montant = montant;
		
		Double solde = this.compte.getSolde();
		
		this.compte.setSolde(solde - this.montant);
		
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	


	@Override
	public String toString() {
		return "Operation du " + date + ": " + montant 
				+ "\nmotif=" + motif 
				+ "\ncompte :" + compte + "\n";
	}
	
	
}
