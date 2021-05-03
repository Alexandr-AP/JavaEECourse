package by.internetbanking.servlet;

import by.internetbanking.exception.PersonWebException;
import by.internetbanking.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet("/addPerson")
public class AddPersonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addPersonPage.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String personName = req.getParameter("personName");
        String personAgeString = req.getParameter("personAge");


        try {
            new PersonService().createPerson(personName, personAgeString);
            req.getRequestDispatcher("/admin").forward(req, resp);
        } catch (PersonWebException e) {
            req.setAttribute("messageList", e.getMessage());
            req.getRequestDispatcher("addPersonPage.jsp").forward(req, resp);
        }


//
//        ArrayList<Person> people = AdminServlet.getPersonList();
//        people.add(person);
//        AdminServlet.setPersonList(people);

    }
}
