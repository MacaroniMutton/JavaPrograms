import java.util.*;
import java.lang.Math;

class Armstrong
{
	int lb;
	int ub;
	Armstrong(int x, int y)
	{
		lb=x;
		ub=y;
	}
	boolean isArmstrong(int n)
	{
		boolean key = false;
		int t = n;
		int d;
		int sum = 0;
		while(t!=0)
		{
			d = t%10;
			sum+=(int)(Math.pow(d,3));
			t= t/10;
		}
		if(sum == n)
			key = true;
		return key;
	}
	void print_Armstrong()
	{
		int count = 0;
		System.out.println("The armstrong numbers in the range "+lb+" to "+ub+" is:");
		for(int i=lb; i<=ub; i++)
		{
			if(isArmstrong(i))
			{
				System.out.print(i+" ");
				count+=1;
			}
		}
		System.out.println("\nNumber of Armstrong numbers in this range: "+count);
	}
	
}

class TestArmstrong
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter lower range: ");
		int x = sc.nextInt();
		System.out.println("Enter upper range: ");
		int y = sc.nextInt();
		Armstrong am = new Armstrong(x,y);
		am.print_Armstrong();
	}
}
