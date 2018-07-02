package Pvw;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Tetris {

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
        int n = sc.nextInt();

        int numVer;
        ArrayList<Integer> graph[];
        int[][] capacity, flow;

        // double all vertices except first and last to limit "vertex capacity"
        numVer = 2*w;
        graph =  (ArrayList<Integer>[]) new ArrayList[numVer];

        for(int i = 0; i < numVer; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        capacity = new int[numVer][numVer];
        flow = new int[numVer][numVer];

        for(int i = 0; i < n; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int mapped_src, mapped_dest;

            // edge { a, b } ==> { 2a, 2b-1 } if a > 0
            if(src > 0) {
                mapped_src = 2 * src;
                mapped_dest = 2 * dest - 1;
            }
            // edge { a, b } ==> { a, 2b-1 } if a == 0
            else {
                mapped_src = src;
                mapped_dest = 2 * dest - 1;
            }

            graph[mapped_src].add(mapped_dest);
            graph[mapped_dest].add(mapped_src);
            capacity[mapped_src][mapped_dest] += 1;
        }

        // limit "vertex capacity" to 1
        for(int i = 1; i < numVer - 2; i += 2) {
            graph[i].add(i + 1);
            graph[i + 1].add(i);
            capacity[i][i + 1] = 1;
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
