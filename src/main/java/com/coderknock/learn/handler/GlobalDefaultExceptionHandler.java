package com.coderknock.learn.handler;

import com.coderknock.learn.json.ResultJson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 拿客
 * 网站：www.coderknock.com
 * QQ群：213732117
 * 三产 创建于 2016年10月26日 14:52:09。
 * 描述：全局捕获
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    private static final Log log = LogFactory.getLog(GlobalDefaultExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultJson defaultErrorHandler(Exception ex) {
        ResultJson resultJson = new ResultJson();
        resultJson.setResult(false);
        if (ex instanceof BindException) {
            BindException bindException = (BindException) ex;
            BindingResult result = bindException.getBindingResult();
            if (result != null && result.hasErrors()) {
                List<ObjectError> list = result.getAllErrors();
                list.forEach(objectError -> {
                    resultJson.addMessages(objectError.getDefaultMessage());
                });
            }
        }
        log.debug("异常:" + ex.getMessage(), ex);
        return resultJson;
    }
}
