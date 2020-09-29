
public class FlightInfo {

	private int flightID;
	private String airline;
	private double tix;
	private int safety;
	
	public FlightInfo() {
		
	}

	public FlightInfo(int flightID, String airline, double tix, int safety) {
		super();
		this.flightID = flightID;
		this.airline = airline;
		this.tix = tix;
		this.safety = safety;
	}

	public int getFlightID() {
		return flightID;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public double getTix() {
		return tix;
	}

	public void setTix(int tix) {
		this.tix = tix;
	}

	public int getSafety() {
		return safety;
	}

	public void setSafety(int safety) {
		this.safety = safety;
	}

	@Override
	public String toString() {
		return "FlightInfo [flightID=" + flightID + ", airline=" + airline + ", tix=" + tix + ", safety=" + safety
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flightID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightInfo other = (FlightInfo) obj;
		if (flightID != other.flightID)
			return false;
		return true;
	}

}
