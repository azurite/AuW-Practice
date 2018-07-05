package AWProg17;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DiningTable {

    private static int[] color;
    private static int[] distance;

    private static final int NULL = -1;

    private static void bfs_visit(ArrayList<Integer>[] graph, int v0) {
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        q.add(v0);

        color[v0] = 0;
        distance[v0] = 0;

        while(!q.isEmpty()) {
            int v = q.poll();

            for(int w : graph[v]) {
                if(color[w] == NULL) {
                    distance[w] = distance[v] + 1;
                    color[w] = (distance[w] % 2 == 0) ? 0 : 1;

                    q.add(w);
                }
            }
        }
    }

    private static void testCase(Scanner sc, PrintStream out) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();

        ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();

            graph[src].add(dest);
            graph[dest].add(src);
        }

        color = new int[n];
        distance = new int[n];

        for(int i = 0; i < n; i++) {
            color[i] = NULL;
        }

        bfs_visit(graph, r);

        for(int i = 0; i < n; i++) {
            if(color[i] == NULL) {
                bfs_visit(graph, i);
            }
        }

        for(int src = 0; src < n; src++) {
            for(int dest : graph[src]) {
                if(color[src] == color[dest]) {
                    out.println("no");
                    return;
                }
            }
        }

        ArrayList<Integer> buddies = new ArrayList<Integer>();

        for(int i = 0; i < n; i++) {
            if(color[i] == color[r]) {
                buddies.add(i);
            }
        }

        Collections.sort(buddies);

        for(int i = 0; i < buddies.size(); i++) {
            out.print(buddies.get(i));

            if(i != buddies.size() - 1) {
                out.print(" ");
            }
        }

        out.println();
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
