package BonusExercises;

import java.io.InputStream;
import java.io.PrintStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class RandomDivisors {

    private static double positiveDelta = 1 / 1e8;

    public static String round(double in) {
        DecimalFormat df = new DecimalFormat("0.0####");
        df.setRoundingMode(RoundingMode.DOWN);
        return df.format(in);
    }

    public static long lcm(long a, long b) {
        long t;
        long old_a = a;
        long old_b = b;

        while(b != 0) {
            t = b;
            b = a % b;
            a = t;
        }

        return old_a * old_b / a;
    }

    public static String solve(int[] a) {
        double totalProb = 0.0;

        for(int i = 1; i < Math.pow(2, a.length); i++) {
            int k = a.length;
            int iHat = i;
            long subLcm = 1;
            int oneS = 0;

            while(iHat != 0) {
                while(iHat / Math.pow(2, k) < 1) { k--; }

                subLcm = lcm(subLcm, a[k]);
                iHat -= Math.pow(2, k--);
                oneS++;
            }

            totalProb += (oneS % 2 == 0 ? -1 : 1) / (double)subLcm;
        }

        return round(1 - totalProb + positiveDelta);
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner s = new Scanner(in);

        int testCases = s.nextInt();

        for(int i = 0; i < testCases; i++) {
            int k = s.nextInt();

            int[] input = new int[k];

            for(int j = 0; j < k; j++) {
                input[j] = s.nextInt();
            }

            out.println(solve(input));
        }
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}

