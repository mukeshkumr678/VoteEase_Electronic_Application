import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

class Idpassword {
    private HashMap<String, String> loginInfo = new HashMap<>();

    Idpassword() {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String dbUrl = "jdbc:ucanaccess://D://OOP_Final_Project//VoteEase//VoteEase.accdb";
                 Connection connection = DriverManager.getConnection(dbUrl);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT username, password FROM users");

                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    loginInfo.put(username, password);
                }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    protected HashMap<String, String> getLoginInfo()
    {
        return loginInfo;
    }
}
