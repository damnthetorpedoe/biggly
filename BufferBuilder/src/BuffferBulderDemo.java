
	public class BuffferBulderDemo {

		public static void main(String[] args) {
			String s="a prickly pear is best prepared and other tales";
			
			String ar[]=s.split(" ");
			
			StringBuilder sb=new StringBuilder();
			
			for (int i = 0; i < ar.length; i++) {
				sb.append(Character.toUpperCase(ar[i].charAt(0))).append(ar[i].substring(1)).append(" ");
			}
			
			StringBuilder sb2 = new StringBuilder();
			

			for (int j = 0; j < ar.length;j++) {
				sb2.append(ar[j].substring(0,ar[j].length()-1)).append(Character.toUpperCase(ar[j].charAt(ar[j].length()-1))).append(" ");
			}
			
			System.out.println(sb.toString().trim());
			System.out.println(sb2.toString().trim());
		}

	}

	//Tasks
	//Same example as above but try to covert every word's last letter to uppercase

