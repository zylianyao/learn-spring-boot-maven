package com.coderknock.learn.config;

import com.coderknock.learn.repository.ReaderRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.ManagementServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 拿客
 * 网站：www.coderknock.com
 * QQ群：213732117
 * 三产 创建于 2016年10月26日 11:19:14。
 * 描述：自定义的安全配置，用于覆盖起步配置中的自动配置
 */
@Profile("production")
@Configuration
@EnableWebSecurity//实际上创建了一个WebSecurityConfiguration bean  SpringBootWebSecurityConfiguration 就失效了
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Log logger = LogFactory.getLog(SecurityConfig.class);

    @Autowired
    private ManagementServerProperties managementServerProperties;
    @Autowired
    private ReaderRepository readerRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String endpointsUrl = managementServerProperties.getContextPath() + "/**";
        http.authorizeRequests().antMatchers(endpointsUrl).access("hasRole('ADMIN')")
                .antMatchers("/").access("hasRole('READER')")//登录者角色限制
                .antMatchers("/**").permitAll().and()
                .formLogin().loginPage("/login")
                .failureUrl("/login?error=true");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //定义自定义 UserDetailsService
        auth.userDetailsService(username -> {
            UserDetails userDetails = readerRepository.findOne(username);
            if (userDetails != null) {
                return userDetails;
            }
            throw new UsernameNotFoundException("User '" + username + "' not found.");
        })
                .and()
                .inMemoryAuthentication()
                .withUser("admin").password("coderknock")
                .roles("ADMIN", "READER");
    }
}
