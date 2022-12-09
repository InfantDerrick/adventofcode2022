package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class RucksackReorganization {
    public static void main(String[] args) {
        List<String[]> l = new LinkedList<>();
        try (Scanner sc = new Scanner(new File("res/RucksackReogranization.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                l.add(new String[] { line.substring(0, line.length() / 2),
                        line.substring(line.length() / 2, line.length()) });
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(part1(l));
        List<String> m = new LinkedList<>();
        try (Scanner sc = new Scanner(new File("res/RucksackReogranization.txt"))) {
            while (sc.hasNextLine())
                m.add(sc.nextLine());
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(part2(m));
    }

    public static int part1(List<String[]> l) {
        int sum = 0;
        for (String[] x : l) {
            char a = ' ';
            for (char b : x[0].toCharArray()) {
                if (x[1].indexOf(b) != -1) {
                    a = b;
                    break;
                }

            }
            sum += Character.isLowerCase(a) ? a - 96 : a - 38;
        }
        return sum;
    }

    public static int part2(List<String> l) {
        int sum = 0;
        for (int i = 0; i < l.size(); i += 3) {
            for (char x : l.get(i).toCharArray())
                if (l.get(i + 1).indexOf(x) != -1 && l.get(i + 2).indexOf(x) != -1) {
                    sum += Character.isLowerCase(x) ? x - 96 : x - 38;
                    break;
                }
        }
        return sum;
    }
}