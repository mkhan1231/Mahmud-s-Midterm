package math.problems;

public class Pattern {

	public static void main(String[] args) {
		/* Read this numbers, find the pattern then implement the logic from this pattern.which will give you this output.
		 * 100,99,98,97,96,95,94,93,92,91,90,88,86,84,82,80,78,76,74,72,70,67,64,61,58,55,52,49,46,43,40,36,32............
		 *
		 *
		 */

		//Using Nested loop

		int num1 = 1;
		int num2 = 100;
		int num3 = 0;
		int[] a = new int[40];

		while (num2 > 0) {
			for (int i = 0; i < 10; i++) {
				System.out.print(num2+",");
				a[num3] = num2;
				num2 = num2-num1;
				num3++;
			}
			num1++;
		}
	}
}

