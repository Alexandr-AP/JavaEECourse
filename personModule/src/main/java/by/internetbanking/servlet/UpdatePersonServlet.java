package by.internetbanking.servlet;

import by.internetbanking.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/updatePerson")
public class UpdatePersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String updatePersonID = req.getParameter("updatePersonID");
        String updatePersonName = req.getParameter("updatePersonName");
        String updatePersonAge = req.getParameter("updatePersonAge");
        req.setAttribute("updatePersonID", updatePersonID);
        req.setAttribute("updatePersonName", updatePersonName);
        req.setAttribute("updatePersonAge", updatePersonAge);

        req.getRequestDispatcher("/updatePersonPage.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String personIDstr = req.getParameter("personID");
        int personID = Integer.parseInt(personIDstr);
        String personName = req.getParameter("personName");
        String personAgeStr = req.getParameter("personAge");
        int personAge = Integer.parseInt(personAgeStr);

        new PersonService().updatePersonById(personID,personName,personAge);

        // AdminServlet.setPersonList(people);
        req.getRequestDispatcher("/admin").forward(req, resp);
    }
}
