package services;

import javax.ejb.Remote;

@Remote
public interface Test1Remote {

	void Consommation();
	public String Add(String s );
	public String getAll();
}
