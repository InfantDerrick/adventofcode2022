package src;
import java.util.*;
import java.util.regex.*;
import java.io.*;
public class SupplyStacks {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("res/SupplyStacks.txt"));
        System.out.println(part1(sc));
        sc = new Scanner(new File("res/SupplyStacks.txt"));
        System.out.println(part2(sc));
    }
    public static String part1(Scanner sc){
        boolean flag = false;
        Stack<Character>[] state = new Stack[9];
        for(int i = 0; i < state.length; i++) state[i] = new Stack<>();
        Stack<Character>[] in = new Stack[9];
        for(int i = 0; i < state.length; i++) in[i] = new Stack<>();
        while(!flag){
            String line = sc.nextLine();
            if(line.charAt(0) == ' ') flag = true;
            else{
                for(int i = 1; i < line.length(); i+=4)
                    if(line.charAt(i) != ' ') in[i/4].add(line.charAt(i));
            }
        }
        
        sc.nextLine();
        for(int i = 0; i < in.length; i++)
            while(!in[i].empty())
                state[i].add(in[i].pop());
        while(sc.hasNextLine()){
            List<Integer> numbers = findIntegers(sc.nextLine());
            for(int i = 0; i < numbers.get(0); i++)
                state[numbers.get(2) - 1].add(state[numbers.get(1) - 1].pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < state.length; i++)
            sb.append(state[i].pop());
        return sb.toString();
    }
    private static String part2(Scanner sc){
        boolean flag = false;
        Stack<Character>[] state = new Stack[9];
        for(int i = 0; i < state.length; i++) state[i] = new Stack<>();
        Stack<Character>[] in = new Stack[9];
        for(int i = 0; i < state.length; i++) in[i] = new Stack<>();
        while(!flag){
            String line = sc.nextLine();
            if(line.charAt(0) == ' ') flag = true;
            else{
                for(int i = 1; i < line.length(); i+=4)
                    if(line.charAt(i) != ' ') in[i/4].add(line.charAt(i));
            }
        }
        
        sc.nextLine();
        for(int i = 0; i < in.length; i++)
            while(!in[i].empty())
                state[i].add(in[i].pop());
        System.out.println(Arrays.toString(state));
        while(sc.hasNextLine()){
            List<Integer> numbers = findIntegers(sc.nextLine());
            if(numbers.get(0) == 1)
                state[numbers.get(2) - 1].add(state[numbers.get(1) - 1].pop());
            else{
                Stack<Character> temp = new Stack<>();
                for(int i = 0; i < numbers.get(0); i++) temp.add(state[numbers.get(1) - 1].pop());
                while(!temp.isEmpty()) state[numbers.get(2) - 1].add(temp.pop());
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < state.length; i++)
            sb.append(state[i].pop());
        return sb.toString();
    }
    static List<Integer> findIntegers(String stringToSearch) {
        Pattern integerPattern = Pattern.compile("-?\\d+");
        java.util.regex.Matcher matcher = integerPattern.matcher(stringToSearch);
    
        List<Integer> integerList = new ArrayList<>();
        while (matcher.find()) {
            integerList.add(Integer.parseInt(matcher.group()));
        }
    
        return integerList;
    }
}