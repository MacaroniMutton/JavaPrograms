import java.util.*;
import java.time.*;
import java.text.*;
import java.util.concurrent.TimeUnit;

class BombDate
{
	int year;
	int month;
	int date;
	int hrs;
	int min;
	int sec;
	int c;
	BombDate()
	{
		year = 2000;
		month = 1;
		date = 1;
		hrs = 0;
		min = 0;
		sec = 0;
		c = 3;
	}
	void setDate(int year, int month, int date)
	{
		this.year = year;
		this.month = month;
		this.date = date;
		c=1;
	}
	void setDate(int year, int month, int date, int hrs, int min)
	{
		this.year = year;
		this.month = month;
		this.date = date;	
		this.hrs = hrs;
		this.min = min;
		c=2;
	}
	void setDate(int year, int month, int date, int hrs, int min, int sec)
	{
		this.year = year;
		this.month = month;
		this.date = date;	
		this.hrs = hrs;
		this.min = min;
		this.sec = sec;
		c=3;
	}
	void monthDisplay()
	{
		switch(month)
				{
					case 1:
						System.out.print("January ");
						break;
					case 2:
						System.out.print("February ");
						break;
					case 3:
						System.out.print("March ");
						break;
					case 4:
						System.out.print("April ");
						break;
					case 5:
						System.out.print("May ");
						break;
					case 6:
						System.out.print("June ");
						break;
					case 7:
						System.out.print("July ");
						break;
					case 8:
						System.out.print("August ");
						break;
					case 9:
						System.out.print("September ");
						break;
					case 10:
						System.out.print("October ");
						break;
					case 11:
						System.out.print("November ");
						break;
					case 12:
						System.out.print("December ");
						break;
					default:
						System.out.print("[INVALID] ");
				}
				
	}
	void displayDate()
	{
		switch(c)
		{
			case 1:
				monthDisplay();
				System.out.print(date+", ");
				System.out.print(year+" ");
				break; 
			case 2:
				monthDisplay();
				System.out.print(date+", ");
				System.out.print(year+", ");
				System.out.print(hrs+":"+min);
				break; 
			case 3:
				monthDisplay();
				System.out.print(date+", ");
				System.out.print(year+", ");
				System.out.print(hrs+":"+min+":"+sec);
				break;
		}
	}
	void calculateRemainTime(String scheduled_date)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		try
		{
			Date scheduledDate = format.parse(scheduled_date);
			long time_difference = scheduledDate.getTime() - currentDate.getTime();
			time_difference /= 1000;
			long days = (time_difference/(24*3600));
			long hours = (time_difference%(24*3600))/3600;
			long minutes = ((time_difference%(24*3600))%3600)/60;
			long seconds = ((time_difference%(24*3600))%3600)%60;
			System.out.println("Days: "+days);
			System.out.println("Hours: "+hours);
			System.out.println("Minutes: "+minutes);
			System.out.println("Seconds: "+seconds);
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
	}
}
class DateMain
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		BombDate bd = new BombDate();
		int year=2000, month=1, date=1, hrs=0, min=0, sec=0;
		System.out.print("Default date: ");
		bd.displayDate();
		System.out.println("\nTo set the scheduled Date, use the menu below:\n");
		System.out.println("**************Choose Date Format*************");
		System.out.println("1. MM DD,YYYY");
		System.out.println("2. MM DD,YYYY HRS:MIN");
		System.out.println("3. MM DD,YYYY HRS:MIN:SEC");
		System.out.println("*********************************************");
		System.out.println("Enter your choice(1/2/3): ");
		int o = sc.nextInt();
		switch(o)
		{
			case 1:
				System.out.println("Enter year:");
				year = sc.nextInt();
				System.out.println("Enter month:");
				month = sc.nextInt();
				System.out.println("Enter date:");
				date = sc.nextInt();
				bd.setDate(year, month, date);
				System.out.print("Date of explosion: ");
				bd.displayDate();
				break;
			case 2:
				System.out.println("Enter year:");
				year = sc.nextInt();
				System.out.println("Enter month:");
				month = sc.nextInt();
				System.out.println("Enter date:");
				date = sc.nextInt();
				System.out.println("Enter hrs:");
				hrs = sc.nextInt();
				System.out.println("Enter min:");
				min = sc.nextInt();
				bd.setDate(year, month, date, hrs, min);
				System.out.print("Date of explosion: ");
				bd.displayDate();
				break;
			case 3:
				System.out.println("Enter year:");
				year = sc.nextInt();
				System.out.println("Enter month:");
				month = sc.nextInt();
				System.out.println("Enter date:");
				date = sc.nextInt();
				System.out.println("Enter hrs:");
				hrs = sc.nextInt();
				System.out.println("Enter min:");
				min = sc.nextInt();
				System.out.println("Enter sec:");
				sec = sc.nextInt();
				bd.setDate(year, month, date, hrs, min, sec);
				System.out.print("Date of explosion: ");
				bd.displayDate();
				break;
			default:
				System.out.println("Invalid choice");
				System.exit(0);
		}
		System.out.println("\n\nRemaining time:");
		String s = String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(date)+" "+String.valueOf(hrs)+":"+String.valueOf(min)+":"+String.valueOf(sec);
		bd.calculateRemainTime(s);
	}
}










