package math.problems;

import databases.ConnectToSqlDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumber {

	public static void main(String[] args) {
		/*
		 * Find list of Prime numbers from number 2 to 1 million.
		 * Try the best solution as possible.Which will take less CPU life cycle.
		 * Out put number of Prime numbers on the given range.
		 *
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 */


		//To minimize the processing time, the upper range was put as 10000

		System.out.println("\f");
		int [ ] array = new int [1229]; //There are 1229 prime numbers from 2 to 10000
		int x = 0;
		int i =2;
		while(x<1229){
			if(is_prime(i)){
			array [x] = i;
			System.out.println(array[x] + "\t");
			x++;
			}
			i++;
		}

		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
		List<String> lowestValue = new ArrayList<String>();
		try {
			connectToSqlDB.insertDataFromArrayToSqlTable(array, "tbl_primeNumber", "column_primeNumber");
			lowestValue = connectToSqlDB.readDataBase("tbl_primenumber", "column_primeNumber");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Data is reading from the Table (tbl_primenumber) and displaying to the console");
		for(String st:lowestValue){
			System.out.println(st);
		}
	}

	public static boolean is_prime(int num) //determines if number is prime
	{
		for(int i=2; i<num; i++)
		if(num%i==0)
		return false;
		return true;

	}
}
