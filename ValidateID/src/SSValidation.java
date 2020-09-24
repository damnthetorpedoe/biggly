
public class SSValidation {

	public static void main(String[] args) {
		String ss = "585-99-9476";
		boolean b = false;
		
		if(ss.length()<11) {System.out.println(ss+" is an invalid SSN");}
		else if(ss.length()>11) {System.out.println(ss+" is an invalid SSN");}
		else if(ss.length()==11 && ss.charAt(3)=='-' && ss.charAt(6)=='-') {
			int digit =0;
			for (int i=0; i<11; i++) {
				if(ss.charAt(i)=='-') {digit++;}
				if(Character.isDigit(ss.charAt(i))) {
					digit++;
				}	
			}
			if(digit==11) {
				b=true;
			}
			if(b) {
				System.out.println(ss+" is a valid SSN");
			}else {
				System.out.println(ss+" is an invalid SSN");
			}	
		}
		
	}}