package fajar.java.webservlet;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/** Embedded Apache Tomcat
 * Salah satu hal yang sulit ketika proses development Java Web adalah, kita harus membuat dulu War File, lalu mendeploy nya ke Apache Tomcat untuk mencobanya
 * Jika terdapat perubahan, kita harus melakukan hal yang sama, dan ini bisa memakan waktu lama, apalagi jika perubahannya hanya sepele
 * Oleh karena itu, untuk proses Development, kita bisa menggunakan fitur Embedded Tomcat yang terdapat di framework Spring Boot
 * Tidak perlu khawatir jika tidak mengerti tentang Spring Boot, karena di kelas ini kita hanya meminjam fitur Embedded Tomcat nya saja
 */

@ServletComponentScan
@SpringBootApplication
public class BelajarServletApp {
    public static void main(String[] args) {
        SpringApplication.run(BelajarServletApp.class);
    }

}
