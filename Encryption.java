import java.util.*;

class Cipher
{
	String message;
	int key;
	Cipher(String m, int k)
	{
		message = m;
		key = k;
	}
	void encrypt()
	{
		char c;
		String encrypted_message = "";
		for(int i = 0; i<message.length(); i++)
		{
			c = message.charAt(i);
			if((c+key)>126)
				encrypted_message += (char)(32+((c+key)-127));
			else
				encrypted_message += (char)((c+key));
		}
		System.out.println(encrypted_message);
	}
	void decrypt()
	{
		char c;
		String decrypted_message = "";
		for(int i = 0; i<message.length(); i++)
		{
			c = message.charAt(i);
			if((c-key)<32)
				decrypted_message += (char)((c-key)+127-32);
			else
				decrypted_message += (char)((c-key));
		}
		System.out.println(decrypted_message);
	}
}
class Encryption
{
	public static void main(String args[])
	{
		Cipher ci;
		int o;
		String msg1, msg2, str;
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("MENU");
			System.out.println("1.Encrypt Message");
			System.out.println("2.Decrypt Message");
			System.out.println("3.Input a sentence:");
			System.out.println("Enter your choice:");
			int c = sc.nextInt();
			sc.nextLine();
			switch(c)
			{
				case 1:
					System.out.println("Enter the message:");
					msg1 = sc.nextLine();
					System.out.println("Enter the key(1-100):");
					int k = sc.nextInt();
					ci = new Cipher(msg1, k);
					ci.encrypt();
					break;
				case 2:
					System.out.println("Enter the message:");
					msg2 = sc.nextLine();
					System.out.println("Key\t\tDecrypted Message");
					for(int i=1; i<=100; i++)
					{
						System.out.print(i+"\t\t");
						ci = new Cipher(msg2,i);
						ci.decrypt();
					}
					break;
				case 3:
					System.out.println("Enter a sentence:");
					str = sc.nextLine();
					String sub = "lock";
					int ctr = 0;
					for(int i=0; i<str.length()-3; i++)
					{
						if(sub.equals(str.substring(i,i+4)))
							ctr++;
					}
					if(ctr==3)
						System.out.println("welcome to group");
					else
						System.out.println("you may leave");
					break;
				default:
					System.out.println("Invalid option");
			}
			System.out.println("To open the menu again, press 1, otherwise press 0");
			o = sc.nextInt();
		}while(o!=0);
		sc.close();
	}
}




