
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class dbmsconnection
{
    Connection con=null;
    Statement stmt=null;
    dbmsconnection()
    {
        try
        {
            String url="jdbc:oracle:thin:@localhost:1521:JINTO";
            String user="system";
            String password="jithin";
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("DRIVER LOADED");

            con=DriverManager.getConnection(url,user,password);
            System.out.println("CONNECTION MADE");
            stmt=con.createStatement();
            
            
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
}
