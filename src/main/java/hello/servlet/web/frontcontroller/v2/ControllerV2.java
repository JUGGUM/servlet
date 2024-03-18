package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerV2 {
    // v1이랑 비슷하긴하지만 MyView로 반환
    // 하지만 서블릿 기술들을 다 반환하는 종속성을 가지고있었다. v3에서는 이걸 제거
    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
