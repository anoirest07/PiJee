package Ticket;




import java.io.OutputStream;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.primefaces.json.JSONObject;
import org.xhtmlrenderer.pdf.ITextRenderer;

import services.TestRemote;


@ManagedBean
@RequestScoped
@SessionScoped

public class Ticket {
	private int Quantites ;
	@EJB
	private TestRemote rec ;
	private String s;
	private String t="hfhfhfh";

	
	public String getT() {
		return t;
	}


	public void setT(String t) {
		this.t = t;
	}
	Response j;
	@POST
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public void add()
	{
		if(getByEvent()-Quantites <0 ){
			FacesContext.getCurrentInstance().addMessage(null,
	                new FacesMessage("Attention il reste"+" "+getByEvent()+" "+"tickets pour cet Evenement"));
		}else{
			 String jsonString = new JSONObject()
					 .put("Quantites", Quantites)
	                 .put("IdEvent", 3).toString();
			String j = rec.Add(jsonString);
			FacesContext.getCurrentInstance().addMessage(null,
	                new FacesMessage("vous avez reserver"+" "+Quantites+" "+"tickets"));
		}
	}

	
	@GET	
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public int getByEvent(){
		
		String lr= rec.getByEvent();		       
        JSONObject array = new JSONObject(lr);
    	
        return array.getInt("NbPlaceEvent");
	}
	@GET	
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public JSONObject getByEvent1(){
		
		String lr= rec.getByEvent();		       
        JSONObject array = new JSONObject(lr);
    	
        return array;
	}
public TestRemote getRec() {
		return rec;
	}


	public void setRec(TestRemote rec) {
		this.rec = rec;
	}


	public String getS() {
		return s;
	}


	public void setS(String s) {
		this.s = s;
	}


	public Response getJ() {
		return j;
	}


	public void setJ(Response j) {
		this.j = j;
	}


public String getByTitle(){
		
		String lr= rec.getByEvent();		       
        JSONObject array = new JSONObject(lr);
        return array.getString("NomEvent");
	}

	
	public void createPDF(int eventId){
		   eventId=3;
		   
			FacesContext facesContext = FacesContext.getCurrentInstance();
		    ExternalContext externalContext = facesContext.getExternalContext();
		    HttpSession session = (HttpSession) externalContext.getSession(true);
		    String url = "http://localhost:18080/ProjJSF2-web/Ticket/getPDf.xhtml;JSESSIONID="+session.getId()+"pdf=true";
		    try {
		    ITextRenderer renderer = new ITextRenderer();
		    renderer.setDocument(url);
		    renderer.layout();
		    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		    response.reset();
		    response.setContentType("application/pdf");
		    response.setHeader("Content-Disposition","C://user//first.pdf");
		    OutputStream browserStream = response.getOutputStream();
		    renderer.createPDF(browserStream);
		    browserStream.close();
		    session.invalidate();
		    } catch (Exception ex) {
		       ex.printStackTrace();
		    }
		    facesContext.responseComplete();
		    
	}

	
	public int getQuantites() {
		return Quantites;
	}
	public void setQuantites(int Quantites) {
		this.Quantites = Quantites;
	}

}
