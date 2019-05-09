package recommendationService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Stateless
@LocalBean

public class RecommendationSer implements RecommendationSerLocale,RecommendationSerRemote {
	
	@Override
	public void Consommation() {
		// create new jax-rs Client
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:59686/api/Recomendations");
		WebTarget hello =target.path("");
		Response response =hello.request().get();
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}
	public String Add(String s )
	{
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:59686/api/addReclamation");
		Invocation.Builder invocationBuilder = target.request();
		Response response = invocationBuilder.post(Entity.entity(s, MediaType.APPLICATION_JSON));
		return response.readEntity(String.class);
	}
	
	
	
	static javax.ws.rs.client.Client c= ClientBuilder.newClient();
    //set the appropriate URL
	static String getUrl = "http://localhost:59686/api/Recomendations";
	public String getAll(){
		
		String lr = c.target(getUrl).request().get().readEntity(String.class);
		return lr;
	}
	
	public String getByUser(){
		
		String lr = c.target("http://localhost:59686/api/ApiRecommendation/GetByU?id="+1).request().get().readEntity(String.class);
		return lr;
	}
	
public int test(String mail ){
		
		String lr = c.target("http://localhost:59686/api/ApiRecommendation/test?mail="+mail+"&id="+3).request().get().readEntity(String.class);
		 int count=Integer.parseInt(lr);
		return count;
	}
}
