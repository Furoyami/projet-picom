package org.formation.picom.controller.rest;

import java.util.List;

import org.formation.picom.business.Zone;
import org.formation.picom.services.ZoneService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/api/")
public class ZoneRestController {
	
	ZoneService zoneService;
	
	@GetMapping("zones")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Zone> recupererZones(){
		return zoneService.recupererZones();
	}
	

}
