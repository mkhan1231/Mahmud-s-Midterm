package json.parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import databases.ConnectToSqlDB;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CnnAPI {
    /*
      You can get API_KEY from this below link. Once you have the API_KEY, you can fetch the top-headlines news.
      https://newsapi.org/s/cnn-api

      Fetch This following CNN API, It will return some news in Json data. Parse this data and construct
      https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=YOUR_API_KEY

      MY_API_KEY=0d9e35dfa3c140aab8bf9cdd70df957f

      After getting Json Format of the news, You can go to json validator link: https://jsonlint.com/ to see
      how it can be parsed.

      "articles": [{
		"source": {
			"id": "cnn",
			"name": "CNN"
		},
		"author": null,
		"title": "Who is affected by a shutdown? - CNN Video",
		"description": "CNN's Tom Foreman breaks down who is affected by a federal government partial shutdown.",
		"url": "http://us.cnn.com/videos/politics/2018/12/22/federal-partial-shutdown-by-the-numbers-foreman-ctn-vpx.cnn",
		"urlToImage": "https://cdn.cnn.com/cnnnext/dam/assets/181202171029-government-shutdown-capitol-file-super-tease.jpg",
		"publishedAt": "2018-12-23T01:09:50.8583193Z",
		"content": "Chat with us in Facebook Messenger. Find out what's happening in the world as it unfolds."
	   },{}]

	   Read the articles array and construct Headline news as source, author, title,description,url,urlToImage,publishedAt
	   and content. You need to design News Data Model and construct headline news.
	   You can store in Map and then into ArrayList as your choice of Data Structure.

	   You can follow How we implemented in Employee and JsonReaderUtil task.

	   Show output of all the headline news in to console.
	   Store into choice of your database and retrieve.

     */

    public static void main(String[] args) throws Exception {


        List<String> listofid = new ArrayList();
        List<String> listofname = new ArrayList();
        List<String> listofa = new ArrayList();
        List<String> listoft = new ArrayList();
        List<String> listofdes = new ArrayList();
        List<String> listofurl = new ArrayList();
        List<String> listofurlm = new ArrayList();
        List<String> listofpub = new ArrayList();
        List<String> listofcon = new ArrayList();
        Map<String, List<String>> map = new HashMap<>();


        try {
            URL sUrl = new URL("https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=a104f9105b384c15b810feafd3fa56be");
            URLConnection request = sUrl.openConnection();
            request.connect();

            JsonParser jsonParser = new JsonParser();
            JsonElement root = jsonParser.parse(new InputStreamReader((InputStream) request.getContent()));

            JsonObject jsonObject = new JsonObject();
            jsonObject.add("articles", root);

            JsonArray jsonArray = new JsonArray();
            jsonArray.add(root.getAsJsonObject().get("articles"));


            for (int k = 0; k < jsonArray.get(0).getAsJsonArray().size(); k++) {


                JsonObject jsonobject = jsonArray.get(0).getAsJsonArray().get(k).getAsJsonObject();


                String id = jsonobject.get("source").getAsJsonObject().get("id").toString();
                System.out.print(id);
                listofid.add(id);

                String name = jsonobject.get("source").getAsJsonObject().get("name").toString();
                System.out.print(name);
                listofname.add(name);

                String a = jsonobject.get("author").toString();
                System.out.print(a);
                listofa.add(a);
                String t = jsonobject.get("title").toString();
                System.out.print(t);
                listoft.add(t);
                String des = jsonobject.get("description").toString();
                System.out.print(des);
                listofdes.add(des);
                String url = jsonobject.get("url").toString();
                System.out.print(url);
                listofurl.add(url);
                String urlm = jsonobject.get("urlToImage").toString();
                System.out.print(urlm);
                listofurlm.add(urlm);
                String pub = jsonobject.get("publishedAt").toString();
                System.out.print(pub);
                listofpub.add(pub);
                String con = jsonobject.get("content").toString();
                System.out.print(con);
                listofcon.add(con);
                System.out.println();
                map.put("all_id", listofid);
                map.put("all_name", listofname);
                map.put("all_author", listofa);
                map.put("all_title", listoft);
                map.put("all_description", listofdes);
                map.put("all_url", listofurl);
                map.put("all_urlImage", listofurlm);
                map.put("all_publication", listofpub);
                map.put("all_content", listofcon);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Map.Entry e : map.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
        List l1 = listofid;
        List l2 = listofname;
        List l3 = listofa;
        List l4 = listoft;
        List l5 = listofdes;
        List l6 = listofurl;
        List l7 = listofurlm;
        List l8 = listofpub;
        List l9 = listofcon;

        ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
// Inserting Data into MySql
        connectToSqlDB.insertDataFromArrayListToSqlTableforString(l1, "tbl_json1", "data");
        connectToSqlDB.insertDataFromArrayListToSqlTableforString(l2, "tbl_json2", "data");
        connectToSqlDB.insertDataFromArrayListToSqlTableforString(l3, "tbl_json3", "data");
        connectToSqlDB.insertDataFromArrayListToSqlTableforString(l4, "tbl_json4", "data");
        connectToSqlDB.insertDataFromArrayListToSqlTableforString(l5, "tbl_json5", "data");
        connectToSqlDB.insertDataFromArrayListToSqlTableforString(l6, "tbl_json6", "data");
        connectToSqlDB.insertDataFromArrayListToSqlTableforString(l7, "tbl_json7", "data");
        connectToSqlDB.insertDataFromArrayListToSqlTableforString(l8, "tbl_json8", "data");
        connectToSqlDB.insertDataFromArrayListToSqlTableforString(l9, "tbl_json9", "data");
// Reading data from MySql
        System.out.println(connectToSqlDB.readDataBase("tbl_json1", "data"));
        System.out.println(connectToSqlDB.readDataBase("tbl_json2", "data"));
        System.out.println(connectToSqlDB.readDataBase("tbl_json3", "data"));
        System.out.println(connectToSqlDB.readDataBase("tbl_json4", "data"));
        System.out.println(connectToSqlDB.readDataBase("tbl_json5", "data"));
        System.out.println(connectToSqlDB.readDataBase("tbl_json6", "data"));
        System.out.println(connectToSqlDB.readDataBase("tbl_json7", "data"));
        System.out.println(connectToSqlDB.readDataBase("tbl_json8", "data"));
        System.out.println(connectToSqlDB.readDataBase("tbl_json9", "data"));
    }


}
