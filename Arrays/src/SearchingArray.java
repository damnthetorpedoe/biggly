public class SearchingArray {

	public static void main(String[] args) {
		int ar[]= {10,22,33,11,10,10,11,22,44,22,13,45,17,46,47,53};
		int searchElement=22;
		boolean b=false;
		for (int i = 0; i < ar.length; i++) {
			if(ar[i]==searchElement) {
				b=true;
				break;
			}
		}
		if(b) {
			System.out.println(searchElement+" found");
		}else {
			System.out.println(searchElement+" not found");
		}
		
		b=false;
		for (int i = 0; i < ar.length; i++) {
			if(ar[i]==searchElement) {
				b=true;
				System.out.println(searchElement+" found at position "+(i+1));
			}
		}
		if(!b) {
			System.out.println(searchElement+" not found");
		}
		
		System.out.println("Searching all the even numbers in array");
		for (int i = 0; i < ar.length; i++) {
			if(ar[i]%2==0 || ar[i]%3==0 || ar[i]%7==0) continue; 
			else{
				System.out.print(ar[i]+" ");
			}
		}
	}
//search for all prime numbers in array, search for all palindromes in array, all odd numbers in array
}