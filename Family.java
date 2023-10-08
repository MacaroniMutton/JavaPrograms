import java.util.*;

class Parent
{
	String familyName;
	String motherName;
	String fatherName;
	Parent(String fam, String m, String f)
	{
		familyName = fam;
		motherName = m;
		fatherName = f;
	}
}
class Child extends Parent
{
	String name;
	char gender;
	Child(String n, char g, String fam, String m, String f)
	{
		super(fam,m,f);
		name = n;
		gender = g;
	}
	void printDetails()
	{
		System.out.println("Family Name:"+familyName);
		System.out.println("Mother Name:"+motherName);
		System.out.println("Father Name:"+fatherName);
		System.out.println("Child Name:"+name);
		System.out.println("Gender of child:"+gender);
	}
	void update(String x, int c)
	{
		switch(c)
		{
			case 1:
				familyName = x;
				break;
			case 2:
				motherName = x;
				break;
			case 3:
				fatherName = x;
				break;
			case 4:
				name = x;
				break;
		}
	}
	void update(char x, int c)
	{
		gender = x;
	}
}
class Family
{
	public static void main(String args[])
	{
		int o;
		Scanner sc = new Scanner(System.in);
		Child[] child = new Child[5];
		do
		{
			System.out.println("************MENU*************");
			System.out.println("1.Read the details");
			System.out.println("2.Display the details");
			System.out.println("3.Update the details");
			System.out.println("*****************************");
			System.out.println("Enter your choice:");
			int c = sc.nextInt();
			sc.nextLine();
			switch(c)
			{
				case 1:
					for(int i=0; i<5; i++)
					{
						System.out.println("For Child "+(i+1));
						System.out.println("Enter family name:");
						String fam = sc.nextLine();
						System.out.println("Enter mother name:");
						String m = sc.nextLine();
						System.out.println("Enter father name:");
						String f = sc.nextLine();
						System.out.println("Enter child name:");
						String name = sc.nextLine();
						System.out.println("Enter gender:");
						char g = sc.next().charAt(0);
						child[i] = new Child(name,g,fam,m,f);
						sc.nextLine();
					}
					break;
				case 2:
					System.out.println("Which child's details do you want to retrieve(Enter name of child):");
					String x = sc.nextLine();
					for(int i=0; i<5; i++)
					{
						if(x.equalsIgnoreCase(child[i].name))
						{
							child[i].printDetails();
						}
					}
					break;
				case 3:
					System.out.println("Which child's details do you want to update(Enter name of child):");
					String y = sc.nextLine();
					System.out.println("What do you want to update?");
					System.out.println("1.Family Name");
					System.out.println("2.Mother Name");
					System.out.println("3.Father Name");
					System.out.println("4.Child Name");
					System.out.println("5.Gender");
					System.out.println("Enter choice(1/2/3/4/5)");
					int g = sc.nextInt();
					sc.nextLine();
					for(int i=0; i<5; i++)
					{
						if(y.equalsIgnoreCase(child[i].name))
						{
							if(g!=5)
							{
								System.out.println("Enter the new info:");
								String s = sc.nextLine();
								child[i].update(s,g);
							}
							if(g==5)
							{
								System.out.println("Enter the new info:");
								char ch = sc.next().charAt(0);
								child[i].update(ch,g);
								sc.nextLine();
							}
						}
					}
					break;
				default:
					System.out.println("Invalid Choice");
			}
			System.out.println("To open the menu again, press 1 otherwise 0");
			o = sc.nextInt();
		}while(o!=0);
		sc.close();
	}
}








