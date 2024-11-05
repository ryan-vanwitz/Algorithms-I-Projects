package preSBproblems;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class QuestionC {

    public static void main(String[] args) {
        // Example list of bottle volumes (in mL)
        List<BigDecimal> bottles = Arrays.asList(
            new BigDecimal("0"),
            new BigDecimal("100"),
            new BigDecimal("1950"),
            new BigDecimal("1900"),
            new BigDecimal("125"),
            new BigDecimal("200"),
            new BigDecimal("295"),
            new BigDecimal("175")
        );

        // Sort the list
        Collections.sort(bottles);

        // Find the combination and print result
        if (findBottleCombination(bottles)) {
            System.out.println("Combination found!");
        } else {
            System.out.println("No combination found.");
        }
    }

    public static boolean findBottleCombination(List<BigDecimal> bottles) {
        int frontIndex = 0;
        int backIndex = bottles.size() - 1;
        while (frontIndex < backIndex) {
            BigDecimal combinedVolume = bottles.get(frontIndex).add(bottles.get(backIndex));
            if (combinedVolume.compareTo(new BigDecimal("200")) == 0) {
                return true;
            }
            else if (combinedVolume.compareTo(new BigDecimal("200")) < 0) {
                frontIndex++;
            }
            else {
                backIndex--;
            }
        }
        return false;
    }
}