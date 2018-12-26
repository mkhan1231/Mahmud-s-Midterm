package parser;

import databases.ConnectToMongoDB;
import databases.ConnectToSqlDB;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

public class ProcessStudentInfo {

	/*
	 * Under XmlReader class, the parseData() will return list of Student Info which will contain Student first name, last name and score.
	 * You need to implement the method name "convertIntToChar()" which will convert String score into char Grade.('A'for 90 to 100,'B'for 80 to 89 and
	 * 'C' for 70 to 79.
	 *
	 * Here in the main method fill in the code that outlined to read xml data parsed into 2 separate ArrayList, then store into map.
	 * Once map has all data, retrieve those data and out put to console.
	 *
	 * Do any necessary steps that require for below successful output.
	 * ......................................................
	 * Student (id= 1) "Ibrahim" "Khan"        		Grade= B
	 * Student (id= 2) "Asif" "Roni"          		Grade= A
	 * Student (id= 3) "Gumani" "Hose"              Grade= A
	 * Student (id= 4) "Sukanto" "Shaha"            Grade= B
	 * Student (id= 5) "MD" "Hossain"               Grade= C
	 * ......................................................
	 *
	 *
	 * Use any databases[MongoDB, Oracle or MySql] to store data and to retrieve data.
	 *
	 */

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, Exception {
		//Path of XML data to be read.
		String pathSelenium = System.getProperty("user.dir") + "/src/parser/selenium.xml";
		String pathQtp = System.getProperty("user.dir") + "/src/parser/qtp.xml";
		String tag = "id";

		//Declare a Map with List<String> into it.
		Map<String, List<Student>> list = new LinkedHashMap<String, List<Student>>();

				/*Declare 2 ArrayList with Student data type to store Selenium student into one of the ArrayList and
				  Qtp student into another ArrayList. */

		List<Student> seleniumStudents = new ArrayList<Student>();
		List<Student> qtpStudents = new ArrayList<Student>();

		//Create XMLReader object.
		XmlReader xmlReader = new XmlReader();


		//Parse Data using parseData method and then store data into Selenium ArrayList.
		seleniumStudents = xmlReader.parseData(tag, pathSelenium);

		//Parse Data using parseData method and then store data into Qtp ArrayList.
		qtpStudents = xmlReader.parseData(tag, pathQtp);

		//add Selenium ArrayList data into map.
		list.put("sel", seleniumStudents);
		//add Qtp ArrayList data into map.
		list.put("qtp", qtpStudents);

		//Retrieve map data and display output.
		Iterator itr = list.keySet().iterator();
		while (itr.hasNext()) {
			List st = list.get(itr.next());
			for (Object str : st) {
				System.out.println(str);
			}
		}



		//Connect to MySQL database
		ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();

		//Create tables in database
		connectToSqlDB.createTableFromStringToMySql("tbl_Qtp", "mapKey", "mapValue");
		connectToSqlDB.createTableFromStringToMySql("tbl_Selenium", "mapKey", "mapValue");
		//Store Selenium data into Selenium table in Database
		//Store Qtp data into Qtp table in Database
		for (Object str : list.keySet()) {
			for (Object str1 : list.get(str)) {
				List<String> list1 = new ArrayList<String>();
				list1.add(str.toString());
				list1.add(str1.toString());

				if (str.equals("sel")) {
					connectToSqlDB.InsertDataFromArrayListToMySql(list1, "tbl_Selenium", "mapKey", "mapValue");
				} else {
					connectToSqlDB.InsertDataFromArrayListToMySql(list1, "tbl_Qtp", "mapKey", "mapValue");
				}
			}
		}

		//Retrieve Selenium and Qtp students from Database

		List<String> numbers = connectToSqlDB.readDataBase("tbl_Selenium", "mapKey", "mapValue");
		for (String st : numbers) {
			System.out.println(st);

		}

		List<String> numbers1 = connectToSqlDB.readDataBase("tbl_Qtp", "mapKey", "mapValue");
		for (String st : numbers1) {
			System.out.println(st);
		}
	}
}
