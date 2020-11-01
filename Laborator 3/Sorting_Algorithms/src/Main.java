import com.sun.scenario.effect.Merge;
import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import java.util.Collections;
import java.util.Random;
import java.util.Arrays;

public class Main {

    final static int N = 100000;
    static int iteration_mg = 0;
    static int iteration_qs = 0;
    static int iteration_ts = 0;

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args)
    {
        Random rd = new Random();
        Integer[] arr_s = new Integer[N];
        int [] arr_mg, arr_qs, arr_ts;

        arr_mg = new int [N];
        arr_qs = new int [N];
        arr_ts = new int [N];

        int [] arr = new int[N];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = (rd.nextInt(N)-N/4);
            arr_s[i] = Integer.valueOf(arr[i]);
        }

        Arrays.sort(arr_s, Collections.reverseOrder());


        for (int i = 0; i < arr.length; i++)
        {
            arr_mg[i] = arr_s[i];
            arr_qs[i] = arr_s[i];
            arr_ts[i] = arr_s[i];
        }

//        arr_mg = arr.clone();
//        arr_qs = arr.clone();
//        arr_ts = arr.clone();

        long startTime, endTime, elapsedTime;

        System.out.println("\n==========   Algoritmul - MergeSort   ==========");
        // #######################################################
        //System.out.println("Array initial>");
        //printArray(arr_mg);

        startTime = System.nanoTime();
        MergeSort ms =  new MergeSort();
        ms.sort(arr_mg ,0, arr.length-1);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println("\n >> Numarul de iteratii> " + iteration_mg);
        System.out.println(" >> Timpul de executie in microsecunde> " + (long)(elapsedTime/1000));
        System.out.println("\nSorted array>");
        //printArray(arr_mg);
        //System.out.println("===============================================================");
        // #######################################################

        System.out.println("\n==========   Algoritmul - QuickSort   ==========");
        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++
        //System.out.println("Array initial>");
        //printArray(arr_qs);

        startTime = System.nanoTime();
        QuickSort qs =  new QuickSort();
        qs.sort(arr_qs ,0, arr.length-1);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println("\n >> Numarul de iteratii> " + iteration_qs);
        System.out.println(" >> Timpul de executie in microsecunde> " + (long)(elapsedTime/1000));
        //System.out.println("\nSorted array>");
        //printArray(arr_qs);
        System.out.println("===============================================================");
        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++

        System.out.println("\n==========   Algoritmul - TimSort   ==========");
        // =======================================================
        //System.out.println("Array initial>");
        //printArray(arr_qs);

        startTime = System.nanoTime();
        TimSort ts =  new TimSort();
        int n = arr_ts.length;
        ts.timSort(arr_ts, n);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println("\n >> Numarul de iteratii> " + iteration_ts);
        System.out.println(" >> Timpul de executie in microsecunde> " + (long)(elapsedTime/1000));
        //System.out.println("\nSorted array>");
        //printArray(arr_ts);
        System.out.println("===============================================================");
        // =======================================================
    }
}