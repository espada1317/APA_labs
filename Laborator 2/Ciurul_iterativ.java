public class Ciurul_iterativ {

    boolean[] primes=new boolean[Main.VALUE_MAX];

    static boolean isPrime(int value)
    {
        int j = 0;

        for(int i = 1; i <= value; i++) {
            if (value % i == 0) j++;
        }
        if(j == 2) return true;
        return false;
    }

    static void Ciurul_iterativ(int n)
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
