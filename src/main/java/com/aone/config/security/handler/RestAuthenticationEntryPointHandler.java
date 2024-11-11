package com.aone.config.security.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.aone.commons.utils.CommonsUtils;
import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.ErrorResponse;
import com.aone.corelibrary.model.impl.ResponseData;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public final class RestAuthenticationEntryPointHandler implements AuthenticationEntryPoint {

	@Override
	public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException) throws IOException {
		//response.setStatus(HttpStatus.UNAUTHORIZED.value());
		IResponseData<ErrorResponse> responseData = new ResponseData<>(ResultCodeConstant.UNAUTHORIZED, "User session is expired, kindly login again.");
		ObjectMapper objectMapper = CommonsUtils.getObjectMapperInstance();
		response.getWriter().write(objectMapper.writeValueAsString(responseData));
		response.getWriter().flush();
		response.getWriter().close();
	}
}
