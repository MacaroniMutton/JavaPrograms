package StringPrograms;
import java.util.*;
public class Prac2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String rev = "";
        String newstr = "";
        char c;
        for(int i=str.length()-1; i>=0; i--) {
            rev += str.charAt(i);
        }
        for(int i=0; i<rev.length(); i++) {
            c = rev.charAt(i);
            newstr += String.valueOf(Character.toUpperCase(c) - 64);
        }
        System.out.println(newstr);
        sc.close();
    }
}
