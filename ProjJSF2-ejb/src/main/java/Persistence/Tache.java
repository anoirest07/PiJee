package Persistence;

import  java.util.Date;

import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonProperty;






public class Tache {

	@Transient
	private String DeadlineTache;   
	@JsonProperty("IdTache")
	private int IdTache;
	
	@JsonProperty("Nom")
	private NomTache Nom;
	
	@JsonProperty("DescTache")
	private String DescTache;
	
	@JsonProperty("DeadlineTache")
	private Date _DeadlineTache;
	
	@JsonProperty("EtatdeTache")
	private EtatTache EtatdeTache;
	
	@JsonProperty("OragnisateurFk")
	private int OragnisateurFk;
	
	@JsonProperty("IsDeleted")
	private boolean IsDeleted;
	
	@JsonProperty("OrgNom")
	private String OrgNom;




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



	public Tache(int idTache, NomTache nom, String descTache, Date deadlineTache, Persistence.EtatTache etatTache,
			int oragnisateurFk, boolean isDeleted, String orgNom) {
		super();
		IdTache = idTache;
		Nom = nom;
		DescTache = descTache;
		_DeadlineTache = deadlineTache;
		EtatdeTache = etatTache;
		OragnisateurFk = oragnisateurFk;
		IsDeleted = isDeleted;
		OrgNom = orgNom;
	}

	public Tache() {
		super();
	}



	public void setDeadlineTache(Date deadlineTache) {
		_DeadlineTache = deadlineTache;
	}

	public Date get_DeadlineTache() {
		return _DeadlineTache;
	}

	public void set_DeadlineTache(Date _DeadlineTache) {
		this._DeadlineTache = _DeadlineTache;
	}

	public void setDeadlineTache(String deadlineTache) {
		DeadlineTache = deadlineTache;
	}
	public String getDeadlineTache() {
		return DeadlineTache;
	}

	@Override
	public String toString() {
		return "Tache [IdTache=" + IdTache + ", Nom=" + Nom + ", DescTache=" + DescTache + ", DeadlineTache="
				+ DeadlineTache + ", EtatTache=" + EtatdeTache + ", OragnisateurFk=" + OragnisateurFk + ", IsDeleted="
				+ IsDeleted + ", OrgNom=" + OrgNom + "]";
	}   
	
}
