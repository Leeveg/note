package com.leeveg.note.interceptor;

import com.leeveg.note.api.dto.UserInfo;
import com.leeveg.note.api.constant.CacheKey;
import com.leeveg.note.common.util.CurrentThreadHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute(CacheKey.USER_SESSION);
        // 如果user不为空则放行
        if (null != userInfo) {
            CurrentThreadHolder.setUser(userInfo);
            return true;
        }
        // 否则拦截并跳转到登录
        response.sendRedirect("/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
