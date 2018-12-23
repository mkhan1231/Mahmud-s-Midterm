package string.problems;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        /*
          If a String is reversed and it remains unchanged, that is called Palindrome. For example, MOM,DAD,MADAM are
          Palindrome. So write java code to check if a given String is Palindrome or not.
         */
        String str1;
        String str2 ="";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        str1 = sc.nextLine();

        int length = str1.length();
        for ( int i = length - 1; i >= 0; i-- )
            str2 = str2 + str1.charAt(i);

        if (str1.equals(str2))
            System.out.println(str1+" is a palindrome");
        else
            System.out.println(str1+" is not a palindrome");

    }
}
