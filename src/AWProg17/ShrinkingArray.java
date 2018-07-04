package AWProg17;

import java.io.InputStream;
import java.io.PrintStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ShrinkingArray {

    private static String round(double res) {
        DecimalFormat df = new DecimalFormat("0.0##");
        df.setRoundingMode(RoundingMode.HALF_DOWN);
        return df.format(res);
    }

    private static void testCase(Scanner sc, PrintStream out) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] A = new int[n];

        for(int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        /**
         * Definition
         * ----------
         * DP[i][j] := probability that we land on A[i] with "left" and on A[j] with "right"
         *
         * Initialization
         * --------------
         * N/A
         *
         * Calculation
         * -----------
         * DP[i][j] = DP[i - 1][j] * Pr["(i - 1, j) --> (i, j)"] + DP[i][j + 1] * Pr["(i, j + 1) --> (i, j)"]
         *
         * Result
         * ------
         * E[X] = sum{ x * Pr["X=x"] } for all x where x = sum{i=left}_{right} A[i] such that
         * left + n - 1 - right == k
         *
         * */
        double[][] DP = new double[n][n];
        double p_left, p_right;

        // TODO
        // what if k == n ???

        for(int i = 0; i <= k; i++) {
            for(int j = n - 1; j >= n - 1 - k; j--) {
                if(i + n - 1 - j <= k) {

                    if(i > 0 && j < n - 1) {
                        p_left = A[i - 1] / (double)(A[i - 1] + A[j]);
                        p_right = 1.0 - (A[i] / (double)(A[i] + A[j + 1]));

                        DP[i][j] = DP[i - 1][j] * p_left + DP[i][j + 1] * p_right;
                    }
                    else if(i == 0 && j < n - 1) {
                        p_right = 1.0 - (A[i] / (double)(A[i] + A[j + 1]));

                        DP[i][j] = DP[i][j + 1] * p_right;
                    }
                    else if(i > 0 && j == n - 1) {
                        p_left = A[i - 1] / (double)(A[i - 1] + A[j]);

                        DP[i][j] = DP[i - 1][j] * p_left;
                    }
                    else {
                        DP[i][j] = 1;
                    }
                }
            }
        }

        double E = 0.0;

        for(int i = 0; i <= k; i++) {
            for(int j = n - 1; j >= n - 1 - k; j--) {
                if(i + n - 1 - j == k) {

                    long x = 0;
                    for(int m = i; m <= j; m++) {
                        x += A[m];
                    }

                    E += x * DP[i][j];
                }
            }
        }

        out.println(round(E));
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
