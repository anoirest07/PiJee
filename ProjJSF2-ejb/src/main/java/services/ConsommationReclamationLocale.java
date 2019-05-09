package services;


import java.util.List;
import javax.ejb.Local;
import entities.Reclamation;;
@Local
public interface ConsommationReclamationLocale {
	public String Consommation();
	public List<Reclamation> getById(int ID);
	

}
