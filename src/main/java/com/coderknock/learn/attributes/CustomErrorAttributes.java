package com.coderknock.learn.attributes;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;


/**
 * 拿客
 * 网站：www.coderknock.com
 * QQ群：213732117
 * 三产 创建于 2016年10月26日 15:10:37。
 * 描述：捕获异常信息
 */
@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    private static final Log logger = LogFactory.getLog(CustomErrorAttributes.class);

    @Override
    public Map<String, Object> getErrorAttributes(
            RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> attributes = super.getErrorAttributes(requestAttributes, includeStackTrace);

        attributes.put("foo", "bar");
        logger.error(requestAttributes);
        return attributes;
    }

}
