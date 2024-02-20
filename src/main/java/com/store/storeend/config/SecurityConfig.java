package com.store.storeend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

/**
 * @className: SecurityConfig
 * @description:
 * @author: 15506
 * @date: 2024/2/14 18:42
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // 测试接口放行
    public static final List<String> TEST_WHITE_LIST = List.of("/test/**");
    // 验证码放行
    public static final List<String> VERIFY_CODE_WHITE_LIST = List.of("/verify_code/**");
    // 自定义放行
    public static final List<String> CUSTOM_WHITE_LIST = List.of("/user/register","/user/user-name_plagiarism_check","/user/phone_plagiarism_check","/user/email_plagiarism_check");
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // 放行接口
        return (web) -> web
                .ignoring()
                .requestMatchers(TEST_WHITE_LIST.toArray(new String[0]))
                .requestMatchers(VERIFY_CODE_WHITE_LIST.toArray(new String[0]))
                .requestMatchers(CUSTOM_WHITE_LIST.toArray(new String[0]));
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        //省略HttpSecurity的配置
        return httpSecurity.build();
    }
}
