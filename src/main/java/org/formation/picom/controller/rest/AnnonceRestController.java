package org.formation.picom.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.formation.picom.business.Annonce;
import org.formation.picom.dto.AnnonceDto;
import org.formation.picom.services.AnnonceService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/")
public class AnnonceRestController {
	
	AnnonceService annonceService;
	
	@GetMapping("annonces")
	public List<Annonce> recupererAnnonces(){
		return annonceService.recupererAnnonces();
	}
	
	@PostMapping("ajoutAnnnonce")
	@ResponseStatus(code =  HttpStatus.CREATED)
	public Annonce ajouterAnnonce(@Valid @RequestBody AnnonceDto annonceDto, BindingResult result) {
		
		Annonce annonce = new Annonce();
		annonce.setDateHeureCreation(annonceDto.getDateHeureCreation());
		annonce.setDateHeureDebut(annonceDto.getDateHeureDebut());
		annonce.setDateHeureFin(annonceDto.getDateHeureFin());
		annonce.setContenu(annonceDto.getContenu());
		annonce.setNumeroCarte(annonceDto.getNumeroCarte());
		annonce.setAnneeExpiration(annonceDto.getAnneeExpiration());
		annonce.setMoisExpiration(annonceDto.getMoisExpiration());
		annonce.setCryptogramme(annonceDto.getCryptogramme());
		annonce.setMontantRegleEnEuros(annonceDto.getMontantRegleEnEuros());
		annonce.setClient(annonceDto.getClient());
		annonce.setLstZones(annonceDto.getLstZones());
		annonce.setLstTrancheHoraires(annonceDto.getLstTrancheHoraires());
		return annonceService.enregistrerAnnonce(annonce);
		
		
	}

}
