package fajar.java.webservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// kita juga bisa mengubah Status Responsenya sesuai dengan yang kita mau, contohnya kita membuat status jika 404 not found

/** Response Status
 * Kita juga bisa mengubah Http Response Status menggunakan HttpServletResponse
 * Kita bisa menggunakan method setStatus(code) untuk mengubah status code dari Http Response
 */

@WebServlet(urlPatterns = "/not-found")
public class NotFound extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(404);
        resp.getWriter().println("404 NOT FOUND");
    }
}
