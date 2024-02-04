//package com.project.RestaurentsHere.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity(debug = true)
////enable web security already has configuration annotation so no need to define again
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private DataSource dataSource;
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	// it is going to help us in creating the filter chain
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		auth.jdbcAuthentication().dataSource(dataSource)
//				// .passwordEncoder(NoOpPasswordEncoder.getInstance());
//				.passwordEncoder(passwordEncoder);
//
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		http.authorizeRequests()
//
//				.antMatchers("/doregister", "/register", "/home").permitAll().and().formLogin().loginPage("/mylogin")
//				.defaultSuccessUrl("/user/index").and().httpBasic().and().logout()
//				.permitAll().and().exceptionHandling().accessDeniedPage("/accessdenied");
//	}
//
//	@Bean
//	PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//
//}
