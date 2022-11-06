import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class QuarterStats {

    public static void main(String[] args) {

        File file = new File("QuarterBacks.txt");

        String[] names = new String[10];
        double[] completions = new double[10];
        double[] attempts = new double[10];
        double[] percentages = new double[10];
        double[] passingYards = new double[10];
        double[] yardsAttempt = new double[10];
        double[] touchDowns = new double[10];
        double[] interceptions = new double[10];
        double[] sacks = new double[10];

        String recRead;

        try {
            Scanner input2 = new Scanner(file);

            for (int i = 0; i < 10; i++) {
                recRead = input2.nextLine();

                StringTokenizer phrase = new StringTokenizer(recRead, ",");

                names[i] = phrase.nextToken();
                completions[i] = Double.parseDouble(phrase.nextToken());
                attempts[i] = Double.parseDouble(phrase.nextToken());
                percentages[i] = Double.parseDouble(phrase.nextToken());
                passingYards[i] = Double.parseDouble(phrase.nextToken());
                yardsAttempt[i] = Double.parseDouble(phrase.nextToken());
                touchDowns[i] = Double.parseDouble(phrase.nextToken());
                interceptions[i] = Double.parseDouble(phrase.nextToken());
                sacks[i] = Double.parseDouble(phrase.nextToken());
            }
        } catch (FileNotFoundException ex) {
            System.out.printf("ERROR %s\n", ex);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(names[i] + "\t" + completions[i] + "\t" + attempts[i] + "\t" + percentages[i] + "\t" + passingYards[i] + "\t" + yardsAttempt[i] + "\t" + touchDowns[i] + "\t" + interceptions[i] + "\t" + sacks[i]);
        }


        int indexOfHighestPercentage = 0;
        int indexOfHighestPassingYards = 0;
        int indexOfHighestYardsAttempt = 0;

        double highestPercentage = percentages[0];
        double highestPassingYards = passingYards[0];
        double highestYardsAttempt = yardsAttempt[0];

        for (int i = 0; i < percentages.length; i++) {

            if (highestPercentage < percentages[i]) {
                highestPercentage = percentages[i];
                indexOfHighestPercentage = i;
            }
        }
        System.out.println(names[indexOfHighestPercentage] + " has the highest percentage at " + highestPercentage + " %.");

        for (int i = 0; i < passingYards.length; i++) {

            if (highestPassingYards < passingYards[i]) {
                highestPassingYards = passingYards[i];
                indexOfHighestPassingYards = i;
            }
        }
        System.out.println(names[indexOfHighestPassingYards] + " has the highest passing yards at " + highestPassingYards + " yards.");

        for (int i = 0; i < yardsAttempt.length; i++) {

            if (highestYardsAttempt < yardsAttempt[i]) {
                highestYardsAttempt = yardsAttempt[i];
                indexOfHighestYardsAttempt = i;
            }
        }
        System.out.println(names[indexOfHighestYardsAttempt] + "has the highest yards/attempt at " + highestYardsAttempt + " yards/attempt.");
    }
}