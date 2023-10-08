import java.util.*;

class Item
{
    String name;
    double cost;
    char type;
    Item(String n, double c, char t)
    {
        name = n;
        cost = c;
        type = t;
    }
    Item()
    {
        name = "";
        cost = 0;
        type = 'p';
    }
}
class Cart
{
    Item[] item = new Item[100];
    int n;
    Cart(Item[] i, int n)
    {
        item = i;
        this.n = n;
    }
    double totalCost()
    {
        double total = 0;
        for(int i=0; i<n; i++)
        {
            total += item[i].cost;
        }
        return total;
    }
    Item[] perishable()
    {
        Item[] perishables = new Item[100];
        int k = 0;
        for(int i=0; i<n; i++)
        {
            if(item[i].type == 'p')
                perishables[k++] = item[i];
        }
        Item[] new_perishables = new Item[k];
        System.arraycopy(perishables, 0, new_perishables, 0, k);
        return new_perishables;
    }
    Item costliestNonPerishable()
    {
        int m = 0;
        for(int i=0; i<n; i++)
        {
            if(item[i].type == 'n')
            {
                m = i;
                break;
            }
        }
        for(int i=0; i<n; i++)
        {
            if(item[i].type == 'n')
            {
                if(item[i].cost>=item[m].cost)
                {
                    m = i;
                }
            }
        }
        return item[m];
    }
    boolean isNonPerishable()
    {
        boolean key = false;
        for(int i=0; i<n; i++)
        {
            if(item[i].type == 'n')
            {
                key = true;
                break;
            }
        }
        return key;
    }
    boolean isPerishable()
    {
        boolean key = false;
        for(int i=0; i<n; i++)
        {
            if(item[i].type == 'p')
            {
                key = true;
                break;
            }
        }
        return key;
    }
}

class ShoppingCart 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Cart[] cart = new Cart[3];
        Item[][] item = new Item[3][100];
        int o;
        int n;
        String name;
        double co;
        char t;
        for(int i=0; i<3; i++)
        {
            System.out.println("For cart "+(i+1)+", enter number of items:");
            n = sc.nextInt();
            for(int j=0; j<n; j++)
            {
                System.out.println("Enter name of item "+(j+1)+":");
                name = sc.next();
                System.out.println("Enter its cost:");
                co = sc.nextDouble();
                System.out.println("Enter its type(p for Perishable, n for Non-Perishable):");
                t = sc.next().charAt(0);
                item[i][j] = new Item(name, co, t);
            }
            cart[i] = new Cart(item[i], n);
        }
        do
        {
            System.out.println("\n");
            System.out.println("**************MENU***************");
            System.out.println("1. Total cost of each cart");
            System.out.println("2. All perishable items sold");
            System.out.println("3. Costliest non-perishable item sold");
            System.out.println("*********************************");
            System.out.println("\nEnter your choice(1/2/3) : ");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    double total = 0;
                    for(int i=0; i<3; i++)
                    {
                        System.out.println("Cost of cart "+(i+1)+" is : Rs."+cart[i].totalCost());
                        total += cart[i].totalCost();
                    }
                    System.out.println("Overall total cost : "+total);
                    break;
                case 2:
                    Item[] perishables = new Item[100];
                    double tot, grandTotal = 0;
                    for(int i=0; i<3; i++)
                    {
                        tot = 0;
                        if(!cart[i].isPerishable())
                        {
                            System.out.println("No perishable items in cart "+(i+1));
                            continue;
                        }
                        System.out.println("Perishable items for cart "+(i+1)+":");
                        perishables = cart[i].perishable();
                        for(int j=0; j<perishables.length; j++)
                        {
                            System.out.println("Name : "+perishables[j].name);
                            System.out.println("Cost : "+perishables[j].cost);
                            tot += perishables[j].cost;
                        }
                        System.out.println("Total cost of perishable items for this cart : Rs."+tot+"\n");
                        grandTotal += tot;
                    }
                    System.out.println("Grand total of all perishable items : Rs."+grandTotal);
                    break;
                case 3:
                    int max = 0;
                    String str = "";
                    for(int i=0; i<3; i++)
                    {
                        if(cart[i].isNonPerishable())
                        {
                            max = i;
                            break;
                        }
                    }
                    for(int i=0; i<3; i++)
                    {
                        if(!cart[i].isNonPerishable())
                            continue;
                        if(cart[i].costliestNonPerishable().cost >= cart[max].costliestNonPerishable().cost)
                        {
                            max = i;
                            str = cart[max].costliestNonPerishable().name;
                        }
                    }
                    if(str.equals(""))
                        System.out.println("Non Perishable items not present in any cart.");
                    else
                    {
                        System.out.println("Costliest Non-Perishable item : "+cart[max].costliestNonPerishable().name);
                        System.out.println("Its cost : Rs."+cart[max].costliestNonPerishable().cost);
                        System.out.println("Present in cart "+(max+1));
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Options are 1, 2 and 3.");
            }
            System.out.println("To open the menu again, press 1, otherwise press 0");
            o = sc.nextInt();
        }while(o!=0);
        sc.close();
    }
}
