package fajar.java.webservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {


    /** Cookie
     * Cookie adalah informasi yang dibuat di Server dan disimpan di Client (Browser)
     * Cookie akan selalu dikirim ulang oleh Browser setiap melakukan request selanjutnya
     * Detail Cookie sudah dibahas di kelas HTTP
     * Untuk membuat Cookie, kita bisa menggunakan HttpServletResponse.addCookie(cookie)
     * Dan untuk membaca Cookie yang dikirim oleh Browser, kita bisa menggunakan HttpServletRequest.getCookies()
     * https://tomcat.apache.org/tomcat-10.0-doc/servletapi/jakarta/servlet/http/Cookie.html
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException

        cookie akan selalu dibawa tidak bisa dihapus kita hanya bisa memberi session(expired yang negatif) untuk berapa lama cookie ini bertahan
        lalu setelah habis limitnya akan dihapus secara otomatis(ini untuk di server),jika di web tinggal didelete saja
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cookieName = req.getParameter("name");
        String cookieValue = req.getParameter("value");


        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath("/");
        resp.addCookie(cookie);
        resp.getWriter().println("success add cookie "+cookieName + " : "+cookieValue);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getCookies() != null){
            for (Cookie cookie : req.getCookies()){
                resp.getWriter().println("Cookie "+cookie.getName() +" : "+cookie.getValue());
            }
        }
    }
}
