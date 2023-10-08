import java.util.*;
import java.lang.Thread;

class IntegerGenerator {
    int num;
    int a;
    int b;
    int n;
    IntegerGenerator(int a, int b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
    }
    public void generate() {
        num = (int)(Math.random()*(b+1-a));
        System.out.println("Number generated is : "+num);
    }
    public void printSquare() {
        System.out.println("Square of "+num+" is : "+(int)Math.pow(num, 2));
    }
    public void printCube() {
        System.out.println("Cube of "+num+" is : "+(int)Math.pow(num, 3));
    }
}
class Thread1 extends Thread {
    IntegerGenerator ob;
    Thread1(IntegerGenerator ob) {
        this.ob = ob;
    }
    public void run() {
        synchronized(ob) {
            for(int i = 1; i<=ob.n; i++) {
                ob.generate();
                try {
                    Thread.sleep(1000);
                    ob.notify();
                    ob.wait();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
class Thread2 extends Thread {
    IntegerGenerator ob;
    Thread2(IntegerGenerator ob) {
        this.ob = ob;
    }
    public void run() {
        synchronized(ob) {
            for(int i = 1; i<=ob.n; i++) {
                ob.printSquare();
                try {
                    Thread.sleep(1000);
                    ob.wait();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
class Thread3 extends Thread {
    IntegerGenerator ob;
    Thread3(IntegerGenerator ob) {
        this.ob = ob;
    }
    public void run() {
        synchronized(ob) {
            for(int i = 1; i<=ob.n; i++) {
                ob.printCube();
                try {
                    Thread.sleep(1000);
                    ob.notifyAll();
                    ob.wait();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
public class ThreeThread {
    public static void main(String[] args) throws InterruptedException {
        ThreeThread m = new ThreeThread();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range for generating random number:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Enter how many numbers you want to generate:");
        int n = sc.nextInt();
        IntegerGenerator ob = new IntegerGenerator(a, b, n);
        Thread1 t1 = new Thread1(ob);
        Thread2 t2 = new Thread2(ob);
        Thread3 t3 = new Thread3(ob);

        t1.start();
        t2.start();
        t3.start();
    }
}
