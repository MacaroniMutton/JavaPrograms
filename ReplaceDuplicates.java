import java.util.*;
public class ReplaceDuplicates {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = sc.nextLine();
        String sub = "";
        char ch;
        String newstr = "";
        boolean key ;
        for(int i=0; i<str.length(); i++) {
            key = true;
            ch = str.charAt(i);
            sub = str.substring(0, i);
            for(int j=0; j<sub.length(); j++) {
                if(ch == sub.charAt(j)) {
                    key = false;
                    newstr += "#";
                    break;
                }
            }
            if(key) {
                newstr += ch;
            }
        }
        System.out.println(newstr);
    }
}
