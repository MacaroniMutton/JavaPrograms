import java.util.*;

interface Volume {
    double PI = 3.14159;
    double getVolume();
}
interface SurfaceArea {
    double getSurfaceArea();
}
class Cylinder implements Volume, SurfaceArea {
    double radius;
    double height;
    double volume;
    double surfaceArea;
    public Cylinder(double r, double h) {
    	radius = r;
    	height = h;
    }
    public double getVolume() {
        return PI*radius*radius*height;
    }
    public double getSurfaceArea() {
        return 2 * PI * radius * height;
    }
}
public class MoreShapes {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int menu, goBack;
        do {
	        System.out.println("Enter radius and height of cylinder:");
	        double r = sc.nextDouble();
	        double h = sc.nextDouble();
	        Cylinder c = new Cylinder(r,h);
	        do{
	        	System.out.println("*********CYLINDER************");
	            System.out.println("1.Calculate Volume");
	            System.out.println("2.calculate Surface Area");
	            System.out.println("*****************************");
	            System.out.println("Enter your choice(1/2):");
	            int choice = sc.nextInt();
	            switch(choice) {
	            	case 1:
	            		System.out.println("Volume : "+c.getVolume()+" cu.m");
	            		break;
	            	case 2:
	            		System.out.println("Surface Area : "+c.getSurfaceArea()+" sq.m");
	            		break;
	            	default:
	            		System.out.println("Invalid Entry.");
	            }
	            System.out.println("To open the menu again, press 1, otherwise press 0");
	            menu = sc.nextInt();
	        }while(menu!=0);
	        System.out.println("Do you want to try different values of radius and height? Press 1 for yes, or 0 to exit the program.");
	        goBack = sc.nextInt();
    	}while(goBack!=0);
        sc.close();
    }
}

