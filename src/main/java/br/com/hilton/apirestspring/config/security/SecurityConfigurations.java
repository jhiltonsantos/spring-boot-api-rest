package br.com.hilton.apirestspring.config.security;

import br.com.hilton.apirestspring.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@Profile(value={"prod", "test"})
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthService authService;

    @Autowired
    private TokenServices tokenServices;

    @Autowired
    private IUserRepository userRepository;

    @Override @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // BCrypt para gerar o hash da senha do usuario
        auth.userDetailsService(authService).passwordEncoder(new BCryptPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/topics").permitAll()
                .antMatchers(HttpMethod.GET, "/topics/*").permitAll()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/topics/*").hasRole("MODERATOR")
                .anyRequest().authenticated()
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(new AuthTokenFilter(tokenServices, userRepository),
                        UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**",
                "/swagger-resources/**");


    }
}
