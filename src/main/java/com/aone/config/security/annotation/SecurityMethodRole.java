package com.aone.config.security.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.aone.config.security.constant.RoleMatcher;

@Retention(RetentionPolicy.RUNTIME)
public @interface SecurityMethodRole {
	String[] roleList();
	String customRoleExpr() default "";
	RoleMatcher roleMatcher() default RoleMatcher.ANY;  
}
