package Reclamation;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.annotate.JsonProperty;
import org.primefaces.json.JSONArray;


import services.TestRemote;


@ManagedBean(name="reclamlation")
@SessionScoped
public class Reclamation  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int ID;
	private String  Descriptions;
	private int IdEvent;
	private int Idpar;
	
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDescriptions() {
		return Descriptions;
	}
	public void setDescriptions(String descriptions) {
		Descriptions = descriptions;
	}
	public int getIdEvent() {
		return IdEvent;
	}
	public void setIdEvent(int idEvent) {
		IdEvent = idEvent;
	}
	public int getIdpar() {
		return Idpar;
	}
	public void setIdpar(int idpar) {
		Idpar = idpar;
	}
	public ArrayList<Object> getListdata() {
		return listdata;
	}
	public void setListdata(ArrayList<Object> listdata) {
		this.listdata = listdata;
	}
	public Reclamation getSug() {
		return sug;
	}
	public void setSug(Reclamation sug) {
		this.sug = sug;
	}


	ArrayList<Object> listdata= new ArrayList<Object>();	
	private List<entities.Reclamation> lsttaches;
	public List<entities.Reclamation> getLsttaches() {
		return lsttaches;
	}
	public void setLsttaches(List<entities.Reclamation> lsttaches) {
		this.lsttaches = lsttaches;
	}
	
	
	@EJB
	Reclamation sug;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Object> getAll(){
		List<entities.Reclamation> lr= sug.getLsttaches();
		JSONArray array= new JSONArray(lr);
		ArrayList<Object> listdata=new ArrayList<Object>();
		
		if(array!= null){
			for(int i=0; i<array.length(); i++){
				
				
				listdata.add(array.get(i));

				
			}
		}
		return listdata;
	}

	
	
}
