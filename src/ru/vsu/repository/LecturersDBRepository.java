package ru.vsu.repository;

import ru.vsu.ConnectionManager;
import ru.vsu.entities.Lecturer;

import java.sql.ResultSet;
import java.sql.Time;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class LecturersDBRepository implements LecturersRepository {

    private static ConnectionManager connectionManager;
    private static LecturersDBRepository INSTANCE;

    public static LecturersDBRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LecturersDBRepository();
            connectionManager = ConnectionManager.getInstance();
        }
        return INSTANCE;
    }

    private Lecturer getLecturerFromResultSet(ResultSet rs){
        try {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String surname = rs.getString(3);

            return new Lecturer(id,name,surname);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Lecturer> getAll() {
        try{
            List<Lecturer> lecturers = new ArrayList<>();
            ResultSet rs = connectionManager.executeSelect("SELECT * FROM lecturer");
            while (rs.next()){
                lecturers.add(getLecturerFromResultSet(rs));
            }
            rs.close();
            return lecturers;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Lecturer getByID(int id) {
        try {
            ResultSet rs = connectionManager.executeSelect("SELECT * FROM lecturer WHERE id = " + id);
            rs.next();
            Lecturer lecturer= getLecturerFromResultSet(rs);
            rs.close();
            return lecturer;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void add(Lecturer lecturer) {
        try {
            if (lecturer.getID() == null) {
                connectionManager.executeUpdate("INSERT INTO lecturer (name, surname) " +
                        "VALUES ('" + lecturer.getName() + "', '" + lecturer.getSurname() + "')");
                return;
            }
            connectionManager.executeUpdate("INSERT INTO lecturer (id, name, surname) " +
                    "VALUES (" + lecturer.getID() + ", '" + lecturer.getName() + "', '" + lecturer.getSurname()+ "')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            connectionManager.executeUpdate("DELETE FROM lecturer WHERE id = " + id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(int id, Lecturer newLecturer) {
        try {
            connectionManager.executeUpdate("UPDATE lecturer SET name = '" + newLecturer.getName() + "', surname = '"
                    + newLecturer.getSurname() + "' WHERE id = " + id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
