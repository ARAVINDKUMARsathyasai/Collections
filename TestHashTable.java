package axis;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TestHashTable {
	static {
		System.out.println("Telephone directory data collection");
		System.out.println("===========================================================");
	}
	public static void main(String... args) {	
	    Scanner sc = new Scanner(System.in);
		Map tp = new Hashtable();
		
		String name;
		long phone;
		System.out.println("Enter 0 insted of phone number to exit");
		while(true) {
			System.out.println("Enter the Phone Number");
			phone = sc.nextLong();
			if(phone == 0)
				break;
			System.out.println("Enter the Subscriber name");
			name=sc.next();
			
			tp.put(phone, name);
		}
		
		Set set = tp.entrySet();
		Iterator it = set.iterator();
		
		System.out.println("===============================================================\n");
		System.out.println("All the stored data");
		
		while(it.hasNext())
			System.out.println(it.next());
		
		System.out.println("Press 1 : To search by name ");
		System.out.println("Press 2 : To search by phone number");
		
		int op;
		op = sc.nextInt();
		
		switch(op) {
		case 1: name = sc.next();
		        break;
		case 2: phone = sc.nextLong();
				System.out.println(tp.get(phone));
				break;
		}
	}
}
