import java.util.*;
class TestPalindrome 
{
    int n;
    TestPalindrome(int x)
    {
        n=x;
    }
    boolean isPalindrome()
    {
        int t = n;
        int d;
        int rev = 0;
        while(t!=0)
        {
            d = t%10;
            rev = (rev*10) + d;
            t = t/10;
        }
        if(rev == n)
            return true;
        else
            return false;
    }
}

public class Palindrome 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        TestPalindrome t = new TestPalindrome(n);
        if(t.isPalindrome())
            System.out.println("It is a Palindrome number");
        else
            System.out.println("It is not a Palindrome number");
    }
}
