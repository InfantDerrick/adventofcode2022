package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CalorieTracking {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("res/CalorieTracking.txt"));
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            int cur = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.equals("")) {
                    pq.add(cur);
                    cur = 0;
                } else
                    cur += Integer.parseInt(line);
            }
            System.out.println(pq.poll() + pq.poll() + pq.poll());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}