package com.aone.config;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.aone.config.jsonformatting.LocalDateDeserializer;
import com.aone.config.jsonformatting.LocalDateSerializer;
import com.aone.javax.servlet.filter.logging.LoggingFilter;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * The Class WebMvcConfiguration.
 */
@Configuration
@EnableWebMvc
@EnableWebSecurity
@ComponentScan(basePackages = "com.aone")
@PropertySource(value = { "classpath:prop/config.properties" })
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}
	/**
	 * View resolver.
	 *
	 * @return the view resolver
	 */
	@Bean(name = "HelloWorld")
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	/**
	 * Multipart resolver.
	 * max size is 10 mb (in bytes 10000000 in decimal for making the calculation easy for os)
	 * @return the commons multipart resolver
	 */
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		resolver.setMaxUploadSize(10000000);
		return resolver;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#
	 * addResourceHandlers(org.springframework.web.servlet.config.annotation.
	 * ResourceHandlerRegistry)
	 */
	/*
	 * Configure ResourceHandlers to serve static resources like CSS/ Javascript
	 * etc...
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	/**
	 * Logging filter. It will log all request and response along with all the
	 * detail
	 * 
	 * @return the filter
	 */
	@Bean
	public Filter loggingFilter() {
		return new LoggingFilter();
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		SimpleModule simpleModule = new SimpleModule();
		// SERIALIZERS
		simpleModule.addSerializer(LocalDateTime.class, new LocalDateSerializer());
		
		// DESERIALIZERS
		simpleModule.addDeserializer(LocalDateTime.class, new LocalDateDeserializer());
		
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder().modules(simpleModule);
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter(builder.build());
		// mappingJackson2HttpMessageConverter.getObjectMapper().getSerializerProvider().setNullValueSerializer(new NullSerializer());
		converters.add(mappingJackson2HttpMessageConverter);
	}
}