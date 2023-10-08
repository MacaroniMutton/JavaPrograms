package StringPrograms;
import java.util.*;
public class prac5 {
    static int fact(int n) {
        int prod = 1;
        for(int i=1; i<=n; i++) {
            prod *= i;
        }
        return prod;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = sc.nextInt();
        System.out.println("Enter x:");
        int x = sc.nextInt();
        double s = 0;
        for(int i=1; i<=n; i++) {
            s += (((i-1)*x)+i)/(1.0*fact(i));
        }
        System.out.println(s);
    }
}
