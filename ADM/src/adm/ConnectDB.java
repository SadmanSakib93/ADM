
package adm;
import java.sql.*;

public class ConnectDB {
    
    public static Connection connection()
    {
        Connection myConn = null;
        String user = "root";
        String pass = ""; 
        try {
            //  Make a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/admdb", user, pass);

        } catch (Exception exc) {
            exc.printStackTrace();
        } 
        
        
        return myConn;
        
    }
    
}
