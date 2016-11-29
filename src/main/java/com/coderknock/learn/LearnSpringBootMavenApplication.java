package com.coderknock.learn;

import com.coderknock.learn.resolver.ReaderHandlerMethodArgumentResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * 应用程序的启动引导类（bootstrap class），也是主要的Spring配置类
 */
@SpringBootApplication //开启组件扫描和自动配置
public class LearnSpringBootMavenApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootMavenApplication.class, args); //负责启动引导应用程序
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}

	@Override
	public void addArgumentResolvers(
			List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new ReaderHandlerMethodArgumentResolver());
	}
}
