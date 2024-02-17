package ru.vsu.repository;

import  ru.vsu.ConnectionManager;
import ru.vsu.entities.Course;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CoursesDBRepository implements CoursesRepository{

    private static ConnectionManager connectionManager;
    private static CoursesDBRepository INSTANCE;

    public static CoursesDBRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CoursesDBRepository();
            connectionManager = ConnectionManager.getInstance();
        }
        return INSTANCE;
    }

    private Course getCourseFromResultSet(ResultSet rs){
        try {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int hours = rs.getInt(3);
            return new Course(id,name,hours);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Course> getAll() {
        try{
            List<Course> courses = new ArrayList<>();
            ResultSet rs = connectionManager.executeSelect("SELECT * FROM course");
            while (rs.next()){
                courses.add(getCourseFromResultSet(rs));
            }
            rs.close();
            return courses;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Course getByID(int id) {
        try {
            ResultSet rs = connectionManager.executeSelect("SELECT * FROM course WHERE id = " + id);
            rs.next();
            Course course = getCourseFromResultSet(rs);
            rs.close();
            return course;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void add(Course course) {
        try {
            if (course.getID() == null) {
                connectionManager.executeUpdate("INSERT INTO course (name, hours) VALUES ( '"
                        + course.getName() + "', '" + course.getHours()+ "');");
                return;
            }
            connectionManager.executeUpdate("INSERT INTO course (id, name, hours) VALUES ( '"
                    + course.getID() + "' , '" + course.getName() + "', '" + course.getHours() + "');");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            connectionManager.executeUpdate("DELETE FROM course WHERE id = " + id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(int id, Course newCourse) {
        try {
            connectionManager.executeUpdate("UPDATE course SET name = '" + newCourse.getName() + "', hours = '"
                    + newCourse.getHours() +"' WHERE id = " + id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
