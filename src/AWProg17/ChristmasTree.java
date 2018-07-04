package AWProg17;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class ChristmasTree {

    private static boolean[] visited;
    private static int[] distance;
    private static int[] color;

    private static final int NULL = -1;

    // by convention if distance[v] to v0 is: even == color 0, odd == color 1
    private static void bfs_visit(ArrayList<Integer>[] adjList, int v0) {
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        queue.add(v0);

        visited[v0] = true;
        color[v0] = 0;

        while(!queue.isEmpty()) {
            int v = queue.poll();

            for(int w : adjList[v]) {
                if(!visited[w] && color[w] == NULL) {
                    visited[w] = true;
                    distance[w] = distance[v] + 1;
                    color[w] = (distance[w] % 2 == 0) ? 0 : 1;

                    queue.add(w);
                }
            }
        }
    }

    private static void testCase(Scanner sc, PrintStream out) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        // initialize data structures
        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n];
        visited = new boolean[n];
        distance = new int[n];
        color = new int[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
            color[i] = NULL;
        }

        // read input into graph
        for(int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();

            graph[src].add(dest);
            graph[dest].add(src);
        }

        // look of cycle of odd length by coloring graph with 2 colors
        for(int i = 0; i < n ; i++) {
            if(!visited[i]) {
                bfs_visit(graph, i);
            }
        }

        // output result
        for(int src = 0; src < n; src++) {
            for(int dest : graph[src]) {

                if(color[src] == color[dest]) {
                    out.println("no");
                    return;
                }
            }
        }

        out.println("yes");
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
