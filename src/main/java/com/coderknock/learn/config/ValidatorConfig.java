package com.coderknock.learn.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


/**
 * 拿客
 * 网站：www.coderknock.com
 * QQ群：213732117
 * 三产 创建于 2016年10月30日 11:43:01。
 * 描述：
 */
@Configuration
public class ValidatorConfig {

    private static final Log logger = LogFactory.getLog(ValidatorConfig.class);

    @Bean
    public LocalValidatorFactoryBean getLocalValidatorFactoryBean() {
        logger.debug("ValidatorConfig 初始化");
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
        return localValidatorFactoryBean;
    }

}
