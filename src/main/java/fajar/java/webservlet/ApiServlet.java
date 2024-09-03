package fajar.java.webservlet;

import fajar.java.webservlet.model.SayHelloRequest;
import fajar.java.webservlet.util.JsonUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;


@WebServlet({"/api/say-hello"})
public class ApiServlet extends HttpServlet {

    //contoh restfull Api dimana req body json, dan response body juga json


    /** Request Body
     * Saat membuat Web, kadang kita tidak hanya membuat jenis Website biasa
     * Kadang kita membuat RESTful API yang akhirnya mengharuskan kita membaca data request dari user dalam bentuk format selain Form Post, misal JSON atau XML
     * Untuk membaca isi dari Request Body, kita bisa menggunakan method di HttpServletRequest
     * getInputStream() untuk mendapatkan Body dalam bentuk Input Stream
     * getBufferedReader() untuk mendapatka Body dalam bentuk Buffered Reader
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SayHelloRequest sayHelloRequest = JsonUtil.getObjectMapper().readValue(req.getInputStream(), SayHelloRequest.class);
        String sayHello = "Hello "+sayHelloRequest.getFirstName() +" "+sayHelloRequest.getLastName();


        Map<String , String> response = Map.of(
                "data", sayHello
        );


        String jsonResponse = JsonUtil.getObjectMapper().writeValueAsString(response);
        resp.setHeader("Content-Type", "Application/json");
        resp.getWriter().println(jsonResponse);
    }
}
