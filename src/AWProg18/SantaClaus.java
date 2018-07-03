package AWProg18;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class SantaClaus {

    static int numVer; // the number of vertices in the graph
    static ArrayList<Integer> graph[]; // flow is computed on this graph
    static int[][] capacity, flow;

    // Compute a path with positive residual capacity using BFS
    // Return true if such a path exists and false otherwise
    public static boolean augmentingPathExists(int previousVertexOnPath[]) {
        // Allocate space for auxilary data structures
        LinkedList<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[numVer];

        // Initialization of auxilary data structures
        for(int i = 0; i < numVer; i++) visited[i] = false;
        queue.add(0);
        visited[0] = true;

        // BFS
        while(!queue.isEmpty()) {
            int v = queue.poll();
            for(int w : graph[v])
                if(!visited[w] && capacity[v][w] > flow[v][w]) {
                    visited[w] = true;
                    previousVertexOnPath[w] = v;
                    queue.add(w);
                    if(w == numVer-1) return true;
                }
        }

        return false;
    }

    // Computes the value of a maximum flow
    public static int computeMaximumFlow() {
        int i, flowOnPath;
        // Find paths with BFS and return path in previousVertexOnPath array
        int[] previousVertexOnPath = new int[numVer];
        // Start with empty flow
        int maxFlow = 0;
        // Use augmenting path P as long as possible
        while(augmentingPathExists(previousVertexOnPath)) {
            // Compute smallest remaining capacity on P
            flowOnPath = Integer.MAX_VALUE;
            for(i = numVer-1; i != 0; i = previousVertexOnPath[i]) {
                int p = previousVertexOnPath[i];
                flowOnPath = Math.min(flowOnPath, capacity[p][i] - flow[p][i]);
            }
            // Add the smallest remaining capacity to each edge of P
            for(i = numVer-1; i != 0; i = previousVertexOnPath[i]) {
                int p = previousVertexOnPath[i];
                flow[p][i] += flowOnPath;
                flow[i][p] -= flowOnPath;
            }
            maxFlow += flowOnPath;
        }

        return maxFlow;
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        // Create a new Scanner object for reading the input
        Scanner sc = new Scanner(in);

        // Read the number of testcases to follow
        int t = sc.nextInt();

        // Iterate over the testcases and solve the problem
        for (int i = 0; i < t; i++) {
            testCase(sc, out);
        }
    }

    public static void testCase(Scanner sc, PrintStream out) {

        final int n = sc.nextInt();
        final int m = sc.nextInt();

        // all toy types plus all children plus source and sink
        numVer = n + m + 2;

        // Initialize the graph
        capacity = new int[numVer][numVer];
        flow = new int[numVer][numVer];
        graph = (ArrayList<Integer>[])new ArrayList[numVer];

        for(int i = 0; i < numVer; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        // read the children's wants and the number of copies per toy
        int[] d = new int[n];
        int[] c = new int[m];

        for(int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }

        for(int i = 0; i < m; i++) {
            c[i] = sc.nextInt();
        }

        // first part of graph source to toys
        for(int i = 1; i <= m; i++) {
            graph[0].add(i);
            graph[i].add(0);
            flow[0][i] = 0;
            capacity[0][i] = c[i - 1];
            capacity[i][0] = 0;
        }

        // middle part of graph toys to children
        for(int i = 1; i <= m; i++) {
            for(int j = m + 1; j <= m + n; j++) {
                graph[i].add(j);
                graph[j].add(i);
                flow[i][j] = 0;
                capacity[i][j] = 1; // a child can only receive one toy per type
                capacity[j][i] = 0;
            }
        }

        // last part of graph children to sink
        for(int i = m + 1; i <= m + n; i++) {
            graph[i].add(m + n + 1);
            graph[m + n + 1].add(i);
            flow[i][m + n + 1] = 0;
            capacity[i][m + n + 1] = d[i - m - 1];
            capacity[m + n + 1][i] = 0;
        }

        int maxFlow;
        maxFlow = computeMaximumFlow();

        int sumChildWants = 0;

        for(int i = 0; i < n; i++) {
            sumChildWants += d[i];
        }

        if(maxFlow == sumChildWants) {
            out.println("yes");
        }
        else {
            out.println("no");
        }
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}

