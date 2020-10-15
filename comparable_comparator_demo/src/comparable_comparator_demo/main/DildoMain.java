package comparable_comparator_demo.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comparable_comparator_demo.model.Dildo;
import comparable_comparator_demo.comparator.DildoAvailabilityComparator;

public class DildoMain {

	public static void main(String[] args) {
		List<Dildo> dildoList = new ArrayList<>();
		dildoList.add(new Dildo(1, 5.5f, 16.99f, "silicon", 2.5f, true));
		dildoList.add(new Dildo(22, 6.5f, 18.99f, "rubber", 4.5f, true));
		dildoList.add(new Dildo(53, 5f, 26.99f, "marble", 4.5f, true));
		dildoList.add(new Dildo(44, 6.75f, 45.99f, "glass", 4.5f, false));
		dildoList.add(new Dildo(5, 9.0f, 11.99f, "vegetable cellulose", 4.5f, true));
		dildoList.add(new Dildo(17, 8.5f, 16.99f, "stem cells", 5f, false));
		
		System.out.println("Printing \nall \nthe \nDildos:");
		printDildos(dildoList);
		
		Collections.sort(dildoList);
		
		System.out.println("\nPrinting all the dildos sorted based on ID: ");
		printDildos(dildoList);
		
		Collections.sort(dildoList, new DildoAvailabilityComparator());
		
		System.out.println("\nSorting dildos based on availability");
		printDildos(dildoList);
		
		Collections.sort(dildoList, (Dildo d1, Dildo d2) -> {
			Float f1 = d1.getPrice();
			Float f2 = d2.getPrice();
			return f1.compareTo(f2);
		});
		
		System.out.println("\nPrinting all the dildos sorted based on dildo's price");
		printDildos(dildoList);
	
		Collections.sort(dildoList, (Dildo d1, Dildo d2) -> {
			Float f1 = d1.getRating();
			Float f2 = d2.getRating();
			int x = f2.compareTo(f1);
			if (x ==0) {
				Float p1 = d1.getPrice();
				Float p2 = d2.getPrice();
				x= p1.compareTo(p2);
			}
			return x;
		});
		
		System.out.println("\n");
		printDildos(dildoList);
		
		}

	
	

	public static void printDildos(List<Dildo> dildoList) {
		for (Dildo d : dildoList) {
			System.out.println(d);
		}
	}
	
}
