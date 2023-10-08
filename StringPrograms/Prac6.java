package StringPrograms;
import java.util.*;
public class Prac6 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = sc.nextInt();
        int sum = 3;
        int m = 3;
        for(int i=1; i<=n; i++) {
            System.out.print(sum+" ");
            sum += m;
            m *= 2;
        }
    }
}
