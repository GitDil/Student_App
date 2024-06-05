public class Student{
   private  int id;
   private  String sname;
   private String address;
   private String nic;
  private    Stream stream_id;
    private Gender gender;

    Student(){}

    public void  setID(int id){
         this.id = id;
    }
    public int getID(){
        return id;
    }


    public void setName(String sname){
        this.sname = sname;
    }

    public String getName(){
        return sname;
    }

    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }

    public void setNic(String nic){
        this.nic = nic;
    }
    public String getNic(){
        return nic;
    }


    public void setStream(Stream stream_id){
        this.stream_id = stream_id;
    }
    public Stream getStream(){
        return stream_id;
    }

    public void setGender(Gender gender){
        this.gender =gender;
    }

    public Gender getGender(){
        return gender;
    }


}