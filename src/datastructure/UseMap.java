package datastructure;

import databases.ConnectToSqlDB;

import java.sql.Connection;
import java.util.*;

public class UseMap {

	public static void main(String[] args) throws java.lang.Exception {
		/*
		 * Demonstrate how to use Map that includes storing and retrieving elements.
		 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 */
		Map<Integer, String> state = new HashMap<Integer, String>();
		//Storing values to Map by put() method
		state.put(1, "NY");
		state.put(2, "TX");
		state.put(3, "NJ");
		state.put(4, "FL");

		//Retrieving values by get() method
		String var = state.get(2);
		System.out.println("Value at index 2 is: " + var);
		String var1 = state.get(3);
		System.out.println("Value at index 3 is: " + var1);

		List<String> cityOfBD = new ArrayList<String>();
		cityOfBD.add("Dhk");
		cityOfBD.add("Ctg");
		cityOfBD.add("Khl");

		List<String> cityOfIndia = new ArrayList<String>();
		cityOfIndia.add("Chennai");
		cityOfIndia.add("Mumbai");
		cityOfIndia.add("Delhi");

		List<String> cityOfPak = new ArrayList<String>();
		cityOfPak.add("Islamabad");
		cityOfPak.add("Karachi");
		cityOfPak.add("Rawalpindi");

		//Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		Map<String, List<String>> b = new HashMap<String, List<String>>();
		b.put("Bangladesh", cityOfBD);
		b.put("India", cityOfIndia);
		b.put("Pakistan", cityOfPak);

		//Retrieve with while loop and iterator
		System.out.println("Retrieve with while loop and iterator");
		Iterator<Map.Entry<String, List<String>>> it = b.entrySet().iterator();
		while (it.hasNext()) {
		Map.Entry<String, List<String>> x = it.next();
		System.out.println(x.getKey() + " " + x.getValue());
		}

		//Retrieve with For each Loop
		System.out.println("Retrieve with For each Loop");
		for (Map.Entry entry : b.entrySet()) {
		System.out.println(entry.getKey() + " " + entry.getValue());
		}

		//Connect to Database
		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

		//Creating table, inserting data and read values
		connectToSqlDB.createTableFromStringToMySql("tbl_map", "mapKey", "mapValue");
		for (Object str : b.keySet()) {
			for (String str1 : b.get(str)) {
				List<String> list1 = new ArrayList<String>();
				list1.add(str.toString()); // adds key
				list1.add(str1); // adds value
				// Insert data in the database
				connectToSqlDB.InsertDataFromArrayListToMySql(list1, "tbl_map", "mapKey", "mapValue");
			}
		}

		//System.out.println("Reading data from database: ");
		//Reading data from database
		List<String> numbers = connectToSqlDB.readDataBase("tbl_map", "mapKey", "mapValue");

		for (String st : numbers) {
			System.out.println(st);
		}
	}
}
