package Misc;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class EulerTrail {

    private static final int NULL = -1;

    private static boolean hasEulerTrail(ArrayList<Integer>[] graph, int[] oddVertices) {
        int numOddVertices = 0;

        for(int i = 0; i < graph.length; i++) {

            if(graph[i].size() % 2 != 0) {
                oddVertices[(numOddVertices++) % 2] = i;
            }
        }

        HashSet<Integer> seen = new HashSet<Integer>();
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();

        q.add(0);
        seen.add(0);

        while(!q.isEmpty()) {
            int v = q.poll();

            for(int w : graph[v]) {
                if(!seen.contains(w)) {

                    q.add(w);
                    seen.add(w);
                }
            }
        }

        return (seen.size() == graph.length) && (numOddVertices == 0 || numOddVertices == 2);
    }

    private static int[] findPath(ArrayList<Integer>[] graph, int from, int to) {

        int[] pred = new int[graph.length];
        Arrays.fill(pred, NULL);

        HashSet<Integer> seen = new HashSet<Integer>();
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();

        q.add(from);
        seen.add(from);

        while(!q.isEmpty()) {
            int v = q.poll();

            for(int w : graph[v]) {
                if(!seen.contains(w)) {
                    pred[w] = v;
                    q.add(w);
                    seen.add(w);

                    if(w == to) {
                        return pred;
                    }
                }
            }
        }

        // shouldn't happen if graph has an euler trail because graph will then be connected
        // so there is always a path between any two nodes
        return null;
    }

    private static void testCase(Scanner sc, PrintStream out) {

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer>[] graph = (ArrayList<Integer>[])new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();

            graph[src].add(dest);
            graph[dest].add(src);
        }

        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> eulerPath = new ArrayList<Integer>();

        int curr_v, next_v;

        int[] oddVertices = new int[2];
        oddVertices[0] = NULL;
        oddVertices[1] = NULL;

        if(!hasEulerTrail(graph, oddVertices)) {
            out.println("no");
            return;
        }

        if(oddVertices[0] != NULL && oddVertices[1] != NULL) {

            int[] pred = findPath(graph, oddVertices[0], oddVertices[1]);
            curr_v = oddVertices[1];

            // first item in euler trail must come on stack twice otherwise it will be forgotten at the end
            stack.push(curr_v);

            // walk the path between the odd degree vertices, push them on the stack and delete the edges along it
            while(pred[curr_v] != NULL) {
                stack.push(curr_v);

                graph[curr_v].remove(graph[curr_v].indexOf(pred[curr_v]));
                graph[pred[curr_v]].remove(graph[pred[curr_v]].indexOf(curr_v));

                curr_v = pred[curr_v];
            }
        }
        else {
            curr_v = 0;

            // first item in euler trail must come on stack twice otherwise it will be forgotten at the end
            stack.push(curr_v);
        }

        while(!stack.isEmpty()) {
            if(graph[curr_v].size() > 0) {
                stack.push(curr_v);

                next_v = graph[curr_v].get(0);

                graph[curr_v].remove(0);
                graph[next_v].remove(graph[next_v].indexOf(curr_v));

                curr_v = next_v;
            }
            else {
                eulerPath.add(curr_v);
                curr_v = stack.pop();
            }
        }

        for(int i = eulerPath.size() - 1; i >= 0; i--) {
            out.print(eulerPath.get(i) + (i == 0 ? "" : " "));
        }

        out.println();
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
