package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author manon
 */
@Entity
@DiscriminatorValue("LivretA")
public class LivretA extends Compte {
	
	@Column(name = "Taux", nullable = true)		
	private double taux;

	/**
	 * Constructor
	 */
	public LivretA() {}

	
	////////// GETTERS & SETTERS ///////////
	
	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}


	
	@Override
	public String toString() {
		return "LivretA a taux " + taux + "\n";
	}

	




}
