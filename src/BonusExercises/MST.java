package BonusExercises;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int src;
    int dest;
    int weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class Set {
    int parent;
    int height;

    Set(int parent, int height) {
        this.parent = parent;
        this.height = height;
    }
}

public class MST {

    private static int find(Set[] sets, int v) {
        int i = v;
        ArrayList<Integer> toUpdate = new ArrayList<>();

        while(sets[i].parent != i) {
            toUpdate.add(i);
            i = sets[i].parent;
        }

        for(int k : toUpdate) {
            sets[k].parent = i;
        }

        return sets[v].parent;
    }

    private static void union(Set[] sets, int v, int w) {
        int vRoot = find(sets, v);
        int wRoot = find(sets, w);

        if(vRoot != wRoot) {
            if(sets[vRoot].height < sets[wRoot].height) {
                sets[vRoot].parent = wRoot;
            }
            else if(sets[vRoot].height > sets[wRoot].height) {
                sets[wRoot].parent = vRoot;
            }
            else {
                sets[vRoot].parent = wRoot;
                sets[wRoot].height += 1;
            }
        }
    }

    public static int solve(int n, Edge[] edges) {
        int MSTWeight = 0;
        Arrays.sort(edges);

        Set[] sets = new Set[n];

        for(int i = 0; i < n; i++) {
            sets[i] = new Set(i, 1);
        }

        for(Edge e : edges) {
            int v = find(sets, e.src);
            int w = find(sets, e.dest);

            if(v != w) {
                union(sets, v, w);
                MSTWeight += e.weight;
            }
        }

        return MSTWeight;
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner sc = new Scanner(in);
        int testCases = sc.nextInt();

        for(int i = 0; i < testCases; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            Edge[] edges = new Edge[m];

            for(int j = 0; j < m; j++) {
                int src = sc.nextInt();
                int dest = sc.nextInt();
                int weight = sc.nextInt();

                edges[j] = new Edge(src, dest, weight);
            }

            out.println(solve(n, edges));
        }
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
