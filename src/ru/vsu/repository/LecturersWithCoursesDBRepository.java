package ru.vsu.repository;

import ru.vsu.ConnectionManager;
import ru.vsu.entities.LecturerWithCourse;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LecturersWithCoursesDBRepository implements LecturerWithCoursesRepository{

    private static ConnectionManager connectionManager;
    private static LecturersWithCoursesDBRepository INSTANCE;

    public static LecturersWithCoursesDBRepository getInstance(){
        if(INSTANCE == null){
            INSTANCE = new LecturersWithCoursesDBRepository();
            connectionManager = ConnectionManager.getInstance();
        }
        return INSTANCE;
    }

    private LecturerWithCourse getLWCFromResultSet(ResultSet rs){
        try{
            int LecturerID = rs.getInt(1);
            int CourseID = rs.getInt(2);
            return new LecturerWithCourse(LecturerID,CourseID);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<LecturerWithCourse> getAll() {
        try{
            List<LecturerWithCourse> lwc = new ArrayList<>();
            ResultSet rs = connectionManager.executeSelect("SELECT * FROM LECTURERWITHCOURSE");
            while (rs.next()){
                lwc.add(getLWCFromResultSet(rs));
            }
            rs.close();
            return lwc;
        } catch (Exception e){
            //System.out.println(e.getMessage());
            //System.out.println("Отсутствуют");
        }
        return null;
    }

    @Override
    public LecturerWithCourse getByID(int idL, int idC) {
        try {
            ResultSet rs = connectionManager.executeSelect("SELECT * FROM LECTURERWITHCOURSE WHERE lecturerId = " + idL+" AND courseId = "+idC);
            rs.next();
            LecturerWithCourse lws = getLWCFromResultSet(rs);
            rs.close();
            return lws;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void add(LecturerWithCourse lecturerWithCourse) {
        try {
            connectionManager.executeUpdate("INSERT INTO LECTURERWITHCOURSE (lecturerId, courseId) " +
                    "VALUES ('" + lecturerWithCourse.getLecturerId() + "', '" + lecturerWithCourse.getCourseId() + "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int idL, int idC) {
        try {
            connectionManager.executeUpdate("DELETE FROM LECTURERWITHCOURSE WHERE lecturerId = " + idL+" AND courseId = "+idC);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
