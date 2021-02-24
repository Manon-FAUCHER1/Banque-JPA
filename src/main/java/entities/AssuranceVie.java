/**
 * 
 */
package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author manon
 *
 */
@Entity
@DiscriminatorValue("Assurance_Vie")
public class AssuranceVie extends Compte {
	
	@Column(name = "Date_Fin", nullable = true)		
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	@Column(name = "Taux", nullable = true)		
	private double taux;
	
	
	/**
	 * Constructor
	 */
	public AssuranceVie() {}

	////////// GETTERS & SETTERS ///////////

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	@Override
	public String toString() {
		return "Assurance Vie a taux " + taux + ", date de fin " + dateFin + "\n";
	}
	
}
