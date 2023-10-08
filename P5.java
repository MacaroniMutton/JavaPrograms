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

class P5 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students:");
        int n = sc.nextInt();
        Student[] s = new Student[n];
        String name;
        int[][] marks = new int[n][5];
        for(int i=0; i<s.length; i++)
        {
            sc.nextLine();
            System.out.println("For Student "+(i+1)+" : ");
            System.out.println("Enter student name : ");
            name = sc.nextLine();
            for(int j=0; j<5; j++)
            {
                System.out.println("Enter marks of paper "+(j+1)+" : ");
                marks[i][j] = sc.nextInt();
            }
            s[i] = new Student(name, marks[i]);
            s[i].calcAvg();
        }
        System.out.println("");
        for(int i=0; i<s.length; i++)
        {
            System.out.println("Student "+(i+1));
            s[i].display();
        }
        sc.close();
    }
}
