import java.util.*;

class SumDigit
{
    int a;
    int b;
    SumDigit(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
    void digitSum()
    {
        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);
        s1 = s1.substring(0,2);
        s2 = s2.substring(0,2);
        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);
        System.out.println(n1+" + "+n2+" = "+(n1+n2));
    }
}

class P1 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int n = sc.nextInt();
        SumDigit[] s = new SumDigit[n];
        int a,b;
        for(int i=0; i<s.length; i++)
        {
            System.out.println("For Test Case "+(i+1)+" : ");
            do
            {
            System.out.println("Enter first number : ");
            a = sc.nextInt();
            if(a/10 == 0)
                System.out.println("The number should have atleast 2 digits. Try again.");
            }while(a/10 == 0);
            do
            {
            System.out.println("Enter second number : ");
            b  = sc.nextInt();
            if(b/10 == 0)
                System.out.println("The number should have atleast 2 digits. Try again.");
            }while(b/10 == 0);
            s[i] = new SumDigit(a,b);
        }
        System.out.println("");
        for(int i=0; i<s.length; i++)
        {
            s[i].digitSum();
        }
        sc.close();
    }
}
