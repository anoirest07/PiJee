package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import Persistence.Tache;


import com.google.gson.Gson;







@Stateful
@LocalBean
public class TacheService implements TacheServiceLocal,TacheServiceRemote {
	public Date d= new Date();
	@Override
	public String GetListTaches() {
		// TODO Auto-generated method stub
		
		Client client =ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:59686/api/Taches");
		Response response= target.request().get();
		String result= response.readEntity(String.class);
		System.out.println(result);
		return result;
	}
	
	@Override
	public List<Tache> gettoutelestaches() {
			System.out.println("***** get list toute les taches *****");
	    	Client cl = ClientBuilder.newClient();
			WebTarget target = cl.target("http://localhost:59686/api/Taches"); 
			//WebTarget hello = target.path("MesTaches/"+id);     	
			Response response= target.request().get();
			String result = response.readEntity(String.class);
			
			List<String> list = new ArrayList<String>();
			while(result.contains("{")) {
				String usr = result.substring(result.indexOf("{")+1, result.indexOf("}"));
				result = result.replace("{"+usr+"}","");
				list.add("{"+usr+"}");
			}
	    	
	    	System.out.println("ceci est la date --------");
	    	System.out.println(d);
	    	List<Tache> taches = new ArrayList<Tache>();
	    	Gson gson = new Gson();
			for(String item : list) {
				Tache tache = gson.fromJson(item , Tache.class);
				try {
					tache.set_DeadlineTache(new SimpleDateFormat("yyyy-MM-dd").parse(tache.getDeadlineTache()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				taches.add(tache);
				System.out.println(tache);
			}
			return taches;
	    }
	@Override
	public Tache getdetail(int id) {
		System.out.println("***** get list toute les taches *****");
    	Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("localhost:59686/api/TacheAPI/"+id); 
		//WebTarget hello = target.path("MesTaches/"+id);     	
		Response response= target.request().get();
		String result = response.readEntity(String.class);
		
		List<String> list = new ArrayList<String>();
		while(result.contains("{")) {
			String usr = result.substring(result.indexOf("{")+1, result.indexOf("}"));
			result = result.replace("{"+usr+"}","");
			list.add("{"+usr+"}");
		}
    	
    	
    	Tache tache = new Tache();
    	Gson gson = new Gson();
		for(String item : list) {
			 tache = gson.fromJson(item , Tache.class);
			//try {
			//	tache.set_DeadlineTache(new SimpleDateFormat("dd/MM/yyyy").parse(tache.getDeadlineTache()));
			//} catch (ParseException e) {
		//		e.printStackTrace();
		//	}
			
		}
		return tache;
	    }
	
	
	@Override
	public List<Tache> getById(int id) {
			System.out.println("***** get mes taches *****");
	    	Client cl = ClientBuilder.newClient();
			WebTarget target = cl.target("http://localhost:59686/api/MesTaches/"+id); 
			//WebTarget hello = target.path("MesTaches/"+id);     	
			Response response= target.request().get();
			String result = response.readEntity(String.class);
			
			List<String> list = new ArrayList<String>();
			while(result.contains("{")) {
				String usr = result.substring(result.indexOf("{")+1, result.indexOf("}"));
				result = result.replace("{"+usr+"}","");
				list.add("{"+usr+"}");
			}
	    	
	    	
	    	List<Tache> taches = new ArrayList<Tache>();
	    	Gson gson = new Gson();
			for(String item : list) {
				Tache tache = gson.fromJson(item , Tache.class);
				//try {
				//	tache.set_DeadlineTache(new SimpleDateFormat("dd/MM/yyyy").parse(tache.getDeadlineTache()));
				//} catch (ParseException e) {
			//		e.printStackTrace();
			//	}
				taches.add(tache);
				System.out.println(tache);
			}
			return taches;
	    }
	@Override
	public String getmestache(int id) {
//			System.out.println("***** get condidate *****");
//	    	Client cl = ClientBuilder.newClient();
//			WebTarget target = cl.target("http://localhost:59686/api/MesTaches/"+id); 
//			//WebTarget hello = target.path("MesTaches/"+id);     	
//			Response response= target.request().get();
//			String result = response.readEntity(String.class);
//			
//			List<String> list = new ArrayList<String>();
//			while(result.contains("{")) {
//				String usr = result.substring(result.indexOf("{")+1, result.indexOf("}"));
//				result = result.replace("{"+usr+"}","");
//				list.add("{"+usr+"}");
//			}
//	    	
//	    	
//	    	List<Tache> taches = new ArrayList<Tache>();
//	    	Gson gson = new Gson();
//			for(String item : list) {
//				Tache tache = gson.fromJson(item , Tache.class);
//				try {
//					tache.set_DeadlineTache(new SimpleDateFormat("dd/MM/yyyy").parse(tache.getDeadlineTache()));
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
//				taches.add(tache);
//				System.out.println(tache);
//			}
//			return result;
		
		Client client =ClientBuilder.newClient();
		WebTarget target= client.target("http://localhost:59686/api/MesTaches/"+id);
		Response response= target.request().get();
		String result= response.readEntity(String.class);
		System.out.println(result);
		return result;
	    }

}
