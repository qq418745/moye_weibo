package top.moyeye.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;


/**
 * hjc_cms
 * Mr.liuchengming
 * 2019-12-31 17:17
 **/
@EnableWebSecurity
@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private AuthenticationEntryPoint authenticationEntryPoint;

//    @Autowired
//    private AjaxRequestMatcher ajaxRequestMatcher;
    @Autowired
    private  UserNameDetailsService userNameDetailsService;



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers(
                "/p/**",
                "/dist/**",
                "/img/**",
                "/js/**",
                "/*.ico",
                "/plugins/**",
                "/*.html",
                "/",
                "/weiboUser/p/**",
                "/weibo/p/**",
                "/view/**",
                "/login**").permitAll()
                .anyRequest().authenticated();

        http
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login-check")
                .successForwardUrl("/")
                .failureUrl("/login.html?error=loginError").permitAll()
                .and().csrf().disable()//关闭CSRF
                .headers().contentTypeOptions().disable();//放静态资源

        http.logout().logoutSuccessUrl("/"); //注销成功后，回到首页
        http.rememberMe();
      //  http.exceptionHandling().defaultAuthenticationEntryPointFor(authenticationEntryPoint, ajaxRequestMatcher);

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(userNameDetailsService);
        auth.authenticationProvider(authProvider);
    }

    @Bean
    public Md5PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder();
    }







}
