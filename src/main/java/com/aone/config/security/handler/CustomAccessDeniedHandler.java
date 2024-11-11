package com.aone.config.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.aone.commons.utils.CommonsUtils;
import com.aone.corelibrary.constant.ResultCodeConstant;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.ErrorResponse;
import com.aone.corelibrary.model.impl.ResponseData;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex) throws IOException, ServletException {
		//response.setStatus(HttpStatus.FORBIDDEN.value());
		IResponseData<ErrorResponse> responseData = new ResponseData<ErrorResponse>(ResultCodeConstant.FORBIDDEN, "User does not have required privilege to perform the operation.");
		ObjectMapper objectMapper = CommonsUtils.getObjectMapperInstance();
		response.getWriter().write(objectMapper.writeValueAsString(responseData));
		response.getWriter().flush();
		response.getWriter().close();
	}
	
}
