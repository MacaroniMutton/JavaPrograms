import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
class Person
{
    String name;
    Date admittedDate;
    Person(String n, Date a)
    {
        name = n;
        admittedDate = a;
    }
    String getName() 
    {
        return name;
    }
    Date getAdmittedDate() 
    {
        return admittedDate;
    }
}
class Doctor extends Person
{
    String specialty;
    double fees;
    double income = 0;
    Doctor(String n, Date a, String s, double f)
    {
        super(n,a);
        specialty = s;
        fees = f;
    }
    Doctor(Doctor d)
    {
        super(d.name, d.admittedDate);
        specialty = d.specialty;
        fees = d.fees;
    }
    void updateIncome(double billing)
    {
        income += billing;
    }
    double getFees() 
    {
        return fees;
    }
    double getIncome() 
    {
        return income;
    }
    String getSpecialty() 
    {
        return specialty;
    }
    @Override public String toString()
    {
        return (name+"\t\t"+specialty+"\t\t"+fees);
    }
}
class Patient extends Person
{
    Doctor doc;
    Patient(String n, Date a, Doctor d)
    {
        super(n,a);
        doc = new Doctor(d);
    }
    Patient(Patient p)
    {
        super(p.name, p.admittedDate);
        doc = new Doctor(p.doc);
    }
    Doctor getDoc() 
    {
        return doc;
    }
}
class Billing
{
    Patient p;
    Doctor doc;
    double amount;
    Date currentDate;
    Billing(Patient p, Doctor doc, double a, Date c)
    {
        this.p = new Patient(p);
        this.doc = new Doctor(doc);
        amount = a;
        currentDate = c; 
    }
    int calculateRemainTime(Date scheduledDate)
	{
        int days;
        long time_difference = currentDate.getTime() - scheduledDate.getTime();
        time_difference /= 1000;
        days = (int)(time_difference/(24*3600));
        return days;
	}
    double generateBill()
    {
        return calculateRemainTime(p.getAdmittedDate())*2000+doc.getFees()*calculateRemainTime(p.getAdmittedDate());
    }
    double generateIncome()
    {
        return doc.getFees()*calculateRemainTime(p.getAdmittedDate());
    }
    @Override public boolean equals(Object o)
    {
        if(this.doc == o)
            return true;
        else
            return false;
    }
    @Override public String toString()
    {
        return ("Patient: "+p.getName()+", "+doc.getSpecialty()+": "+doc.getName()+", Fee:Rs. "+doc.getFees());
    }
}
public class Hospital
{
    public static void main(String args[])
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Scanner sc = new Scanner(System.in);
        int docNo;
        boolean escape = false;
        System.out.println("Enter number of doctors:");
        int n = sc.nextInt();
        sc.nextLine();
        Doctor[] doc = new Doctor[n];
        Patient[] patient = new Patient[100];
        int patientNo = 0;
        for(int i=0; i<n; i++)
        {
            System.out.println("For Doctor "+(i+1));
            System.out.println("Enter name:");
            String name = sc.nextLine();
            System.out.println("Enter date of joining(yyyy-MM-dd):");
            String dateOfJoining = sc.nextLine();
            Date d;
            try
            {
                d = format.parse(dateOfJoining);
                System.out.println("Enter specialty:");
                String specialty = sc.nextLine();
                System.out.println("Enter fees:");
                double fees = sc.nextDouble();
                sc.nextLine();
                doc[i] = new Doctor(name, d, specialty, fees);
            }
            catch(ParseException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("\n**************************************************\n");
        System.out.println("Current date: "+new Date());
        do
        {
            System.out.println("Enter name of patient:");
            String name = sc.nextLine();
            System.out.println("Enter date to be admitted(yyyy-MM-dd):");
            String admittedDate = sc.nextLine();
            Date d;
            try
            {
                d = format.parse(admittedDate);
                System.out.println("");
                System.out.println("Sr.No\tDoctor Name\tSpecialty\t\tFees");
                for(int i=0; i<n; i++)
                {
                    System.out.println((i+1)+"\t"+doc[i]);
                }
                do
                {
                    System.out.println("Choose which doctor you want:");
                    docNo = sc.nextInt();
                    if(docNo<=n && docNo>=1)
                    {
                        patient[patientNo++] = new Patient(name, d, doc[docNo-1]);
                        System.out.println("To input another patient, press 1, otherwise press 0");
                        int repeat = sc.nextInt();
                        sc.nextLine();
                        if(repeat == 0)
                            escape = true;
                    }
                    else
                    {
                        System.out.println("Invalid Entry");
                    }
                }while(!(docNo<=n && docNo>=1));
            }
            catch(ParseException e)
            {
                e.printStackTrace();
            }
            if(escape)
                break;
        }while(true);
        Billing[] bill = new Billing[patientNo];
        for(int i=0; i<patientNo; i++)
        {
            bill[i] = new Billing(patient[i], doc[i], doc[i].getFees(), new Date());
        }
        double tot = 0;
        for(int i=0; i<patientNo; i++)
        {
            if(bill[i].equals(patient[i].getDoc()));
            {
                double billing = bill[i].generateBill();
                tot += billing;
                System.out.println("Record "+(i+1)+": "+bill[i]+" Bill: Rs."+billing);
                doc[i].updateIncome(bill[i].generateIncome());
            }
        }
        System.out.println("Total due amount:Rs. "+tot);
        sc.close();
    }
}
