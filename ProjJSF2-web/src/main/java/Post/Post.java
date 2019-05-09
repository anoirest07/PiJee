package Post;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;

import PostService.PostSerRemote;


@ManagedBean
@RequestScoped
public class Post {
	private String Title ;
	private String Description ;
	private int Like;
	@EJB
	private PostSerRemote rec ;

	
	Response j;
	@POST
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public void add()
	{
		 String jsonString = new JSONObject()
                 .put("Title", Title)
                 .put("Description", Description)
                 .put("ParticipantId", 1).toString();
		rec.Add(jsonString);
		 //rec.getByUser();
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
	public ArrayList<Object> getTopPost(){
	
		String lr= rec.getTopPost();		       
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

	public String getTitle() {
		return Title;
	}
	public void setTitle(String Title) {
		this.Title = Title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String Description) {
		this.Description = Description;
	}
	public int getLike() {
		return Like;
	}
	public void setLike(int Like) {
		this.Like = Like;
	}
	
	}
