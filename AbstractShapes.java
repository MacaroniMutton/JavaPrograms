import java.util.*;
abstract class Shapes {
    final static double PI = 3.14159;
    abstract double RectangleArea(double l, double b);
    abstract double SquareArea(double s);
    abstract double CircleArea(double r);
} 
class Rectangles extends Shapes {
    double RectangleArea(double l, double b) {
        double area = l*b;
        return area;
    }
    double SquareArea(double s) {
        return 0;
    }
    double CircleArea(double r) {
        return 0;
    }
}

class Squares extends Shapes {
    double RectangleArea(double l, double b) {
        return 0;
    }

    double SquareArea(double s) {
        double area = s*s;
        return area;
    }

    double CircleArea(double r) {
        return 0;
    }
}

class Circles extends Shapes {
    double RectangleArea(double l, double b) {
        return 0;
    }

    double SquareArea(double s) {
        return 0;
    }

    double CircleArea(double r) {
        double area = PI*r*r;
        return area;
    }
}
class AbstractShapes {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Rectangles rec = new Rectangles();
        Squares sq = new Squares();
        Circles circ = new Circles();
        for(int i=0; i<4; i++) {
            System.out.println("Enter length and breadth of rectangle "+(i+1)+": ");
            double l = sc.nextDouble();
            double b = sc.nextDouble();
            System.out.println("Area : "+rec.RectangleArea(l, b)+" sq.m");
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter side of square " + (i + 1) + ": ");
            double s = sc.nextDouble();
            System.out.println("Area : " + sq.SquareArea(s) + " sq.m");
        }
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter radius of circle " + (i + 1) + ": ");
            double r = sc.nextDouble();
            System.out.println("Area : " + circ.CircleArea(r) + " sq.m");
        }
        sc.close();
    }
}
