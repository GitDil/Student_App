import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class StudentDao {
    private static List<Student> get(String qry) {
        List<Student> students = new ArrayList<>();

        ResultSet result = null;

        try {
            result = CommonDao.getQuery(qry);

            while (result.next()){
                Student stu = new Student();
                stu.setID(result.getInt("id"));
                stu.setName(result.getString("name"));
                stu.setAddress(result.getString("address"));
                stu.setNic(result.getString("nic"));
                stu.setStream(StreamDao.getById(result.getInt("stream_id")));
                stu.setGender(GenderDao.getById(result.getInt("gender_id")));

                students.add(stu);
            }

        } catch (SQLException e) {
            System.out.println("Cant Acess Database" + e.getMessage());
        }

        return students;
    }

    public static List<Student> getAll() {
        String qry = "SELECT * from student";
        List<Student> students = get(qry);
        return students;
    }

    public static List<Student> getByName(String sname){
        String qry = "SELECT * From student where name like '" + sname + "%'";
        List <Student> students = get(qry);
        return students;
    }

    public static List<Student> getAllByGender(Gender gender){
        String qry = "SELECT * FROM employee where gender_id=" + gender.getID();
        List <Student> students = get(qry);
        return students;
    }

    public static List<Student> getNameAndGender(String sname,Gender gender){
        String qry = "SELECT * From student where name like '" + sname + "%' and gender_id="+gender.getID();
        List <Student> students = get(qry);
        return students;
    }

    public static Student  getByNic(String nic) {

        Student student = null;

        try {
            String qry = "Select * from student where nic='" + nic+"'";

            ResultSet result = CommonDao.getQuery(qry);

            if (result.next() && result != null) {
                student = new Student();
                student.setID(result.getInt("id"));
                student.setName(result.getString("name"));
                student.setNic(result.getString("nic"));
                student.setAddress(result.getString("address"));
                student.setStream(StreamDao.getById(result.getInt("stream_id")));
                student.setGender(GenderDao.getById(result.getInt("gender_id")));

            }

        } catch (Exception e) {
            System.out.println("can't Connect as" + e.getMessage());

        }
        return student;

    }

    public static String save(Student student) {

        String msg = "";

        String qry = "INSERT INTO student(name, address, nic, stream_id, gender_id) VALUES ('"
        + student.getName() + "','"
        + student.getAddress() + "',"
        + student.getNic() + ","  // Added missing quote
        + student.getStream().getID() + ","
        + student.getGender().getID() + ")";  // Removed extra quote after getGender().getID()

        // INSERT INTO employee (name,address,nic,stream_id,gender_id) values('"
        // Sunil','
        // Kaluthra',
        // 20055509876',
        // 1',
        // 1);

        System.out.println(qry);

        msg = CommonDao.modify(qry);

        return msg;

    }

    public static String update(Student student) {

        String msg = "can't connect database";

        String qry = "UPDATE  student SET name = '" +
                student.getName() + "', address = '" +
                student.getAddress() + "', nic = '" +
                student.getNic() + "', gender_id = '" +  // Removed extra space after '='
                student.getGender().getID() + "', stream_id = '" + // Added missing quote and space
                student.getStream().getID() + "' WHERE id = " + student.getID();


        // System.out.println(qry);

        msg = CommonDao.modify(qry);
        return msg;

    }

    public static String delete(Student student) {

        String msg = "Can't Connect Database";

        String qry = "DELETE FROM student WHERE id=" + student.getID();
        msg = CommonDao.modify(qry);

        return msg;}

}
