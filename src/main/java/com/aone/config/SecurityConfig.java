package com.aone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.aone.commons.utils.PropertyUtil;
import com.aone.config.security.handler.CustomAccessDeniedHandler;
import com.aone.config.security.handler.RestAuthenticationEntryPointHandler;
import com.aone.config.security.util.SecurityUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService customUserDetailsService;
	
	@Autowired
	private CustomAccessDeniedHandler accessDeniedHandler;
	
	@Autowired
	private RestAuthenticationEntryPointHandler authenticationEntryPointHandler;
	
	/*@Autowired
	DataSource dataSource;
	
//	@Autowireda
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(a
			"select username,password, enabled from users where username=?")
		.authoritiesByUsernameQuery(
			"select username, role from user_roles where username=?");
	}	*/

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService);
	}
	
	/*@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	        .withUser("admin").password("admin@123").roles("ADMIN")
	        .and()
	        .withUser("user").password("user@123").roles("USER");
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
	    
		//ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry =
				//SecurityUtil.setSecurityRolesPathWise(expressionInterceptUrlRegistry);
		ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry = http
	    .csrf().disable()
	    .exceptionHandling()
	    .authenticationEntryPoint(authenticationEntryPointHandler)
	    .and()
	    .authorizeRequests();
	    
		
		// add all the security paths for application custom exceptions
		SecurityUtil.setSecurityRolesPathWise(expressionInterceptUrlRegistry);
		
		// to access any request user must be authenticated
		if(PropertyUtil.checkProdEnv()) {
			expressionInterceptUrlRegistry.antMatchers("/rest/**").authenticated();
		} else {
			expressionInterceptUrlRegistry.antMatchers("/rest1/**").authenticated();
		}
		
		expressionInterceptUrlRegistry.and()		
			.formLogin().loginPage("/login")
			.defaultSuccessUrl("/index")
			.failureUrl("/login?error")
			.usernameParameter("username").passwordParameter("password")				
		.and()
			.logout().logoutSuccessUrl("/login?logout")
//	    //.successHandler(mySuccessHandler)
//	    //.failureHandler(myFailureHandler)
	  	.and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}

}