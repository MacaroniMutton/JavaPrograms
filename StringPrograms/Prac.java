package StringPrograms;
import java.util.*;
public class Prac {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String rev = "";
        String newstr = "";
        int k = 1;
        for(int i=str.length()-1; i>=0; i--) {
            rev += str.charAt(i);
        }
        for(int i=0; i<rev.length(); i++) {
            newstr += (char)(rev.charAt(i)+k);
        }
        System.out.println(newstr);
    }
}
