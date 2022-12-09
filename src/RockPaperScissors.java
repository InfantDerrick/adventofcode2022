package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("res/RockPaperScissors.txt"));
        long score = 0;
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            score += playGame(line[0], line[1]);
        }
        System.out.println(score);
    }

    public static int playGame(String enemy, String us) {
        if (us.equals("Y"))
            return 3 + (enemy.charAt(0) - 'A') + 1;
        if (us.equals("X")) {
            switch (enemy.charAt(0)) {
                case 'A':
                    return 3;
                case 'B':
                    return 1;
                case 'C':
                    return 2;
            }
        }
        switch (enemy.charAt(0)) {
            case 'A':
                return 2 + 6;
            case 'B':
                return 3 + 6;
            case 'C':
                return 1 + 6;
        }
        return 0;
    }
}