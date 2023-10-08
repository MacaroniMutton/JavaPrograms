import java.util.*;

class Time
{
	int totSeconds;
	int hours;
	int minutes;
	int seconds;
	Time(int totSeconds)
	{
		this.totSeconds = totSeconds;
		this.hours = 0;
		this.minutes = 0;
		this.seconds = 0;
	}
	Time(int hours, int minutes, int seconds)
	{
		this.totSeconds = 0;
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	void conversion1()
	{
		hours = totSeconds/3600;
		minutes = (totSeconds%3600)/60;
		seconds = (totSeconds%3600)%60;
		System.out.println("Hours: "+hours);
		System.out.println("Minutes: "+minutes);
		System.out.println("Seconds: "+seconds);
	}
	void conversion2()
	{
		totSeconds = hours*3600 + minutes*60 + seconds;
		System.out.println("Total seconds: "+totSeconds);
	}
}

class TimeCalc
{
	public static void main(String args[])
	{
		int totSeconds, hours, minutes, seconds, o;
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("************MENU***************");
			System.out.println("1.Total seconds to hours, minutes, seconds");
			System.out.println("2.Hours, minutes, seconds to total seconds");
			System.out.println("*******************************");
			System.out.println("Enter your choice(1/2):");
			int c = sc.nextInt();
			switch(c)
			{
				case 1:
					System.out.println("Enter total seconds:");
					totSeconds = sc.nextInt();
					Time t1 = new Time(totSeconds);
					t1.conversion1();
					break;
				case 2:
					System.out.println("Enter hours, minutes, seconds:");
					hours = sc.nextInt();
					minutes = sc.nextInt();
					seconds = sc.nextInt();
					Time t2 = new Time(hours, minutes, seconds);
					t2.conversion2();
					break;
				default:
					System.out.println("Invalid choice. Options are 1 or 2.");
			}
			System.out.println("To display the menu again, press 1, otherwise press 0 to exit");
			o = sc.nextInt();
		}while(o!=0);
		
	}
}





