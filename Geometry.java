import java.util.*;

class Shape
{
    double getArea()
    {
        return 0;
    }
    double getPerimeter()
    {
        return 0;
    }
    double getSide()
    {
        return 0;
    }
}
class Circle extends Shape
{
    final double PI = 3.14159;
    double radius, area, perimeter;
    Circle(double r)
    {
        radius = r;
        area = PI*radius*radius;
        perimeter = 2*PI*radius;
    }
    double getArea()
    {
        return area;
    }
    double getPerimeter()
    {
        return perimeter;
    }
    double getSide()
    {
        return radius;
    }
}
class Triangle extends Shape
{
    double a, perimeter, area;
    Triangle(double a)
    {
        this.a = a;
        perimeter = 3*a;
        area = (Math.sqrt(3)*a*a)/4.0;
    }
    double getArea()
    {
        return area;
    }
    double getPerimeter()
    {
        return perimeter;
    }
    double getSide()
    {
        return a;
    }
}
class Pentagon extends Shape
{
    double a, perimeter, area;
    Pentagon(double a)
    {
        this.a = a;
        perimeter = 5*a;
        area = (Math.sqrt(5*(5+2*Math.sqrt(5)))*a*a)/4.0;
    }
    double getArea()
    {
        return area;
    }
    double getPerimeter()
    {
        return perimeter;
    }
    double getSide()
    {
        return a;
    }
}

class Geometry 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Shape shape;
        int o;
        do
        {
            System.out.println("************SHAPES**************");
            System.out.println("1.Circle");
            System.out.println("2.Triangle");
            System.out.println("3.Pentagon");
            System.out.println("********************************");
            System.out.println("Enter your choice(1/2/3):");
            int c = sc.nextInt();
            switch(c)
            {
                case 1:
                    System.out.println("Enter radius:");
                    double radius = sc.nextDouble();
                    shape = new Circle(radius);
                    System.out.println("Radius of circle: "+shape.getSide()+" m");
                    System.out.println("Perimeter of circle: "+shape.getPerimeter()+" m");
                    System.out.println("Area of circle: "+shape.getArea()+" sq.m");
                    break;
                case 2:
                    System.out.println("Enter side of triangle:");
                    double side = sc.nextDouble();
                    shape = new Triangle(side);
                    System.out.println("Side of Triangle: "+shape.getSide()+" m");
                    System.out.println("Perimeter of triangle: "+shape.getPerimeter()+" m");
                    System.out.println("Area of triangle: "+shape.getArea()+" sq.m");
                    break;
                case 3:
                    System.out.println("Enter side of pentagon:");
                    double a = sc.nextDouble();
                    shape = new Pentagon(a);
                    System.out.println("Side of pentagon: "+shape.getSide()+" m");
                    System.out.println("Perimeter of pentagon: "+shape.getPerimeter()+" m");
                    System.out.println("Area of pentagon: "+shape.getArea()+" sq.m");
                    break;
                default:
                    System.out.println("Invalid Entry");
            }
            System.out.println("To open the menu again, press 1 otherwise press 0");
            o = sc.nextInt();
        }while(o!=0);
        sc.close();
    }
}
