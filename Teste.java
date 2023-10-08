import java.util.*;
class Student
{
    String name;
    int[] marks = new int[5];
    double average;
    Student(String n, int[] m)
    {
        name = n;
        marks = m;
        average = 0;
    }
    void calcAvg()
    {
        double sum = 0;
        for(int i=0; i<marks.length; i++)
        {
            sum += marks[i];
        }
        average = sum / marks.length;
    }
    void display()
    {
        System.out.println("Student name : "+name);
        for(int i=0; i<marks.length; i++)
        {
            System.out.println("Paper "+(i+1)+" Marks : "+marks[i]);
        }
        System.out.println("Average : "+average);
    }
}

class Teste
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String name;
        int[] marks = new int[5];
        System.out.println("Enter student name : ");
        name = sc.nextLine();
        for(int i=0; i<5; i++)
        {
            System.out.println("Enter marks of paper "+(i+1)+" : ");
            marks[i] = sc.nextInt();
        }
        Student s= new Student(name, marks);
        s.calcAvg();
        System.out.println("");
        s.display();
        sc.close();
    }
}
