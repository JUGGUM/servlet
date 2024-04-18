package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/***
 * v1: 프론트 컨트롤러를 도입
 * 기존 구조를 최대한 유지하면서 프론트 컨트롤러를 도입
 * v2: View 분류
 * 단순 반복 되는 뷰 로직 분리
 * v3: Model 추가
 * 서블릿 종속성 제거
 * 뷰 이름 중복 제거
 * v4: 단순하고 실용적인 컨트롤러
 * v3와 거의 비슷
 * 구현 입장에서 ModelView를 직접 생성해서 반환하지 않도록 편리한 인터페이스 제공
 * v5: 유연한 컨트롤러
 * 어댑터 도입
 * 어댑터를 추가해서 프레임워크를 유연하고 확장성 있게 설계
 * 되도록 큰틀을 바꿀때는 큰틀에 집중하고 세세한 부분을 바꿀때는 세세한거에 집중하도록 따로따로 작업
 */
public class ControllerV4HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4); // 핸들러는 V4만 지원한다는뜻
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV4 controller = (ControllerV4) handler; // 강제 캐스팅
        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();

        String viewName = controller.process(paramMap, model);

        // 중요한 부분 뷰의이름을 반환했지만 어댑터는 뷰의 이름이 아닌 모델 뷰를 만들어서 반환해야 한다.
        ModelView mv = new ModelView(viewName);
        mv.setModel(model);

        return mv;
    }
    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName,
                        request.getParameter(paramName)));
        return paramMap;
    }
}
