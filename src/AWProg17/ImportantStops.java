package AWProg17;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportantStops {
    private static final int NULL = -1;
    private static int num;

    private static int[] dfs;
    private static int[] low;
    private static int[] parent;
    private static boolean[] isArtVertex;

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

        for(int i = 0; i < adjList.length; i++) {
            parent[i] = NULL;
        }

        // find all articulation points
        for(int i = 0; i < n; i++) {
            if(dfs[i] == 0) {
                dfs_visit(adjList, i);
            }
        }

        // output result
        ArrayList<Integer> artVertices = new ArrayList<Integer>();

        for(int i = 0; i < n; i++) {
            if(isArtVertex[i]) {
                artVertices.add(i);
            }
        }

        if(artVertices.size() == 0) {
            out.println(-1);
        }
        else {
            for(int i = 0; i < artVertices.size(); i++) {
                out.print(i == artVertices.size() - 1 ? artVertices.get(i) : (artVertices.get(i) + " "));
            }
            out.println();
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
