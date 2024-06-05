public class Gender {
     int id;
     String name;

    Gender(){}

    public void setID(int id){
        this.id = id;
    }
    public int getID(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public String toString(){return name;}
}
