package by.internetbanking.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


//@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("word", "hjgkmbnglknbm8890");
        //   response.sendRedirect("/internetbanking/home.jsp");
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateAndTime = dtf.format(now);
        request.setAttribute("word", dateAndTime);
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if ("admin".equals(login) && "admin".equals(password)) {
           // response.sendRedirect("/internetbanking/admin");
          request.getRequestDispatcher("/admin").forward(request, response);
        } else if ("user".equals(login) && "user".equals(password)) {
            request.getRequestDispatcher("/user").forward(request, response);
        } else {
            response.sendRedirect("/index.html");
        }
    }

}