import java.util.*;
import java.time.*;
import java.text.*;
import java.util.concurrent.TimeUnit;

class datetesting {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String s1 = sc.nextLine();
        Date date = new Date();
        Date current = f.parse(s1);
        System.out.print("%d", current.getTime() - date.getTime());
    }
}
