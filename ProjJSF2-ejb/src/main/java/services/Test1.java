package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
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
public class Test1 implements Test1Remote, Test1Locale {

	@Override
	public void Consommation() {
		// create new jax-rs Client
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:59686/api/ApiEvent/Create");
		WebTarget hello = target.path("");
		Response response = hello.request().get();

		String result = response.readEntity(String.class);
		System.out.println(result);

		response.close();

	}

	@Override
	public String Add(String s) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:59686/api/ApiEvent/Create");
		Invocation.Builder invocationBuilder = target.request();
		Response response = invocationBuilder.post(Entity.entity(s, MediaType.APPLICATION_JSON));
		return response.readEntity(String.class);
	}

	static javax.ws.rs.client.Client c = ClientBuilder.newClient();
	static String getUrl = "http://localhost:59686/api/ApiEvent/GetAll";

	public String getAll() {

		String lr = c.target(getUrl).request().get().readEntity(String.class);
		return lr;
	}
}
