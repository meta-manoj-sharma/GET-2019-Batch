package com.metacube.student.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	// Enable jdbc authentication
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	// Secure the end points with HTTP Basic authentication
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/welcome").permitAll()
				.antMatchers("/index").authenticated()
				.antMatchers("/addStudent").access("hasRole('ADMIN')")
				.antMatchers("/showStudent").access("hasRole('USER')")
				.antMatchers("/emailSearch")
				.access("hasRole('ADMIN')or hasRole('USER')")
				.antMatchers("/showemail")
				.access("hasRole('ADMIN')or hasRole('USER')").and().formLogin()
				.loginPage("/index").defaultSuccessUrl("/index")
				.failureUrl("/login?error=true").usernameParameter("username")
				.passwordParameter("password").and().csrf().disable();
	}
}