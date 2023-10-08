import java.util.*;
class Wall
{
    double length;
    double breadth;
    double cost;
    Wall(double l, double b)
    {
        length = l;
        breadth = b;
    }
    static double cost(Wall w)
    {
        w.length *= 3.28;
        w.breadth *= 3.28;
        double area = w.length*w.breadth;
        w.cost = area*10;
        return w.cost;
    }
}

class P4 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of wall(in metres) :");
        double l = sc.nextDouble();
        System.out.println("Enter breadth of wall(in metres) :");
        double b = sc.nextDouble();
        Wall w = new Wall(l,b);
        double cost = Wall.cost(w);
        System.out.println("Cost of painting the wall : Rs."+cost);
        sc.close();
    }
}
