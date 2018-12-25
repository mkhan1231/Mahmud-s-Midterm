package datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UseQueue {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Queue that includes add,peek,remove,pool elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * 
		 */

		Queue<String> q = new LinkedList<String>();

		//Adding elements to the Queue by add() method
		q.add("Neymer");
		q.add("Ronaldinho");
		q.add("Maradona");
		q.add("Ronaldo");
		q.add("Messi");
		q.add("Zidane");
		q.add("Pele");
		System.out.println("Elements in Queue: "+q);

		//Removing elements by remove() method. As per FIFO, the first element "Neymer" entered is removed first
		q.remove();
		System.out.println("Elements in Queue after removing one element: "+q);

		//element() method returns the head of the Queue. Head is the first element of Queue
		System.out.println("Head of the Queue after remove: "+q.element());

		//poll() method removes and returns the head of the Queue. Returns null if the Queue is empty
		System.out.println("Poll method removes latest head and returns it: "+q.poll());


		//peek() method return the head but returns null if the Queue is empty
		System.out.println("peek method returns the latest head of the Queue: "+q.peek());

		//Again displaying the elements of Queue
		System.out.println("Elements in Queue:"+q);

		//Use of For Each loop  to retrieve data.

		System.out.println("Use of for each loop to retrieve data: ");
		for (String str1 : q) {
			System.out.print(str1+" ");
		}
		System.out.println();

		//Use of while loop with Iterator to retrieve data.
		System.out.println("Use of while loop to retrieve data: ");
		Iterator itr = q.iterator();
		while (itr.hasNext()) {
		String str2 = (String) itr.next();
		System.out.print(str2+" ");
		}
		System.out.println();

	}

}
