import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
    public static void main(String[] args) throws SQLException {
        /**
         * Protocol :
         * http, https: For surfing on web
         * jdbc:subprotocol:subname
         * jdbc:<db type> : <ip address + port number + db name>
         */

        String url = "jdbc:mysql://localhost:3306/test";
        Connection connection = DriverManager.getConnection(url, "root", "");

        String sqsQuery = "CREATE TABLE person(id int, name varchar(16))";
        Statement statement = connection.createStatement();
        statement.execute(sqsQuery);
    }
}
