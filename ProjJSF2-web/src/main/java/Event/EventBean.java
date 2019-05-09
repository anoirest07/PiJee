package Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Event;
import services.Test1Remote;

@ManagedBean
@ViewScoped
public class EventBean {
	private Boolean isInclude = false;

	private String filterString;
	
	public List<Event> listEvents = new ArrayList<>();

	public String getFilterString() {
		return filterString;
	}

	public void setFilterString(String filterString) {
		this.filterString = filterString;
	}

	public List<Event> getListEvents() {
		return listEvents;
	}

	public void setListEvents(List<Event> listEvents) {
		this.listEvents = listEvents;
	}

	public Boolean getIsInclude() {
		return isInclude;
	}

	public void setIsInclude(Boolean isInclude) {
		this.isInclude = isInclude;
	}

	
	@EJB
	private Test1Remote rec;

	@PostConstruct
	public void getAll() {

		String json = rec.getAll();
		ObjectMapper mapper = new ObjectMapper();
		List<Event> al = new ArrayList<>();
		try {
			al = mapper.readValue(json, new TypeReference<List<Event>>() {
			});
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Error While Parsing Object");
		}
		if (!isInclude) {
			listEvents = al.stream()
					.filter(item -> item.getDateEventDebut() != null && item.getDateEventDebut().after(new Date()))
					.collect(Collectors.toList());
			// listEvents = al.stream()
			// .filter(item -> item.getDateEventDebut() != null &&
			// item.getDateEventDebut().after(new
			// Date())).sorted(Comparator.comparing(Event::getNbPlaceEvent))
			// .collect(Collectors.toList());
			listEvents.forEach(item -> item.setStyle("table-success"));
			// listEvents = listFiltred;
		} else {
			// listEvents =
			// al.stream().sorted(Comparator.comparing(Event::getNbPlaceEvent))
			// .collect(Collectors.toList());
			listEvents = al;
			listEvents.forEach(item -> {
				if (item.getDateEventDebut() != null && item.getDateEventDebut().after(new Date())) {
					item.setStyle("table-success");
				}
			});
		}

		if (filterString != null && !"".equals(filterString)) {
			listEvents = listEvents.stream()
					.filter(item -> item.getNomEvent().toLowerCase().contains(filterString.toLowerCase())
							|| Integer.toString(item.getNbPlaceEvent()).toLowerCase().contains(filterString.toLowerCase())
							|| item.getDescriptionEvent().toLowerCase().contains(filterString.toLowerCase())
							|| item.getLocationEvent().toLowerCase().contains(filterString.toLowerCase()))
					.collect(Collectors.toList());
		}

	}

//	public void createPDF(List<Event> listEvents) {
//		// report.setEventId(eventId);
//
//		// FacesContext facesContext = FacesContext.getCurrentInstance();
//		// ExternalContext externalContext = facesContext.getExternalContext();
//		// HttpSession session = (HttpSession) externalContext.getSession(true);
//		// String url =
//		// "http://http://localhost:18080/ProjJSF2-web/Event/get.xhtml;JSESSIONID="+session.getId()+"pdf=true";
//		// try {
//		// ITextRenderer renderer = new ITextRenderer();
//		// renderer.setDocument(url);
//		// renderer.layout();
//		// HttpServletResponse response = (HttpServletResponse)
//		// externalContext.getResponse();
//		// response.reset();
//		// response.setContentType("application/pdf");
//		// response.setHeader("Content-Disposition","C://user//first.pdf");
//		// OutputStream browserStream = response.getOutputStream();
//		// renderer.createPDF(browserStream);
//		// browserStream.close();
//		// session.invalidate();
//		// } catch (Exception ex) {
//		// ex.printStackTrace();
//		// }
//		// facesContext.responseComplete();
//
//	}

	public void filter(String column) {
		System.out.println("Column is " + column);
		if (column.equals("nbPlaces")) {
			listEvents = listEvents.stream().sorted(Comparator.comparing(Event::getNbPlaceEvent))
					.collect(Collectors.toList());
		} else if (column.equals("nameEvent")) {
			listEvents = listEvents.stream().sorted(Comparator.comparing(Event::getNomEvent))
					.collect(Collectors.toList());
		} else if (column.equals("description")) {
			listEvents = listEvents.stream().sorted(Comparator.comparing(Event::getDescriptionEvent))
					.collect(Collectors.toList());
		} else if (column.equals("location")) {
			listEvents = listEvents.stream().sorted(Comparator.comparing(Event::getLocationEvent))
					.collect(Collectors.toList());
		} else if (column.equals("startDate")) {
			listEvents = listEvents.stream().sorted(Comparator.comparing(Event::getDateEventDebut))
					.collect(Collectors.toList());
		} else if (column.equals("endDate")) {
			listEvents = listEvents.stream().sorted(Comparator.comparing(Event::getDateEventFin))
					.collect(Collectors.toList());
		}

	}

}
