package string.problems;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        /*
          If a String is reversed and it remains unchanged, that is called Palindrome. For example, MOM,DAD,MADAM are
          Palindrome. So write java code to check if a given String is Palindrome or not.
         */
        String str3 = "ABBA";
        if (palindromeChecking(str3)) {
            System.out.println(str3+ " is Palindrome");
        }
        else {
            System.out.println(str3+" is not Palindrome");
        }
    }


    public static boolean palindromeChecking(String str1) {

        String word = str1;
        StringBuilder str2 = new StringBuilder();
        int wordLength = word.length();

        for (int i = 0; i < wordLength; i++) {
            str2.append(word.charAt(wordLength - 1 - i));
        }
        String revPalindrome = new String(str2);

        if (word.matches(revPalindrome))
            return true;
        else return false;
    }
}

