import java.util.*;
import java.lang.Math;

class Bank
{
	String name;
	long acc_num;
	String acc_type;
	private double balance;
	Bank(String n, long num, String type, double b)
	{
		name = n;
		acc_num = num;
		acc_type = type;
		balance = b;
	}
	void deposit(double dep)
	{
		balance += dep;
	}
	void withdraw(double wit)
	{
		if((balance - wit) >= 0)
			balance -= wit;
		else
			System.out.println("Not enough money in account");
	}
	double comp_intrst(double rate_of_interest, int time)
	{
		double compi;
		compi = balance*Math.pow((1+(rate_of_interest/100)), time) - balance;
		return compi;
	}
	void printDetails()
	{
		System.out.println("Name: "+name);
		System.out.println("Account Number: "+acc_num);
		System.out.println("Account Type: "+acc_type);
		System.out.println("Balance: Rs."+balance);
	}
	void menu()
	{
		System.out.println("\n****************************MENU****************************");
		System.out.println("1. Deposit an amount");
		System.out.println("2. Withdraw an amount");
		System.out.println("3. Display Compound Interest");
		System.out.println("4. Display account details");
		System.out.println("**************************************************************");
	}
}
class BankAccount
{
	public static void main(String args[])
	{
		double am, com;
		double rate_of_interest;
		int time;
		boolean retry;
		int s;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name of the depositer:");
		String name = sc.nextLine();
		System.out.println("Enter account number:");
		long acc_num = sc.nextLong();
		sc.nextLine();
		System.out.println("Enter type of account:");
		String acc_type = sc.nextLine();
		System.out.println("Enter initial balance amount in the account:");
		double balance = sc.nextDouble();
		Bank bk = new Bank(name, acc_num, acc_type, balance);
		do
		{
			bk.menu();
			System.out.println("\nEnter your choice(1/2/3/4): ");
			int c = sc.nextInt();
			switch(c)
			{
				case 1:
					System.out.println("Enter an amount to deposit:");
					am = sc.nextDouble();
					bk.deposit(am);
					break;
				case 2:
					System.out.println("Enter an amount to withdraw:");
					am = sc.nextDouble();
					bk.withdraw(am);
					break;
				case 3:
					System.out.println("Enter rate of interest:");
					rate_of_interest = sc.nextDouble();
					System.out.println("Enter time in years:");
					time = sc.nextInt();
					com = bk.comp_intrst(rate_of_interest, time);
					System.out.println("Compound Interest: Rs."+com);
					break;
				case 4:
					bk.printDetails();
					break;
				default:
					System.out.println("Invalid choice. Options are 1, 2 and 3.");
			}
			System.out.println("To open up the menu, press 1. To leave this software, press 0");
			s = sc.nextInt();
			if(s == 1)
				retry = true;
			else
				retry = false;
			
		}while(retry);
	}
}
