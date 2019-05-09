package Rest;

import java.util.ArrayList;

import javax.ejb.EJB;

import org.primefaces.json.JSONArray;

import services.Test1Remote;

public class EventResource {

	@EJB
	private Test1Remote rec ;


	public void add()
	{
		
//		Event event = new Event();
//		 String jsonString = new JSONObject()
//				.put("NomEvent", event.getNomEvent())
//                 .put("TeamFK", 4).toString();
//		rec.Add(jsonString);
		 //rec.getByUser();
	}

	

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
}
