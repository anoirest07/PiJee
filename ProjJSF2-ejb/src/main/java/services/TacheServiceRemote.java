package services;

import java.util.List;

import javax.ejb.Remote;

import Persistence.Tache;



@Remote
public interface TacheServiceRemote {
	public String GetListTaches();
	public List<Tache> getById(int id);
	public String getmestache(int id);
	public List<Tache> gettoutelestaches() ;
	public Tache getdetail(int id);
}
