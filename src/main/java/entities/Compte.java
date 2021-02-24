
package entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author manon
 *
 */
@Entity
@Table(name = "Compte")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type")
public class Compte {

	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Numero", length = 50, nullable = false)
	private String numero;
	
	@Column(name = "Solde", length = 50, nullable = false)
	private double solde;
	
	//////////RELATION ///////////
	
	@ManyToMany
	@JoinTable(name="REL_CLIENT_COMPTE",
		joinColumns= @JoinColumn(name="ID_COMPTE", referencedColumnName="ID"),
		inverseJoinColumns= @JoinColumn(name="ID_CLIENT", referencedColumnName="ID")
	)
	private List<Client> clients;
	
	@OneToMany(mappedBy="compte")
	private List<Operation> operations;

	/**
	 * Constructor
	 */
	public Compte() {}
	
	////////// GETTERS & SETTERS ///////////

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	@Override
	public String toString() {
		return "Compte n°" + numero + " solde : " + solde + "\n";
	}
	
	
}
