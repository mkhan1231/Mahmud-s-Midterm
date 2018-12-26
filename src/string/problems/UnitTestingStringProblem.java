package string.problems;

import static org.testng.AssertJUnit.assertEquals;

public class UnitTestingStringProblem {
    public static void main(String[] args) throws java.lang.AssertionError{
        //Apply Unit Test into all the methods in this package.

        boolean b=Anagram.checkAnagram("top","poty");
        try {
            assertEquals("true", b);
        }catch (Exception e){
            e.getMessage();
        }

    }
}
