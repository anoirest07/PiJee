package services;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import entities.Reclamation;
import com.google.gson.Gson;




@Stateful
@LocalBean
public class ConsommationReclamation implements ConsommationReclamationLocale, ConsommationReclamationRemote {
	
	
	@Override
	public String Consommation() {
		// TODO Auto-generated method stub
		
		Client client =ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:59686/api/ApiReclamation/GetAll");
		Response response= target.request().get();
		String result= response.readEntity(String.class);
		System.out.println(result);
		return result;
	}


	
	@Override
	public List<Reclamation> getById(int ID) {
			System.out.println("***** get condidate *****");
	    	Client cl = ClientBuilder.newClient();
			WebTarget target = cl.target("http://localhost:59686/api/getRecmlamation/"+ID); 
			//WebTarget hello = target.path("MesTaches/"+id);     	
			Response response= target.request().get();
			String result = response.readEntity(String.class);
			
			List<String> list = new ArrayList<String>();
			while(result.contains("{")) {
				String usr = result.substring(result.indexOf("{")+1, result.indexOf("}"));
				result = result.replace("{"+usr+"}","");
				list.add("{"+usr+"}");
			}
	    	
	    	
	    	List<Reclamation> reclamations = new ArrayList<Reclamation>();
	    	Gson gson = new Gson();
			for(String item : list) {
				Reclamation reclamation = gson.fromJson(item , Reclamation.class);
				reclamations.add(reclamation);
				System.out.println(reclamation);
			}
			return reclamations;
	    }
	


}
