package Misc;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GreedyColor {

    private static int[] color;
    private static final int NULL = -1;

    private static void testCase(Scanner sc, PrintStream out) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer>[] graph = (ArrayList<Integer>[])new ArrayList[n];
        color = new int[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
            color[i] = NULL;
        }

        boolean[] isColorAvailable = new boolean[n];

        for(int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();

            graph[src].add(dest);
            graph[dest].add(src);
        }

        color[0] = 0;

        for(int v = 0; v < n; v++) {
            Arrays.fill(isColorAvailable, true);

            for(int w : graph[v]) {
                if(color[w] != NULL) {
                    isColorAvailable[color[w]] = false;
                }
            }

            for(int i = 0; i < n; i++) {
                if(isColorAvailable[i]) {
                    color[v] = i;
                    break;
                }
            }
        }

        int largestColor = 0;

        for(int v = 0; v < n; v++) {
            largestColor = Math.max(largestColor, color[v]);
        }

        out.println(largestColor + 1);
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

