import java.util.*;

class User
{
	String name;
	int age;
	double accBalance;
	User(String name, int age, double accBalance)
	{
		this.name = name;
		this.age = age;
		this.accBalance = accBalance;
	}
	boolean isEligible(int AgeRestriction, double cost)
	{
		boolean key = false;
		if(age >= AgeRestriction && accBalance >= cost)
			key = true;
		return key;
	}
	void watchMovie(int AgeRestriction, double cost)
	{
		if(isEligible(AgeRestriction,cost))
		{
			accBalance -= cost;
			System.out.println("You can watch this movie! You now have Rs."+accBalance+" left in your account.");
		}
		else
			System.out.println("You are not eligible to watch this movie.");
	}
}

class Movie
{
	String MovieTitle;
	int AgeRestriction;
	double cost;
	Movie(String MovieTitle, int AgeRestriction, double cost)
	{
		this.MovieTitle = MovieTitle;
		this.AgeRestriction = AgeRestriction;
		this.cost = cost;
	}
	double getCost()
	{
		return cost;
	}
	int getAgeRestriction()
	{
		return AgeRestriction;
	}
}

class BookMyMovie
{
	public static void main(String args[])
	{
		int k,c,o,g;
		Scanner sc = new Scanner(System.in);
		System.out.println("********LOGIN SCREEN**********");
		System.out.println("Enter name of user:");
		String name = sc.nextLine();
		System.out.println("Enter age of user:");
		int age = sc.nextInt();
		System.out.println("Enter account balance:");
		double accBalance = sc.nextDouble();
		System.out.println("******************************");
		User u = new User(name, age, accBalance);
		System.out.println("\n\n");
		Movie[] m = new Movie[100];
		m[1] = new Movie("The Order", 18, 350);
		m[2] = new Movie("The Hangover", 18, 300);
		m[3] = new Movie("Mulan", 9, 250);
		m[4] = new Movie("Baby's Day Out", 3, 200);
		m[5] = new Movie("The Night in the Museum", 13, 320);
		m[6] = new Movie("Rio", 9, 200);
			do
			{
				System.out.println("*********AVAILABLE MOVIES*********");
				System.out.println("1.The Order");
				System.out.println("2.The Hangover");
				System.out.println("3.Mulan");
				System.out.println("4.Baby's Day Out");
				System.out.println("5.The Night in the Museum");
				System.out.println("6.Rio");
				System.out.println("**********************************");
				do
				{
					System.out.println("\nWhich movie are you interested in?(Enter 1/2/3/4/5/6): ");
					c = sc.nextInt();
					if(!(c>=1 && c<=6))
					{
						System.out.println("Invalid choice. If you are not interested in these movies, you can leave by pressing 0, otherwise press 1");
						k = sc.nextInt();
						if(k == 0)
							System.exit(0);
					}
				}while(!(c>=1 && c<=6));
				System.out.println("For this Movie:");
				System.out.println("Age Restriction: "+m[c].getAgeRestriction());
				System.out.println("Cost: "+m[c].getCost());
				System.out.println("Do you want to buy tickets? Press 1 for yes and 0 for no");
				o = sc.nextInt();
				if(o == 1)
					u.watchMovie(m[c].getAgeRestriction(), m[c].getCost());
				System.out.println("Do you want to go back to list of available movies? Press 1 for yes and 0 for no");
				g = sc.nextInt();
			}while(g != 0);
			sc.close();
	}	
}
	
	
	
	
	
