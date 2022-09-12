package org.formation.picom.controller.rest;

import java.util.List;

import org.formation.picom.business.TrancheHoraire;
import org.formation.picom.services.TrancheHoraireService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/")
public class TrancheHoraireRestController {
	
	TrancheHoraireService trancheHoraireService;
	
	@GetMapping("trancheHoraires")
	@ResponseStatus(code = HttpStatus.OK)
	public List<TrancheHoraire> recupererTrancheHoraires(){
		return trancheHoraireService.recupererTrancheHoraire();
	}

}
