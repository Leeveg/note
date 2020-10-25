package com.leeveg.note.aspect;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.leeveg.note.api.bean.LogBean;
import com.leeveg.note.common.base.ResultMsg;
import com.leeveg.note.common.exception.BaseException;
import com.leeveg.note.common.util.CurrentThreadHolder;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Aspect
@Order(1)
@Slf4j
public class LogAspect {

    @Resource
    private HttpServletRequest request;

    @Pointcut("execution(* com.leeveg.note..*.controller..*.*(..))")
    public void monitor() {
    }

    @Around(value = "monitor()")
    public Object monitor(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        String reqno = null;
        long startTime = System.currentTimeMillis();
        try {
            // 随机生成访问编号
            reqno = CurrentThreadHolder.getReqNo();

            //获取当前请求对象
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();

            LogBean logBean = new LogBean();
            Signature signature = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();
            if (method.isAnnotationPresent(ApiOperation.class)) {
                ApiOperation log = method.getAnnotation(ApiOperation.class);
                logBean.setDescription(log.value());
            }

            String urlStr = request.getRequestURL().toString();
            logBean.setBasePath(StrUtil.removeSuffix(urlStr, URLUtil.url(urlStr).getPath()));
            logBean.setIp(request.getRemoteUser());
            logBean.setMethod(request.getMethod());
            logBean.setParameter(getParameter(method, joinPoint.getArgs()));
            logBean.setHeader(getHeader(request));
            logBean.setStartTime(startTime);
            logBean.setUri(request.getRequestURI());
            logBean.setUrl(request.getRequestURL().toString());
            log.info("编号【{}】请求报文：{}", reqno, JSONUtil.parse(logBean).toString());

            result = joinPoint.proceed();
        } catch (BaseException e) {
            result = ResultMsg.fail(e.getCode(), e.getMsg());
        } catch (Exception e) {
            log.info("编号【{}】请求异常：{}", reqno, e.getMessage(), e);
            result = ResultMsg.error();
        } finally {
            // 避免线程复用导致数据错误
            CurrentThreadHolder.remove();
        }
        long endTime = System.currentTimeMillis();
        log.info("编号【{}】请求耗时【{}ms】返回结果：{}", reqno, (endTime - startTime), JSON.toJSONString(result));
        return result;
    }

    /**
     * 根据方法和传入的参数获取请求参数
     */
    private Object getParameter(Method method, Object[] args) {
        List<Object> argList = new ArrayList<>();
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            //将RequestBody注解修饰的参数作为请求参数
            RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
            if (requestBody != null) {
                argList.add(args[i]);
            }
            //将RequestParam注解修饰的参数作为请求参数
            RequestParam requestParam = parameters[i].getAnnotation(RequestParam.class);
            if (requestParam != null) {
                Map<String, Object> map = new HashMap<>();
                String key = parameters[i].getName();
                if (!StringUtils.isEmpty(requestParam.value())) {
                    key = requestParam.value();
                }
                map.put(key, args[i]);
                argList.add(map);
            }

            //将 ModelAttribute 注解修饰的参数作为请求参数
            ModelAttribute modelAttribute = parameters[i].getAnnotation(ModelAttribute.class);
            if (modelAttribute != null) {
                argList.add(args[i]);
            }
        }
        if (argList.size() == 0) {
            return null;
        } else if (argList.size() == 1) {
            return argList.get(0);
        } else {
            return argList;
        }
    }

    /**
     * 获取请求头信息
     *
     * @param request
     * @return
     */
    private Object getHeader(HttpServletRequest request) {
        Map<String, String> header = new HashMap<>();
        return header;
    }

}
