package com.coderknock.learn.initializer;

import com.coderknock.learn.LearnSpringBootMavenApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 拿客
 * 网站：www.coderknock.com
 * QQ群：213732117
 * 三产 创建于 2016年10月28日 15:55:54。
 * 描述：用于打包war时提供web.xml的功能
 */
public class ReadingListServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(LearnSpringBootMavenApplication.class);
    }
}
