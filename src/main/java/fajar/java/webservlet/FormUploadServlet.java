package fajar.java.webservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@WebServlet(urlPatterns = "/form-upload")
@MultipartConfig
public class FormUploadServlet extends HttpServlet {

    /** Upload File
     * Salah satu hal yang biasa dilakukan saat membuat Web adalah, upload file
     * Servlet juga mendukung penanganan Upload File menggunakan HttpServletRequest
     * getPart(name) digunakan untuk mendapatkan file upload berdasarkan nama
     * getParts() digunakan untuk mendapatkan semua file upload
     * File upload direpresentasikan dalam interface Part
     * https://tomcat.apache.org/tomcat-10.0-doc/servletapi/jakarta/servlet/http/Part.html
     * Saat kita membuat Servlet yang akan menerima upload file, kita harus tambahkan annotation @MultipartConfig sebagai penanda bahwa Servlet itu bisa menerima upload file
     * https://tomcat.apache.org/tomcat-10.0-doc/servletapi/jakarta/servlet/annotation/MultipartConfig.html
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Path path = Path.of(FormUploadServlet.class.getResource("html/form-upload.html").getPath());
        String html = Files.readString(path);
        resp.getWriter().println(html);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Part profile = req.getPart("profile");

        Path uploadLocation = Path.of("upload/" + UUID.randomUUID().toString()+ profile.getSubmittedFileName());
        Files.copy(profile.getInputStream(), uploadLocation);



        resp.getWriter().println("Hello "+name+ ", your profile saved in "+uploadLocation.toAbsolutePath());
    }
}
