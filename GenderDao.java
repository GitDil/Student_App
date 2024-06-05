import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

public class GenderDao {
    
    public static Gender getById(int id) {

        Gender gender = new Gender();

        try {

            String qry = "SELECT * FROM gender where id=" + id;
            ResultSet result = CommonDao.getQuery( "SELECT * FROM gender where id=" + id);

            result.next();
            gender.setID(result.getInt("id"));
            gender.setName(result.getString("name"));

        } catch (SQLException e) {
            System.out.println("Cant acess the database" + e.getMessage());
        }

        return gender;
    }

    public static List<Gender> getAll(){
        List <Gender> genders = new ArrayList<Gender>();

        try{
        
            ResultSet result = CommonDao.getQuery("SELECT * from Gender");

            while(result.next()){
                Gender gen = new Gender();
                gen.setID((result.getInt("id")));
                gen.setName(result.getString("name"));
                genders.add(gen);
                
            }
        }catch(SQLException e){
            System.out.println();
        }

        return genders;
    }

    // public static Object getById(String string) {
    // return null;
    // }

}
