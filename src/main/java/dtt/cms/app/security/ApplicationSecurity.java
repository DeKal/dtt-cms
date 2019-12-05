package dtt.cms.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter{
	public static final String ADMIN = "ROLE_ADMIN";
	public static final String USER = "ROLE_USER";
	public static final String ANONYMOUS = "ROLE_ANONYMOUS";
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
          	.antMatchers("/login", "/resources/login/**").permitAll()	
            .anyRequest().authenticated()
            .and()
			.formLogin().loginPage("/login").defaultSuccessUrl("/", true);
    }
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user").password("{noop}123456").roles("USER")
			.and()
			.withUser("admin").password("{noop}123456").roles("ADMIN");
	}
}
