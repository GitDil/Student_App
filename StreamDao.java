import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class StreamDao{
    public static Stream getById(int id){

        Stream strem = new Stream();

        try{
            String qry = "select * from stream where id="+id;
            ResultSet result = CommonDao.getQuery(qry);

            result.next();
            strem.setID(result.getInt("id"));
            strem.setName(result.getString("name"));
        }catch(SQLException e){
            System.out.println("DB Error"+e.getMessage());
        }

        return strem;
    }

    public static List <Stream> getAll(){

        List<Stream> streams= new ArrayList<Stream>();

        try{
            String qry = "select * from stream";
            ResultSet result = CommonDao.getQuery(qry);

            while(result.next()){
                 Stream stream =  new Stream();
                stream.setID(result.getInt("id"));
                stream.setName(result.getString("name"));
                streams.add(stream);
            }

           
        }catch(SQLException e){
            System.out.println("DB Error"+e.getMessage());
        }

        return streams;
    }
}