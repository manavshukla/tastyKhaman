package com.aone.config.security.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SecurityClassRole {
	String baseRoleName();
}
