package com.coderknock.learn.health;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 拿客
 * 网站：www.coderknock.com
 * QQ群：213732117
 * 三产 创建于 2016年10月28日 11:31:20。
 * 描述：监控亚马逊的健康情况没有登录的情况下不会看到详细信息有权限管理登录后可以看到详细信息
 */
@Component
public class AmazonHealth implements HealthIndicator { //也可以简单的继承AbstractHealthIndicator

    private static final Log logger = LogFactory.getLog(AmazonHealth.class);

    @Override
    public Health health() {
        try {
            RestTemplate rest = new RestTemplate();
            //向Amazon发送请求
            rest.getForObject("http://www.amazon.com", String.class);
            //报告UP状态
            return Health.up().build();
        } catch (Exception e) {
            //报告DOWN状态
            //如果有很多附加信息，可以多次调用withDetail()方法，每次设置一个要放入健康记录的附加字段
            return Health.down(e).withDetail("reason", e.getMessage()).build();
        }
    }
}
