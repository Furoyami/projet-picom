package org.formation.picom.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.formation.picom.business.Client;
import org.formation.picom.business.TrancheHoraire;
import org.formation.picom.business.Zone;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnnonceDto {
	
	private LocalDateTime dateHeureCreation;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime dateHeureDebut;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Future(message = "La date de fin doit être dans le future")
	private LocalDateTime dateHeureFin;
	private String contenu;
//	@CreditCardNumber
	@NotEmpty(message = "Veuillez entrer un numéro de carte")
	private String numeroCarte;

	@NotNull(message = "Veuillez entrer une année d'expiration")
	private int anneeExpiration;

	@NotNull(message = "Veuillez entrer un mois d'expiration")
	private String moisExpiration;

	@NotEmpty(message = "Veuillez entrer un cryptogramme")
	private String cryptogramme;

	private double montantRegleEnEuros;

	@ManyToOne
	private Client client;
	@ManyToMany
	private List<Zone> lstZones;
	@ManyToMany
	private List<TrancheHoraire> lstTrancheHoraires;
}
