import java.util.*;

class Employee
{
	private String name;
	private String id;
	private int age;
	Employee(String n, String i, int a)
	{
		name = n;
		id = i;
		age = a;
	}
	String getName()
	{
		return name;
	}
	String getId()
	{
		return id;
	}
	int getAge()
	{
		return age;
	}
}
class SalariedEmployee extends Employee
{
	private double empSalary;
	String type;
	SalariedEmployee(double empSalary, String type, String name, String id, int a)
	{
		super(name,id,a);
		this.empSalary = empSalary;
		this.type = type;
	}
	void setSalary(double allowance)
	{
		if(type.equalsIgnoreCase("permanent"))
			empSalary = empSalary + 2000*(allowance);
	}
	double getSalary()
	{
		return empSalary;
	}
}
class EmployeeMain
{
	public static void main(String args[])
	{
		double allowance = 70;
		Scanner sc = new Scanner(System.in);
		SalariedEmployee[] emp = new SalariedEmployee[5];
			for(int i=0; i<5; i++)
			{
					System.out.println("For employee "+(i+1));
					System.out.println("Enter name:");
					String name = sc.nextLine();
					System.out.println("Enter id:");
					String id = sc.nextLine();
					System.out.println("Enter age:");
					int age = sc.nextInt();
					System.out.println("Enter salary:");
					double sal = sc.nextDouble();
					System.out.println("Enter type of employee(permanent or contract):");
					String type = sc.next();
					emp[i] = new SalariedEmployee(sal,type,name,id,age);
					emp[i].setSalary(allowance);
					sc.nextLine();
			}
			int m = 0;
			for(int i=0; i<5; i++)
			{
				if(emp[i].getSalary()>emp[m].getSalary())
					m=i;
			}
			System.out.println("Employee with highest salary:"+emp[m].getName());
			System.out.println("Employee ID:"+emp[m].getId());
			System.out.println("Age of employee:"+emp[m].getAge());
			System.out.println("Salary:"+emp[m].getSalary());
			sc.close();
	}
}








