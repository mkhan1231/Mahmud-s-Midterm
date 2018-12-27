package databases;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;


public class UnitTestConnectDB {
    @Test
    public void connectionTest() {

        try {
            ConnectToSqlDB.connectToSqlDatabase();
            System.out.println("mysql database connected successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}