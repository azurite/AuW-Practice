package AWProg17;

import java.io.InputStream;
import java.io.PrintStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class IslandTribes {

    private static String round(double n) {
        DecimalFormat df = new DecimalFormat("0.0######");
        df.setRoundingMode(RoundingMode.HALF_DOWN);
        return df.format(n);
    }

    private static void testCase(Scanner sc, PrintStream out) {
        int b = sc.nextInt();
        int h = sc.nextInt();
        int n = sc.nextInt();

        double[][][] DP = new double[b + 1][h + 1][n + 1];
        DP[b][h][n] = 1;

        double p_b_looses, p_h_looses, p_n_looses;

        /**
         * DP[i][j][k] := "probability that we have i bears, j hunters and k ninjas"
         *
         * To calculate DP[i][j][k] it is only possible for this constellation to arise from either
         * (i + 1, j, k), (i, j + 1, k) or (i, j , k + 1) then we calculate the probability that i looses,
         * j looses or k looses respectively and multiply it with the probability that the constellation before
         * the fight would happen which is stored in DP[i + 1][j][k], DP[i][j + 1][k] and DP[i][j][k + 1] respectively.
         *
         * If we have tribes i,j,k and i looses to j then that probability is
         * (i * j) / (i * j + i * k + j * k) or in other words the number of ways that someone from i and from j is
         * drawn divided by all interesting events i.e. all possible ways to draw two members from different tribes.
         * */
        for(int i = b; i >= 0; i--) {
            for(int j = h; j >= 0; j--) {
                for(int k = n; k >= 0; k--) {

                    if(i + j + k == 0) {
                        DP[i][j][k] = 0;
                        continue;
                    }

                    if(i + 1 <= b) {
                        if(j == 0) {
                            p_b_looses = 0.0;
                        }
                        else {
                            p_b_looses = ((i + 1) * j) / (double)(((i + 1) * j) + ((i + 1) * k) + (j * k));
                        }

                        DP[i][j][k] += DP[i + 1][j][k] * p_b_looses;
                    }

                    if(j + 1 <= h) {
                        if(k == 0) {
                            p_h_looses = 0.0;
                        }
                        else {
                            p_h_looses = ((j + 1) * k) / (double)((i * (j + 1)) + (i * k) + ((j + 1) * k));
                        }

                        DP[i][j][k] += DP[i][j + 1][k] * p_h_looses;
                    }

                    if(k + 1 <= n) {
                        if(i == 0) {
                            p_n_looses = 0.0;
                        }
                        else {
                            p_n_looses = ((k + 1) * i) / (double)((i * j) + (i * (k + 1)) + (j * (k + 1)));
                        }

                        DP[i][j][k] += DP[i][j][k + 1] * p_n_looses;
                    }
                }
            }
        }

        double p_b_survival = 0, p_h_survival = 0, p_n_survival = 0;

        for(int i = 1; i <= b; i++) {
            p_b_survival += DP[i][0][0];
        }

        for(int i = 1; i <= h; i++) {
            p_h_survival += DP[0][i][0];
        }

        for(int i = 1; i <= n; i++) {
            p_n_survival += DP[0][0][i];
        }

        out.println(round(p_b_survival) + " " + round(p_h_survival) + " " + round(p_n_survival));
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner sc = new Scanner(in);

        int testCases = sc.nextInt();

        for(int i = 0 ; i < testCases; i++) {
            testCase(sc, out);
        }
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
