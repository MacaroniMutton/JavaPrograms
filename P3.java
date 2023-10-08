import java.util.*;
class Cycler
{
    String name;
    int age;
    int no_of_marathons;
    double[] speed = new double[100];
    double avg_speed;
    Cycler(String n, int a, int no, double[] s)
    {
        name = n;
        age = a;
        no_of_marathons = no;
        speed = s;
    }
    void calcAvg()
    {
        double sum = 0;
        for(int i=0; i<no_of_marathons; i++)
        {
            sum += speed[i];
        }
        avg_speed = sum / no_of_marathons;
    }
    void display()
    {
        System.out.println("Name : "+name);
        System.out.println("Age : "+age);
        System.out.println("No of marathon attended : "+no_of_marathons);
        System.out.println("Average speed of cycler : "+avg_speed+" km/hr");
    }
}

class P3 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of cyclers:");
        int n = sc.nextInt();
        Cycler[] c = new Cycler[n];
        String name;
        int age, no_of_marathons;
        double[] speed = new double[100];
        for(int i=0; i<c.length; i++)
        {
            sc.nextLine();
            System.out.println("For Cycler "+(i+1)+" : ");
            System.out.println("Enter name : ");
            name = sc.nextLine();
            System.out.println("Enter age : ");
            age = sc.nextInt();
            System.out.println("Enter no of marathons attended : ");
            no_of_marathons = sc.nextInt();
            for(int j=0; j<no_of_marathons; j++)
            {
                System.out.println("Enter avg speed(km/hr) in marathon "+(j+1)+" : ");
                speed[j] = sc.nextDouble();
            }
            c[i] = new Cycler(name, age, no_of_marathons, speed);
            c[i].calcAvg();
        }
        System.out.println("");
        for(int i=0; i<c.length; i++)
        {
            System.out.println("Cycler "+(i+1));
            c[i].display();
        }
        sc.close();
    }
}
