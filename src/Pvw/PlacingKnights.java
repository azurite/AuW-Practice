package Pvw;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class PlacingKnights {

    static boolean[][] isPresent;
    static int n;

    static int numVer;
    static ArrayList<Integer> graph[];
    static int[][] capacity, flow;

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

    private static int map(int x, int y) {
        return n*x + y + 1;
    }

    private static boolean isOnBoard(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static boolean isValidAndNotConnected(int x, int y, int Nx, int Ny) {
        return isPresent[x][y] &&
                isOnBoard(Nx, Ny) &&
                isPresent[Nx][Ny] &&
                graph[map(x, y)].indexOf(map(Nx, Ny)) == -1 &&
                graph[map(Nx, Ny)].indexOf(map(x, y)) == -1;
    }

    private static void connect(int x, int y, int Nx, int Ny) {

        if(isValidAndNotConnected(x, y, Nx, Ny)) {

            graph[map(x, y)].add(map(Nx, Ny));
            graph[map(Nx, Ny)].add(map(x, y));

            if((x + y) % 2 == 0) {
                capacity[map(x, y)][map(Nx, Ny)] = 1;
            }
            else {
                capacity[map(Nx, Ny)][map(x, y)] = 1;
            }
        }
    }

    public static void testCase(Scanner sc, PrintStream out) {
        n = sc.nextInt();
        numVer = n * n + 2;

        capacity = new int[numVer][numVer];
        flow = new int[numVer][numVer];

        graph = (ArrayList<Integer>[])new ArrayList[numVer];

        for(int i = 0; i < numVer; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        isPresent = new boolean[n][n];
        int presentFields = 0;

        for(int x = 0; x < n; x++) {
            for(int y = 0; y < n; y++) {
                boolean present = (sc.nextInt() == 1);
                isPresent[x][y] = present;

                if(present) {
                    presentFields++;
                }
            }
        }

        for(int x = 0; x < n; x++) {
            for(int y = 0; y < n; y++) {
                if((x + y) % 2 == 0 && isPresent[x][y]) {
                    graph[0].add(map(x, y));
                    graph[map(x, y)].add(0);
                    capacity[0][map(x, y)] = 1;
                }
                else if((x + y) % 2 != 0 && isPresent[x][y]) {
                    graph[numVer - 1].add(map(x, y));
                    graph[map(x, y)].add(numVer - 1);
                    capacity[map(x, y)][numVer - 1] = 1;
                }
            }
        }

        for(int x = 0; x < n; x++) {
            for(int y = 0; y < n; y++) {
                connect(x, y, x - 1, y - 2);
                connect(x, y, x - 1, y + 2);
                connect(x, y, x + 1, y - 2);
                connect(x, y, x + 1, y + 2);
                connect(x, y, x - 2, y - 1);
                connect(x, y, x - 2, y + 1);
                connect(x, y, x + 2, y - 1);
                connect(x, y, x + 2, y + 1);
            }
        }

        out.println(presentFields - edmondsKarp(numVer, graph, capacity, flow));
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner sc = new Scanner(in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            testCase(sc, out);
        }
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
