package by.internetbanking.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExampleServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = "<!DOCTYPE html> " +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">" + "<html>\n" +
                "<title> Title </title>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1> NNNNNNNN1 </h1>\n" +
                "<b><i> Good Day, comander рргдр ЫыЫВЫВ</i></b>\n" +
                "</body>\n" +
                "<html>";
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println(text);


    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
