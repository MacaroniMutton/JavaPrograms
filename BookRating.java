import java.util.*;

class Book
{
	private String name;
	int n;
 	Rating[] rate = new Rating[n];
 	Book(String na, int n, Rating[] rat)
 	{
 		name = na;
 		this.n = n;
 		rate = rat;
 	}
 	double average()
 	{
 		double avg = 0;
 		for(int i=0; i<n; i++)
 		{
 			avg += rate[i].getrating();
 		}
 		avg /= n;
 		return avg;
 	}
 	String getName()
 	{
 		return name;
 	}
}
class Rating
{
	private int r;
	void setRating()
	{
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("Please give a rating from 1 to 5:");
			r = sc.nextInt();
			if(!(r>=1 && r<=5))
				System.out.println("Invalid Entry");
		}while(!(r>=1 && r<=5));
	}
	int getrating()
	{
		return r;
	}
}
class BookRating
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of books:");
		int books = sc.nextInt();
		System.out.println("Enter number of readers:");
		int readers = sc.nextInt();
		sc.nextLine();
		Rating[][] rate = new Rating[books][readers];
		Book[] b = new Book[books];
		String name;
		for(int i=0; i<books; i++)
		{
			System.out.println("FOR BOOK "+(i+1)+":");
			System.out.println("Enter its name:"); 
			name = sc.nextLine();
			for(int j=0; j<readers; j++)
			{
				System.out.println("For reader "+(j+1)+":");
				rate[i][j] = new Rating();
				rate[i][j].setRating();
			}
			b[i] = new Book(name, readers, rate[i]);
			sc.nextLine();
		}
		System.out.println("\n");
		int m = 0;
		for(int i=0; i<books; i++)
		{
			System.out.println("Average rating of "+b[i].getName()+" is : "+b[i].average());
			if(b[i].average() > b[m].average())
				m = i;
		}
		int[] index = new int[books];
		int k = 0;
		for(int i=0; i<books; i++)
		{
			if(b[m].average() == b[i].average())
				index[k++] = i;
		}
		System.out.print("Book with highest average rating is ");
		for(int i=0; i<k; i++)
		{
			System.out.print(b[index[i]].getName());
			if(i==(k-1))
				continue;
			if(k!=1)
				System.out.print(" and ");
		}
		System.out.print(", with a rating of "+b[m].average());
		sc.close();
	}	
}



