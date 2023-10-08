import java.util.*;

class Line
{
	Line(double m,double c)
	{
		System.out.println("y = "+m+"x + "+c);
	}
	Line(double x1, double y1, double m)
	{
		System.out.println("y - "+y1+" = "+m+"(x - "+x1+")");
	}
	Line(double x1, double x2, double y1, double y2)
	{
		double m = (y2-y1)/(x2-x1);
		System.out.println("(y - "+y1+") / "+(y1-y2)+" = "+m+"(x - "+x1+") / "+(x1-x2));
	}
}
class LineEqn
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		double x1,y1,x2,y2,m,c;
		int o;
		Line li;
		do
		{
			System.out.println("***********MENU***********");
			System.out.println("1.Slope-y-intercept");
			System.out.println("2.Slope point form");
			System.out.println("3.Two Point Form");
			System.out.println("**************************");
			System.out.println("Enter choice(1/2/3):");
			int g = sc.nextInt();
			switch(g)
			{
				case 1:
					System.out.println("Enter slope:");
					m = sc.nextDouble();
					System.out.println("Enter y-intercept:");
					c = sc.nextDouble();
					li = new Line(m,c);
					break;
				case 2:
					System.out.println("Enter x1:");
					x1 = sc.nextDouble();
					System.out.println("Enter y1:");
					y1 = sc.nextDouble();
					System.out.println("Enter slope:");
					m = sc.nextDouble();
					li = new Line(x1,y1,m);
					break;
				case 3:
					System.out.println("Enter x1:");
					x1 = sc.nextDouble();
					System.out.println("Enter y1:");
					y1 = sc.nextDouble();
					System.out.println("Enter x2:");
					x2 = sc.nextDouble();
					System.out.println("Enter y2:");
					y2 = sc.nextDouble();
					li = new Line(x1,x2,y1,y2);
					break;
				default:
					System.out.println("Invalid Choice");
			}
			System.out.println("To open up menu again, press 1 otherwise press 0");
			o = sc.nextInt();
		}while(o!=0);
	}
}



