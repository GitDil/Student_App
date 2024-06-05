import java.util.Hashtable;
import java.util.List;

public class ST {
    public static void main(String[] args) {
       
    //     Hashtable<String,Object> ht = new Hashtable<>();
    //     ht.put("name", "Sunil");
    //     List<Student> students = StudentController.get(ht);
    //     for(Student stu:students){
    //         System.out.println(stu.getID() + " ");
    //         System.out.println(stu.getName() + " ");
    //         System.out.println(stu.getAddress() + " ");
    //         System.out.println(stu.getStream() + " ");
    //         System.out.println(stu.getGender().getName() + " ");
    //     }
    // }

        //Unit Test-6->StudentDao->getAllByName()
         
        //   List<Student> student = StudentDao.getByName("s");
        //     for(Student stu:student){
        //     System.out.println(stu.getID() + " ");
        //     System.out.println(stu.getName() + " ");
        //     System.out.println(stu.getNic() + " ");
        //     System.out.println(stu.getAddress() + " ");
        //     System.out.println(stu.getStream() + " ");
        //     System.out.println(stu.getGender().getName() + " ");
        // }
         
        //

        
         //Unit Test-8->EmployeeDao->getAllByNameAndGender()
          
        //  Gender gen = GenderDao.getById(1);
          
        //  List<Student> student = StudentDao.getNameAndGender("s", gen);
          
        //  for (Student stu : student) {
        //  System.out.print(stu.getID() + " ");
        //  System.out.print(stu.getName() + " ");
        //   System.out.print(stu.getNic() + " ");
        //   System.out.print(stu.getGender().getName() + "");
        //   System.out.print(stu.getStream() .getName() +" \n");
        //  }
         

        
         // =======With Gender-Male=======
        //  Gender gen = GenderDao.getById(1);
         
        //   Hashtable<String,Object> ht = new Hashtable<>();
        //  ht.put("gender", gen);
         
        //  List<Student> student = StudentController.get(ht);
         
        //   for(Student stu:student){
        //     System.out.println(stu.getID() + " ");
        //     System.out.println(stu.getName() + " ");
        //     System.out.println(stu.getNic() + " ");
        //     System.out.println(stu.getAddress() + " ");
        //     System.out.println(stu.getStream() + " ");
        //     System.out.println(stu.getGender().getName() + " ");
         
        //  =======With Gender-Female=======
        //  Gender gen = GenderDao.getById(2);
         
        //   Hashtable<String,Object> ht = new Hashtable<>();
        //   ht.put("gender", gen);
         
        //   List<Student> student = StudentController.get(ht);
         
        //  for (Student st : student) {
        //  System.out.print(st.getID() + " ");
        //  System.out.print(st.getName() + " ");
        //   System.out.print(st.getNic() + " ");
        //  System.out.print(st.getAddress() + " ");
        //   System.out.println(st.getGender().getName() + " ");
        //   System.out.print(st.getStream().getName() + "\n ");
        //   }
         
        //  //=======With Name and Gender=======
        //   Gender gen = GenderDao.getById(2);
         
        //   Hashtable<String, Object> ht = new Hashtable<>();
        //   ht.put("name", "u");
        //   ht.put("gender", gen);
         
        //  List<Student> student = StudentController.get(ht);
         
        //  for (Student st : student) {
        //  System.out.print(st.getID() + " ");
        //  System.out.print(st.getName() + " ");
        //   System.out.print(st.getNic() + " ");
        //  System.out.print(st.getAddress() + " ");
        //   System.out.println(st.getGender().getName() + " ");
        //   System.out.print(st.getStream().getName() + "\n ");
        //   }
        //  /

         //Unit Test10-> StudentDao.save()

            // Student student = new Student();
            // student.setName("Sunil");
            // student.setAddress("Kaluthra");
            // student.setNic("20055509876");
            // student.setStream(StreamDao.getById(1));
            // student.setGender(GenderDao.getById(1));

            // String msg = StudentDao.save(student);
            // System.out.println(msg);

            //Unit Test11->     StudentDao.save() Nic
            //Student student = StudentDaoDao.getByNic("200166601622");
            // if(student !=null){
            //     System.out.println("Nic is Exisit");
            // }else{
            //     System.out.println("New NIC");
            // }
            // //With New NIC

            // Student student2 = StudentDao.getByNic("244166601622");
            // if(student2 !=null){
            //     System.out.println("Nic is Exisit");
            // }else{
            //     System.out.println("New NIC");
            // }

            //Unit Test 12 ->StudentDao(); Database eke thiyana nic ekk atthe 

            // Student student =    new Student();
            // student.setName("Rabbit");
            // student.setAddress("Kaluthra");
            // student.setNic("199956789012");
            // student.setStream(StreamDao.getById(2));
            // student.setGender(GenderDao.getById(3));

            // String msg =StudentController.post(student);
            // System.out.println(msg);

        //     String qry = "INSERT INTO student(name,address,nic,stream_id,gender_id) values('"
        //  + student.getName() + "',"
        //  + student.getAddress() + "',"
        //  + student.getNic() + ","
        //  + student.getGender().getID() + ","
        //  + student.getStream().getID() + ")";
        //         System.out.print(qry);

                    //Addd ==== Test
                // Student stu= new Student();

                //   stu.setName("Hashiya");
                //   stu.setAddress("Colombo");
                //   stu.setNic("123455789121");
                //   stu.setGender(GenderDao.getById(1));
                //   stu.setStream(StreamDao.getById(1));

                //   String msg=StudentDao.save(stu);
                  //System.out.println(msg);
}


}
