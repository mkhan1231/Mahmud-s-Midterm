package databases;
import org.testng.Assert;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;

public class UnitTestConnectDB {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException{
        ConnectToSqlDB con = new ConnectToSqlDB();
        Connection resultConnection=con.connectToSqlDatabase();
        //Assert.assertEquals(resultConnection,

    }
}