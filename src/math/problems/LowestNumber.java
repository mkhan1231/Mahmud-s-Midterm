package math.problems;

import databases.ConnectToSqlDB;

import java.util.ArrayList;
import java.util.List;

public class LowestNumber {

		public static void main(String[] args) throws Exception {
		/*
		 * Write java solution to find the lowest number from this array.
		 * Use one of the databases from mysql or mongodb to store and to retrieve.*/

		int  array[] = new int[]{211,110,99,34,67,89,67,456,321,456,78,90,45,32,56,78,90,54,32,123,67,5,679,54,32,65};

		int smallest = Integer.MAX_VALUE;
		for(int i=0; i<array.length; i++){
		if(smallest>array[i]){
		smallest = array[i];
			}
		}
		System.out.println("Lowest number in array is: "+smallest);

		ArrayList<Integer> numList1 = new ArrayList<>();
		numList1.add(smallest);
		List numList2 =  new ArrayList();
		numList2=numList1;

		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
		connectToSqlDB.insertDataFromArrayListToSqlTable(numList2,"tbl_lowestNumber", "column_lowestNumber");
		List<String> numbers = connectToSqlDB.readDataBase("tbl_lowestNumber", "column_lowestNumber");

		for(String st:numbers){
		System.out.println(st);
		}
	}
}