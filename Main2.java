import java.util.*;
class Table{
    int city, days;
    float[] temp = new float[days];
    Table(int city, int days, float[] temp)
    {
        this.city=city;
        this.days=days;
        this.temp=temp;
    }
    void display(float arr[][])
    {
        System.out.print("city ");
        for(int i = 0; i<days; i++)
        {
            System.out.print("\tday "+ (i+1) + "\t");
        }
            System.out.println();
        for(int m =0; m<city; m++)
        {
            System.out.print((m+1));
            for(int n=0; n<days; n++)
            {
                System.out.print("\t" + arr[m][n] + "\t");
            }
                System.out.println();
           
        }
    }
   
    int maxTemp()
    {
        float max = temp[0];
        int dmax= 0;
        for(int i=0; i<days; i++)
        {
            if(max<=temp[i])
            {
                max = temp[i];
                dmax=i;
            }
        }
        System.out.println("Highest temp = " + max + " on day " + (dmax+1));
        return dmax;
    }
   
    int minTemp()
    {
        float min = temp[0];
        int dmin= 0;
        for(int i=0; i<days; i++)
        {
            if(min>=temp[i])
            {
                min = temp[i];
                dmin=i;
            }
        }
        System.out.println("Lowest temp = " + min + " on day " + (dmin+1));
        return dmin;
    }
}
class Main2
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of cities: ");
        int city = sc.nextInt();
        System.out.println("Enter the no of days: ");
        int days = sc.nextInt();
        float arr[][] = new float[city][days];
        Table[] t = new Table[city];
        for(int i=0; i<city; i++)
        {
            System.out.print("\nEnter the temperatures for city "+ (i+1) + " on :");
            System.out.println();
            for(int j=0; j<days; j++)
            {
                System.out.print("Day "+ (j+1) + ": ");
                arr[i][j] = sc.nextFloat();
            }
            t[i] = new Table(city, days, arr[i]);
        }
        t[0].display(arr);
        int[] maximaIndices = new int[city];
        int[] minimaIndices = new int[city];
        for(int i=0; i<city; i++)
        {
            System.out.println("For city "+(i+1)+":");
            maximaIndices[i] = t[i].maxTemp();
            minimaIndices[i] = t[i].minTemp();
        }
        int globalMax = maximaIndices[0];
        int globalMin = minimaIndices[0];
        int cityMax = 0;
        int cityMin = 0;
        for(int i=0; i<city; i++)
        {
            if(arr[i][maximaIndices[i]]>arr[cityMax][globalMax])
            {
                cityMax = i;
                globalMax = maximaIndices[i];
            }
            if(arr[i][minimaIndices[i]]<arr[cityMin][globalMin])
            {
                cityMin = i;
                globalMin = minimaIndices[i];
            }
        }
        System.out.println("Global maximum temperature: "+(arr[cityMax][globalMax])+" in city "+(cityMax+1)+" on day "+(globalMax+1));
        System.out.println("Global minimum temperature: "+(arr[cityMin][globalMin])+" in city "+(cityMin+1)+" on day "+(globalMin+1));
    }
}
