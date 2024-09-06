package fajar.java.webservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Stream;

@WebServlet(urlPatterns = "/query")
public class QueryServlet extends HttpServlet {


    /** Request Param
     * Saat membuat Web, kadang kita mengirim data melalui Query Parameter
     * Untuk mengambil data Query Parameter yang dikirim oleh user, kita bisa menggunakan HttpServletRequest
     * getParameter(name) untuk mengambil parameter berdasarkan nama
     * getParameterNames() untuk mengambil semua nama parameter yang ada
     * getParameterMap() untuk mengambil semua nama parameter beserta value nya
     * getParameterValues(name) untuk mengambil parameter yang value nya lebih dari satu
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] numbers = req.getParameterValues("number");
        int sum = Stream.of(numbers).mapToInt(Integer::parseInt).sum();//untk mentotal semua data numbers
        resp.getWriter().println("total numbers : "+sum);//kita bisa terus menambahkan /query?number=3&number=10 ...dimana number akan ditambahkan dari number1....numberN
    }
}
