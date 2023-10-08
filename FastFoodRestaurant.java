import java.util.*;

interface EatItHere {
    void serveOrder();
}
interface TakeAway {
    void deliverOrder();
}
class Customer implements EatItHere, TakeAway {
    static int orderNumber = 0;
    double orderPrice;
    double total;
    double additional;
    Customer() {
        orderPrice = 0;
        orderNumber++;
    }
    public static int getOrderNumber() {
        return orderNumber;
    }
    public double getOrderPrice() {
        return orderPrice;
    }
    public double getAdditional() {
        return additional;
    }
    public double getTotal() {
        return total;
    }
    public void serveOrder() {
        if((0.1*orderPrice)<=500)
            additional = (0.1*orderPrice);
        else
            additional = 500;
            total = orderPrice + additional;
    }
    public void deliverOrder() {
        if(((5*orderPrice)/100.0)>=45)
            additional = ((5*orderPrice)/100.0);
        else
            additional = 45;
        total = orderPrice + additional;
    }
    void incrementPrice(int no, int quantity) {
        switch(no) {
            case 1:
                orderPrice += 345 * quantity;
                break;
            case 2:
                orderPrice += 395 * quantity;
                break;
            case 3:
                orderPrice += 495 * quantity;
                break;
            case 4:
                orderPrice += 500 * quantity;
                break;
            default:
                System.out.println("Invalid Entry");
        }
    }
    static void menu() {
        System.out.println("**********************Item List**********************");
        System.out.println("Item Name\t\t\tPrice");
        System.out.println("1.Garden Fresh Pizza\t\t\t345");
        System.out.println("2.Veggie Delight Pizza\t\t\t395");
        System.out.println("3.Smoked Chicken Pizza\t\t\t495");
        System.out.println("4.BBQ Chicken Pizza\t\t\t500");
        System.out.println("*****************************************************");
    }
    

}

class FastFoodRestaurant {
    public static void main(String args[]) {
        int repeat, i = 0;
        int o, c;
        int filledSeats = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of seats in the restaurant:");
        int n = sc.nextInt();
        Customer[] customer = new Customer[100];
        do{
            customer[i] = new Customer();
            System.out.println("Welcome to Mario's Pizzeria! Do you want to eat here or takeaway?");
            System.out.println("Press 1 for eat here, 2 for takeaway:");
            c = sc.nextInt();
            if(c==1)
                filledSeats++;
            if(filledSeats>n) {
                System.out.println("Seats are full. Do you want takeaway? Press 1 for yes, 0 for no");
                int a = sc.nextInt();
                if(a==1)
                    c = 2;
                else {
                    System.out.println("Well then come back in 30-40 min.");
                    System.exit(0);
                }
            }
            do {
                Customer.menu();
                System.out.println("What would you like to order?(1/2/3/4):");
                int no = sc.nextInt();
                System.out.println("How much?");
                int quantity = sc.nextInt();
                customer[i].incrementPrice(no, quantity);
                System.out.println("Anything else? Press 1 for yes, 0 for no");
                repeat = sc.nextInt();
            } while (repeat != 0);
            switch(c) {
                case 1:
                    customer[i].serveOrder();
                    break;
                case 2:
                    customer[i].deliverOrder();
                    break;
                default:
                    System.out.println("Invalid Entry");
            }
            System.out.println("Order Number : "+Customer.getOrderNumber());
            System.out.println("Price : Rs. "+customer[i].getOrderPrice());
            System.out.println("Additional Charges : Rs. "+customer[i].getAdditional());
            System.out.println("Total Price: Rs. "+customer[i].getTotal());
            System.out.println("\nPress 1 to take order of another customer, otherwise press 0");
            o = sc.nextInt();
            if(o!=0) {
                i++;
            }
        }while(o!=0);
        sc.close();
    }
}