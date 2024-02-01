package hello.servlet.web.frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class MyView {
    private String viewPath;

    // 생성자 생성
    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    // 뷰가 렌더링 되도록 동작하는 구간
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // view 객체를 통해 html화면을 렌더링
        modelToRequestAttribute(model, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

    private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        //어떤걸 하는지 모를 소스가있으면 따로 메소드 생성해서 해당 부분의 역할을 이름으로 정의하여 생성
        model.forEach((key, value) -> request.setAttribute(key, value));
    }
}
