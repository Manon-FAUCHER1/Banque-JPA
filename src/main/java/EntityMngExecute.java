import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Adresse;
import entities.AssuranceVie;
import entities.Banque;
import entities.Client;
import entities.Compte;
import entities.LivretA;
import entities.Operation;
import entities.Virement;

/**
 * 
 */

/**
 * @author manon
 *
 */
public class EntityMngExecute {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityMngExecute.insert(em);
		
	}
	
	
	public static void insert(EntityManager em) {
		
		////////// BANQUES ///////////////
		
		Banque banque1 = new Banque();
		banque1.setNom("BNP Paribas");
		
		////////// CLIENT 1 ///////////////
		
		Adresse adresse1 = new Adresse(31, "Avenue du général Leclerc", 92340, "BOURG LA REINE");
		
		Client client1 = new Client();
		client1.setPrenom("Jean");
		client1.setNom("MOULIN");		
		client1.setAdresse(adresse1);
		client1.setBanque(banque1);
		

		////////// CLIENT 2 ///////////////
		
		Adresse adresse2 = new Adresse(64, "Rue de l'eglise", 33380, "MIOS");
		
		Client client2 = new Client();
		client2.setPrenom("Claude");
		client2.setNom("MONET");
		client2.setAdresse(adresse2);
		client2.setBanque(banque1);
		
		///////// COMPTE 1 : CLIENT 1 & CLIENT 2 /////////////////
		
		Compte compte1 = new Compte();
		compte1.setNumero("FR7630001007941234567890185");
		compte1.setSolde(1652.326);
		
		List<Client> listClients = new ArrayList<>();
		listClients.add(client1);
		listClients.add(client2);
		
		compte1.setClients(listClients);
		
		///////// OPERATION TYPE OPERATION /////////////
		
		Operation op = new Operation();
		op.setCompte(compte1);
		op.setMontant(375);
		op.setDate(LocalDate.of(2021, 2, 24));
		
		
		////////// CLIENT 3 : LIVRETA 1 & ASSURANCE VIE 1 //////////////
		
		Adresse adresse3 = new Adresse(15, "Boulevard des Tribunes", 4430, "NANTES");
		
		Client client3 = new Client();
		client3.setPrenom("James");
		client3.setNom("BOND");
		client3.setAdresse(adresse3);
		client3.setBanque(banque1);
	
		LivretA livretA1 = new LivretA();
		livretA1.setNumero("FR7630004000031234567890143");
		livretA1.setSolde(210);
		livretA1.setTaux(1.6);
		
		AssuranceVie assuranceVie1 = new AssuranceVie();
		assuranceVie1.setNumero("FR7630076020821234567890186");
		assuranceVie1.setSolde(1235.36);
		assuranceVie1.setTaux(2);
		
		List<Compte> listComptes = new ArrayList<>();
		listComptes.add(livretA1);
		listComptes.add(assuranceVie1);
		
		client3.setComptes(listComptes);
		
		///////// OPERATION TYPE VIREMENT /////////////
		
		Virement virement = new Virement();
		virement.setMotif("LOYER");
		virement.setDate(LocalDate.of(2021, 2, 24));
		virement.setCompte(livretA1);
		virement.setMontant(230);
		virement.setBeneficiaire("Mr TROU");
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		///////// PERSIST ////////////
		em.persist(banque1);
		em.persist(client1);
		em.persist(client2);
		em.persist(compte1);
		em.persist(op);
		em.persist(client3);
		em.persist(livretA1);
		em.persist(assuranceVie1);
		em.persist(virement);
		
		transaction.commit();
		
		
		
	}

}
