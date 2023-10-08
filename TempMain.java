import java.util.*;

class City
{
	String cityName;
	double[] cityTemp = new double[100];
	City(String n, double[] t)
	{
		cityName = n;
		cityTemp = t;
	}
	int maxTemp()
	{
		int m = 0;
		for(int i=0; i<cityTemp.length; i++)
		{
			if(cityTemp[i]>cityTemp[m])
				m = i;
		}
		return m;
	}
	int minTemp()
	{
		int m = 0;
		for(int i=0; i<cityTemp.length; i++)
		{
			if(cityTemp[i]<cityTemp[m])
				m = i;
		}
		return m;
	}
	void displayTemp()
	{
		for(int i=0; i<cityTemp.length; i++)
		{
			System.out.println(cityTemp[i]+"\t");
		}
		System.out.println("");
	}
}
class TempMain
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String n;
		System.out.println("Enter number of cities:");
		int r = sc.nextInt();
		System.out.println("Enter number of days:");
		int c = sc.nextInt();
		double[][] temp = new double[r][c];
		City[] city = new City[c];
		for(int i = 0; i<r; i++)
		{
			System.out.println("Enter name of city "+(i+1)+":");
			n = sc.next();
			System.out.println("For city "+(i+1)+":");
			for(int j = 0; j<c; j++)
			{
				System.out.println("Enter temperature for day "+(j+1)+":");
				temp[i][j] = sc.nextDouble();
			}
			city[i] = new City(n, temp[i]);
		}
		System.out.println("\n");
		System.out.print("\t");
		for(int i=0; i<c; i++)
		{
			System.out.print("Day "+(i+1)+"\t");
		}
		System.out.println("");
		for(int i=0; i<r; i++)
		{
			System.out.print(city[i].cityName+"\t");
			for(int j=0; j<c; j++)
			{
				System.out.print(temp[i][j]+"\t");
			}
			System.out.println("");
		}
		int x=0;
		int y=city[0].maxTemp();
		for(int i=0; i<r; i++)
		{
			if(temp[i][city[i].maxTemp()]>temp[x][y])
			{
				x = i;
				y = city[i].maxTemp();
			}
		}
		System.out.println("City with maximum temperature:"+city[x].cityName);
		System.out.println("The maximum temperature:"+temp[x][y]+" C, on day "+(y+1));
		x=0;
		y=city[0].minTemp();
		for(int i=0; i<r; i++)
		{
			if(temp[i][city[i].minTemp()]<temp[x][y])
			{
				x = i;
				y = city[i].minTemp();
			}
		}
		System.out.println("City with minimum temperature:"+city[x].cityName);
		System.out.println("The minimum temperature:"+temp[x][y]+" C, on day "+(y+1));
		sc.close();
	}
}




