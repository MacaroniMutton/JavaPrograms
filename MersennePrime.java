import java.lang.Math;
class FindMerPrime
{
    boolean isPrime(int n)
    {
        boolean key = true;
        if(n==1)
            return false;
        for(int i=2; i<=Math.sqrt(n); i++)
        {
            if(n%i==0)
            {
                key = false;
                break;
            }
        }
        return key;
    }
    void printMersenne()
    {
        int mer;
        System.out.println("Mersenne primes for 2<=p<=31 are:");
        for(int p=2; p<=31; p++)
        {
            mer = (int)Math.pow(2,p)-1;
            if(isPrime(mer))
                System.out.println(mer+"\tvalue of p ="+p);
        }
    }
}
class MersennePrime 
{
    public static void main(String args[])
    {
        FindMerPrime ob = new FindMerPrime();
        ob.printMersenne();
    }
}
