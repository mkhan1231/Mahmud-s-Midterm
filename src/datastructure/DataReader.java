package datastructure;

import databases.ConnectToSqlDB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class DataReader {

	public static void main(String[] args) throws java.io.IOException, java.lang.Exception{
		/*
		 * User API to read the below textFile and print to console.
		 * Use BufferedReader class. 
		 * Use try....catch block to handle Exception.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 * After reading from file using BufferedReader API, store each word into Stack and LinkedList. So each word
		 * should construct a node in LinkedList.Then iterate/traverse through the list to retrieve as FIFO
		 * order from LinkedList and retrieve as FILO order from Stack.
		 *
		 * Demonstrate how to use Stack that includes push,peek,search,pop elements.
		 * Use For Each loop/while loop/Iterator to retrieve data.
		 */


		String textFile = "/Users/Mahmud Khan/IdeaProjects/MidtermNovember2018/src/data/self-driving-car";
		FileReader fr = null;
		BufferedReader br = null;

		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
		connectToSqlDB.createTableFromStringToMySql("tbl_selfDrivingCar","data_values" );

		try {
			fr = new FileReader(textFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("We could not find the file..");
		}
		String data;
		br = new BufferedReader(fr);
		Stack newStack = new Stack();  // Create Stack
		LinkedList<String> newLinkedList = new LinkedList<>();
		try {
				while((data = br.readLine()) !=null) {
					System.out.println(data);
					String[] str1 = data.split(" ");
					for (int i = 0; i < str1.length; i++) {
						//Demonstrated push() method for Stack
						newStack.push(str1[i]);
						newLinkedList.add(str1[i]);
					}
					connectToSqlDB.insertDataFromStringToSqlTable(data, "tbl_selfDrivingCar", "data_values");
				}
		}catch (IOException ioe1) {
			ioe1.printStackTrace();
			System.out.println("We could not read the file..");
		}
		finally {
			if(fr != null) {
				fr = null;
			}
			if(br != null) {
				br = null;
			}
		}
		//Retrieving and Printing from Database
		List<String> readText = connectToSqlDB.readDataBase("tbl_selfDrivingCar", "data_values");
		System.out.println("Retrieving and Printing from Database");
		for(String st:readText){
		System.out.println(st);
		}

		//Retrieving data from LinkedList
		System.out.println("Retrieving and Printing from Linked List that follows FIFO: ");
		for(int i=0; i<newLinkedList.size(); i++){
			System.out.print(newLinkedList.get(i)+" , ");
		}
		System.out.println();

		//Retrieving data from Stack
		System.out.println("Retrieving and Printing from Stack that follows FILO/LIFO order: ");
		for (int i=newStack.size()-1; i>=0; i--) {
			System.out.print(newStack.get(i)+" , ");
		}
		System.out.println();

		//Demonstrating push,peek,search,pop element for stack
		//peek()method returns the element at the top of the Stack
		System.out.println("Peeking stack: "+ newStack.peek());

		//search() method returns the position of the element if it is successfully found in the stack
		System.out.println("Searching stack: "+newStack.search("steps!"));

		//pop() method returns the element present at the top of the stack and then removes it
		System.out.println("Popping stack: "+newStack.pop());

		//again peek()method returns the element at the top of the Stack
		System.out.println("Peeking again: "+newStack.peek());

		//element() is not for Stack, it is for Queue

		//Retrieving data using for-each loop
		System.out.println("Retrieving data from stack using for-each loop: ");
		for(Object stOb: newStack) {
		System.out.println(stOb);
		}

		//Retrieving data using while loop
		System.out.println("Retrieving data from stack using while loop: ");
		while(!newStack.empty()){
			System.out.println(newStack.pop());
		}

		//Retrieving data using iterator
		System.out.println("Retrieving data from LinkedList using iterator: ");
		Iterator itOb = newLinkedList.iterator();
		while(itOb.hasNext()) {
		String strOb = (String) itOb.next();
		System.out.println(strOb);
		}
	}
}


