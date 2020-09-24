public class ValidateDLDemo {

		public static void main(String[] args) {

			String dL="D665020";
			boolean b=false;
			
			if(dL.length()>7) {System.out.println(dL+ " is an INVALID DL");}
			else if(dL.length()<7) {System.out.println(dL+ " is an INVALID DL");}
			else if(dL.length()==7 && Character.isUpperCase(dL.charAt(0))) {
				int digit = 0;
				for(int i = 0; i < 7; i++) {
					if(Character.isDigit(dL.charAt(i))) {
						digit++;
				}
			}
				if(digit==6) {
					b=true;
				}
				if(b) {
					System.out.println(dL+" is a valid DL");
				}else {
					System.out.println(dL+" is an INVALID DL");
				}
			}
		

			}
}			
