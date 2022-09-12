package org.formation.picom.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@RequiredArgsConstructor
public class TrancheHoraire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int debut;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "lstTrancheHoraires")
	@ToString.Exclude
	private List<Annonce> lstAnnonces;
	
	public String getTrancheHoraireFormatee() {
		return debut + "h";
	}
	
}
