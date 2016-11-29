package com.coderknock.learn.metrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 拿客
 * 网站：www.coderknock.com
 * QQ群：213732117
 * 三产 创建于 2016年10月28日 11:22:05。
 * 描述：
 */
@Component
public class ApplicationContextMetrics implements PublicMetrics {
    private ApplicationContext context;

    @Autowired
    public ApplicationContextMetrics(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public Collection<Metric<?>> metrics() {
        List<Metric<?>> metrics = new ArrayList<>();
        //记录启动时间
        metrics.add(new Metric<Long>("coderknock.spring.context.startup-date", context.getStartupDate()));
        //记录Bean定义数量
        metrics.add(new Metric<Integer>("coderknock.spring.beans.definitions", context.getBeanDefinitionCount()));
        //记录Bean数量
        metrics.add(new Metric<Integer>("coderknock.spring.beans", context.getBeanNamesForType(Object.class).length));
        //记录控制器类型的Bean数量   Spring Boot提供的BasicErrorController会计算这个控制器
        metrics.add(new Metric<Integer>("coderknock.spring.controllers", context.getBeanNamesForAnnotation(Controller.class).length));
        return metrics;
    }
}
