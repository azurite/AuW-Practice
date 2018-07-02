import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

import BonusExercises.*;
import Pvw.*;

public class test extends testSetup {

    @Test
    public void MST_Sample() throws FileNotFoundException {
        String inPath = "testCases/MST/sample.in";
        String outPath = "testCases/MST/sample.out";

        init(outPath);

        MST.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void MST_Test1() throws FileNotFoundException {
        String inPath = "testCases/MST/test1.in";
        String outPath = "testCases/MST/test1.out";

        init(outPath);

        MST.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void Password_Sample() throws FileNotFoundException {
        String inPath = "testCases/Password/sample.in";
        String outPath = "testCases/Password/sample.out";

        init(outPath);

        Password.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }
    @Test
    public void Password_Test1() throws FileNotFoundException {
        String inPath = "testCases/Password/test1.in";
        String outPath = "testCases/Password/test1.out";

        init(outPath);

        Password.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }
    @Test
    public void Password_Test2() throws FileNotFoundException {
        String inPath = "testCases/Password/test2.in";
        String outPath = "testCases/Password/test2.out";

        init(outPath);

        Password.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void Password_Test3() throws FileNotFoundException {
        String inPath = "testCases/Password/test3.in";
        String outPath = "testCases/Password/test3.out";

        init(outPath);

        Password.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void WinterSeason_Sample() throws FileNotFoundException {
        String inPath = "testCases/WinterSeason/sample.in";
        String outPath = "testCases/WinterSeason/sample.out";

        init(outPath);

        WinterSeason.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void WinterSeason_Test1() throws FileNotFoundException {
        String inPath = "testCases/WinterSeason/test1.in";
        String outPath = "testCases/WinterSeason/test1.out";

        init(outPath);

        WinterSeason.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void WinterSeason_Test2() throws FileNotFoundException {
        String inPath = "testCases/WinterSeason/test2.in";
        String outPath = "testCases/WinterSeason/test2.out";

        init(outPath);

        WinterSeason.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void RandomDivisors_Sample() throws FileNotFoundException {
        String inPath = "testCases/RandomDivisors/sample.in";
        String outPath = "testCases/RandomDivisors/sample.out";

        init(outPath);

        RandomDivisors.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void RandomDivisors_Test1() throws FileNotFoundException {
        String inPath = "testCases/RandomDivisors/test1.in";
        String outPath = "testCases/RandomDivisors/test1.out";

        init(outPath);

        RandomDivisors.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void RandomDivisors_Test2() throws FileNotFoundException {
        String inPath = "testCases/RandomDivisors/test2.in";
        String outPath = "testCases/RandomDivisors/test2.out";

        init(outPath);

        RandomDivisors.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void PrimalityTesting_Sample() throws FileNotFoundException {
        String inPath = "testCases/PrimalityTesting/sample.in";
        String outPath = "testCases/PrimalityTesting/sample.out";

        init(outPath);

        PrimalityTesting.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void PrimalityTesting_Test1() throws FileNotFoundException {
        String inPath = "testCases/PrimalityTesting/test1.in";
        String outPath = "testCases/PrimalityTesting/test1.out";

        init(outPath);

        PrimalityTesting.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void PrimalityTesting_Test2() throws FileNotFoundException {
        String inPath = "testCases/PrimalityTesting/test2.in";
        String outPath = "testCases/PrimalityTesting/test2.out";

        init(outPath);

        PrimalityTesting.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void MinCut_Sample() throws FileNotFoundException {
        String inPath = "testCases/MinCut/sample.in";
        String outPath = "testCases/MinCut/sample.out";

        init(outPath);

        MinCut.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void MinCut_Test1() throws FileNotFoundException {
        String inPath = "testCases/MinCut/test1.in";
        String outPath = "testCases/MinCut/test1.out";

        init(outPath);

        MinCut.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void MinCut_Test2() throws FileNotFoundException {
        String inPath = "testCases/MinCut/test2.in";
        String outPath = "testCases/MinCut/test2.out";

        init(outPath);

        MinCut.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void SantaClaus_Sample() throws FileNotFoundException {
        String inPath = "testCases/SantaClaus/sample.in";
        String outPath = "testCases/SantaClaus/sample.out";

        init(outPath);

        SantaClaus.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void SantaClaus_Test1() throws FileNotFoundException {
        String inPath = "testCases/SantaClaus/test1.in";
        String outPath = "testCases/SantaClaus/test1.out";

        init(outPath);

        SantaClaus.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void CoinTossing_Sample() throws FileNotFoundException {
        String inPath = "testCases/CoinTossing/sample.in";
        String outPath = "testCases/CoinTossing/sample.out";

        init(outPath);

        CoinTossing.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void CoinTossing_Test1() throws FileNotFoundException {
        String inPath = "testCases/CoinTossing/test1.in";
        String outPath = "testCases/CoinTossing/test1.out";

        init(outPath);

        CoinTossing.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void CoinTossing_Test2() throws FileNotFoundException {
        String inPath = "testCases/CoinTossing/test2.in";
        String outPath = "testCases/CoinTossing/test2.out";

        init(outPath);

        CoinTossing.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void CoinTossing_Test3() throws FileNotFoundException {
        String inPath = "testCases/CoinTossing/test3.in";
        String outPath = "testCases/CoinTossing/test3.out";

        init(outPath);

        CoinTossing.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void ShoppingTrip_Sample() throws FileNotFoundException {
        String inPath = "testCases/ShoppingTrip/sample.in";
        String outPath = "testCases/ShoppingTrip/sample.out";

        init(outPath);

        ShoppingTrip.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void ShoppingTrip_Sample2() throws FileNotFoundException {
        String inPath = "testCases/ShoppingTrip/sample2.in";
        String outPath = "testCases/ShoppingTrip/sample2.out";

        init(outPath);

        ShoppingTrip.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }
}
