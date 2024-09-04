package fajar.java.webservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/body")
public class BodyServlet extends HttpServlet {


    /** HTTP Response
     * Pada method service() di Servlet terdapat parameter kedua yaitu ServletResponse
     * Atau di HttpServlet menggunakan class HttpServletResponse
     * Ini adalah representasi dari HTTP Response
     * Untuk mengirim response, kita bisa gunakan object HttpServletResponse tersebut

    **  Response Body
     * Untuk mengirim response body pada HttpServletResponse, kita bisa menggunakan PrintWriter pada method getWriter()
     * Method ini digunakan untuk menulis data apapun ke Response Body pada HTTP Response
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //ini adalah contoh mengembalikan response Body dengan format html
        String html = """
                    <html>
                    <body>
                    <h1>Fajar Abdillah Ahmad</h1>
                    </body>
                    </html>
                """;

        resp.getWriter().println(html);
    }
}
