import java.util.HashSet;
import java.util.Set;


public class FlightMain {

	public static void main(String[] args) {
		
		Set<FlightInfo> flightsList = new HashSet<>();
		flightsList.add(new FlightInfo(1234, "Frontier",125.55,2));
		flightsList.add(new FlightInfo(1235, "United",300.55,4));
		flightsList.add(new FlightInfo(12346, "Frontier",125.55,2));
		flightsList.add(new FlightInfo(12346, "Frontier",125.55,2));
		flightsList.add(new FlightInfo(12346, "Frontier",125.55,2));
		flightsList.add(new FlightInfo(12347, "JetBlue",200.75,5));
		
		System.out.println("Printing all flights");
		printFlights(flightsList);

	}
	
	public static void printFlights(Set<FlightInfo> flights) {
		for (FlightInfo f:flights) {
			System.out.println(f);
		}
	}
	
}
