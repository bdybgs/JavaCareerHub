package ru.vsu.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.vsu.entities.Lecturer;
import ru.vsu.service.CoursesService;
import ru.vsu.service.CoursesServicesMemory;
import ru.vsu.service.LecturersService;
import ru.vsu.service.LecturersServicesMemory;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "LecturerServlet", urlPatterns = "/lecturer")
public class LecturerServlet extends HttpServlet {

    private final LecturersService lecturersService = LecturersServicesMemory.getINSTANCE();
    private final CoursesService coursesService = CoursesServicesMemory.getINSTANCE();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            // Отобразить форму добавления
            request.getRequestDispatcher("/WEB-INF/views/lecturers/addlecturer.jsp").forward(request, response);
        } else if ("updateName".equals(action)) {
            // Отобразить форму обновления имени преподавателя
            int lecturerId = Integer.parseInt(request.getParameter("id"));
            Lecturer lecturer = lecturersService.getByID(lecturerId);
            request.setAttribute("lecturer", lecturer);
            request.getRequestDispatcher("/WEB-INF/views/lecturers/updatelecturername.jsp").forward(request, response);
        } else if ("updateSurname".equals(action)) {
            // Отобразить форму обновления фамилии преподавателя
            int lecturerId = Integer.parseInt(request.getParameter("id"));
            Lecturer lecturer = lecturersService.getByID(lecturerId);
            request.setAttribute("lecturer", lecturer);
            request.getRequestDispatcher("/WEB-INF/views/lecturers/updatelecturersurname.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            // Отобразить форму редактирования преподавателя
            int lecturerId = Integer.parseInt(request.getParameter("id"));
            Lecturer lecturer = lecturersService.getByID(lecturerId);
            request.setAttribute("lecturer", lecturer);
            request.getRequestDispatcher("/WEB-INF/views/lecturers/editlecturer.jsp").forward(request, response);
        } else {
            // Вывести всех преподавателей
            List<Lecturer> lecturers = lecturersService.getAll();
            request.setAttribute("lecturers", lecturers);
            request.getRequestDispatcher("/WEB-INF/views/lecturers/alllecturers.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            // Добавить преподавателя
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            lecturersService.add(new Lecturer(name, surname));
        } else if ("updateName".equals(action)) {
            // Обновить имя преподавателя
            int lecturerId = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            lecturersService.updateName(lecturerId, name);
        } else if ("updateSurname".equals(action)) {
            // Обновить фамилию преподавателя
            int lecturerId = Integer.parseInt(request.getParameter("id"));
            String surname = request.getParameter("surname");
            lecturersService.updateSurname(lecturerId, surname);
        } else if ("edit".equals(action)) {
            // Перенаправить на форму редактирования преподавателя
            response.sendRedirect(request.getContextPath() + "/lecturer?action=edit&id=" + request.getParameter("id"));
            return;
        } else if ("update".equals(action)) {
            // Обновить преподавателя (используем updateName и updateSurname)
            int lecturerId = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            lecturersService.updateName(lecturerId, name);
            lecturersService.updateSurname(lecturerId, surname);
        } else if ("delete".equals(action)) {
            // Выполнить удаление преподавателя
            int lecturerId = Integer.parseInt(request.getParameter("id"));
            lecturersService.delete(lecturerId);
        }

        // Перенаправить на вывод всех преподавателей
        response.sendRedirect(request.getContextPath() + "/lecturer?action=all");
    }
}

