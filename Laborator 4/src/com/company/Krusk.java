package com.company;

import java.util.*;

class Krusk
{
    static int V = 0;
    static int[] parent;
    static int INF = Integer.MAX_VALUE;

    static int find(int i)
    {
        while (parent[i] != i) i = parent[i];
        return i;
    }

    static void union1(int i, int j)
    {
        int a = find(i);
        int b = find(j);
        parent[a] = b;
    }

    void kruskalMST(int cost[][], int V)
    {
        parent = new int[V];
        int mincost = 0;

        for (int i = 0; i < V; i++)
            parent[i] = i;

        int edge_count = 0;
        while (edge_count < V - 1)
        {
            int min = INF, a = -1, b = -1;
            for (int i = 0; i < V; i++)
            {
                for (int j = 0; j < V; j++)
                {
                    if (find(i) != find(j) && cost[i][j] < min)
                    {
                        min = cost[i][j];
                        a = i;
                        b = j;
                    }
                }
            }

            union1(a, b);
            System.out.printf("Edge %d:(%d, %d) cost:%d \n", edge_count++, a, b, min);
            mincost += min;
        }
        System.out.printf("\nMinimum cost > %d \n", mincost);
    }
}