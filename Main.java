import java.util.*;
class Digits
{
    int n;
    Digits(int n)
    {
        this.n=n;
    }
    int first2Digits()
    {
        int t = n;
        int ctr = 0;
        while(t!=0)
        {
            ctr++;
            t/=10;
        }
        int r = n / (int)Math.pow(10,(ctr-2));
        return r;
    }
}

class Main 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number:");
        int n1 = sc.nextInt();
        Digits x1 = new Digits(n1);
        System.out.println("Enter second number:");
        int n2 = sc.nextInt();
        Digits x2 = new Digits(n2);
        int a = x1.first2Digits();
        int b = x2.first2Digits();
        System.out.println(a+"+"+b+"="+(a+b));
        sc.close();
    }
}
