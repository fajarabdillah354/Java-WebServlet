package fajar.java.webservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(urlPatterns = "/redirect")
public class RedirectServlet extends HttpServlet{


    /** Redirect
     * Untuk melakukan redirect, sebenarnya kita sudah bahas di kelas HTTP, kita cukup menggunakan status code 3xx dan menambahkan header Location yang menuju lokasi baru
     * Namun di Servlet, terdapat method yang bisa digunakan untuk mempermudah yaitu HttpServletResponse.sendRedirect(page)
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/hello");//ketika redirect terjadi akan otomatis ke halaman /hello
    }
}
