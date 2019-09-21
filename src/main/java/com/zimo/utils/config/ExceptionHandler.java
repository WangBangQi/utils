package com.zimo.utils.config;

import cn.zimo.wbq.exceptions.ErrCodeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取到 Controller 层抛出的异常
 */
@ControllerAdvice
public class ExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handler(Exception e, HttpServletRequest request, HandlerMethod handler){
        if (e instanceof ErrCodeException){
            ErrCodeException bizEx = (ErrCodeException)e;
            log.error("==>resolverException.BaseException");
            log.error("==>errCode:" + bizEx.getErrcode() + " ,errMsg:" + bizEx.getMessage());
            log.error("==>Error class: " + handler.getBean().getClass().getName());
            log.error("==>Error method: " + handler.getMethod().getName());
            this.printArgs(request);
            log.error("==>异常堆栈详情:", e);
            return new Result(Integer.valueOf(bizEx.getErrcode()),bizEx.getMessage());
        } else {
            log.error("==>resolverException.Exception");
            log.error("==>Error class: " + handler.getBean().getClass().getName());
            log.error("==>Error method: " + handler.getMethod().getName());
            this.printArgs(request);
            log.error("==>异常堆栈详情:", e);
            return new Result(9999,e.getMessage());
        }
    }

    private void printArgs(HttpServletRequest request){
        for (Object key : request.getParameterMap().keySet()) {
            String[] value = (String[]) request.getParameterMap().get(key);
            String paramValue = "";
            for (String str : value) {
                paramValue += str + ";";
            }
            log.error("==>args[" + key + "]: " + paramValue);
        }
    }
}
