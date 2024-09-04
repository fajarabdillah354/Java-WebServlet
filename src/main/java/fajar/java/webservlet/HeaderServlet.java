package fajar.java.webservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/header")
public class HeaderServlet extends HttpServlet {

    /** Request Header
     * Request Header yang dikirim oleh user juga bisa kita ambil dari object HttpServletRequest
     * getHeader(name) untuk mendapat value header berdasarkan nama
     * getHeaderValues(name) untuk mendapat value header yang lebih dari satu
     * getHeaderNames() untuk mendapat semua nama header
     * getDateHeader(name) untuk mendapat value header yang bernilai date (milis)
     * getIntHeader(name) untuk mendapat value header yang bernilai int
     * Perlu diingat, bahwa header name itu tidak case sensitive, jadi Content-Type dan content-type adalah nama yang sama
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> names = req.getHeaderNames();

        String name;
        while ((name = names.nextElement()) != null){
            String value = req.getHeader(name);
            resp.getWriter().println("Header "+name+" with value : "+value);
        }
    }
}
