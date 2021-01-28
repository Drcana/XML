package rs.ac.uns.ftn.portal_poverenika.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import rs.ac.uns.ftn.portal_poverenika.security.JwtAuthorizationFilter;
import rs.ac.uns.ftn.portal_poverenika.security.JwtUtil;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests().anyRequest().authenticated()
                .and()
                .addFilterAfter(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        http.csrf().disable();
        http.cors();
    }

    @Override
    public void configure(WebSecurity web) {
//        web.ignoring().antMatchers("/**/**/**");
//        web.ignoring().antMatchers("/**/**");
        web.ignoring().antMatchers("/api/auth/login");
        web.ignoring().antMatchers("/api/auth/register");
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }
}
