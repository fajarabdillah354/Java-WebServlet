package fajar.java.webservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/todolist")
public class TodolistServlet extends HttpServlet {


    /** HTTP Method
     * Secara default, Servlet akan menangani semua jenis HTTP Request dengan Method apapun, seperti GET, POST, PUT, DELETE, dan lain-lain
     * Saat kita menggunakan HttpServlet, sebenarnya di dalam method service() sudah terdapat logic untuk memisahkan tiap HTTP Method
     * Jika kita hanya ingin membuat logic untuk jenis HTTP Method tertentu, kita bisa langsung override method dengan prefix do dan diakhiri dengan nama HTTP Method nya, misal doGet(), doPost(), dan lain-lain
     * https://tomcat.apache.org/tomcat-10.0-doc/servletapi/jakarta/servlet/http/HttpServlet.html
     */

    private List<String> todos = new ArrayList<>();

    //Http Method untuk GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(todos);
    }



    //Http Method untuk POST
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String todo = req.getParameter("todo");
        if (todo != null){
            todos.add(todo);
            resp.getWriter().println("add todo : "+todo);
        }else {
            resp.getWriter().println("toto parameter mush exist");
        }

    }
}
