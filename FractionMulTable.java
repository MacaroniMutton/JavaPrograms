import java.util.*;
import java.lang.Math;

class QuickMafs
{
	static int gcd(int a, int b)
	{
		int gcd = 1;
		a = Math.abs(a);
		b = Math.abs(b);
		for(int i=1; i<=Math.min(a,b); i++)
		{
			if(a%i==0 && b%i==0)
				gcd = i;
		}
		return gcd;
	}
}
class Frac
{
	int n;
	int d;
	Frac()
	{
		n = 1;
		d = 1;
	}
	Frac(int n, int d)
	{
		this.n = n;
		this.d = d;
	}
	int getn()
	{
		return n;
	}
	int getd()
	{
		return d;
	}
	void reduce()
	{
		int gcd = QuickMafs.gcd(n,d);
		n /= gcd;
		d /= gcd;
	}
	static Frac multiply(Frac f1, Frac f2)
	{
		int n = f1.n*f2.n;
		int d = f1.d*f2.d;
		Frac f = new Frac(n,d);
		f.reduce();
		return f;
	}
    static void multable(int d)
    {
        Frac f = new Frac();
        System.out.print("\t\t");
        for(int i=1; i<d; i++)
        {
            Frac f1 = new Frac(i,d);
            f1.reduce();
            System.out.print(f1.getn()+"/"+f1.getd()+"\t\t");
        }
        System.out.println("");
        for(int i=1; i<=d; i++)
        {
            System.out.print("----------------");
        }
        System.out.println("");
        for(int i=1; i<d; i++)
        {
            Frac f1 = new Frac(i,d);
            f1.reduce();
            System.out.print(f1.getn()+"/"+f1.getd()+"\t\t");
            for(int j=1; j<d; j++)
            {
                Frac f2 = new Frac(j,d);
                f2.reduce();
                f = multiply(f1,f2);
                System.out.print(f.getn()+"/"+f.getd()+"\t\t");
            }
            System.out.println("");
        }
    }
}
class FractionMulTable
{
	public static void main(String args[])
	{
		int o;
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("Enter the denominator:");
            int d = sc.nextInt();
            Frac.multable(d);
			System.out.println("\nDo you want to try again? Press 1 for yes and 0 for no");
			o = sc.nextInt();
		}while(o!=0);
	}
}










