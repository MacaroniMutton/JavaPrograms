import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
class Bank
{
    double ROI = 2;

    double getROI() 
    {
        return ROI;
    }
    void setROI()
    {
        ROI = 2;
    }

}
class SBI_Bank extends Bank
{
    double principal;
    double ROI;
    int period;
    SBI_Bank(double p, int pe)
    {
        principal = p;
        period = pe;
    }
    double getROI() 
    {
        return ROI;
    }

    void setROI() 
    {
        if(principal>=20000000)
            ROI = super.ROI;
        else
        {
            if(period<0)
            {
                System.out.println("Invalid date entered");
                System.exit(0);
            }
            else
            {
                if(period>=7 && period<=14)
                    ROI = 3;
                else if(period>=15 && period<=30)
                    ROI = 3;
                else if(period>=31 && period<=45)
                    ROI = 3;
                else if(period>=46 && period<=90)
                    ROI = 4.05;
                else if(period>=91 && period<=120)
                    ROI = 4.10;
                else if(period>=121 && period<=180)
                    ROI = 4.10;
                else
                    ROI = super.ROI;
            }
        }
    }
}
class ICICI_Bank extends Bank
{
    double principal;
    double ROI;
    int period;

    ICICI_Bank(double p, int pe)
    {
        principal = p;
        period = pe;
    }

    double getROI() 
    {
        return ROI;
    }

    void setROI() 
    {
        if (principal >= 20000000)
            ROI = super.ROI;
        else 
        {
            if (period < 0)
            {
                System.out.println("Invalid date entered");
                System.exit(0);
            }
            else 
            {
                if (period >= 7 && period <= 14)
                    ROI = 3.10;
                else if (period >= 15 && period <= 30)
                    ROI = 3.20;
                else if (period >= 31 && period <= 45)
                    ROI = 3.50;
                else if (period >= 46 && period <= 90)
                    ROI = 4.50;
                else if (period >= 91 && period <= 120)
                    ROI = 4.70;
                else if (period >= 121 && period <= 180)
                    ROI = 4.90;
                else
                    ROI = super.ROI;
            }
        }
    }
}

class Axis_Bank extends Bank 
{
    double principal;
    double ROI;
    int period;

    Axis_Bank(double p, int pe) 
    {
        principal = p;
        period = pe;
    }

    double getROI() 
    {
        return ROI;
    }

    void setROI() 
    {
        if (principal >= 20000000)
            ROI = super.ROI;
        else 
        {
            if (period < 0)
            {
                System.out.println("Invalid date entered");
                System.exit(0);
            }
            else 
            {
                if (period >= 7 && period <= 14)
                    ROI = 3.15;
                else if (period >= 15 && period <= 30)
                    ROI = 3.15;
                else if (period >= 31 && period <= 45)
                    ROI = 3.45;
                else if (period >= 46 && period <= 90)
                    ROI = 4.05;
                else if (period >= 91 && period <= 120)
                    ROI = 4.70;
                else if (period >= 121 && period <= 180)
                    ROI = 5.00;
                else
                    ROI = super.ROI;
            }
        }
    }
}

class BankingProgram 
{
    static double getMaturityAmount(double principal, int period, double ROI)
    {
        double interest = principal*Math.pow((1+ROI/(100.0*365)), period);
        return interest;
    }
    static int calculateRemainTime(Date scheduledDate) 
    {
        Date currentDate = new Date();
        int days;
        long time_difference = currentDate.getTime() - scheduledDate.getTime();
        time_difference /= 1000;
        days = (int) (time_difference / (24 * 3600));
        return days;
    }
    public static void main(String args[])
    {
        double principal, maturityAmount = 0;
        String d;
        int o, period = 0;
        Date depositDate;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Scanner sc = new Scanner(System.in);
        Bank account1, account2, account3;
        do
        {
            System.out.println("\nCurrent Date: "+new Date()+"\n");
            System.out.println("Enter principal amount: ");
            principal = sc.nextDouble();
            System.out.println("When was the deposition made(yyyy-MM-dd):");
            d = sc.next();
            try 
            {
                depositDate = format.parse(d);
                period = calculateRemainTime(depositDate);
            } 
            catch (ParseException e) 
            {
                e.printStackTrace();
            }
            System.out.println("********BANKS*********");
            System.out.println("1.SBI Bank");
            System.out.println("2.ICICI Bank");
            System.out.println("3. Axis Bank");
            System.out.println("**********************");
            System.out.println("Which bank(1/2/3):");
            int c = sc.nextInt();
            switch(c)
            {
                case 1:
                    account1 = new SBI_Bank(principal, period);
                    account1.setROI();
                    System.out.println("Rate of interest:"+account1.getROI()+"%");
                    maturityAmount = getMaturityAmount(principal, period, account1.getROI());
                    break;
                case 2:
                    account2 = new ICICI_Bank(principal, period);
                    account2.setROI();
                    System.out.println("Rate of interest:"+account2.getROI()+"%");
                    maturityAmount = getMaturityAmount(principal, period, account2.getROI());
                    break;
                case 3:
                    account3 = new Axis_Bank(principal, period);
                    account3.setROI();
                    System.out.println("Rate of interest:"+account3.getROI()+"%");
                    maturityAmount = getMaturityAmount(principal, period, account3.getROI());
                    break;
                default:
                    System.out.println("Invalid Entry.");
            }
            System.out.println("Maturity amount : Rs."+maturityAmount);
            System.out.println("\nTo try a different bank, press 1 otherwise 0.");
            o = sc.nextInt();
        }while(o!=0);
        sc.close();
    }
}
