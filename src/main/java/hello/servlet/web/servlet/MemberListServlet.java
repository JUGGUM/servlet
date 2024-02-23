package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * findAll로 전체회원을 조회후
 * for 루프를 돌려 회원수만큼 동적으로 생성하고 응답
 *
 * 정적인 HTML이라면 화면이 달라지는 회원의 저장 결과보여주는 일 불가능
 * 하지만 동적인 HTML이라서 가능, 하지만 자바코드로 만드는게 불편
 * 그러므로 HTML 파일을 따로 만들어 동적으로 변경해야 하는 부분만 자바코드를 만들수있도록 나온것이 템플릿엔진
 * 템플릿엔진을 사용하면 HTML문서에 필요한 것만 코드를 적용해서 동적으로 사용가능
 * EX) JSP, 타임리프, Freemarker, velocity
 */
@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        List<Member> members = memberRepository.findAll();
        PrintWriter w = response.getWriter();
        w.write("<html>");
        w.write("<head>");
        w.write(" <meta charset=\"UTF-8\">");
        w.write(" <title>Title</title>");
        w.write("</head>");
        w.write("<body>");
        w.write("<a href=\"/index.html\">메인</a>");
        w.write("<table>");
        w.write(" <thead>");
        w.write(" <th>id</th>");
        w.write(" <th>username</th>");
        w.write(" <th>age</th>");
        w.write(" </thead>");
        w.write(" <tbody>");
        /*
         w.write(" <tr>");
         w.write(" <td>1</td>");
         w.write(" <td>userA</td>");
         w.write(" <td>10</td>");
         w.write(" </tr>");
        */
        for (Member member : members) {
            w.write(" <tr>");
            w.write(" <td>" + member.getId() + "</td>");
            w.write(" <td>" + member.getUsername() + "</td>");
            w.write(" <td>" + member.getAge() + "</td>");
            w.write(" </tr>");
        }
        w.write(" </tbody>");
        w.write("</table>");
        w.write("</body>");
        w.write("</html>");
    }
}
