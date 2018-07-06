package AWProg17;

import java.io.InputStream;
import java.io.PrintStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Jackpot {

    private static String round(double n) {
        DecimalFormat df = new DecimalFormat("0.0####");
        df.setRoundingMode(RoundingMode.HALF_DOWN);
        return df.format(n);
    }

    private static void testCase(Scanner sc, PrintStream out) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] wheels = new int[n + 1][k + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                wheels[i][j] = sc.nextInt();
            }
        }

        /**
         * DP[i][j] := "probability of having an increasing sequence of length i ending with a_ij"
         * a_ij := a_j from wheel i where 1 <= i <= n and 1 <= j <= k
         * */
        double[][] DP = new double[n + 1][k + 1];

        for(int j = 1; j <= k; j++) {
            DP[1][j] = 1 / (double)k;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= k; j++) {

                int pivot = wheels[i][j];
                double prob = 0.0;

                for(int m = 1; m <= k; m++) {
                    if(wheels[i - 1][m] <= pivot) {
                        prob += DP[i - 1][m];
                    }
                }

                DP[i][j] = 1 / (double)k * prob;
            }
        }

        double res = 0.0;

        for(int j = 1; j <= k; j++) {
            res += DP[n][j];
        }

        out.println(round(res));
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
