import java.util.*;
public class Practice {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = sc.nextLine();
        str.toUpperCase();
        char ch;
        char c;
        String newstr = "";
        for(int i=0; i<str.length(); i++) {
            ch = str.charAt(i);
            if((i+1)%4==1) {
                c = (char)(ch+1);
                if(c>='A' && c<='Z')
                    newstr += c;
                else
                    newstr += (char)(c-26);
            }
            else if((i+1)%4==2) {
                c = (char)(ch+4);
                if(c>='A' && c<='Z')
                    newstr += c;
                else
                    newstr += (char)(c-26);
            }
            else if((i+1)%4==3) {
                c = (char)(ch+18);
                if(c>='A' && c<='Z')
                    newstr += c;
                else
                    newstr += (char)(c-26);
            }
            else {
                c = (char)(ch+19);
                if(c>='A' && c<='Z')
                    newstr += c;
                else
                    newstr += (char)(c-26);
            }
        }
        System.out.println(newstr);
    }
}
