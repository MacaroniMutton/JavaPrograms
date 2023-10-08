import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class AverageException extends Exception {
    AverageException() {
        System.out.println("Batting average of entire team is less than 20");
    }
}

class Cricketer {
    String player_name;
    int runs_hit;
    int innings_count;
    int not_out_count;
    double batting_avg;
    
    
    public Cricketer(String player_name, int runs_hit, int innings_count, int not_out_count) {
        super();
        this.player_name = player_name;
        this.runs_hit = runs_hit;
        this.innings_count = innings_count;
        this.not_out_count = not_out_count;
    }
    void calc_avg() {
        try{
            batting_avg = (runs_hit*1.0) / (innings_count - not_out_count);
        }
        catch(ArithmeticException e) {
            System.out.println("Cricketer hasn't played yet");
        }
    }
    double get_avg() {
        return batting_avg;
    }
    @Override
    public String toString() {
        return (player_name+"\t\t"+batting_avg+"\t\t"+runs_hit+"\t\t"+innings_count+"\t\t"+not_out_count); 
    }
}

public class CricketMain {
    static void bubbleSortAscending(Cricketer[] cricketer) {
        Cricketer temp;
        for (int i = 0; i < cricketer.length - 1; i++) {
            for (int j = 0; j < cricketer.length - 1 - i; j++) {
                if (cricketer[j].get_avg() > cricketer[j + 1].get_avg()) {
                    temp = cricketer[j];
                    cricketer[j] = cricketer[j + 1];
                    cricketer[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        boolean repeat = true;
        String pn;
        int run = 0, inn = 0, nout = 0;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Cricketer[] cricketer = new Cricketer[11];
        double total_avg = 0;
        try{
            for(int i = 0; i<cricketer.length; i++) {
                System.out.println("Cricketer "+(i+1));
                System.out.println("Enter name of player:");
                pn = input.readLine();
                while(repeat){
                    try{
                    System.out.println("Enter no. of runs hit:");
                    run = Integer.parseInt(input.readLine());
                    if(run<0)
                        throw new ArithmeticException();
                    repeat = false;
                    }
                    catch(NumberFormatException e){
                        repeat = true;
                        System.out.println("Should be integer");
                    }
                    catch(ArithmeticException e){
                        repeat = true;
                        System.out.println("Should be greater than 0");
                    }
                }
                repeat = true;
                while(repeat){
                    try{
                    System.out.println("Enter innings count:");
                    inn = Integer.parseInt(input.readLine());
                    if(inn<0)
                        throw new ArithmeticException();
                    if(inn==0 && run!=0)
                    throw new ArithmeticException();
                    repeat = false;
                    }
                    catch(NumberFormatException e){
                        repeat = true;
                        System.out.println("Should be integer");
                    }
                    catch(ArithmeticException e){
                        repeat = true;
                        System.out.println("Should be greater than 0");
                    }
                }
                repeat = true;
                while(repeat){
                    try{
                    System.out.println("Enter not out count:");
                    nout = Integer.parseInt(input.readLine());
                    if(nout>=inn)
                        throw new ArithmeticException();
                    repeat = false;
                    }
                    catch(NumberFormatException e){
                        repeat = true;
                        System.out.println("Should be integer");
                    }
                    catch(ArithmeticException e){
                        repeat = true;
                        System.out.println("Not out count should be lesser than innings count");
                    }
                }
                repeat = true;
                cricketer[i] = new Cricketer(pn, run, inn, nout);
                cricketer[i].calc_avg();
                System.out.println("Batting average : "+cricketer[i].get_avg());
                total_avg += cricketer[i].get_avg();
            }
            total_avg /= cricketer.length;
            bubbleSortAscending(cricketer);
            System.out.println("Sr.No\tCricketer Name\tBatting_avg\tRuns hit\tInnings count\tNot out count");
            for(int i = 0; i<cricketer.length; i++) {
                System.out.println((i+1)+"\t"+cricketer[i]);
            }
            System.out.println("Total average : "+total_avg);
            if(total_avg<20)
                throw new AverageException();
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Max number of cricketers in a team is 11");
        }
        catch(ArrayStoreException e){
            e.printStackTrace();
        }
        catch(AverageException e){
            System.out.println("Exception in batting average got caught");
        }
        finally {
            input.close();
        }
    }
}
