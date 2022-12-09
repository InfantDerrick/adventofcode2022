package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.*;

public class CampCleanup {
    static class Range {
        int start, end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, NumberFormatException {
        Scanner sc = new Scanner(new File("res/CampCleanup.txt"));
        List<Range[]> l = new LinkedList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] pair = line.split(",");
            String[] p1 = pair[0].split("-");
            String[] p2 = pair[1].split("-");
            l.add(new Range[] { new Range(Integer.parseInt(p1[0]), Integer.parseInt(p1[1])),
                    new Range(Integer.parseInt(p2[0]), Integer.parseInt(p2[1])) });
        }
        System.out.println(problem1(l));
        System.out.println(problem2(l));
    }

    public static int problem2(List<Range[]> l) {
        int sum = 0;
        for (Range[] p : l)
            if (p[0].start <= p[1].end && p[0].end >= p[1].start)
                sum++;
        return sum;
    }

    public static int problem1(List<Range[]> l) {
        int sum = 0;
        for (Range[] p : l)
            if ((p[0].start <= p[1].start && p[0].end >= p[1].end)
                    || (p[1].start <= p[0].start && p[1].end >= p[0].end))
                sum++;
        return sum;
    }

}
