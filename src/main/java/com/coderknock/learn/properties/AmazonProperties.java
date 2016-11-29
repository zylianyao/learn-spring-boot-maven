package com.coderknock.learn.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 拿客
 * 网站：www.coderknock.com
 * QQ群：213732117
 * 三产 创建于 2016年10月26日 15:00:25。
 * 描述：加载Amazon相关的配置属性
 */
@Component
//属性注入
@ConfigurationProperties("amazon")
public class AmazonProperties {
    private String associateId;

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }

    public String getAssociateId() {
        return associateId;
    }
}
