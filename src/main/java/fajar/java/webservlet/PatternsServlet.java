package fajar.java.webservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/patterns/*")//dia akan menerima semua servlet yang depannya /patterns.
public class PatternsServlet extends HttpServlet {

    /** URL Patterns
     * Saat membuat Servlet URL, sebenarnya kita bisa menggunakan patterns atau pola
     * Namun patterns yang didukung oleh Servlet sangatlah sederhana, hanya bisa menggunakan patterns * (star)
     Contoh Patterns
     /products/*  = /products, /products/create, /products/1234, /products/eko
     /api/*.json = /api/products.json, /api/products/hello.json, /api/category/1.json


      * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(req.getRequestURI());
    }
}


