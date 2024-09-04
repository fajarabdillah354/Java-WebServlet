package fajar.java.webservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@WebServlet(urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {


    /** Download File
     * Sebelumnya kita selalu menggunakan Writer pada ServletResponse
     * Writer digunakan untuk mengirim response body dalam bentuk Text, bagaimana jika datanya dalam bentuk binary? Seperti gambar, video dan lain-lain
     * Kita bisa menggunakan method getOutputStream() untuk melakukan itu
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String file = req.getParameter("file");
        Path path = Path.of("upload/" +file);
        byte[] bytes = Files.readAllBytes(path);


        //kita bisa memaksa mendownload, ketika didownload file tidak ditampilkan dalam web
        String force = req.getParameter("force");
        if ("true".equals(force)){
            resp.setHeader("Content-Disposition", "attachment; filename=\""+path.getFileName()+"\"");
        }

        resp.getOutputStream().write(bytes);
    }
}
