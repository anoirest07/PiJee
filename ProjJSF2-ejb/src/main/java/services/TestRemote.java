package services;

import javax.ejb.Remote;

@Remote
public interface TestRemote {

	void Consommation();
	public String Add(String s );
	public String getByEvent();
}
