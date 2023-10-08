import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

abstract class Payment {
    double amount = 25000;
    abstract void paymentDetails(double update);
}
class CashPayment extends Payment {
    void paymentDetails(double update) {
        amount -= update;
        System.out.println("Cost:Rs. "+update);
        System.out.println("Payment done in cash.");
        System.out.println("Money left:Rs. "+amount);
    }
}
class CreditCardPayment extends Payment {
    String cardName;
    Date expiryDate;
    String creditCardNumber;
    CreditCardPayment(String name, Date exp, String no) {
        cardName = name;
        expiryDate = exp;
        creditCardNumber = no;
    }
    boolean isExpired() {
        Date currentDate = new Date();
        long time_difference = expiryDate.getTime() - currentDate.getTime();
        if(time_difference<0)
            return true;
        else
            return false;
    }
    void paymentDetails(double update) {
        System.out.println("Cost:Rs. " + update);
        amount -= update;
        System.out.println("Payment done using credit card.");
        System.out.println("Money left:Rs. " + amount);
    }
}
class Person {
    String name;
    String phoneNumber;
    Person(String name, String pn) {
        this.name = name;
        phoneNumber = pn;
    }

}
class Westside {
    int noOfClothes = 10;
    int noOfAccessories = 10;
    float cost = 5000;
    void decrementClothes(int u) {
        noOfClothes -= u;
    }
    void decrementAccessories(int u) {
        noOfAccessories -= u;
    }
}

class Shopping {
    public static void main(String args[]) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Scanner sc = new Scanner(System.in);
        Person[] person = new Person[5];
        Westside w = new Westside();
        int clothes, acc, o = 0, r = 0;
        int total = 0;
        for(int i=0; i<person.length; i++) {
            int repeat = 0;
            boolean nextCase = false;
            boolean paymentDone = false;
            do {
                total = 0;
                o = 0;
                r = 0;
                repeat = 0;
                clothes = 0;
                acc = 0;
                System.out.println("Customer "+(i+1)+": ");
                if(w.noOfClothes==0 && w.noOfAccessories==0) {
                    System.out.println("Clothes and Accessories out of stock");
                    continue;
                }
                if(w.noOfClothes==0)
                    System.out.println("Clothes out of Stock");
                if(w.noOfAccessories==0)
                    System.out.println("Accessories out of Stock");
                System.out.println("Enter name of person:");
                String name = sc.nextLine();
                System.out.println("Enter phone number:");
                String pn = sc.nextLine();
                person[i] = new Person(name, pn);
                if(w.noOfClothes>0) {
                    do {
                        do {
                            System.out.println("Enter no. of clothes you want to buy:");
                            clothes = sc.nextInt();
                        }while(clothes>10 || clothes<0);
                        if(w.noOfClothes<clothes) {
                            System.out.println("Not available. We have "+w.noOfClothes+" clothes and "+w.noOfAccessories+" accessories available.\nIf you want to try again to buy clothes, press 1 otherwise press 0");
                            o = sc.nextInt();
                            clothes = 0;
                        }
                        else
                            o = 0;
                    }while(o!=0);
                    total += clothes*w.cost;
                }
                if(w.noOfAccessories>0) {
                    do {
                        do {
                            System.out.println("Enter no. of accessories you want to buy:");
                            acc = sc.nextInt();
                        }while(acc>10 || acc<0);
                        if(w.noOfAccessories<acc) {
                            System.out.println("Not available. We have "+w.noOfClothes+" clothes and "+w.noOfAccessories+" accessories available.\nIf you want to try again to buy accessories, press 1 otherwise press 0");
                            r = sc.nextInt();
                            acc = 0;
                        }
                        else
                            r = 0;
                    }while(r!=0);
                    total += acc*w.cost;
                }
                System.out.println("Enter method of payment:");
                System.out.println("1 for Cash");
                System.out.println("2 for Credit Card");
                int paymentMethod = sc.nextInt();
                sc.nextLine();
                switch(paymentMethod) {
                    case 2:
                        System.out.println("Enter name on the card:");
                        String cardname = sc.nextLine();
                        System.out.println("Enter expiration date(yyyy-MM-dd):");
                        String d = sc.nextLine();
                        Date expDate = new Date();
                        try {
                            expDate = format.parse(d);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Enter credit card number:");
                        String no = sc.nextLine();
                        CreditCardPayment pay2 = new CreditCardPayment(cardname, expDate, no);
                        if(pay2.isExpired()) {
                            System.out.println("Your credit card has expired.");
                            System.out.println("Do you want to pay in cash? Press 1 for yes, 0 for no");
                            int isCash = sc.nextInt();
                            sc.nextLine();
                            if(isCash==0)
                                break;
                            else
                                nextCase = true;
                        }
                        else {
                            if(pay2.amount-total<0)
                                System.out.println("Not enough money in credit card");
                            else {
                                pay2.paymentDetails(total);
                                w.decrementAccessories(acc);
                                w.decrementClothes(clothes);
                                paymentDone = true;
                            }
                        }
                        if(!nextCase)
                            break;
                    case 1:
                        CashPayment pay1 = new CashPayment();
                        if(pay1.amount-total<0)
                            System.out.println("You don't have enough cash.");
                        else {
                            pay1.paymentDetails(total);
                            w.decrementAccessories(acc);
                            w.decrementClothes(clothes);
                            paymentDone = true;
                        }
                        break;
                    default:
                        System.out.println("Invalid Entry.");
                }
                if(!paymentDone) {
                    System.out.println("To change your cart, press 1, otherwise press 0");
                    repeat = sc.nextInt();
                    sc.nextLine();
                }
            }while(repeat!=0);
        }
        sc.close();
    }
}
