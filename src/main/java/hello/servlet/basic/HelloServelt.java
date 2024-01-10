package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServelt extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 여러가지 WAS서버들이 서블릿을 구현을 각자할건데 해당 request와 response는 인터페이스
         *  즉, 해당 구현체들을 반환하는것 */
        System.out.println("HelloServelt.service");
        System.out.println("request  = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain"); // content-type
        response.setCharacterEncoding("utf-8"); // content-type
        response.getWriter().write("hello" + username);
    }

}
