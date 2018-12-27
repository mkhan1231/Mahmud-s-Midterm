package string.problems;

import java.util.*;

public class DetermineLargestWord {
    public static void main(String[] args) {
        /*
         Implement to Find the length and longest word in the given sentence below.
         Should return "10 biological".
         */
        String s="Human brain is a biological learning machine";
        Map<Integer, String> length = longestWord(s);
        System.out.println(length);
    }

    public static Map<Integer, String> longestWord(String a){
        Map<Integer, String> map = new HashMap<Integer, String>();
        String str = a;

        String st1 = Arrays.stream(str.split(" ")).max(Comparator.comparingInt(String::length)).orElse(null);
        int length = st1.length();
        map.put(length,st1);
        return map;
    }
}
