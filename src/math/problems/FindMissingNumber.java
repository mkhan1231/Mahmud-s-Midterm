package math.problems;

import java.util.Arrays;

/**
 * Created by mrahman on 04/22/17.
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        /*
         * If n = 10, then array will have 9 elements in the range from 1 to 10.
         * For example {10, 2, 1, 4, 5, 3, 7, 8, 6}. One number will be missing in array (9 in this case).
         * Write java code to find the missing number from the array. Write static helper method to find it.
         */
        int [] array = new int[]{10, 2, 1, 4, 5, 3, 7, 8, 6};
        int missingNum = pickMissingNum(array,9);
        System.out.println("The Missing Number is: "+missingNum);
    }

    static int pickMissingNum (int a[], int n)
    {
        int total;
        total  = (n+1)*(n+2)/2;
        for ( int i = 0; i< n; i++)
            total = total-a[i];
        return total;
    }

}

