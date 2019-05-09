package services;

import java.util.List;

import javax.ejb.Local;

import Persistence.Tache;



@Local
public interface TacheServiceLocal {

	public String GetListTaches();
	public List<Tache> getById(int id);
	public String getmestache(int id);
	public List<Tache> gettoutelestaches() ;
	public Tache getdetail(int id);
	
}
