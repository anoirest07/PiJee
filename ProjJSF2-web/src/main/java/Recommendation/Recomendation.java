package Recommendation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import recommendationService.RecommendationSerRemote;

@ManagedBean
@RequestScoped
@JsonIgnoreProperties(ignoreUnknown=true)
public class Recomendation {
	@JsonProperty("EmailParticipent")
	private String EmailParticipent ;
	private String Nom ;
	private String Prenom;

	
	@EJB
	private RecommendationSerRemote rec ;
	Response j;
	@POST
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public void add()
	{
		 String jsonString = new JSONObject()
				 
                 .put("EmailParticipent", EmailParticipent)
                 .put("IdParticipant", 1).toString();
		 JSONObject jsonObject = new JSONObject(jsonString);
		 String mail = jsonObject.getString("EmailParticipent");
		 System.out.println(mail);
		 if(test(mail)==0){
		rec.Add(jsonString);
		FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("you have invited the person with this email "+mail+" to this event"));
	 sendSms();
		 }
		 else{
			 FacesContext.getCurrentInstance().addMessage(null,
		                new FacesMessage("the person with this email "+mail+"is already invited to this event"));
			 System.out.println("nooooo");
		 }
		 //rec.getByUser();
	}
	@GET
	
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Object> getByUser(){
		
		String lr= rec.getByUser();		       
        JSONArray array = new JSONArray(lr);
    	ArrayList<Object> al=new ArrayList<Object>();
        for (int i = 0; i < array.length(); i++) {
        	  al.add(array.get(i));
        }
        return al;
	}
@GET
	
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Object> getAll(){
		
		String lr= rec.getAll();		       
        JSONArray array = new JSONArray(lr);
    	ArrayList<Object> al=new ArrayList<Object>();
        for (int i = 0; i < array.length(); i++) {
        	  al.add(array.get(i));
        	//JSONObject obj =array.getJSONObject(i);
        	//System.out.println(obj.getString("description"));
        	//System.out.println(obj.getInt("id"));
        }
        return al;
	}
@GET

@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
public int test(String s){
	
	int lr= rec.test(s);		       
    
    return lr;
}
	public String getEmailParticipent() {
		return EmailParticipent;
	}
	public void setEmailParticipent(String EmailParticipent) {
		this.EmailParticipent = EmailParticipent;
	}
	public String sendSms() {
		try {
			// Construct data
			String apiKey = "apikey=" + "iDofBUf0/+M-JY4LPkhAC1gVrMNfucKt59YpT7O723";
			String message = "&message=" + "tou have been invited to this event";
			String sender = "&sender=" + "spiritus";
			String numbers = "&numbers=" + "+21628246709";
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}

}
