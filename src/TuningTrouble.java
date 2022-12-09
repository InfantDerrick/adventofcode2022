package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TuningTrouble {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("res/TuningTrouble.txt"));
        String line = sc.nextLine();
        System.out.println(prob(line, 4));
        System.out.println(prob(line, 14));
    }
    private static int prob(String x, int len){
        HashSet<Character> set = new HashSet<>();
        int l = 0, r = 0;
        for(; r < x.length(); r++){
            if(set.size() == len) return r;
            while(set.contains(x.charAt(r)))
                set.remove(x.charAt(l++));
            if(!set.contains(x.charAt(r))) set.add(x.charAt(r));
        }
        return -1;
    }
}
