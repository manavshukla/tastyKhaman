package com.aone.module.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aone.commons.utils.CacheRequestUtils;
import com.aone.config.security.IAuthenticationFacade;
import com.aone.corelibrary.model.IResponseData;
import com.aone.corelibrary.model.impl.RequestData;
import com.aone.module.contact.model.Contact;
import com.aone.module.login.service.ILoginService;

@Controller
@RequestMapping
public class LoginController {
	
	@Autowired
    private IAuthenticationFacade authenticationFacade;
	
	private ILoginService loginService;
	
	public ILoginService getLoginService() {
		return loginService;
	}

	@Autowired
	@Qualifier(value="loginServiceImpl")
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	private boolean isUserLogin() {
		Authentication authentication = authenticationFacade.getAuthentication();
		return authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken);
	}

	@RequestMapping(value = "/login", method = {RequestMethod.POST,RequestMethod.GET} )
	public String login(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = { "/", "home", "/home.html", "index", "/index.html"}, method = RequestMethod.GET)
	public String home(ModelMap model) {
		if(!isUserLogin()) {
			return "login";
		}
		return "index";
	}
	
	//@Override
	@RequestMapping(value = "/rest/login/getCurrentLoginUserDetails", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE })
	public @ResponseBody ResponseEntity<IResponseData<Contact>> getCurrentLoginUserDetails(@RequestBody RequestData<Contact, Long> requestData) {
		CacheRequestUtils.chacheRequestData(Thread.currentThread().getName(), requestData);
		return loginService.getCurrentLoginUserDetails(requestData);
	}
}
