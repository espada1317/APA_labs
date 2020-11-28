package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

import static com.company.Krusk.INF;
import static java.lang.StrictMath.abs;

public class Main {

    static int[][] generateMatrix(int V)
    {
        int res[][] = new int [V][V];

        for (int i = 0; i < V; i++)
            Arrays.fill(res[i], INF);

        Random rand = new Random();
        for(int i = 0; i < V - 1; i++)
        {
            res[i][i+1] = rand.nextInt(20) + 1;
            res[i+1][i] = res[i][i+1];
        }

        Scanner s = new Scanner(System.in);
        System.out.println("Dati numarul de arce aditionare> ");
        int nr_arce = s.nextInt();

        while (nr_arce > 0)
        {
            int i = rand.nextInt(V);
            int j = rand.nextInt(V);

            if (i != j && abs(i-j)!=1 && res[i][j]==INF)
            {
                res[i][j] = rand.nextInt(20) + 1;
                res[j][i] = res[i][j];
                nr_arce--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        long startTime, endTime, elapsedTime;

        Scanner s = new Scanner(System.in);
        System.out.println("Dati numarul de noduri(V) :");
        int V = s.nextInt();
        Krusk.V = V;

        /*
        int cost[][] = {{ INF,   4,   4, INF, INF, INF },
                        {   4, INF,   2, INF, INF, INF },
                        {   4,   2, INF,   3,   4,   2 },
                        { INF, INF,   3, INF,   3, INF },
                        { INF, INF,   4,   3, INF,   3 },
                        { INF, INF,   2, INF,   3, INF }};
        */

        int cost[][] = generateMatrix(V);

        for (int i = 0; i < V ; i++)
        {
            for (int j = 0; j < V; j++)
            {
                if(cost[i][j] != INF)
                    System.out.print(cost[i][j]+ "\t");
                else
                    System.out.print("INF\t");
            }
            System.out.println();
        }

        System.out.println("\n\n==========   Algoritmul - Kruskal   ==========");
        // #######################################################
        startTime = System.nanoTime();

        Krusk K = new Krusk();
        K.kruskalMST(cost, V);

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println(" >> Timpul de executie in microsecunde> " + (long)(elapsedTime/1000));
        //System.out.println("===============================================================");
        // #######################################################

        System.out.println("\n==========   Algoritmul - Prim   ==========");
        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++
        startTime = System.nanoTime();

        Prim g = new Prim();
        g.Prim(cost, V);

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println(" >> Timpul de executie in microsecunde> " + (long)(elapsedTime/1000));
        System.out.println("===============================================================");
        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++
    }
}
