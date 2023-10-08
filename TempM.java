import java.util.*;

class TempM
{	
	public static void main(String[] args)
	{
		CityTemp ct[] = new CityTemp[100];
		Scanner sc = new Scanner(System.in);
		CityTemp c = new CityTemp();
		
		System.out.println("Enter number of cities");
		int nc = sc.nextInt();
		
		int i, j;
		String name;
		String garbage;
		int dtmp[][] = new int[nc+1][100];
		int maxl = 0, minl = 0;
		
		for(i = 0; i<nc; i++)
		{
			garbage = sc.nextLine();
			System.out.println("Enter name of city " + (i+1));
			name = sc.nextLine();
			
			System.out.println("Enter number of days");
			int nd = sc.nextInt();
			
			minl = 0;
			maxl = 0;
			
			for(j = 0; j<nd; j++)
			{
				dtmp[0][j] = j + 1;
				System.out.println("Enter temperature for day " + (j+1));
				dtmp[i+1][j] = sc.nextInt();
			}
			for(j = 0; j<nd; j++)
			{
				if(dtmp[i+1][j] < dtmp[i+1][minl])
				{
					minl = j;
				}
				if(dtmp[i+1][j] > dtmp[i+1][maxl])
				{
					maxl = j;
				}
			}
			
			ct[i] = new CityTemp(name, dtmp[i+1], maxl, minl, nd);
		}
		
		System.out.println("\nTemperatures of the cities are as follows:\n");
		int a, b;
		for(a = 0; a<nc; a++)
		{       
		        System.out.println("City:\t" + ct[a].name);
		        System.out.print("Day number:\t");
		        for(b = 0; b<ct[a].nodays; b++)
		        {
		                System.out.print(dtmp[0][b] + "\t");
		        }
		        System.out.print("\nTemperature:\t");
		        for(b = 0; b<ct[a].nodays; b++)
		        {
		                System.out.print(dtmp[a+1][b] + "\t");
		        }
		        System.out.print("\n\n");
		}
		/*
		int a;
		int gmax = ct[0].daytemp[1][ct[0].maxl], gmin = ct[0].daytemp[1][ct[0].minl];
		int gmaxl = ct[0].maxl, gminl = ct[0].minl;
		String gmaxcity = ct[0].name, gmincity = ct[0].name;
		for(a = 0; a<nc; a++)
		{
			if(ct[a].daytemp[1][ct[a].minl] < gmin)
			{
				gmincity = ct[a].name;
				gmin = ct[a].daytemp[1][ct[a].minl];
				gminl = ct[a].minl;
			}
			if(ct[a].daytemp[1][ct[a].maxl] > gmax)
			{
				gmaxcity = ct[a].name;
				gmax = ct[a].daytemp[1][ct[a].maxl];
				gmaxl = ct[a].maxl;
			}
		}
		System.out.println(ct[1].daytemp[1][ct[1].maxl]+"\nGlobal max:\nCity: " + gmaxcity + "\nTemperature: " + gmax + "\nDay: " + (gmaxl + 1));
		System.out.println(ct[1].name+"\nGlobal min:\nCity: " + gmincity + "\nTemperature: " + gmin + "\nDay: " + (gminl + 1));*/
	sc.close();
	}
}

class CityTemp
{
	String name;
	int daytemp[] = new int[100];
	int i;
	int maxl, minl, nodays;
	
	CityTemp()
	{
		
	}
	
	CityTemp(String a, int dt[], int mxl, int mnl, int nd)
	{
		this.name = a;
		this.daytemp = dt;
		this.maxl = mxl;
		this.minl = mnl;
		this.nodays = nd;
		System.out.println("Local max: " + daytemp[maxl]);
		System.out.println("Local min: " + daytemp[minl]);
	}
	
	/*void maxmin()
	{
		int max[] = new int[100];
		for(i = 0; i<tp.nc; i++)
		{
			
		}
		
	}
	
	int maxtemploc(int dt[][])
	{
		
	}
	
	int mintemploc(int dt[][])
	{
		
	}*/
}