package AWProg17;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class UnequalWedding {

    private static boolean augPathExists(int numVer, ArrayList<Integer>[] graph, int[][] capacity, int[][] flow, int[] pred) {

        boolean[] visited = new boolean[numVer];
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int succ : graph[cur]) {
                if(!visited[succ] && capacity[cur][succ] > flow[cur][succ]) {
                    visited[succ] = true;
                    pred[succ] = cur;
                    queue.add(succ);

                    if(succ == numVer - 1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static int edmondsKarp(int numVer, ArrayList<Integer>[] graph, int[][] capacity, int[][] flow) {

        int maxFlow = 0;
        int[] pred = new int[numVer];

        while(augPathExists(numVer, graph, capacity, flow, pred)) {
            int df = Integer.MAX_VALUE;

            for(int v = numVer - 1; v != 0; v = pred[v]) {
                df = Math.min(df, capacity[pred[v]][v] - flow[pred[v]][v]);
            }

            for(int v = numVer - 1; v != 0; v = pred[v]) {
                flow[pred[v]][v] += df;
                flow[v][pred[v]] -= df;
            }

            maxFlow += df;
        }

        return maxFlow;
    }

    private static void testCase(Scanner sc, PrintStream out) {
        int w = sc.nextInt();
        int m = sc.nextInt();

        int numVer;
        ArrayList<Integer> graph[];
        int[][] capacity, flow;

        // all men, all women and source and sink
        numVer = w + m + 2;
        graph =  (ArrayList<Integer>[]) new ArrayList[numVer];

        for(int i = 0; i < numVer; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        capacity = new int[numVer][numVer];
        flow = new int[numVer][numVer];

        // source to women
        for(int i = 1; i <= w; i++) {
            graph[0].add(i);
            graph[i].add(0);
            capacity[0][i] = 1;
        }

        // women to men
        for(int i = 1; i <= w; i++) {
            int n = sc.nextInt();

            for(int j = 0; j < n; j++) {
                int mj = sc.nextInt();

                graph[i].add(w + mj);
                graph[w + mj].add(i);
                capacity[i][w + mj] = 1;
            }
        }

        // men to sink
        for(int i = w + 1; i <= w + m; i++) {
            graph[i].add(numVer - 1);
            graph[numVer - 1].add(i);
            capacity[i][numVer - 1] = 1;
        }

        out.println(edmondsKarp(numVer, graph, capacity, flow));
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
