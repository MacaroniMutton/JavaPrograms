import java.util.*;

class Test
{
	double base;
	int power;
	int logBase;
	int argument;
	Test()
	{
		base = 2;
		power = 2;
		logBase = 2;
		argument = 2;
	}
	double calculate(double b, int p)
	{
		base = b;
		power = p;
		return Math.pow(base, power);
	}
	double calculate(int lb, int a)
	{
		logBase = lb;
		argument = a;
		return (Math.log(argument)/Math.log(logBase));
	}
}
class LogPower
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Test t = new Test();
		double base;
		int power;
		int logBase;
		int argument;
		int o;
		do
		{
			System.out.println("*************MENU**************");
			System.out.println("1. Calculate base raised to power");
			System.out.println("2. Calculate log of argument to a base");
			System.out.println("*******************************");
			System.out.println("\nEnter your choice(1/2): ");
			int c = sc.nextInt();
			switch(c)
			{
				case 1:
					System.out.println("Enter the base:");
					base = sc.nextDouble();
					System.out.println("Enter the power:");
					power = sc.nextInt();
					System.out.println(base+" raised to "+power+" = "+t.calculate(base,power));
					break;
				case 2:
					System.out.println("Enter the logBase:");
					logBase = sc.nextInt();
					System.out.println("Enter the argument:");
					argument = sc.nextInt();
					System.out.println("log of "+argument+" to the base "+logBase+" = "+t.calculate(logBase,argument));
					break;
				default:
					System.out.println("Invalid Choice. Options are 1 and 2");
			}
			System.out.println("To open the menu again, press 1 otherwise press 0");
			o = sc.nextInt();
		}while(o!=0);
		sc.close();
	}
}







