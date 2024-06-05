
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CommonDao {
    public static  ResultSet getQuery(String qry){

        ResultSet result = null;

        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/colleage","root","1234");
            Statement stm = con.createStatement();
            result = stm.executeQuery(qry);

        }catch(SQLException e){
            System.out.println("Cant Acess Database"+e.getMessage());
        }
        return result;
    }

    public static String modify(String qry){

        String msg = "0";
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/colleage", "root", "1234");
                Statement stm = con.createStatement();
                int row = stm.executeUpdate(qry);
                    if (row != 0) {
                        msg = "1";
                    }else {
                        msg = "DB Error";
                    }
    
            } catch (SQLException e) {
                System.out.println("Can't Connect as :" + e.getMessage());
            }
                return msg;
    }

}
