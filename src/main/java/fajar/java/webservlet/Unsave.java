package fajar.java.webservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/unsave")
public class Unsave extends HttpServlet {

//    String response = "";//ini bahaya karna sharing variable

    /** MasalahNYA
     * ketika kita membuka web yang sama dengan name beda, anggep aja di web 1 name = Yanto dengan sleep= 3 detik, dan di web 2 name=Yatno dengan sleep=5 detik
     * ketika web berjalan berbarengan yang harusnya di web 2 kita menampilkan data Yatno malah menjadi Yanto ini karna proses di web 1 selesai terlebih dahulu, karna menggunakan sharing variable yaitu variabel name maka di web 2 juga yang harusnya menampilkan data Yatno tetapi menampilkan data Yanto
     */


    /** Singleton (1 object diakses oleh semua request)
     * Saat Java Web dijalankan, Servlet hanya akan dibuat satu kali, alias singleton
     * Oleh karena itu, HTTP Request yang masuk akan selalu menggunakan Servlet yang sama
     * Hal ini perlu diperhatikan, karena jika kode yang kita buat tidak Thread Safe, maka data antar HTTP Request bisa tertukar
     * Oleh karena itu, pastikan kode yang kita buat harus Thread Safe
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String response = "";
        String name = req.getParameter("name");
        Long sleep = Long.parseLong(req.getParameter("sleep"));

        response = "hello "+name;



        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        resp.getWriter().println(response);
    }
}
