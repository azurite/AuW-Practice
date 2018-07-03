package AWProg18;

import java.io.InputStream;
import java.io.PrintStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class WinterSeason {

    /**
     * Rounds the result properly as required from the exercise
     */
    public static String round(double n) {
        DecimalFormat df = new DecimalFormat("0.0##");
        df.setRoundingMode(RoundingMode.HALF_DOWN);

        return df.format(n);
    }

    /**
     * sums up elements of array {a} inside the interval [s,e)
     */
    public static double sumOfRange(double[] a, int s, int e) {
        double sum = 0;

        for(int i = s; i < e; i++) {
            sum += a[i];
        }

        return sum;
    }

    /**
     * DP[i][j] = probability that on the first i days there will be exactly j snowy days
     */
    public static String solve(int n, int k, double[] p) {
        double[][] DP = new double[n + 1][n + 1];

        DP[1][0] = 1 - p[1];
        DP[1][1] = p[1];

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(j > 0) {
                    DP[i][j] = (1 - p[i]) * DP[i - 1][j] + p[i] * DP[i - 1][j - 1];
                }
                else {
                    DP[i][j] = (1 - p[i]) * DP[i - 1][j];
                }
            }
        }

        return round(sumOfRange(DP[n], k, n + 1));
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner s = new Scanner(in);

        int testCases = s.nextInt();

        for(int i = 0; i < testCases; i++) {
            int n = s.nextInt();
            int k = s.nextInt();

            double[] p = new double[n + 1];

            for(int j = 1; j <= n; j++) {
                p[j] = s.nextDouble();
            }

            out.println(solve(n, k, p));
        }
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
