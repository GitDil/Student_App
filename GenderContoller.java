import java.util.List;

public class GenderContoller {
    public static List<Gender> get(){
        List<Gender> gender  = GenderDao.getAll();
        return gender;
    }
}
