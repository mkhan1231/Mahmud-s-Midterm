package math.problems;

import java.util.Scanner;

/**
 * Created by mrahman on 04/02/18.
 */
public class Factorial {

    public static void main(String[] args) {
        /*
         * Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120.
         * Write a java program to find Factorial of a given number using Recursion as well as Iteration.
         *
         */

        int factorial1 = factRecursion(5);
        System.out.println("Recursion: Factorial of 5 is: " + factorial1);

        int factorial2=5;
        System.out.println("Iteration: Factorial of "+factorial2+" is : "+factIteration(factorial2));
    }

    //Method for finding Factorial by Recursion
    public static int factRecursion(int n) {
        int output;
        if (n == 1) {
            return 1;
        }
        output = factRecursion(n - 1) * n;
        return output;
    }

    //Method for finding Factorial by Iteration
    public static int factIteration(int n){
        int fact=1;
        for(int i=1; i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }


}

