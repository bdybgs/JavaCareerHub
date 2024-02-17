package ru.vsu.entities;

public class Course {

    protected Integer id;
    protected String name;
    protected int hours;

    public Course(int id,
                  String name,
                  int hours){
        this.id=id;
        this.name=name;
        this.hours=hours;
    }

    public Course(String name,
                  int hours){
        this.id=null;
        this.name=name;
        this.hours=hours;
    }

    //public Integer getCourseId(){return id;}

    public String getName(){
        return name;
    }

    public int getHours(){
        return hours;
    }

    public Integer getID(){
        return id;
    }
    public void setID(int id){
        this.id=id;
    }
//    @Override
//    public Integer getID() {
//        return id;
//    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hours=" + hours +
                '}';
    }
}