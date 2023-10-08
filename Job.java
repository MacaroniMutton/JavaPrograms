import java.util.*;
class Posting
{
	int courseWork;
	int AptTest;
	int TechTest;
	int interview;
	Posting(int courseWork, int AptTest, int TechTest, int interview)
	{
		this.courseWork = courseWork;
		this.AptTest = AptTest;
		this.TechTest = TechTest;
		this.interview = interview;
	}
	Posting(int TechTest, int interview)
	{
		this.TechTest = TechTest;
		this.interview = interview;
	}
	Posting(int interview)
	{
		this.interview = interview;
	}
	void eligibility(int c)
	{
		switch(c)
		{
			case 1:
				if((courseWork+AptTest+TechTest+interview)>=80)
					System.out.println("You are eligible for this post.");
				else
					System.out.println("You are not eligible.");
				break;
			case 2:
				if((TechTest+interview)>=85)
					System.out.println("You are eligible for this post.");
				else
					System.out.println("You are not eligible.");
				break;
			case 3:
				if(interview>=90)
					System.out.println("You are eligible for this post.");
				else
					System.out.println("You are not eligible.");
				break;
			default:
				System.out.println("Invalid entry. Choices are 1, 2 and 3.");
		}
	}
}
class Job
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int o;
		do
		{
			System.out.println("*****AVAILABLE POSTS******");
			System.out.println("1.Programmer");
			System.out.println("2.Team Leader");
			System.out.println("3.Project Manager");
			System.out.println("**************************");
			System.out.println("Which job post do you want to apply for:");
			int c = sc.nextInt();
			Posting p;
			int courseWork;
			int AptTest;
			int TechTest;
			int interview;
			switch(c)
			{
				case 1:
					do
					{
						System.out.println("Enter marks in course work(out of 25):");
						courseWork = sc.nextInt();
						if(courseWork>25 || courseWork<0)
							System.out.println("Invalid Entry.");
					}while(courseWork>25 || courseWork<0);
					do
					{
						System.out.println("Enter marks in Aptitude test(out of 25):");
						AptTest = sc.nextInt();
						if(AptTest>25 || AptTest<0)
							System.out.println("Invalid Entry.");
					}while(AptTest>25 || AptTest<0);
					do
					{
						System.out.println("Enter marks in Technical Test(out of 25):");
						TechTest = sc.nextInt();
						if(TechTest>25 || TechTest<0)
							System.out.println("Invalid Entry.");
					}while(TechTest>25 || TechTest<0);
					do
					{
						System.out.println("Enter marks in interview(out of 25):");
						interview = sc.nextInt();
						if(interview>25 || interview<0)
							System.out.println("Invalid Entry.");
					}while(interview>25 || interview<0);
					p = new Posting(courseWork, AptTest, TechTest, interview);
					p.eligibility(c);
					break;
				case 2:
					do
					{
						System.out.println("Enter marks in Technical Test(out of 50):");
						TechTest = sc.nextInt();
						if(TechTest>50 || TechTest<0)
							System.out.println("Invalid Entry.");
					}while(TechTest>50 || TechTest<0);
					do
					{
						System.out.println("Enter marks in interview(out of 50):");
						interview = sc.nextInt();
						if(interview>50 || interview<0)
							System.out.println("Invalid Entry.");
					}while(interview>50 || interview<0);
					p = new Posting(TechTest, interview);
					p.eligibility(c);
					break;
				case 3:
					do
					{
						System.out.println("Enter marks in interview(out of 100):");
						interview = sc.nextInt();
						if(interview>100 || interview<0)
							System.out.println("Invalid Entry.");
					}while(interview>100 || interview<0);
					p = new Posting(interview);
					p.eligibility(c);
					break;
				default:
					System.out.println("Invalid entry. Choices are 1, 2 and 3.");
			}
			System.out.println("To open the menu again, press 1 otherwise press 0");
			o = sc.nextInt();
		}while(o!=0);
		sc.close();
	}	
}



