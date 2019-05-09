package services;

import java.util.List;

import javax.ejb.Remote;
import entities.Reclamation;
@Remote
public interface ConsommationReclamationRemote {

	//void Consommation();
	//public String Add(String s );
	public String Consommation();
	public List<Reclamation> getById(int ID);



}
