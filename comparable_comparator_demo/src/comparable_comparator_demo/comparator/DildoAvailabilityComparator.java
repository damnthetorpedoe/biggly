package comparable_comparator_demo.comparator;

import java.util.Comparator;

import comparable_comparator_demo.model.Dildo;

public class DildoAvailabilityComparator implements Comparator<Dildo> {

	public DildoAvailabilityComparator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Dildo o1, Dildo o2) {
		Boolean b1=o1.isAvailability();
		Boolean b2=o2.isAvailability();
		return b2.compareTo(b1);
	}

}
