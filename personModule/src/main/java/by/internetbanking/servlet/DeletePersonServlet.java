package by.internetbanking.servlet;

import by.internetbanking.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/deletePerson")
public class DeletePersonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deletePersonIDstr = req.getParameter("deletePersonID");
        int deletePersonID = Integer.parseInt(deletePersonIDstr);
        new PersonService().deletePersonById(deletePersonID);
        req.getRequestDispatcher("/admin").forward(req, resp);
    }
}
