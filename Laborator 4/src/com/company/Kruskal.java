package com.company;

import java.util.*;

class Kruskal
{
    class Edge implements Comparable<Edge>
    {
        int src, dest, weight;

        public int compareTo(Edge compareEdge)
        {
            return this.weight - compareEdge.weight;
        }
    };

    class subset
    {
        int parent, rank;
    };

    int vertices, edges;
    Edge edge[];

    void readEdges(int edges)
    {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < edges; i++)
        {
            System.out.println("\nArcul nr. "+ i +">\nDati nodul-sursa, nodul-destinatie, greutatea nodului: (Ex: 0 2 4)");
            edge[i].src = s.nextInt();
            edge[i].dest = s.nextInt();
            edge[i].weight = s.nextInt();
        }
    }

    Kruskal(int v, int e)
    {
        vertices = v;
        edges = e;
        edge = new Edge[edges];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    int find(subset subsets[], int i)
    {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void KruskalAlgo() {
        Edge result[] = new Edge[vertices];

        for (int i = 0; i < vertices; ++i)
            result[i] = new Edge();

        Arrays.sort(edge);

        subset subsets[] = new subset[vertices];
        for (int i = 0; i < vertices; ++i)
            subsets[i] = new subset();

        for (int v = 0; v < vertices; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        int i = 0;
        int e = 0;
        while (e < vertices - 1)
        {
            Edge next_edge = new Edge();
            next_edge = edge[i++];
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if (x != y)
            {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " - " + result[i].dest + ": " + result[i].weight);
    }
}