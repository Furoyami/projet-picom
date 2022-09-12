package org.formation.picom.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	
	
//	@NonNull
	@NotNull(message = "Merci d'indiquer une date de début")
	private LocalDateTime dateHeureDebut;
	
//	@NonNull
	@NotBlank(message = "Merci de renseigner le contenu de l'annonce")
	private String contenu;
	
//	@CreditCardNumber
	@NotEmpty(message = "Veuillez entrer un numéro de carte")
	private String numeroCarte;

//	@NonNull
	@NotNull(message = "Veuillez entrer une année d'expiration")
	private Integer anneeExpiration;

//	@NonNull
	@NotNull(message = "Veuillez entrer un mois d'expiration")
	private String moisExpiration;

//	@NonNull
	@NotEmpty(message = "Veuillez entrer un cryptogramme")
	private String cryptogramme;

//	@NonNull
	@NotNull(message = "Veuillez entrer un montant")
	private Double montantRegleEnEuros;

//	@NonNull
	@NotNull(message = "Veuillez renseigner le client.")
	private Long client;
	
//	@NonNull
	@NotEmpty(message = "Veuillez renseigner les tranches horaires.")
	private List<Long> lstZones;
	
//	@NonNull
	@NotEmpty(message = "Veuillez renseigner les zones.")
	private List<Long> lstTrancheHoraires;
}
