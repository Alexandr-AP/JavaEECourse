package by.internetbanking.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PersonListServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/page.html").forward(req,resp);


//        String contextPath = req.getContextPath();
//        resp.sendRedirect(contextPath+"/page.html");

    }

    @Override
    public void destroy() {
        super.destroy();
    }


}
