import java.util.*;

class MonthError extends Exception {
    MonthError() {
        System.out.println("Invalid month.");
    }
}
class DayError extends Exception {
    DayError() {
        System.out.println("Invalid day for the corresponding month.");
    }
}

class DateChanger {
    int month;
    int day;
    public DateChanger(int month, int day) {
        this.month = month;
        this.day = day;
    }
    boolean check() throws MonthError, DayError {
        boolean verified = false;
        if(!(month>=1 && month<=12))
            throw new MonthError();
        else {
            switch(month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if(!(day>=1 && day<=31)) {
                        throw new DayError();
                    }
                    else {
                        verified = true;
                    }
                    break;
                case 2:
                    if(!(day>=1 && day<=29)) {
                        throw new DayError();
                    }
                    else {
                        verified = true;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if(!(day>=1 && day<=30)) {
                        throw new DayError();
                    }
                    else {
                        verified = true;
                    }
                    break;
            }
        }
        return verified;
    }
    void convert() {
        String m = "";
        String d = String.valueOf(day);
        switch(month) {
            case 1:
                m = "January";
                break;
            case 2:
                m = "February";
                break;
            case 3:
                m = "March";
                break;
            case 4:
                m = "April";
                break; 
            case 5:
                m = "May";
                break;
            case 6:
                m = "June";
                break;
            case 7:
                m = "July";
                break;
            case 8:
                m = "August";
                break;
            case 9:
                m = "September";
                break;
            case 10:
                m = "October";
                break;
            case 11:
                m = "November";
                break;
            case 12:
                m = "December";
                break;   
        }
        System.out.println("This is the same as "+m+" "+d);
    }
}
public class DateChangerMain {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        char o;
        do{
            try {
                System.out.println("Enter Date in month/day numeric notation");
                String num_date = sc.next();
                num_date.trim();
                int month = 0, day = 0;
                int inx = num_date.indexOf("/");
                if(inx == -1)
                    throw new MonthError();
                try {
                    month = Integer.parseInt(num_date.substring(0,inx));
                }
                catch(NumberFormatException e) {}
                try{
                    day = Integer.parseInt(num_date.substring(inx+1,num_date.length()));
                }
                catch(NumberFormatException e) {}
                DateChanger change = new DateChanger(month,day);
                if(change.check()) {
                    change.convert();
                }
            }
            catch(MonthError e) {
                System.out.println("Try Again.");
            }
            catch(DayError e) {
                System.out.println("Try Again.");
            }
            System.out.println("Again?(y/n)");
            o = sc.next().charAt(0);
        }while(o=='y');
        sc.close();
    }
}
