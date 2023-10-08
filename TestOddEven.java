import java.util.*;

class OddEven
{
	public int lb;
	public int ub;
	OddEven(int x,int y)
	{
		lb=x;
		ub=y;
	}
	boolean isEven(int n)
	{
		if(n%2 == 0)
			return true;
		else
			return false;
	}
	boolean isOdd(int n)
	{
		if(n%2 != 0)
			return true;
		else
			return false;
	}
	void print_Even()
	{
		int count = 0;
		for(int i=lb; i<=ub; i++)
		{
			if(isEven(i))
			{
				System.out.print(i+" ");
				count += 1;
			}
		}
		System.out.println("\nTotal number of even numbers in the range : "+count);
	}
	void print_Odd()
	{
		int count = 0;
		for(int i=lb; i<=ub; i++)
		{
			if(isOdd(i))
			{
				System.out.print(i+" ");
				count += 1;
			}
		}
		System.out.println("\nTotal number of odd numbers in the range : "+count);
	}
}

class TestOddEven
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of test cases:");
		int t = sc.nextInt();
		OddEven[] obj = new OddEven[t];
		for(int i = 0; i<t; i++)
		{ 
			System.out.println("\nFor Test Case "+(i+1)+" : ");
			System.out.println("Enter lower range:");
			int x = sc.nextInt();
			System.out.println("Enter upper range:");
			int y = sc.nextInt();
			obj[i] = new OddEven(x,y);
		}
		for(int i = 0; i<t; i++)
		{
			System.out.println("\nTest Case "+(i+1)+"- Range "+obj[i].lb+"-"+obj[i].ub+" : ");
			obj[i].print_Even();
			obj[i].print_Odd();
		}
	}
}
