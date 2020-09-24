
public class WrapperClassLab {

	public static void main(String[] args) {
		Integer i1=10;//common pool
		Integer i2=10;//common pool
		Integer i3=new Integer(10); //heap
		
		System.out.println("i1==i2 : "+(i1==i2));
		System.out.println("i1==i3 : "+(i1==i3));
		//i1++;
		System.out.println("i1 = "+i1);
		System.out.println("i2 = "+i2);
		
		System.out.println("i1.equals(i2) : "+i1.equals(i2));
		System.out.println("i1.equals(i3) : "+i1.equals(i3));
		
		/*
		 * public int obj1.compareTo(obj2) - used for sorting, it is available in all the wrapper classes & String class
		 * if value of obj1 is equals to the value of obj2 it will return 0 
		 * if value of obj1 is greater than value of obj2 it will return positive value
		 * if value of obj1 is smaller than value of obj2 it will return -ve value
		 */
		Integer i4=99;
		System.out.println("i4.compareTo(99) : "+i4.compareTo(99));
		System.out.println("i4.compareTo(9) : "+i4.compareTo(9));
		System.out.println("i4.compareTo(999) : "+i4.compareTo(999));
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
//		int x=i4; //Autoboxing
//		System.out.println("x : "+x);
//		
//		x=10000;
//		i4=x; //Autoboxing
//		System.out.println("i4 : "+i4);
//		
//		String s="12443";
//		
//		int a=Integer.parseInt(s);  //Common across all the wrappers except Character
//		System.out.println("a = "+a);
//		
//		a=1919191;
//		s=a+"";//anything in java can be converted to the String by just doing this
//		System.out.println("s : "+s);
//		
//		Integer i5=77;
//		Float f=i5.floatValue(); //doubleValue() //shortValue() //longValue()
//		System.out.println("f = "+f);
//		int r=f.intValue();
//		System.out.println("r : "+r);
		
		
		Long l1 = 3333333333333333333l;
		System.out.println("\nLong: ");
		System.out.println("l1.compareTo(3333333333333333333) : "+l1.compareTo(3333333333333333333l));
		System.out.println("l1.compareTo(3333333333333333334) : "+l1.compareTo(3333333333333333332l));
		System.out.println("l1.compareTo(2222222222223333333) : "+l1.compareTo(4333333333333333333l));
		
		System.out.println("\nLong Max_Value: \r" + Long.MAX_VALUE);
		System.out.println("Long Min_Value: \r" + Long.MIN_VALUE);
		
		Float f1 = 23.45636f;
		System.out.println("\nFloat: ");
		System.out.println("f1.compareTo(23.45636) : "+f1.compareTo(23.45636f));
		System.out.println("f1.compareTo(22.45636) : "+f1.compareTo(22.45636f));
		System.out.println("f1.compareTo(24.45636) : "+f1.compareTo(24.45636f));
		
		System.out.println("\nFloat Max_Value: \n"+Float.MAX_VALUE);
		System.out.println("Float Min_Value: \n"+Float.MIN_VALUE);
		System.out.println("Float Max_Exponent: \r" + Float.MIN_EXPONENT);
		
		
		Double d1 = 413.413;
		double d2 = 413.413;
		double d3 = 413.333;
		double d4 = 413.4444;
		
		System.out.println("\nDouble: ");
		System.out.println("d1.compareTo(d2) : "+d1.compareTo(d2));
		System.out.println("d1.compareTo(d3) : "+d1.compareTo(d3));
		System.out.println("d1.compareTo(d4) : "+d1.compareTo(d4));
		
		System.out.println("\nDouble Max_Value: \r" + Double.MAX_VALUE);
		System.out.println("Double Min_Valye: \r" + Double.MIN_VALUE);
		System.out.println("Double Max_Exponent: \r" + Double.MIN_EXPONENT);
		
	}
	
	//Task here : Immitate the above with Float, Long and Double classes respectively

}