package top.moyeye.security;

import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * info: json请求拦截
 * Mr.liuchengming
 * 2020-12-21 14:59
 **/
@Component
public class AjaxRequestMatcher implements RequestMatcher {

    @Override
    public boolean matches(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With")) ||
                request.getHeader("Accept") != null &&
                        request.getHeader("Accept").contains("application/json");
    }

}
