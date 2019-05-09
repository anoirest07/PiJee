package Model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Event {
	
	@JsonProperty("NomEvent")
	private String nomEvent;
	@JsonProperty("DescriptionEvent")
	private String descriptionEvent;
	@JsonProperty("LocationEvent")
	private String locationEvent;
	@JsonProperty("DateEventDebut")
	private Date dateEventDebut;
	@JsonProperty("DateEventFin")
	private Date dateEventFin;
	@JsonProperty("NbPlaceEvent")
	private int nbPlaceEvent;
	private String style = "table-danger";
	
	
	
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getNomEvent() {
		return nomEvent;
	}
	public void setNomEvent(String nomEvent) {
		this.nomEvent = nomEvent;
	}
	public String getDescriptionEvent() {
		return descriptionEvent;
	}
	public void setDescriptionEvent(String descriptionEvent) {
		this.descriptionEvent = descriptionEvent;
	}
	public String getLocationEvent() {
		return locationEvent;
	}
	public void setLocationEvent(String locationEvent) {
		this.locationEvent = locationEvent;
	}
	public Date getDateEventDebut() {
		return dateEventDebut;
	}
	public void setDateEventDebut(Date dateEventDebut) {
		this.dateEventDebut = dateEventDebut;
	}
	public Date getDateEventFin() {
		return dateEventFin;
	}
	public void setDateEventFin(Date dateEventFin) {
		this.dateEventFin = dateEventFin;
	}
	public int getNbPlaceEvent() {
		return nbPlaceEvent;
	}
	public void setNbPlaceEvent(int nbPlaceEvent) {
		this.nbPlaceEvent = nbPlaceEvent;
	}

	
	
}
