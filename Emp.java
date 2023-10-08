import java.util.*;
class Employee
{
    double baseSalary;
    double bonus;
    String name;
    Employee()
    {
        baseSalary = 10000;
        bonus = 0;
    }
    void setName(String name) 
    {
        this.name = name;
    }
    String getName() {
        return name;
    }
    double getSalary()
    {
        return baseSalary;
    }
    double getBonus()
    {
        return bonus;
    }
}
class Intern extends Employee
{
    double baseSalary;
    double bonus;
    Intern()
    {
        super();
        baseSalary = super.baseSalary * 0.75;
        bonus = 600;
    }
    double getSalary()
    {
        return baseSalary;
    }
    double getBonus() 
    {
        return bonus;
    }
}
class Clerk extends Employee 
{
    double baseSalary;
    double bonus;
    Clerk()
    {
        super();
        baseSalary = super.baseSalary * 0.5;
        bonus = 100;
    }
    double getSalary() 
    {
        return baseSalary;
    }

    double getBonus() 
    {
        return bonus;
    }
}
class Manager extends Employee 
{
    double baseSalary = super.baseSalary * 2;
    double bonus = 900;
    Manager()
    {
        baseSalary = super.baseSalary * 2;
        bonus = 900;
    }
    double getSalary() 
    {
        return baseSalary;
    }

    double getBonus() 
    {
        return bonus;
    }
}
public class Emp 
{
    public static void main(String args[])
    {
        String name;
        int role;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of employees:");
        int n = sc.nextInt();
        Employee[] emp = new Employee[n];
        for(int i=0; i<n; i++)
        {
            System.out.println("Enter name of employee "+(i+1)+" : ");
            name = sc.next();
            System.out.println("Enter type of employee:");
            System.out.println("1 for Intern");
            System.out.println("2 for Clerk");
            System.out.println("3 for Manager");
            role = sc.nextInt();
            switch(role)
            {
                case 1:
                    emp[i] = new Intern();
                    break;
                case 2:
                    emp[i] = new Clerk();
                    break;
                case 3:
                    emp[i] = new Manager();
                    break;
                default:
                    System.out.println("Invalid Entry");
            }
            emp[i].setName(name);
        }
        System.out.println("Sr. No\tEmployee Name\tSalary\tBonus\tTotal Salary");
        for(int i=0; i<n; i++)
        {
            System.out.println((i+1)+"\t"+emp[i].getName()+"\t\t"+emp[i].getSalary()+"\t"+emp[i].getBonus()+"\t"+(emp[i].getSalary()+emp[i].getBonus()));
        }
        sc.close();
    }
}
