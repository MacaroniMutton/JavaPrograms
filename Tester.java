import java.util.*;
class Production
{
    String title;
    String director;
    String writer;
    static int boxOfficeCollection = 0;
    
    public Production(String t, String d, String w)
    {
        setTitle(t);
        setDirector(d);
        setWriter(w);
    }
    public String getTitle() 
    {
        return title;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }
    public String getDirector() 
    {
        return director;
    }
    public void setDirector(String director) 
    {
        this.director = director;
    }
    public String getWriter() 
    {
        return writer;
    }
    public void setWriter(String writer) 
    {
        this.writer = writer;
    }
    public static int getBoxOfficeCollection() 
    {
        return boxOfficeCollection;
    }
    @Override public String toString()
    {
        return ("Title : "+title+"\nDirector : "+director+"\nWriter : "+writer);
    }
}
class Play extends Production
{
    static int performances = 0;
    int costPerSeat = 500;
    int noOfSeats = 0;
    public Play(String t, String d, String w)
    {
        super(t,d,w);
        updatePerformances();
    }
    public void updatePerformances()
    {
        performances++;
    }
    public static int getPerformances() 
    {
        return performances;
    }
    public int getCostPerSeat() 
    {
        return costPerSeat;
    }
    public void updateNoOfSeats(int noOfSeats) 
    {
        this.noOfSeats += noOfSeats;
    }
    public void updateBoxOfficeCollection()
    {
        boxOfficeCollection += costPerSeat*noOfSeats;
    }
    @Override public String toString()
    {
        return ("Title : "+title+"\nDirector : "+director+"\nWriter : "+writer+"\nNo. of performances : "+performances);
    }
}
class Musical extends Play
{
    String composer;
    String lyricist;
    int costPerSeat = 800;
    public Musical(String t, String d, String w, String c, String l)
    {
        super(t,d,w);
        setComposer(c);
        setLyricist(l);
    }
    public String getComposer() 
    {
        return composer;
    }
    public void setComposer(String composer) 
    {
        this.composer = composer;
    }
    public String getLyricist() 
    {
        return lyricist;
    }
    public void setLyricist(String lyricist) 
    {
        this.lyricist = lyricist;
    }
    public int getCostPerSeat() 
    {
        return costPerSeat;
    }
    public void updateBoxOfficeCollection()
    {
        boxOfficeCollection += costPerSeat*noOfSeats;
    }
    @Override public String toString()
    {
        return ("Title : "+title+"\nDirector : "+director+"\nWriter : "+writer+"\nNo. of performances : "+performances+"\nComposer : "+composer+"\nLyricist : "+lyricist);
    }
}

public class Tester 
{
    public static void main(String args[])
    {
        int seats, isTickets, o;
        Scanner sc = new Scanner(System.in);
        Play[] p = new Play[3];
        Musical[] m = new Musical[2];
        p[0] = new Play("The GodFather","Francis Ford Coppola","Mario Puzo");
        p[1] = new Play("Inception","Christopher Nolan","Christopher Nolan");
        p[2] = new Play("Man of Steel","Zack Snyder","David S. Goyer");
        m[0] = new Musical("Beauty and the beast","	Bill Condon","Linda Woolverton","Alan Menken","Howard Ashman");
        m[1] = new Musical("Encanto","Jared Bush","Byron Howard","Germaine Franco","Lin-Manuel Miranda");
        do
        {
            System.out.println("Welcome to Book My Show! We currently have these shows available:\n");
            System.out.println("**********AVAILABLE SHOWS**********");
            System.out.println("");
            System.out.println("              PLAYS                ");
            System.out.println("1. The GodFather");
            System.out.println("2. Inception");
            System.out.println("3. Man of Steel");
            System.out.println("");
            System.out.println("            MUSICALS               ");
            System.out.println("1. Beauty and the Beast");
            System.out.println("2. Encanto");
            System.out.println("************************************");
            System.out.println("Are you interested in watching a Play(Press 1) or a Musical(Press 2)?");
            int menuOption = sc.nextInt();
            System.out.println("Which one?");
            int k = sc.nextInt();
            switch(menuOption)
            {
                case 1:
                    System.out.println(p[k-1]);
                    System.out.println("Cost per Seat : Rs."+p[k-1].getCostPerSeat());
                    System.out.println("Do you want to buy tickets for this? Press 1 for yes, 0 for no:");
                    isTickets = sc.nextInt();
                    if(isTickets == 1)
                    {
                        do
                        {
                            System.out.println("Enter how many seats:");
                            seats = sc.nextInt();
                            if(seats>=0)
                                p[k-1].updateNoOfSeats(seats);
                            else
                                System.out.println("Invalid Entry.");
                        }while(seats<0);
                    }
                    break;
                case 2:
                    System.out.println(m[k-1]);
                    System.out.println("Cost per Seat : Rs."+m[k-1].getCostPerSeat());
                    System.out.println("Do you want to buy tickets for this? Press 1 for yes, 0 for no:");
                    isTickets = sc.nextInt();
                    if(isTickets == 1)
                    {
                        do
                        {
                            System.out.println("Enter how many seats:");
                            seats = sc.nextInt();
                            if(seats>=0)
                                m[k-1].updateNoOfSeats(seats);
                            else
                                System.out.println("Invalid Entry.");
                        }while(seats<0);
                    }
                    break;
                default:
                    System.out.println("Invalid Entry.");
            }
            System.out.println("To open the list of shows again, press 1, otherwise press 0 to leave");
            o = sc.nextInt();
        }while(o!=0);
        for(int i=0; i<3; i++)
        {
            p[i].updateBoxOfficeCollection();
        }
        for(int i=0; i<2; i++)
        {
            m[i].updateBoxOfficeCollection();
        }
        System.out.println("Total number of performances : "+Play.getPerformances());
        System.out.println("Box Office Collection : "+Production.getBoxOfficeCollection());
        sc.close();
    }
}
