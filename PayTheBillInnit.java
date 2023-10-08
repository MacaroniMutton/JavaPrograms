import java.util.*;

class Purchase
{
	String item;
	double price;
	int quantity;
	int additional_quantity;
	static double totPrice = 0;
	Purchase(String i, double p)
	{
		item = i;
		price = p;
		quantity = 0;
	}
	double billing()
	{
		return price*additional_quantity;
	}
	void updateQuantity(int q)
	{
		quantity += q;
		additional_quantity = q;
	}
	static double payment() //Cash on Delivery
	{
		return (totPrice+50);
	}
	static double payment(String bankName, long accountNo)  //Net Banking
	{
		return (totPrice+(totPrice/100));
	}
	static double payment(long creditCardNo) //Credit Card
	{
		return (totPrice+((2*totPrice)/100));
	}
	void displayCart()
	{
		if(quantity>0)
		{
			System.out.println("Item name: "+item);
			System.out.println("Quantity: "+quantity);
			System.out.println("Price: "+ (price*quantity));
		}
	}
}
class PayTheBillInnit
{
	static void itemList()
	{
		System.out.println("**********************Item List**********************");
		System.out.println("Item Name\t\t\tPrice");
		System.out.println("1.Garden Fresh Pizza\t\t\t345");
		System.out.println("2.Veggie Delight Pizza\t\t\t395");
		System.out.println("3.Smoked Chicken Pizza\t\t\t495");
		System.out.println("4.BBQ Chicken Pizza\t\t\t500");
		System.out.println("*****************************************************");
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Purchase[] p = new Purchase[100];
		int k,q,o;
		double tot;
		String bankName;
		long accno,cred;
		p[0] = new Purchase("Garden Fresh Pizza", 345);
		p[1] = new Purchase("Veggie Delight Pizza", 395);
		p[2] = new Purchase("Smoked Chicken Pizza", 495);
		p[3] = new Purchase("BBQ Chicken Pizza", 500);
		itemList();
		do
		{
		System.out.println("\n\n");
		System.out.println("***********MENU***********");
		System.out.println("1.Add Item");
		System.out.println("2.View Cart");
		System.out.println("3.Go for payment");
		System.out.println("**************************");
		System.out.println("Enter your choice(1/2/3):");
		int c = sc.nextInt();
		System.out.println("\n\n");
		switch(c)
		{
			case 1:
				itemList();
				System.out.println("Enter item number(1/2/3/4):");
				k = sc.nextInt();
				k -= 1;
				System.out.println("Enter its quantity:");
				q = sc.nextInt();
				p[k].updateQuantity(q);
				Purchase.totPrice += p[k].billing();
				break;
			case 2:
				System.out.println("Cart:");
				for(int i=0; i<4; i++)
				{
					p[i].displayCart();
				}
				System.out.println("Total Price(without additional Charges):" + Purchase.totPrice);
				break;
			case 3:
				System.out.println("***********Payment Method***********");
				System.out.println("1.COD");
				System.out.println("2.Net Banking");
				System.out.println("3.Credit Card");
				System.out.println("************************************");
				System.out.println("Enter payment method(1/2/3):");
				int g = sc.nextInt();
				switch(g)
				{
					case 1:
						tot = Purchase.payment();
						for(int i=0; i<4; i++)
						{
							p[i].displayCart();
						}
						System.out.println("Total Price(without additional Charges):" + Purchase.totPrice);
						System.out.println("Total Price(with additional Charges):" + tot);
						System.exit(0);
						break;
					case 2:
						System.out.println("Enter bank name:");
						bankName = sc.next();
						System.out.println("Enter account no:");
						accno = sc.nextLong();
						tot = Purchase.payment(bankName, accno);
						for(int i=0; i<4; i++)
						{
							p[i].displayCart();
						}
						System.out.println("Total Price(without additional Charges):" + Purchase.totPrice);
						System.out.println("Total Price(with additional Charges):" + tot);
						System.exit(0);
						break;
					case 3:
						System.out.println("Enter credit card no:");
						cred = sc.nextLong();
						tot = Purchase.payment(cred);
						for(int i=0; i<4; i++)
						{
							p[i].displayCart();
						}
						System.out.println("Total Price(without additional Charges):" + Purchase.totPrice);
						System.out.println("Total Price(with additional Charges):" + tot);
						System.exit(0);
						break;
					default:
						System.out.println("Invalid Choice");
				}
			default:
				System.out.println("Invalid Choice");
				
		}
		System.out.println("To open the menu again, press 1, else press 0");
		o = sc.nextInt();
		}while(o!=0);
		sc.close();
	}	
}








