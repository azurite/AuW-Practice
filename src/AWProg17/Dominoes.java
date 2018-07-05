package AWProg17;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Dominoes {

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

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int numVer;
        ArrayList<Integer> graph[];
        int[][] capacity, flow;

        // all squares plus source and sink
        numVer = n*m + 2;
        graph =  (ArrayList<Integer>[]) new ArrayList[numVer];

        for(int i = 0; i < numVer; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        capacity = new int[numVer][numVer];
        flow = new int[numVer][numVer];

        boolean[][] isOccupied = new boolean[n][m];

        for(int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            isOccupied[x][y] = true;
        }

        int nodeVal;

        /**
         * Imagine the n * m grid as a chessboard with white and black fields where if (x, y) is a field
         * and x + y is even then the field is white. Otherwise it is black. By convention we connect
         * source to white fields and black fields to sink and we connect white with black fields in a grid like fashion
         * but nonzero capacities are only allowed from white to black and not the other way around.
         * Since each domino will occupy a white and a black field our goal is now to find a
         * maximum (kardinality) matching in our bipartite graph
         * */
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < m; y++) {
                nodeVal = m * x + y + 1;

                if(!isOccupied[x][y]) {

                    // white chess fields go from source to nodes
                    if((x + y) % 2 == 0) {
                        graph[0].add(nodeVal);
                        graph[nodeVal].add(0);
                        capacity[0][nodeVal] = 1;
                    }
                    else {
                        // black chess fields go from node to sink
                        graph[nodeVal].add(numVer - 1);
                        graph[numVer - 1].add(nodeVal);
                        capacity[nodeVal][numVer - 1] = 1;
                    }
                }
            }
        }

        int nodeSrc, nodeDest;

        /**
         * Here we map the coordinate (x, y) onto x*m + y + 1
         * This gives us a bijection from ({0} U [n-1]) X ({0} U [m-1]) --> [n*m]
         * */
        for(int x = 0; x < n; x++) {
            for(int y = 0; y < m; y++) {

                if(!isOccupied[x][y]) {

                    if(y + 1 < m && !isOccupied[x][y + 1]) {
                        nodeSrc = m * x + y + 1;
                        nodeDest =  m * x + (y + 1) + 1;

                        graph[nodeSrc].add(nodeDest);
                        graph[nodeDest].add(nodeSrc);

                        // always make capacity go from source to sink
                        if((x + y) % 2 == 0) {
                            capacity[nodeSrc][nodeDest] = 1;
                        }
                        else {
                            capacity[nodeDest][nodeSrc] = 1;
                        }
                    }

                    if(x + 1 < n && !isOccupied[x + 1][y]) {
                        nodeSrc = m * x + y + 1;
                        nodeDest =  m * (x + 1) + y + 1;

                        graph[nodeSrc].add(nodeDest);
                        graph[nodeDest].add(nodeSrc);

                        // always make capacity go from source to sink
                        if((x + y) % 2 == 0) {
                            capacity[nodeSrc][nodeDest] = 1;
                        }
                        else {
                            capacity[nodeDest][nodeSrc] = 1;
                        }
                    }
                }
            }
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
