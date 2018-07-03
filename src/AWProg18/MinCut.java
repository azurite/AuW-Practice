package AWProg18;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class MinCut {

    static class Set {
        int parent;
        int height;

        public Set(int parent, int height) {
            this.parent = parent;
            this.height = height;
        }

        public static int find(List<AWProg18.MinCut.Set> sets, int v) {
            int i = v;
            ArrayList<Integer> toUpdate = new ArrayList<Integer>();

            while(sets.get(i).parent != i) {
                toUpdate.add(i);
                i = sets.get(i).parent;
            }

            for(int k : toUpdate) {
                sets.get(k).parent = i;
            }

            return sets.get(v).parent;
        }

        public static void union(List<AWProg18.MinCut.Set> sets, int v, int w) {
            int vRoot = find(sets, v);
            int wRoot = find(sets, w);

            if(vRoot != wRoot) {
                AWProg18.MinCut.Set vSet = sets.get(vRoot);
                AWProg18.MinCut.Set wSet = sets.get(wRoot);

                if(vSet.height < wSet.height) {
                    vSet.parent = wRoot;
                }
                else if(vSet.height > wSet.height) {
                    wSet.parent = vRoot;
                }
                else {
                    vSet.parent = wRoot;
                    wSet.height += 1;
                }
            }
        }
    }

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    private static int karger(List<Edge> edgeList, int n, int m) {

        List<Set> sets = new ArrayList<Set>(m);

        for(int i = 0; i < edgeList.size(); i++) {
            sets.add(new Set(i, 1));
        }

        Random r = new Random();
        int numVertices = n;
        int cutSize = 0;

        while(numVertices > 2) {
            int i = r.nextInt(m);
            Edge e = edgeList.get(i);

            int u = Set.find(sets, e.src);
            int v = Set.find(sets, e.dest);

            if(u != v) {
                Set.union(sets, u, v);
                numVertices--;
            }
        }

        for(Edge e : edgeList) {
            int u = Set.find(sets, e.src);
            int v = Set.find(sets, e.dest);

            if(u != v) {
                cutSize++;
            }
        }

        return cutSize;
    }

    private static int solve(List<Edge> edgeList, int n, int m) {

        int minCut = Integer.MAX_VALUE;
        int repetitions = 20;

        for(int i = 0; i < repetitions; i++) {
            minCut = Math.min(minCut, karger(edgeList, n, m));
        }

        return minCut;
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner s = new Scanner(in);

        int testCases = s.nextInt();

        for(int i = 0; i < testCases; i++) {
            int n = s.nextInt();
            int m = s.nextInt();

            ArrayList<Edge> edgeList = new ArrayList<Edge>(m);

            for(int j = 0; j < m; j++) {
                edgeList.add(new Edge(s.nextInt(), s.nextInt()));
            }

            out.println(solve(edgeList, n, m));
        }
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}

