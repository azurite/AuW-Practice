package AWProg17;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Dominoes {

    private static void testCase(Scanner sc, PrintStream out) {
        
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
