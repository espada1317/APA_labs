import static java.lang.Math.sqrt;

public class Ciurul_radical {

    boolean[] primes=new boolean[Main.VALUE_MAX];

    static boolean isPrime(int value)
    {
        for(int i = 2; i <= sqrt(value); i++) {
            if(value % i == 0)
                return false;
        }
        return true;
    }

    static void Ciurul_radical(int n)
    {
        int k = 0;

        System.out.println(" >> Numerele prime de la 1 la " + n + " >");

        for (int i = 2; i < n; i++)
        {
            //if(i % 100 == 0) System.out.println();
            if(isPrime(i))
            {
                System.out.print(i + " ");
                k++;
            }
        }

        System.out.println("\n\n >> Numarul de valori prime > " + k);
    }
}
