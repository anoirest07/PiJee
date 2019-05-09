package entities;


import org.codehaus.jackson.annotate.JsonProperty;



public class Reclamation {
	   
		@JsonProperty("ID")
		private int ID;
		

		@JsonProperty("Descriptions")
		private int Descriptions;
		
		@JsonProperty("IdEvent")
		private int IdEvent;
		
		@JsonProperty("Idpar")
		private int Idpar;

		public int getID() {
			return ID;
		}

		public void setID(int iD) {
			ID = iD;
		}

		public int getDescriptions() {
			return Descriptions;
		}

		public void setDescriptions(int descriptions) {
			Descriptions = descriptions;
		}

		public int getIdEvent() {
			return IdEvent;
		}

		public void setIdEvent(int idEvent) {
			IdEvent = idEvent;
		}

		public int getIdpar() {
			return Idpar;
		}

		public void setIdpar(int idpar) {
			Idpar = idpar;
		}

		public Reclamation(int iD, int descriptions, int idEvent, int idpar) {
			super();
			ID = iD;
			Descriptions = descriptions;
			IdEvent = idEvent;
			Idpar = idpar;
		}

		public Reclamation() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Reclamation [ID=" + ID + ", Descriptions=" + Descriptions + ", IdEvent=" + IdEvent + ", Idpar="
					+ Idpar + "]";
		}
		
		
	

		
}
