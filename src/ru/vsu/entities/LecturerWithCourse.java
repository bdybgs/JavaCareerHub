package ru.vsu.entities;

public class LecturerWithCourse {
    protected Integer lecturerId;
    protected Integer courseId;

    public LecturerWithCourse(int lecturerId,
                    int courseId){
        this.lecturerId=lecturerId;
        this.courseId=courseId;
    }

    public Integer getLecturerId(){
        return lecturerId;
    }

    public Integer getCourseId(){
        return courseId;
    }
}
