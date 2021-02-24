/**
 * 
 */
package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author manon
 *
 */
@Embeddable
public class Adresse {

	@Column(name = "Numero", nullable = true)
	private int numero;
	
	@Column(name = "Rue", nullable = true)
	private String rue;
	
	@Column(name = "Code_Postal", nullable = true)
	private int codePostal;
	
	@Column(name = "Ville", nullable = true)
	private String ville;
	
	/**
	 * Constructor
	 */
	public Adresse() {}
	

	/**
	 * Constructor
	 * @param numero
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Adresse(int numero, String rue, int codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	////////// GETTERS & SETTERS ///////////

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	
	@Override
	public String toString() {
		return "Adresse : " + numero + " " + rue + ", " + codePostal + " " + ville + "\n";
	}
	
	
}
