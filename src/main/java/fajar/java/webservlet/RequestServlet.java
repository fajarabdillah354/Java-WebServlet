package fajar.java.webservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/request")
public class RequestServlet extends HttpServlet {

    /** HTTP Request
     * Semua HTTP Request yang masuk ke Servlet akan disimpan dalam object ServletRequest
     * Namun saat kita menggunakan class HttpServlet, object tersebut akan dikonversi menjadi HttpServletRequest
     * Ada banyak sekali informasi yang bisa kita dapatkan, dari mulai Header, Parameter, Body, Cookie dan lain-lain
     * https://tomcat.apache.org/tomcat-10.0-doc/servletapi/jakarta/servlet/http/HttpServletRequest.html
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Method : "+req.getMethod());
        resp.getWriter().println("Query : "+req.getQueryString());
        resp.getWriter().println("Request URI : "+req.getRequestURI());
        resp.getWriter().println("Servlet Path : "+req.getServletPath());
        resp.getWriter().println("Context Path : "+req.getContextPath());
    }
}
