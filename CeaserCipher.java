import java.util.Scanner;

class CeaserCipher
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        char c1, ch;
        for(int i=1; i<=26; i++)
        {
            for(int j=0; j<x.length(); j++)
            {
                c1 = x.charAt(j);
                if((c1>='A' && c1<='Z') || (c1>='a' && c1<='z'))
                {
                    
                    ch = (char)(x.charAt(j)+i);
                    if(((ch>='A' && ch<='Z') && (c1>='A' && c1<='Z'))  || ((ch>='a' && ch<='z') && (c1>='a' && c1<='z')))
                        System.out.print(ch);
                    else
                        System.out.print((char)(ch-26));
                }
                else
                    System.out.print(c1);
            }
            System.out.println("");
        }
    }
}