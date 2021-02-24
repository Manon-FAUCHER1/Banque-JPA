
package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author manon
 *
 */
@Entity
@Table(name = "Banque")
public class Banque {

	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Nom", length = 100, nullable = false)
	private String nom;

	////////// RELATION ///////////
	
	@OneToMany(mappedBy = "banque")
	private List<Client> clients;
	
	
	/**
	 * Constructor
	 */
	public Banque() {}
	
	////////// GETTERS & SETTERS ///////////

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Banque : " + nom + "\n";
	}
	
	
	
	
}
