package AWProg18;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

class Vertex {
    String value;
    int inDeg = 0;
    int outDeg = 0;
    LinkedList<Vertex> successors = new LinkedList<>();

    Vertex(String value) {
        this.value = value;
    }
}

public class Password {

    public static boolean isConnected(HashMap<String, Vertex> adjList) {

        HashSet<Vertex> visited = new HashSet<>();
        ArrayDeque<Vertex> Q = new ArrayDeque<>();

        for(Vertex v : adjList.values()) {
            Q.addLast(v);
            break;
        }

        while(!Q.isEmpty()) {
            Vertex curr = Q.removeFirst();

            visited.add(curr);
            Iterator<Vertex> it = adjList.get(curr.value).successors.iterator();

            while(it.hasNext()) {
                Vertex successor = it.next();

                if(!visited.contains(successor)) {
                    Q.addLast(successor);
                }
            }
        }

        return visited.size() == adjList.size();
    }

    public static String solve(HashMap<String, Vertex> adjList) {

        Vertex InEqualOutPlusOne = null;
        Vertex OutEqualInPlusOne = null;

        for(Vertex vertex : adjList.values()) {

            if(vertex.inDeg == vertex.outDeg + 1) {
                if(InEqualOutPlusOne != null) {
                    return "no";
                }
                else {
                    InEqualOutPlusOne = vertex;
                }
            }

            if(vertex.outDeg == vertex.inDeg + 1) {
                if(OutEqualInPlusOne != null) {
                    return "no";
                }
                else {
                    OutEqualInPlusOne = vertex;
                }
            }

            if(vertex.inDeg != vertex.outDeg && vertex != InEqualOutPlusOne && vertex != OutEqualInPlusOne) {
                return "no";
            }
        }

        return isConnected(adjList) ? "yes" : "no";
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner s = new Scanner(in);

        int testCases = s.nextInt();

        for(int i = 0; i < testCases; i++) {
            int n = s.nextInt();

            HashMap<String, Vertex> adjList = new HashMap<>();

            for(int j = 0; j < n; j++) {
                String letters = s.next();

                String firstTwo = letters.substring(0, 2);
                String lastTwo = letters.substring(1, 3);

                if(!adjList.containsKey(firstTwo)) {
                    adjList.put(firstTwo, new Vertex(firstTwo));
                }

                if(!adjList.containsKey(lastTwo)) {
                    adjList.put(lastTwo, new Vertex(lastTwo));
                }

                Vertex first = adjList.get(firstTwo);
                Vertex last = adjList.get(lastTwo);

                first.outDeg++;
                last.inDeg++;

                first.successors.push(last);
                last.successors.push(first);
            }

            out.println(solve(adjList));
        }
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}

