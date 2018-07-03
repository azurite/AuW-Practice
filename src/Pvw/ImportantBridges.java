package Pvw;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ImportantBridges {

    private static class Pair implements Comparable<Pair> {
        int v;
        int w;

        Pair(int v, int w) {
            this.v = Math.min(v, w);
            this.w = Math.max(v, w);
        }

        @Override
        public int compareTo(Pair other) {
            if(this.v < other.v) {
                return -1;
            }
            else if(this.v == other.v) {
                if(this.w < other.w) {
                    return -1;
                }
            }

            return 1;
        }

        public String toString() {
            return this.v + " " + this.w;
        }
    }

    private static final int NULL = -1;
    private static int num;

    private static int[] dfs;
    private static int[] low;
    private static int[] parent;
    private static boolean[] isArtVertex;
    private static ArrayList<Pair> bridges;

    private static void dfs_visit(ArrayList<Integer>[] adjList, int v) {
        num++;
        dfs[v] = num;
        low[v] = dfs[v];

        int children = 0;

        for(int w : adjList[v]) {
            if(dfs[w] == 0) {
                children++;
                parent[w] = v;

                dfs_visit(adjList, w);

                low[v] = Math.min(low[v], low[w]);

                if((parent[v] != NULL && low[w] >= dfs[v]) || (parent[v] == NULL && children >= 2)) {
                    isArtVertex[v] = true;
                }

                if(low[w] > dfs[v]) {
                    bridges.add(new Pair(v, w));
                }
            }
            else if(w != parent[v]) {
                low[v] = Math.min(low[v], dfs[w]);
            }
        }
    }

    private static void testCase(Scanner sc, PrintStream out) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer>[] adjList = (ArrayList<Integer>[]) new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        // construct graph from input
        for(int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();

            adjList[src].add(dest);
            adjList[dest].add(src);
        }

        // initialize data structures
        num = 0;
        dfs = new int[n];
        low = new int[n];
        parent = new int[n];
        isArtVertex = new boolean[n];
        bridges = new ArrayList<Pair>(m);

        for(int i = 0; i < adjList.length; i++) {
            parent[i] = NULL;
        }

        // find all articulation points and bridges
        dfs_visit(adjList, 0);

        // sort bridges lexicographically
        Collections.sort(bridges);


        // output result
        out.println(bridges.size());

        for(Pair bridge : bridges) {
            out.println(bridge);
        }
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner sc = new Scanner(in);

        int testCases = sc.nextInt();

        for(int i = 0; i < testCases; i++) {
            testCase(sc, out);
        }
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
