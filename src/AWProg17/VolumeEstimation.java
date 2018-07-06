package AWProg17;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class VolumeEstimation {

    private static final double it_max = 3 * Math.pow(0.01, -2) * Math.log(2 / 0.01);
    private static final double alt_it_max = 6 * 1e5;

    private static void testCase(Scanner sc, PrintStream out) {
        int d = sc.nextInt();
        int n = sc.nextInt();

        int[][] constraints = new int[n + 1][d + 1];
        int[] limits = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= d; j++) {
                constraints[i][j] = sc.nextInt(); // a_ij
            }

            limits[i] = sc.nextInt(); // b_i
        }

        double v = sc.nextDouble();
        Random r = new Random();

        int inside = 0;
        int iterations = (int)Math.min(it_max / v, alt_it_max);

        for(int i = 0; i < iterations; i++) {
            double[] random_point = new double[d + 1];

            for(int x = 1; x <= d; x++) {
                random_point[x] = r.nextDouble();
            }

            boolean isInside = true;

            for(int j = 1; j <= n; j++) {
                double solution = 0.0;

                for(int x = 1; x <= d; x++) {
                    solution += constraints[j][x] * random_point[x];
                }

                if(solution > limits[j]) {
                    isInside = false;
                    break;
                }
            }

            if(isInside) {
                inside++;
            }
        }

        double estimatedVolume =  inside / (double)iterations;

        if(estimatedVolume >= v * 0.99 && estimatedVolume <= v * 1.01) {
            out.println("yes");
        }
        else {
            out.println("no");
        }
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
