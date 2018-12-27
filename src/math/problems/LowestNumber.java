package math.problems;

import databases.ConnectToSqlDB;

import java.util.ArrayList;
import java.util.List;

public class LowestNumber {

	public static void main(String[] args) throws Exception {
		/*
		 * Write java solution to find the lowest number from this array.
		 * Use one of the databases from mysql or mongodb to store and to retrieve.*/

		int array[] = new int[]{211, 110, 99, 34, 67, 89, 67, 456, 321, 456, 78, 90, 45, 32, 56, 78, 90, 54, 32, 123, 67, 5, 679, 54, 32, 65};

		System.out.println("lowest number from array is :" + LowestNumber.lowest(array));

		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.add(LowestNumber.lowest(array));

		List list = arrList;
		List numList2 = new ArrayList();
		numList2 = list;

		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
		connectToSqlDB.insertDataFromArrayListToSqlTable(numList2, "tbl_lowestNumber", "column_lowestNumber");
		List<String> numbers = connectToSqlDB.readDataBase("tbl_lowestNumber", "column_lowestNumber");

		for (String st : numbers) {
			System.out.println(st);

		}

	}

	public static int lowest(int[] array) {
		int lowest = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (lowest > array[i]) {
				lowest = array[i];
			}
		}
		return lowest;
	}
}
