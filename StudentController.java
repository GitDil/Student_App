import java.util.Hashtable;
import java.util.List;

public class StudentController{
    
    public static List<Student> get(Hashtable <String ,Object> ht){

        List<Student> student;
        if(ht == null){
            student = StudentDao.getAll();
        }else{
            String sname = (String) ht.get("sname");
            Gender genders =(Gender) ht.get("gender");

            if(genders ==null)
                student = StudentDao.getByName(sname);
            else if(sname ==null)
                student = StudentDao.getAllByGender(genders);
            else
                student = StudentDao.getNameAndGender(sname, genders);
            
        }
        
        return student;
    }

    public static String post(Student  student) {
        String msg = "";
        String error = "";
    
        Student stm = StudentDao.getByNic(student.getNic());
    
        if (stm != null)
            error = error + "Existing NIC";
    
        if(error.isEmpty()) {
            String dberr = StudentDao.save(student);
            if(dberr.equals("1"))
                msg = "1";
            else 
            msg = dberr;
        } else {
            msg = "Data Error/n" + error;
        }
        return msg;
    }

    public static String put(Student student) {

        String msg = "";
        String error = "";

        Student stm = StudentDao.getByNic(student.getNic());

        if (stm != null && student.getID() != stm.getID())
            error = error + "Existing Nic";

        if (error.isEmpty()) {
            String dberr = StudentDao.update(student);
            if (dberr.equals("1"))
                msg = "1";

            else
                msg = dberr;

        } else {
            msg = "Data Error:" + error;
        }
        return msg;
    }

    public static String delete(Student student) {

        String errors = "";
        String msg = "";

        String sts = StudentDao.delete(student);
        if (sts.equals("1")) {
            msg = sts;
        } else {
            errors = errors + sts;
            msg = errors;
        }

        return msg;
}

    
    
}
