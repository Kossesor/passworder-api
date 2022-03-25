package com.myself.passworder.config;

import com.myself.passworder.services.UserService;
import com.myself.passworder.utils.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                httpBasic().disable()
                .cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll();
//                .authorizeRequests()
//                .antMatchers(
//                        "/",
//                        "/assets/**",
//                        "/registration",
//                        "/activation/*"
//                ).permitAll()
//                .anyRequest().authenticated()
//            .and()
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/login")
//                .defaultSuccessUrl("/home", true)
//                .permitAll()
//            .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/")
//                .permitAll()
//            .and()
//                .rememberMe();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder amb) throws Exception {
        amb.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }
}