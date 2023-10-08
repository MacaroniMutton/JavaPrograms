package StringPrograms;
import java.util.*;
public class Prac4 {
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
        int s = 0;
        for(int i=1; i<=n; i++) {
            s += fact(i);
        }
        System.out.println(s);
    }
}
