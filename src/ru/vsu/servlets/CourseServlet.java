package ru.vsu.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.vsu.entities.Course;
import ru.vsu.service.CoursesService;
import ru.vsu.service.CoursesServicesMemory;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CourseServlet", urlPatterns = "/course")
public class CourseServlet extends HttpServlet {

    private final CoursesService coursesService = CoursesServicesMemory.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            // Отобразить форму добавления
            request.getRequestDispatcher("/WEB-INF/views/courses/addcourse.jsp").forward(request, response);
        } else if ("updateName".equals(action)) {
            // Отобразить форму обновления имени курса
            int courseId = Integer.parseInt(request.getParameter("id"));
            Course course = coursesService.getByID(courseId);
            request.setAttribute("course", course);
            request.getRequestDispatcher("/WEB-INF/views/courses/updatename.jsp").forward(request, response);
        } else if ("updateHours".equals(action)) {
            // Отобразить форму обновления количества часов курса
            int courseId = Integer.parseInt(request.getParameter("id"));
            Course course = coursesService.getByID(courseId);
            request.setAttribute("course", course);
            request.getRequestDispatcher("/WEB-INF/views/courses/updatehours.jsp").forward(request, response);
        } else {
            // Вывести все курсы
            List<Course> courses = coursesService.getAll();
            request.setAttribute("courses", courses);
            request.getRequestDispatcher("/WEB-INF/views/courses/allcourses.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            // Добавить курс
            String name = request.getParameter("name");
            int hours = Integer.parseInt(request.getParameter("hours"));
            coursesService.add(new Course(name, hours));
        } else if ("updateName".equals(action)) {
            // Обновить имя курса
            int courseId = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            coursesService.updateName(courseId, name);
        } else if ("updateHours".equals(action)) {
            // Обновить количество часов курса
            int courseId = Integer.parseInt(request.getParameter("id"));
            int hours = Integer.parseInt(request.getParameter("hours"));
            coursesService.updateHours(courseId, hours);
        } else if ("delete".equals(action)) {
            // Выполнить удаление курса
            int courseId = Integer.parseInt(request.getParameter("id"));
            coursesService.delete(courseId);
        }

        // Перенаправить на вывод всех курсов
        response.sendRedirect(request.getContextPath() + "/course");
    }


}
