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
class Fraction
{
	int n;
	int d;
	Fraction()
	{
		n = 1;
		d = 1;
	}
	Fraction(int n, int d)
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
	static Fraction add(Fraction f1, Fraction f2)
	{
		int n = f1.n*f2.d + f1.d*f2.n;
		int d = f1.d*f2.d;
		Fraction f = new Fraction(n,d);
		f.reduce();
		return f;
	}
	static Fraction subtract(Fraction f1, Fraction f2)
	{
		int n = f1.n*f2.d - f1.d*f2.n;
		int d = f1.d*f2.d;
		Fraction f = new Fraction(n,d);
		f.reduce();
		return f;
	}
	static Fraction multiply(Fraction f1, Fraction f2)
	{
		int n = f1.n*f2.n;
		int d = f1.d*f2.d;
		Fraction f = new Fraction(n,d);
		f.reduce();
		return f;
	}
	static Fraction divide(Fraction f1, Fraction f2)
	{
		int n = f1.n*f2.d;
		int d = f1.d*f2.n;
		Fraction f = new Fraction(n,d);
		f.reduce();
		return f;
	}
}
class FractionMain
{
	public static void main(String args[])
	{
		int o;
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("For first number:");
			System.out.println("Enter numerator:");
			int n1 =sc.nextInt();
			System.out.println("Enter denominator:");
			int d1 =sc.nextInt();
			Fraction f1 = new Fraction(n1,d1);
			f1.reduce();
			System.out.println("For second number:");
			System.out.println("Enter numerator:");
			int n2 =sc.nextInt();
			System.out.println("Enter denominator:");
			int d2 =sc.nextInt();
			Fraction f2 = new Fraction(n2,d2);
			f2.reduce();
			Fraction f = new Fraction();
			System.out.println("***********FRACTION CALCULATOR***********");
			System.out.println("1. Addition");
			System.out.println("2. Subtraction");
			System.out.println("3. Multiplication");
			System.out.println("4. Division");
			System.out.println("*****************************************");
			System.out.println("Enter your choice(1/2/3/4):");
			int c = sc.nextInt();
			switch(c)
			{
				case 1:
					f = Fraction.add(f1,f2);
					System.out.println(f1.getn()+"/"+f1.getd()+" + "+f2.getn()+"/"+f2.getd()+" = "+f.getn()+" / "+f.getd());
					break;
				case 2:
					f = Fraction.subtract(f1,f2);
					System.out.println(f1.getn()+"/"+f1.getd()+" - "+f2.getn()+"/"+f2.getd()+" = "+f.getn()+" / "+f.getd());
					break;
				case 3:
					f = Fraction.multiply(f1,f2);
					System.out.println(f1.getn()+"/"+f1.getd()+" * "+f2.getn()+"/"+f2.getd()+" = "+f.getn()+" / "+f.getd());
					break;
				case 4:
					f = Fraction.divide(f1,f2);
					System.out.println(f1.getn()+"/"+f1.getd()+" / "+f2.getn()+"/"+f2.getd()+" = "+f.getn()+" / "+f.getd());
					break;
				default:
					System.out.println("Invalid Choice.Options are 1,2,3 and 4.");
			}
			System.out.println("Do you want to try again? Press 1 for yes and 0 for no");
			o = sc.nextInt();
		}while(o!=0);
	}
}









