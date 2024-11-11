package com.aone.javax.servlet.filter.logging;

import static java.util.Arrays.asList;
import static java.util.Collections.emptySet;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toSet;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;

import com.aone.javax.servlet.filter.logging.entity.LoggingRequest;
import com.aone.javax.servlet.filter.logging.entity.LoggingResponse;
import com.aone.javax.servlet.filter.logging.wrapper.LoggingHttpServletRequestWrapper;
import com.aone.javax.servlet.filter.logging.wrapper.LoggingHttpServletResponseWrapper;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class LoggingFilter.
 * @author bharat tulsiyani
 */
public class LoggingFilter implements Filter {

	/** The Constant OBJECT_MAPPER. */
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	/** The log. */
	private Logger log = getLogger(getClass());/*Logger.getLogger(LoggingFilter.class);*///

	/** The max content size. */
	private int maxContentSize;

	/** The excluded paths. */
	private Set<String> excludedPaths = emptySet();

	/** The request prefix. */
	private String requestPrefix;

	/** The response prefix. */
	private String responsePrefix;

	static {
		OBJECT_MAPPER.setSerializationInclusion(Include.NON_EMPTY);
	}

	/**
	 * Instantiates a new logging filter.
	 */
	public LoggingFilter() {
		this(Builder.create());
	}

	/**
	 * Instantiates a new logging filter.
	 *
	 * @param builder the builder
	 */
	public LoggingFilter(Builder builder) {
		requireNonNull(builder, "builder must not be null");

		if (isNotBlank(builder.loggerName)) {
			this.log = getLogger(builder.loggerName);
		}
		this.maxContentSize = builder.maxContentSize;
		this.excludedPaths = builder.excludedPaths;
		this.requestPrefix = builder.requestPrefix;
		this.responsePrefix = builder.responsePrefix;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		String loggerName = filterConfig.getInitParameter("loggerName");
		if (isNotBlank(loggerName)) {
			this.log = getLogger(getClass());
		}

		String maxContentSize = filterConfig.getInitParameter("maxContentSize");
		if (maxContentSize != null) {
			this.maxContentSize = Integer.parseInt(maxContentSize);
		}

		String excludedPaths = filterConfig.getInitParameter("excludedPaths");
		if (isNotBlank(excludedPaths)) {
			String[] paths = excludedPaths.split("\\s*,\\s*");
			this.excludedPaths = new HashSet<>(asList(paths));
		}

		String requestPrefix = filterConfig.getInitParameter("requestPrefix");
		if (isNotBlank(requestPrefix)) {
			this.requestPrefix = requestPrefix;
		}

		String responsePrefix = filterConfig.getInitParameter("responsePrefix");
		if (isNotBlank(responsePrefix)) {
			this.responsePrefix = responsePrefix;
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
			throw new ServletException("LoggingFilter just supports HTTP requests");
		}
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		if (!log.isDebugEnabled()) {
			filterChain.doFilter(httpRequest, httpResponse);
			return;
		}
		for (String excludedPath : excludedPaths) {
			String requestURI = httpRequest.getRequestURI();
			if (requestURI.startsWith(excludedPath)) {
				filterChain.doFilter(httpRequest, httpResponse);
				return;
			}
		}

		LoggingHttpServletRequestWrapper requestWrapper = new LoggingHttpServletRequestWrapper(httpRequest);
		LoggingHttpServletResponseWrapper responseWrapper = new LoggingHttpServletResponseWrapper(httpResponse);

		log.debug(requestPrefix + getRequestDescription(requestWrapper));
		filterChain.doFilter(requestWrapper, responseWrapper);
		log.debug(responsePrefix + getResponseDescription(responseWrapper));
		httpResponse.getOutputStream().write(responseWrapper.getContentAsBytes());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
	}

	/**
	 * Gets the request description.
	 *
	 * @param requestWrapper the request wrapper
	 * @return the request description
	 */
	protected String getRequestDescription(LoggingHttpServletRequestWrapper requestWrapper) {
		LoggingRequest loggingRequest = new LoggingRequest();
		loggingRequest.setSender(requestWrapper.getLocalAddr());
		loggingRequest.setMethod(requestWrapper.getMethod());
		loggingRequest.setPath(requestWrapper.getRequestURI());
		loggingRequest.setParams(requestWrapper.isFormPost() ? null : requestWrapper.getParameters());
		loggingRequest.setHeaders(requestWrapper.getHeaders());
		String content = requestWrapper.getContent();
		if (log.isTraceEnabled()) {
			loggingRequest.setBody(content);
		} else {
			loggingRequest.setBody(content.substring(0, Math.min(content.length(), maxContentSize)));
		}

		try {
			return OBJECT_MAPPER.writeValueAsString(loggingRequest);
		} catch (JsonProcessingException e) {
			log.warn("Cannot serialize Request to JSON", e);
			return null;
		}
	}

	/**
	 * Gets the response description.
	 *
	 * @param responseWrapper the response wrapper
	 * @return the response description
	 */
	protected String getResponseDescription(LoggingHttpServletResponseWrapper responseWrapper) {
		LoggingResponse loggingResponse = new LoggingResponse();
		loggingResponse.setStatus(responseWrapper.getStatus());
		loggingResponse.setHeaders(responseWrapper.getHeaders());
		String content = responseWrapper.getContent();
		if (log.isTraceEnabled()) {
			loggingResponse.setBody(content);
		} else {
			loggingResponse.setBody(content.substring(0, Math.min(content.length(), maxContentSize)));
		}

		try {
			return OBJECT_MAPPER.writeValueAsString(loggingResponse);
		} catch (JsonProcessingException e) {
			log.warn("Cannot serialize Response to JSON", e);
			return null;
		}
	}

	/**
	 * The Class Builder.
	 */
	public static class Builder {

		/** The logger name. */
		private String loggerName = LoggingFilter.class.getName();

		/** The max content size. */
		private int maxContentSize = 1024;

		/** The excluded paths. */
		private Set<String> excludedPaths = emptySet();

		/** The request prefix. */
		private String requestPrefix = "REQUEST: ";

		/** The response prefix. */
		private String responsePrefix = "RESPONSE: ";

		/**
		 * Creates the.
		 *
		 * @return the builder
		 */
		public static Builder create() {
			return new Builder();
		}

		/**
		 * Logger name.
		 *
		 * @param loggerName the logger name
		 */
		public void loggerName(String loggerName) {
			requireNonNull(loggerName, "loggerName must not be null");
			this.loggerName = loggerName;
		}

		/**
		 * Max content size.
		 *
		 * @param maxContentSize the max content size
		 * @return the builder
		 */
		public Builder maxContentSize(int maxContentSize) {
			this.maxContentSize = maxContentSize;
			return this;
		}

		/**
		 * Excluded paths.
		 *
		 * @param excludedPaths the excluded paths
		 * @return the builder
		 */
		public Builder excludedPaths(String... excludedPaths) {
			requireNonNull(excludedPaths, "excludedPaths must not be null");
			this.excludedPaths = Stream.of(excludedPaths).collect(toSet());
			return this;
		}

		/**
		 * Request prefix.
		 *
		 * @param requestPrefix the request prefix
		 */
		public void requestPrefix(String requestPrefix) {
			requireNonNull(requestPrefix, "requestPrefix must not be null");
			this.requestPrefix = requestPrefix;
		}

		/**
		 * Response prefix.
		 *
		 * @param responsePrefix the response prefix
		 */
		public void responsePrefix(String responsePrefix) {
			requireNonNull(responsePrefix, "responsePrefix must not be null");
			this.responsePrefix = responsePrefix;
		}
	}
}