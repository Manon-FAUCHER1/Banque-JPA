
package entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author manon
 *
 */
@Entity
@Table(name = "Client")
public class Client {

	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Nom", length = 50, nullable = false)
	private String nom;
	
	@Column(name = "Prenom", length = 50, nullable = false)
	private String prenom;
	
	@Column(name = "Date_Naissance", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@Embedded
	private Adresse adresse;
	
	//////////RELATION ///////////
	
	@ManyToOne
	@JoinColumn(name = "Id_Banque")
	private Banque banque;
	
	
	@ManyToMany
	@JoinTable(name="REL_CLIENT_COMPTE",
		joinColumns= @JoinColumn(name="ID_CLIENT", referencedColumnName="Id"),
		inverseJoinColumns= @JoinColumn(name="ID_COMPTE", referencedColumnName="Id")
	)
	private List<Compte> comptes;

	/**
	 * Constructor1
	 */
	public Client() {}
	
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public Banque getBanque() {
		return banque;
	}
	
	

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	
	
	public List<Compte> getComptes() {
		return comptes;
	}

	
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	
	
	@Override
	public String toString() {
		return "Client n°" + id + " : " + nom + " " + prenom + ", né le " + dateNaissance + "\n" 
				+ adresse;
	}

	
}
