package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * V3
 * 제일 중요!!!!!
 * 1. 서블릿 종속성 제거 : 컨트롤러 입장에서는 request, response 굳이 필요x
 *                      해당 파라미터는 map 으로 대신 넘길수있도록 함
 *                      그리고 request객체를 모델로 사용하는대신 별도의 모델객체를 만들어서 반환
 * 2. 뷰이름중복제거 : 뷰이름에도 중복이있기때문에 뷰의 논리이름을 반환하고 실제 물리위치의 이름은 컨트롤러에서 처리하도록 단순화 시킬것
 *
 */
@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV3.service");

        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // request에 있는 파라미토로 paramMap을 만들어서 반환
        // 안이 디테일하다면 메소드로 뽑는게 좋다.
        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);

        String viewName = mv.getViewName();
        MyView view = viewResolver(viewName); // 논리이름 반환
        view.render(mv.getModel(), request, response);

    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        // 파라미터 정보로 map으로 변환하고 그 map을 컨트롤러에 전달
        Map<String, String> paramMap = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

    private MyView viewResolver(String viewName){
        // 논리이름을 물리이름으로 바꾸는 구간
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
