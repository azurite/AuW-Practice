package Pvw;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class KingdomDefense {

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

    private static long edmondsKarp(int numVer, ArrayList<Integer>[] graph, int[][] capacity, int[][] flow) {

        long maxFlow = 0;
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

        int numVer;
        ArrayList<Integer> graph[];
        int[][] capacity, flow;

        int l = sc.nextInt();
        int p = sc.nextInt();

        // l nodes plus source and sink
        numVer = l + 2;
        graph =  (ArrayList<Integer>[]) new ArrayList[numVer];

        for(int i = 0; i < numVer; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        capacity = new int[numVer][numVer];
        flow = new int[numVer][numVer];

        long totalDemand = 0;
        long minRequirements = 0;

        // we always add up += capacity[x][y] because we do not support multi graphs
        for(int i = 1; i <= l; i++) {
            int gi = sc.nextInt();
            int di = sc.nextInt();

            graph[0].add(i);
            graph[i].add(0);
            capacity[0][i] += gi;

            graph[i].add(numVer - 1);
            graph[numVer - 1].add(i);
            capacity[i][numVer - 1] += di;

            totalDemand += di;
        }

        for(int i = 1; i <= p; i++) {
            // plus 1 because input vertices are 0 indexed and we used 1 indexed nodes (0 = source here)
            int fi = sc.nextInt() + 1;
            int ti = sc.nextInt() + 1;
            int minCi = sc.nextInt();
            int maxCi = sc.nextInt();

            graph[fi].add(numVer - 1);
            graph[numVer - 1].add(fi);
            capacity[fi][numVer - 1] += minCi;

            graph[0].add(ti);
            graph[ti].add(0);
            capacity[0][ti] += minCi;

            graph[fi].add(ti);
            graph[ti].add(fi);
            capacity[fi][ti] += maxCi - minCi;

            minRequirements += minCi;
        }

        long maxFlow = edmondsKarp(numVer, graph, capacity, flow);

        if(maxFlow >= totalDemand + minRequirements) {
            out.println("yes");
        }
        else {
            out.println("no");
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
