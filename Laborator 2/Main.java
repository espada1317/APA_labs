import java.util.Scanner;

public class Main {

    static final int VALUE_MAX = 100000000;

    static int n;
    static boolean ciur[] = new boolean[VALUE_MAX];

    static int no_primes = 0;
    static int prime [] = new int[VALUE_MAX];

    static void Ciurul_Eratostene(int n)
    {
        ciur[0] = ciur[1] = true;

        for (int j = 4; j <= n; j+=2)
            ciur[j] = true;
        for (int i = 3; i * i <= n; i += 2)
            if (!ciur[i])
                for (int j = i * i; j <= n; j += 2 * i)
                    ciur[j] = true;

        prime[no_primes++] = 2;
        for (int i = 3; i <= n; i += 2)
            if (!ciur[i])
                prime[no_primes++] = i;

        System.out.println(" >> Numerele prime de la 1 la " + n + " >");
        for (int i = 0; i < no_primes; i++) {
            //if(i % 20 == 0) System.out.println();
            System.out.print(prime[i] + " ");
        }

        System.out.println("\n\n >> Numarul de valori prime > " + no_primes);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Dati valoarea n> ");
        n = scan.nextInt();

        System.out.println("##########   Algoritmul - Ciurul lui Eratostene   #########");
        // #######################################################  Ciurul lui Eratostene
        long startTime = System.nanoTime();
        Ciurul_Eratostene(n);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        System.out.println(" >> Timpulde executie in milisecunde> " + (long)(elapsedTime/1000000));
        System.out.println("############################################################");
        // #######################################################


        System.out.println("\n++++++++  Algoritmul - Ciurul radical   ++++++++");
        // #######################################################  Ciurul radical
        startTime = System.nanoTime();
        Ciurul_radical.Ciurul_radical(n);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println(" >> Timpulde executie in milisecunde> " + (long)(elapsedTime/1000000));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        // #######################################################


        System.out.println("\n==========   Algoritmul - Ciurul iterativ   ==========");
        // #######################################################  Ciurul iterativ
        startTime = System.nanoTime();
        Ciurul_iterativ.Ciurul_iterativ(n);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println(" >> Timpulde executie in milisecunde> " + (long)(elapsedTime/1000000));
        System.out.println("===============================================================");
        // #######################################################


        System.out.println();
    }
}