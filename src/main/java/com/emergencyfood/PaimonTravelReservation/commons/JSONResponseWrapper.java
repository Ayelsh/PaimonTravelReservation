package com.emergencyfood.PaimonTravelReservation.commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.Resource;

@ControllerAdvice
public class JSONResponseWrapper implements ResponseBodyAdvice {

    //监听ResponseBody的修改，发生修改就判断注解存在与否

    @Resource
    ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }


    @Override
    public Object beforeBodyWrite(Object returnValue, MethodParameter returnType, org.springframework.http.MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        // 先从方法上取注解
        RestWrapper restWrapper = returnType.getMethodAnnotation(RestWrapper.class);
        if (restWrapper == null) {
            // 再从类上取
            restWrapper = returnType.getDeclaringClass().getAnnotation(RestWrapper.class);
        }

        // 如果没有定义该注解或禁用了，则直接返回
        if (restWrapper == null || restWrapper.disabled()) {
            return returnValue;
        }

        // 对结果进行包装
        RestResult<Object> result = RestResult.success(returnValue);

        // 如果结果集是 String 类型，要提前进行序列化操作，否则会包装失败
        if (returnType.getParameterType() == String.class) {
            try {
                return objectMapper.writeValueAsString(result);
            } catch (Exception e) {

                throw new RuntimeException(e);
            }
        }

        // 返回包装后的结果集
        return result;
    }

}
