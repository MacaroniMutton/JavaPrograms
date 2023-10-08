import java.util.*;
import java.lang.Math;

class Fractions
{
	int n;
	int d;
	Fractions()
	{
		n = 1;
		d = 1;
	}
	Fractions(int num, int den)
	{
		n = num;
		d = den;
	}
	void reduce()
	{
		int gcd = 1;
		for(int i=1; i<=Math.min(n,d); i++)
		{
			if(n%i==0 && d%i==0)
				gcd = i;
		}
		n /= gcd;
		d /= gcd;
	}
	static Fractions multiply(Fractions f1, Fractions f2)
	{
		int n = f1.n*f2.n;
		int d = f1.d*f2.d;
		Fractions f = new Fractions(n,d);
		f.reduce();
		return f;
	}
    static void mul(int d)
    {
        Fractions f = new Fractions();
        System.out.print("\t\t");
        for(int i=1; i<d; i++)
        {
            Fractions f1 = new Fractions(i,d);
            f1.reduce();
            System.out.print(f1.n+"/"+f1.d+"\t\t");
        }
        System.out.println("");
        for(int i=1; i<=d; i++)
        {
            System.out.print("----------------");
        }
        System.out.println("");
        for(int i=1; i<d; i++)
        {
            Fractions f1 = new Fractions(i,d);
            f1.reduce();
            System.out.print(f1.n+"/"+f1.d+"\t\t");
            for(int j=1; j<d; j++)
            {
                Fractions f2 = new Fractions(j,d);
                f2.reduce();
                f = multiply(f1,f2);
                System.out.print(f.n+"/"+f.d+"\t\t");
            }
            System.out.println("");
        }
    }
}
class FracMulTable
{
	public static void main(String args[])
	{
		int o;
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("Enter the denominator:");
            int d = sc.nextInt();
            Fractions.mul(d);
			System.out.println("\nDo you want to try again? Press 1 for yes and 0 for no");
			o = sc.nextInt();
		}while(o!=0);
	}
}











