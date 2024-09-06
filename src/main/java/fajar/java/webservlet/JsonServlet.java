package fajar.java.webservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/json")
public class JsonServlet extends HttpServlet {

    //Ini adalah contoh merubah Response headernya, dimana kita membuat header json application


    /** Response Header
     * HttpServletResponse juga memiliki beberapa method yang bisa kita gunakan untuk mengubah Response Header
     * setHeader(name, value) untuk mengubah header
     * setIntHeader(name, int) untuk mengubah header dengan nilai int
     * setDateHeader(name, long) untuk mengubah header dengan nilai date (milis)
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = """
                    {
                        "name" : "fajar",
                        "value" : 100
                    }
                """;
        resp.setHeader("Content-Type","application/json");//untuk mengubah menjadi json application
        resp.getWriter().println(json);
    }
}
