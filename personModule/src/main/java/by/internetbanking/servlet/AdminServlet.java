package by.internetbanking.servlet;

import by.internetbanking.entity.Person;
import by.internetbanking.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@WebServlet("/admin")


public class AdminServlet extends HttpServlet {

    private static   ArrayList<Person> personList = new ArrayList<>();

    public static ArrayList<Person> getPersonList() {
        return personList;
    }

    public static void setPersonList(ArrayList<Person> personList) {
        AdminServlet.personList = personList;
    }

    @Override
    public void init() throws ServletException {
        personList.add(new Person(1, "Alex", 55));
        personList.add(new Person(2, "Sveta", 56));
        personList.add(new Person(3, "Vano", 15));
        personList.add(new Person(4, "Lena", 57));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Person> people = new PersonService().readAllPersons();
        HttpSession session = req.getSession(true);
        session.setAttribute("adminList", people);
        Object message = req.getAttribute("message");
        session.setAttribute("message", message);
        resp.sendRedirect("admin.jsp");

//        req.setAttribute("adminList", personList);
//        req.setAttribute("test", "text");
//        String contxPath = req.getContextPath();
//        //req.getRequestDispatcher("/admin.jsp").forward(req, resp);
//        HttpSession session = req.getSession(false);
//        session.setAttribute("adminList", personList);
//        session.setAttribute("test", "text");
//        resp.sendRedirect("admin.jsp");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> people = new PersonService().readAllPersons();
        HttpSession session = req.getSession(true);
        session.setAttribute("adminList", people);

//        Object message = req.getAttribute("message");
//        session.setAttribute("message", message);
//        String message1 = req.getParameter("message");
//        session.setAttribute("message", message1);

        resp.sendRedirect("admin.jsp");
    }
}

