package StringPrograms;
import java.util.*;
public class Prac3 {
    static int sum(int n) {
        int s = 0;
        for(int i=1; i<=n; i++) {
            s += i;
        }
        return s;
    }
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
        double s = 0;
        for(int i=2; i<=n; i++) {
            s += (1.0*sum(i))/fact(i);
        }
        System.out.println(s);
    }
}
