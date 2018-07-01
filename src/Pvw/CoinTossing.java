package Pvw;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class CoinTossing {

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

        int numVer;
        ArrayList<Integer> graph[];
        int[][] capacity, flow;

        int n = sc.nextInt();
        int m = sc.nextInt();

        numVer = n + m + 2;
        graph =  (ArrayList<Integer>[]) new ArrayList[numVer];

        for(int i = 0; i < numVer; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        capacity = new int[numVer][numVer];
        flow = new int[numVer][numVer];

        // source to games
        for(int i = 1; i <= m; i++) {
            graph[0].add(i);
            graph[i].add(0);
            capacity[0][i] = 1;
        }

        // games to players
        for(int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            switch(c) {
                case 1:
                    graph[i].add(a + m + 1);
                    graph[a + m + 1].add(i);
                    capacity[i][a + m + 1] = 1;
                    break;

                case 2:
                    graph[i].add(b + m + 1);
                    graph[b + m + 1].add(i);
                    capacity[i][b + m + 1] = 1;
                    break;

                case 0:
                    graph[i].add(a + m + 1);
                    graph[a + m + 1].add(i);
                    capacity[i][a + m + 1] = 1;

                    graph[i].add(b + m + 1);
                    graph[b + m + 1].add(i);
                    capacity[i][b + m + 1] = 1;
                    break;

                default:
                    throw new RuntimeException("invalid input c: " + c);
            }
        }

        // total points of all players
        int[] s = new int[n];

        for(int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }

        //players to sink
        for(int i = m + 1; i <= m + n; i++) {
            graph[i].add(m + n + 1);
            graph[m + n + 1].add(i);
            capacity[i][m + n + 1] = s[i - m - 1];
        }

        // computation
        int maxFlow = edmondsKarp(numVer, graph, capacity, flow);
        int totalPoints = 0;

        for(int i = 0; i < n; i++) {
            totalPoints += s[i];
        }

        // output result
        if(totalPoints == maxFlow && totalPoints == m) {
            out.println("yes");
        }
        else {
            out.println("no");
        }
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner s = new Scanner(in);

        int testCases = s.nextInt();

        for(int i = 0; i < testCases; i++) {
            testCase(s, out);
        }

    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
