package com.client.ws.rasmooplus.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //responsavel pela configuração de autorização -> Acesso URL's
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/plans").permitAll()
                .antMatchers(HttpMethod.GET,"/plans/*").permitAll()
                .anyRequest().authenticated();

    }

    //responsavel pela configuração de autenticação -> Login & Senha
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }
    //responsavel pela configuração de arquivos estaticos -> html,css,js,imagens
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }


}
