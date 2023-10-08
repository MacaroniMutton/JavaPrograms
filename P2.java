import java.util.*;
class Product
{
    String product_name;
    double prize;
    String brand;
    double gst_rate_percent;
    double gst;
    double total_prize;
    void setter(String p, double pr, String b)
    {
        product_name = p;
        prize = pr;
        brand = b;
        gst_rate_percent = 5;
    }
    void displayGST()
    {
        gst = prize*gst_rate_percent/100;
        total_prize = prize + gst;
        System.out.println("*******************************************************\n");
        System.out.println("Product name:"+product_name+"\t\t"+"Brand:"+brand+"\n");
        System.out.println("Original prize : "+prize);
        System.out.println("GST : "+gst);
        System.out.println("Total prize : "+total_prize);
        System.out.println("\n*******************************************************\n");
    }
}

class P2 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of products:");
        int n = sc.nextInt();
        sc.nextLine();
        Product[] p = new Product[n];
        for(int i=0; i<p.length; i++)
        {
            System.out.println("For Product "+(i+1)+" : ");
            System.out.println("Enter product name : ");
            String product_name = sc.nextLine();
            System.out.println("Enter its original prize : ");
            double prize = sc.nextDouble();
            sc.nextLine();
            System.out.println("Enter brand : ");
            String brand = sc.nextLine();
            p[i] = new Product();
            p[i].setter(product_name, prize, brand);
        }
        System.out.println("");
        for(int i=0; i<p.length; i++)
        {
            System.out.println("\t\tProduct "+(i+1));
            p[i].displayGST();
        }
        sc.close();
    }
}
