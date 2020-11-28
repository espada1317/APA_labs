package com.company;

import java.util.Arrays;

class Prim {
    public void Prim(int G[][], int V) {

        int INF = 9999999;
        int nr_edge;

        boolean[] selected = new boolean[V];
        Arrays.fill(selected, false);

        nr_edge = 0;
        selected[0] = true;
        int mincost= 0;

        System.out.println("Edge : Weight");

        while (nr_edge < V - 1)
        {
            int min = INF;
            int x = 0;
            int y = 0;

            for (int i = 0; i < V; i++)
            {
                if (selected[i] == true)
                {
                    for (int j = 0; j < V; j++)
                    {
                        if (!selected[j] && G[i][j] != 0)
                        {
                            if (min > G[i][j])
                            {
                                min = G[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }

            System.out.println(x + " - " + y + " :  " + G[x][y]);
            selected[y] = true;
            nr_edge++;
            mincost+=G[x][y];
        }
        System.out.printf("Minimum cost > %d \n\n", mincost);
    }
}