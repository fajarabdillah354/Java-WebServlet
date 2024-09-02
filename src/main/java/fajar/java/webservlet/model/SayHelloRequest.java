package fajar.java.webservlet.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class SayHelloRequest {

    //Struktur data atau database

    private String firstName;

    private String lastName;

}
