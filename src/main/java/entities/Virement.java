package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.print.attribute.standard.MediaSize.NA;



/**
 * @author manon
 */
@Entity
@DiscriminatorValue("Virement")
public class Virement extends Operation {
	
	@Column(name = "Beneficiaire", nullable = true)
	private String beneficiaire;

	/**
	 * Constructor
	 */
	public Virement() {}
	
	
	////////// GETTERS & SETTERS ///////////

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}


	@Override
	public String toString() {
		return "Virement pour " + beneficiaire + "\n";
	}
	
	

}
