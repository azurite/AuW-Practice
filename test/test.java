import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

import AWProg17.*;
import AWProg18.*;
import Pvw.*;
import Misc.*;

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

    @Test
    public void Tetris_Sample() throws FileNotFoundException {
        String inPath = "testCases/Tetris/sample.in";
        String outPath = "testCases/Tetris/sample.out";

        init(outPath);

        Tetris.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void Tetris_Test() throws FileNotFoundException {
        String inPath = "testCases/Tetris/test.in";
        String outPath = "testCases/Tetris/test.out";

        init(outPath);

        Tetris.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void KingdomDefense_Sample() throws FileNotFoundException {
        String inPath = "testCases/KingdomDefense/sample.in";
        String outPath = "testCases/KingdomDefense/sample.out";

        init(outPath);

        KingdomDefense.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void KingdomDefense_Test1() throws FileNotFoundException {
        String inPath = "testCases/KingdomDefense/test1.in";
        String outPath = "testCases/KingdomDefense/test1.out";

        init(outPath);

        KingdomDefense.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void KingdomDefense_Test2() throws FileNotFoundException {
        String inPath = "testCases/KingdomDefense/test2.in";
        String outPath = "testCases/KingdomDefense/test2.out";

        init(outPath);

        KingdomDefense.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void KingdomDefense_Test3() throws FileNotFoundException {
        String inPath = "testCases/KingdomDefense/test3.in";
        String outPath = "testCases/KingdomDefense/test3.out";

        init(outPath);

        KingdomDefense.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void KingdomDefense_Test4() throws FileNotFoundException {
        String inPath = "testCases/KingdomDefense/test4.in";
        String outPath = "testCases/KingdomDefense/test4.out";

        init(outPath);

        KingdomDefense.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void ImportantBridges_Sample() throws FileNotFoundException {
        String inPath = "testCases/ImportantBridges/sample.in";
        String outPath = "testCases/ImportantBridges/sample.out";

        init(outPath);

        ImportantBridges.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void ImportantStops_Sample() throws FileNotFoundException {
        String inPath = "testCases/ImportantStops/sample.in";
        String outPath = "testCases/ImportantStops/sample.out";

        init(outPath);

        ImportantStops.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void ImportantStops_Test1() throws FileNotFoundException {
        String inPath = "testCases/ImportantStops/test1.in";
        String outPath = "testCases/ImportantStops/test1.out";

        init(outPath);

        ImportantStops.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void ChristmasTree_Sample() throws FileNotFoundException {
        String inPath = "testCases/ChristmasTree/sample.in";
        String outPath = "testCases/ChristmasTree/sample.out";

        init(outPath);

        ChristmasTree.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void ChristmasTree_Test1() throws FileNotFoundException {
        String inPath = "testCases/ChristmasTree/test1.in";
        String outPath = "testCases/ChristmasTree/test1.out";

        init(outPath);

        ChristmasTree.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void ChristmasTree_Test2() throws FileNotFoundException {
        String inPath = "testCases/ChristmasTree/test2.in";
        String outPath = "testCases/ChristmasTree/test2.out";

        init(outPath);

        ChristmasTree.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void ShrinkingArray_Sample() throws FileNotFoundException {
        String inPath = "testCases/ShrinkingArray/sample.in";
        String outPath = "testCases/ShrinkingArray/sample.out";

        init(outPath);

        ShrinkingArray.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void ShrinkingArray_Test1() throws FileNotFoundException {
        String inPath = "testCases/ShrinkingArray/test1.in";
        String outPath = "testCases/ShrinkingArray/test1.out";

        init(outPath);

        ShrinkingArray.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void ShrinkingArray_Test2() throws FileNotFoundException {
        String inPath = "testCases/ShrinkingArray/test2.in";
        String outPath = "testCases/ShrinkingArray/test2.out";

        init(outPath);

        ShrinkingArray.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void ShrinkingArray_Test3() throws FileNotFoundException {
        String inPath = "testCases/ShrinkingArray/test3.in";
        String outPath = "testCases/ShrinkingArray/test3.out";

        init(outPath);

        ShrinkingArray.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void UnequalWedding_Sample() throws FileNotFoundException {
        String inPath = "testCases/UnequalWedding/sample.in";
        String outPath = "testCases/UnequalWedding/sample.out";

        init(outPath);

        UnequalWedding.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void UnequalWedding_Test1() throws FileNotFoundException {
        String inPath = "testCases/UnequalWedding/test1.in";
        String outPath = "testCases/UnequalWedding/test1.out";

        init(outPath);

        UnequalWedding.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void Dominoes_Sample() throws FileNotFoundException {
        String inPath = "testCases/Dominoes/sample.in";
        String outPath = "testCases/Dominoes/sample.out";

        init(outPath);

        Dominoes.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void Dominoes_Test1() throws FileNotFoundException {
        String inPath = "testCases/Dominoes/test1.in";
        String outPath = "testCases/Dominoes/test1.out";

        init(outPath);

        Dominoes.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void DiningTable_Sample() throws FileNotFoundException {
        String inPath = "testCases/DiningTable/sample.in";
        String outPath = "testCases/DiningTable/sample.out";

        init(outPath);

        DiningTable.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void DiningTable_Test1() throws FileNotFoundException {
        String inPath = "testCases/DiningTable/test1.in";
        String outPath = "testCases/DiningTable/test1.out";

        init(outPath);

        DiningTable.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void IslandTribes_Sample() throws FileNotFoundException {
        String inPath = "testCases/IslandTribes/sample.in";
        String outPath = "testCases/IslandTribes/sample.out";

        init(outPath);

        IslandTribes.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void IslandTribes_Test1() throws FileNotFoundException {
        String inPath = "testCases/IslandTribes/test1.in";
        String outPath = "testCases/IslandTribes/test1.out";

        init(outPath);

        IslandTribes.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void Jackpot_Sample() throws FileNotFoundException {
        String inPath = "testCases/Jackpot/sample.in";
        String outPath = "testCases/Jackpot/sample.out";

        init(outPath);

        Jackpot.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void Jackpot_Test1() throws FileNotFoundException {
        String inPath = "testCases/Jackpot/test1.in";
        String outPath = "testCases/Jackpot/test1.out";

        init(outPath);

        Jackpot.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void Jackpot_Test2() throws FileNotFoundException {
        String inPath = "testCases/Jackpot/test2.in";
        String outPath = "testCases/Jackpot/test2.out";

        init(outPath);

        Jackpot.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void Roulette_Sample() throws FileNotFoundException {
        String inPath = "testCases/Roulette/sample.in";
        String outPath = "testCases/Roulette/sample.out";

        init(outPath);

        Roulette.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void Roulette_Test1() throws FileNotFoundException {
        String inPath = "testCases/Roulette/test1.in";
        String outPath = "testCases/Roulette/test1.out";

        init(outPath);

        Roulette.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void VolumeEstimation_Sample() throws FileNotFoundException {
        String inPath = "testCases/VolumeEstimation/sample.in";
        String outPath = "testCases/VolumeEstimation/sample.out";

        init(outPath);

        VolumeEstimation.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void VolumeEstimation_Test1() throws FileNotFoundException {
        String inPath = "testCases/VolumeEstimation/test1.in";
        String outPath = "testCases/VolumeEstimation/test1.out";

        init(outPath);

        VolumeEstimation.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void VolumeEstimation_Test2() throws FileNotFoundException {
        String inPath = "testCases/VolumeEstimation/test2.in";
        String outPath = "testCases/VolumeEstimation/test2.out";

        init(outPath);

        VolumeEstimation.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void EulerTrail_Sample() throws FileNotFoundException {
        String inPath = "testCases/EulerTrail/sample.in";
        String outPath = "testCases/EulerTrail/sample.out";

        init(outPath);

        EulerTrail.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void GreedyColor_Sample() throws FileNotFoundException {
        String inPath = "testCases/GreedyColor/sample.in";
        String outPath = "testCases/GreedyColor/sample.out";

        init(outPath);

        GreedyColor.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void PlacingKnights_Sample() throws FileNotFoundException {
        String inPath = "testCases/PlacingKnights/sample.in";
        String outPath = "testCases/PlacingKnights/sample.out";

        init(outPath);

        PlacingKnights.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }
}
