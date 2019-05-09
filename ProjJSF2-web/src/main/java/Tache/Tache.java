package Tache;

import java.io.Serializable;
import  java.util.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.primefaces.json.JSONArray;


import services.TacheService;
import services.TacheServiceLocal;

@ManagedBean(name="tache")
@SessionScoped
public class Tache implements Serializable {
	private static final long serialVersionUID = 1L;
	private int IdTache;
	

	private NomTache Nom;
	

	private String DescTache;
	

	private Date DeadlineTache;
	

	private EtatTache EtatdeTache;
	

	private int OragnisateurFk;
	

	private boolean IsDeleted;

	private String OrgNom;
	ArrayList<Object> listdata= new ArrayList<Object>();	
	private List<Persistence.Tache> lsttaches;
	private List<Persistence.Tache> undonetasks;
	private List<Persistence.Tache> donetasks;
	private List<Persistence.Tache> done;
	private List<Persistence.Tache> inprogresstasks;
	private List<Persistence.Tache> datetasks;
	public static Persistence.Tache t ;
	public Date d= new Date();
	public List<Persistence.Tache> getDatetasks() {
		return datetasks;
	}

	public void setDatetasks(List<Persistence.Tache> datetasks) {
		this.datetasks = datetasks;
	}

	public Persistence.Tache getT() {
		return t;
	}

	public void setT(Persistence.Tache t) {
		this.t = t;
	}

	public List<Persistence.Tache> getDonetasks() {
		return donetasks;
	}

	public void setDonetasks(List<Persistence.Tache> donetasks) {
		this.donetasks = donetasks;
	}

	public List<Persistence.Tache> getInprogresstasks() {
		return inprogresstasks;
	}

	public void setInprogresstasks(List<Persistence.Tache> inprogresstasks) {
		this.inprogresstasks = inprogresstasks;
	}

	public List<Persistence.Tache> getUndonetasks() {
		return undonetasks;
	}

	public void setUndonetasks(List<Persistence.Tache> undonetasks) {
		this.undonetasks = undonetasks;
	}

	public List<Persistence.Tache> getLsttaches() {
		return lsttaches;
	}

	public void setLsttaches(List<Persistence.Tache> lsttaches) {
		this.lsttaches = lsttaches;
	}


	@EJB
	private TacheServiceLocal sug;
	
	
	
	@PostConstruct
    public void init() {
		lsttaches = sug.getById(1);
		undonetasks=sug.gettoutelestaches().stream().filter(e->e.getEtatdeTache().name().equals(EtatdeTache.undone.name())).collect(Collectors.toList());
		donetasks=sug.gettoutelestaches().stream().filter(e->e.getEtatdeTache().name().equals(EtatdeTache.done.name())).collect(Collectors.toList());
		inprogresstasks=sug.gettoutelestaches().stream().filter(e->e.getEtatdeTache().name().equals(EtatdeTache.inprogress.name())).collect(Collectors.toList());
		datetasks=sug.gettoutelestaches().stream().filter(item -> item.get_DeadlineTache() != null && item.get_DeadlineTache().after(new java.util.Date())).collect(Collectors.toList());
	
    }
	
	
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList <Persistence.Tache> getdoneeeee(){
		//ArrayList <Persistence.Tache> lst =new ArrayList<Persistence.Tache>();
		done=sug.gettoutelestaches().stream().filter(e->e.getEtatdeTache().name().equals(EtatdeTache.done.name())).collect(Collectors.toList());

		return (ArrayList<Persistence.Tache>) done;
	}
	//////////////////////////////////////////////////////////////////////////////////
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Object> getAll(){
		String lr= sug.GetListTaches();
		JSONArray array= new JSONArray(lr);
		ArrayList<Object> listdata=new ArrayList<Object>();
		System.out.println(d);
		if(array!= null){
			for(int i=0; i<array.length(); i++){
				
				
				listdata.add(array.get(i));

				
			}
		}
		return listdata;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Object> getmestache(){
		String lr= sug.getmestache(1);
		JSONArray array= new JSONArray(lr);
		ArrayList<Object> listdata=new ArrayList<Object>();
		
		if(array!= null){
			for(int i=0; i<array.length(); i++){
				
				
				listdata.add(array.get(i));

				
			}
		}
		return listdata;
	}
	
	public String dodone(){
		
		return "/Tache/Details.xhtml";
	}
	
	
	public String showDetail(int id){
		
		return "/Tache/Details.xhtml";
	}
	public String getByIddetail(int id){
		System.err.println("*****************************************************************************hedha el id : "+id);
		
		try{
			t= sug.getdetail(id);
		System.out.println(t);
		

		}catch(Exception e){}


		
		
		
		return "/Tache/Details.xhtml";
	}
	

public int getIdTache() {
	return IdTache;
}


public void setIdTache(int idTache) {
	IdTache = idTache;
}


public NomTache getNom() {
	return Nom;
}


public void setNom(NomTache nom) {
	Nom = nom;
}


public String getDescTache() {
	return DescTache;
}


public void setDescTache(String descTache) {
	DescTache = descTache;
}


public Date getDeadlineTache() {
	return DeadlineTache;
}


public void setDeadlineTache(Date deadlineTache) {
	DeadlineTache = deadlineTache;
}




public EtatTache getEtatdeTache() {
	return EtatdeTache;
}

public void setEtatdeTache(EtatTache etatdeTache) {
	EtatdeTache = etatdeTache;
}

public int getOragnisateurFk() {
	return OragnisateurFk;
}


public void setOragnisateurFk(int oragnisateurFk) {
	OragnisateurFk = oragnisateurFk;
}


public boolean isIsDeleted() {
	return IsDeleted;
}


public void setIsDeleted(boolean isDeleted) {
	IsDeleted = isDeleted;
}


public String getOrgNom() {
	return OrgNom;
}


public void setOrgNom(String orgNom) {
	OrgNom = orgNom;
}


public ArrayList<Object> getListdata() {
	return listdata;
}


public void setListdata(ArrayList<Object> listdata) {
	this.listdata = listdata;
}


public TacheServiceLocal getSug() {
	return sug;
}


public void setSug(TacheServiceLocal sug) {
	this.sug = sug;
}

}
