package axis;

import java.util.Vector;
import java.util.List;
import java.util.Scanner;


public class VectrosClass {
	public static void main (String ...args) {
        String  name;
        int age;
		List list = new Vector();
		System.out.println("Voters list data collection");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 0 to close the function");
     l1:{
    	 while(true) {
			System.out.println("Enter the Name ");
			name=sc.next();
			if(name.equals("0"))
				break l1;
			System.out.println("Enter the age");
			age = sc.nextInt();
			
			if(age >= 18) {
				System.out.println("You are eligible to vote name is updated to list");
				list.add(name);
			}
			else {
				System.out.println("You are not eligible try after "+((18-age)*12)+" Months");
			}
		}
     }
     list.sort(null);
     System.out.println("=====================================================");
     System.out.println("\nEligiblity voters list in alphabetical order \n");
     for(Object lis : list) {
    	 System.out.println(lis);
     } 
	}
}
