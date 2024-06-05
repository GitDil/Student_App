import java.util.List;

public class StreamController {
    public static List<Stream> get(){
        List<Stream> stream = StreamDao.getAll();
        return stream;
    }
    
}
