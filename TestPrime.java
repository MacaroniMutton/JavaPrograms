import java.util.*;
import java.lang.Math;

class Prime
{
	int lb;
	int ub;
	Prime(int x, int y)
	{
		lb=x;
		ub=y;
	}
	boolean isPrime(int n)
	{
		if(n == 1)
			return false;
		boolean key = true;
		for(int i=2; i<=Math.sqrt(n); i++)
		{
			if(n%i==0)
			{
				key = false;
				break;
			}
		}
		return key;
	}
	void print_Primes()
	{
		int count = 0;
		System.out.println("The prime numbers in the range "+lb+" to "+ub+" is:");
		for(int i=lb; i<=ub; i++)
		{
			if(isPrime(i))
			{
				System.out.print(i+" ");
				count+=1;
			}
		}
		System.out.println("\nNumber of prime numbers in this range: "+count);
	}
	
}

class TestPrime
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter lower range: ");
		int x = sc.nextInt();
		System.out.println("Enter upper range: ");
		int y = sc.nextInt();
		Prime p = new Prime(x,y);
		p.print_Primes();
	}
}
