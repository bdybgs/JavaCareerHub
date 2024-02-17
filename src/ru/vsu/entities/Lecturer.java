package ru.vsu.entities;

public class Lecturer{

    protected Integer id;
    protected String name;
    protected String surname;
    //protected int[] courses;

    public Lecturer(int id,
                    String name,
                    String surname
                    //int[] courses
    ){
        this.id=id;
        this.name=name;
        this.surname=surname;
        //this.courses=courses;
    }

    public Lecturer(String name,
                    String surname
            //,int[] courses
    ){
        this.id=null;
        this.name=name;
        this.surname=surname;
        //this.courses=courses;
    }

    //public Integer getLecturerId(){return id;}

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
//    public int[] getCourses(){
//        return courses;
//    }

    public void setID(int id){
        this.id=id;
    }

    public Integer getID(){
        return id;
    }
//    @Override
//    public Integer getID() {
//        return id;
//    }
}
