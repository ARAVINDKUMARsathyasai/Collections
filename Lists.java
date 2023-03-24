package axis;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Customer{
	private String name;
	private int accType;
	private int age;
	private long accNo;
	private String address;
	
	public Customer() {}
	
	public Customer(String name, int accType, int age,long accNo, String address) {
		this.name = name;
		this.accType = accType;
		this.age = age;
		this.accNo = accNo;
		this.address = address;
	}
	
	public void display() {
		System.out.println("=============================Account details=================================================");
		System.out.println("Name of the customer = "+name);
		if (accType == 1)
			System.out.println("Account type is savings ");
		else
			System.out.println("Account type is current ");
		System.out.println("Age of the customer = "+age);
		System.out.println("Account Number = "+accNo);
		System.out.println("Address of the customer = "+address+"\n");
	}
	
}

class Savings extends Customer{
	private List  deposit = new ArrayList();
	private List  credit = new ArrayList();
	private List  balance = new ArrayList();
	
	private float dep;
	private float cre;
	private float bal;
	
	public Savings() {}
	
	public Savings(String name, int age, long accNo, String address)
	{
		super(name,1,age,accNo,address);
		super.display();
	}
	
	public void calculate(Float cre, Float dep) {
		this.dep = dep;
		this.cre = cre;
		if(dep > 0 && this.bal >= dep) {
			  this.bal = this.bal - dep;
			  credit.add("0.0");
			  deposit.add(dep);
			  balance.add(this.bal);
		}
		
		else if(cre>0)
			{
				this.bal += cre;
				credit.add(cre);
				deposit.add(dep);
				balance.add(this.bal);
			}
			this.display();
	}
	
	public void display() {
		System.out.println("===============================Tranzation Details ===============================================");
		System.out.println("Sl No\tCreadit\tDeposit\tBalance");
		if(deposit.size() !=0) {
		for(int i = 0;i<deposit.size();i++) {	
			System.out.println((i+1)+"\t"+credit.get(i)+"\t"+deposit.get(i)+"\t"+balance.get(i));
		}
		}
		else
			System.out.println("1\t0.0\t0.0\t0.0");
	}
}

public class Lists {
	
	public static void main(String[] args) {
        boolean check = true;
		Scanner sc = new Scanner(System.in);
		String name ;
		System.out.println("Enter the name of the customer ");
		name = sc.next();
		int age;
		System.out.println("Enter the age of the customer ");
		age = sc.nextInt();
		long accNo;
		System.out.println("Enter your Account Number ");
		accNo = sc.nextLong();
		String addres;
		System.out.println("Enter the address of the customer ");
		addres = sc.next();
		
		Savings sv = new Savings(name,age,accNo,addres);
		
		System.out.println("Press 1 : For mini statement");
		System.out.println("Press 2 : To add money to your account");
		System.out.println("Press 3 : To withdraw money from your account");
		System.out.println("Press 4 : To Close transations " );
		
		int op;
		float cre,dep;
		while(check) {	
			op = sc.nextInt();
			switch (op) {
				case 1: sv.display();
						break;
				case 2: System.out.println("Enter the value greater than 0");
				        cre = sc.nextFloat();
				        dep = 0f;
				        if(cre >0) {
				        	sv.calculate(cre, dep);
				        }
				        else {
				        	sv.display();
				        }
				        break;
				case 3:System.out.println("Enter the value greater than 0");
				        cre = 0f;
				        dep = sc.nextFloat();
				        if(dep >0) {
				        	sv.calculate(cre, dep);
				        }
				        else {
				        	sv.display();
				        }
				        break;
				case 4:System.exit(0);
				default :
					System.out.println("invalid operation try again");
			}
		}
}
}
