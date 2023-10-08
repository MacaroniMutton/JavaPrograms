package StringPrograms;
import java.util.*;

public class WordReversal {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String str = sc.nextLine();
        str.trim();
        str += " ";
        String word;
        String rev = "";
        char c;
        int p = 0;
        for(int i=0; i<str.length(); i++) {
            c = str.charAt(i);
            if(c == ' ') {
                word = str.substring(p, i);
                for(int j=word.length()-1; j>=0; j--)
                    rev += word.charAt(j);
                rev += " ";
                p = i+1;
            }
        }
        System.out.println(rev);
    }
}
