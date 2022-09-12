package org.formation.picom.initialisation;

import java.time.LocalDateTime;

import org.formation.picom.business.Administrateur;
import org.formation.picom.business.Annonce;
import org.formation.picom.business.Arret;
import org.formation.picom.business.Client;
import org.formation.picom.business.TrancheHoraire;
import org.formation.picom.business.Zone;
import org.formation.picom.dao.AnnonceDao;
import org.formation.picom.dao.ArretDao;
import org.formation.picom.dao.TrancheHoraireDao;
import org.formation.picom.dao.UtilisateurDao;
import org.formation.picom.dao.ZoneDao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

	private final UtilisateurDao utilisateurDao;
	private final ZoneDao zoneDao;
	private final ArretDao arretDao;
	private final TrancheHoraireDao trancheHoraireDao;
	private final AnnonceDao annonceDao;

	@Override
	public void run(String... args) throws Exception {
		ajouterAdministrateur();
		ajouterClient();
		ajouterZone();
		ajouterArrets();
		ajouterTrancheHoraire();
		ajouterAnnonce();

	}

	public void ajouterAdministrateur() {
		Administrateur administrateur = new Administrateur();
		administrateur.setNom("Pochet");
		administrateur.setPrenom("Jennifer");
		administrateur.setEmail("admin1@orsys.fr");
		administrateur.setMotDePasse("12345678");

		utilisateurDao.save(administrateur);
	}

	private void ajouterClient() {

		Client client = new Client();
		client.setNom("Lamontagne");
		client.setPrenom("Neville");
		client.setEmail("client1@orsys.fr");
		client.setMotDePasse("12345678");
		client.setNumeroDeTelephone("0798765432");
		utilisateurDao.save(client);
	}

	public void ajouterZone() {
		for (int i = 0; i < 5; i++) {
			Zone zone = new Zone();
			zone.setNom("zone " + (i + 1));
			zoneDao.save(zone);
		}
	}

	public void ajouterArrets() {
		for (int i = 0; i < 20; i++) {
			Arret arret = new Arret();
			arret.setNom("arret" + (i + 1));
			arretDao.save(arret);
		}
	}

	public void ajouterTrancheHoraire() {
		for (int i = 6; i < 20; i++) {
			TrancheHoraire trancheHoraire = new TrancheHoraire();
			trancheHoraire.setDebut(i);
			trancheHoraireDao.save(trancheHoraire);
		}

	}

	public void ajouterAnnonce() {
		for (int i = 1; i < 6; i++) {
		Annonce annonce = new Annonce();
		annonce.setDateHeureCreation(LocalDateTime.now());
		annonce.setDateHeureDebut(LocalDateTime.of(2002, 12, 15, 18, 0));
		annonce.setDateHeureFin(LocalDateTime.of(2022, 12, 17, 19, 0));
		annonce.setContenu("annonce test" + i);
		annonce.setNumeroCarte("0000111122223333");
		annonce.setAnneeExpiration(2022);
		annonce.setMoisExpiration("12");
		annonce.setCryptogramme("333");
		annonce.setMontantRegleEnEuros(0d);
		annonceDao.save(annonce);
		}
	}

}