package BonusExercises;

import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class PrimalityTesting {

    private enum Prime {
        YES, NO
    }

    private static Prime mrt(long n, long a) {

        long d = (n - 1) / 2;
        long k = 1;

        while(d % 2 == 0) {
            d = d / 2;
            k += 1;
        }

        BigInteger bigNMinusONe = BigInteger.valueOf(n - 1);
        BigInteger TWO = BigInteger.valueOf(2);

        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigD = BigInteger.valueOf(d);
        BigInteger bigN = BigInteger.valueOf(n);

        BigInteger bigX = bigA.modPow(bigD, bigN);

        if(bigX.equals(BigInteger.ONE) || bigX.equals(bigNMinusONe)) {
            return Prime.YES;
        }

        for(int i = 1; i < k; i++) {
            bigX = bigX.modPow(TWO, bigN);

            if(bigX.equals(BigInteger.ONE)) {
                return Prime.NO;
            }

            if(bigX.equals(bigNMinusONe)) {
                return Prime.YES;
            }
        }

        return Prime.NO;
    }

    private static Prime probMRT(long n) {

        if(n == 2) {
            return Prime.YES;
        }

        if(n % 2 == 0 || n == 1) {
            return Prime.NO;
        }

        Random r = new Random();
        long a;

        for(int i = 1; i <= 10; i++) {
            a = Math.abs((r.nextLong() % (n - 3))) + 2;

            if(mrt(n, a) == Prime.NO) {
                return Prime.NO;
            }
        }

        return Prime.YES;
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner s = new Scanner(in);

        int testCases = s.nextInt();

        for(int i = 0; i < testCases; i++) {
            if(probMRT(s.nextLong()) == Prime.YES) {
                out.println("yes");
            }
            else {
                out.println("no");
            }
        }
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}

