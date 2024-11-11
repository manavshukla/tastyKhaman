package com.aone.javax.servlet.filter.logging.wrapper;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The Class LoggingHttpServletRequestWrapper.
 * @author bharat tulsiyani
 */
public class LoggingHttpServletRequestWrapper extends HttpServletRequestWrapper {

	/** The Constant FORM_CONTENT_TYPE. */
	private static final String FORM_CONTENT_TYPE = "application/x-www-form-urlencoded";

	/** The Constant METHOD_POST. */
	private static final String METHOD_POST = "POST";

	/** The content. */
	private byte[] content;

	/** The parameter map. */
	private final Map<String, String[]> parameterMap;

	/** The delegate. */
	private final HttpServletRequest delegate;

	/**
	 * Instantiates a new logging http servlet request wrapper.
	 *
	 * @param request the request
	 */
	public LoggingHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		this.delegate = request;
		if (isFormPost()) {
			this.parameterMap = request.getParameterMap();
		} else {
			this.parameterMap = Collections.emptyMap();
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestWrapper#getInputStream()
	 */
	@Override
	public ServletInputStream getInputStream() throws IOException {
		if (ArrayUtils.isEmpty(content)) {
			return delegate.getInputStream();
		}
		return new LoggingServletInputStream(content);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestWrapper#getReader()
	 */
	@Override
	public BufferedReader getReader() throws IOException {
		if (ArrayUtils.isEmpty(content)) {
			return delegate.getReader();
		}
		return new BufferedReader(new InputStreamReader(getInputStream()));
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
	 */
	@Override
	public String getParameter(String name) {
		if (ArrayUtils.isEmpty(content) || this.parameterMap.isEmpty()) {
			return super.getParameter(name);
		}
		String[] values = this.parameterMap.get(name);
		if (values != null && values.length > 0) {
			return values[0];
		}
		return Arrays.toString(values);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestWrapper#getParameterMap()
	 */
	@Override
	public Map<String, String[]> getParameterMap() {
		if (ArrayUtils.isEmpty(content) || this.parameterMap.isEmpty()) {
			return super.getParameterMap();
		}
		return this.parameterMap;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestWrapper#getParameterNames()
	 */
	@Override
	public Enumeration<String> getParameterNames() {
		if (ArrayUtils.isEmpty(content) || this.parameterMap.isEmpty()) {
			return super.getParameterNames();
		}
		return new ParamNameEnumeration(this.parameterMap.keySet());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestWrapper#getParameterValues(java.lang.String)
	 */
	@Override
	public String[] getParameterValues(String name) {
		if (ArrayUtils.isEmpty(content) || this.parameterMap.isEmpty()) {
			return super.getParameterValues(name);
		}
		return this.parameterMap.get(name);
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		try {
			if (this.parameterMap.isEmpty()) {
				content = IOUtils.toByteArray(delegate.getInputStream());
			} else {
				content = getContentFromParameterMap(this.parameterMap);
			}
			String requestEncoding = delegate.getCharacterEncoding();
			String normalizedContent = StringUtils.normalizeSpace(new String(content, requestEncoding != null ? requestEncoding : StandardCharsets.UTF_8.name()));
			return StringUtils.isBlank(normalizedContent) ? "[EMPTY]" : normalizedContent;
		} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}

	/**
	 * Gets the content from parameter map.
	 *
	 * @param parameterMap the parameter map
	 * @return the content from parameter map
	 */
	private byte[] getContentFromParameterMap(Map<String, String[]> parameterMap) {
		return parameterMap.entrySet().stream().map(e -> {
			String[] value = e.getValue();
			return e.getKey() + "=" + (value.length == 1 ? value[0] : Arrays.toString(value));
		}).collect(Collectors.joining("&")).getBytes();
	}

	/**
	 * Gets the headers.
	 *
	 * @return the headers
	 */
	public Map<String, String> getHeaders() {
		Map<String, String> headers = new HashMap<>(0);
		Enumeration<String> headerNames = getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			if (headerName != null) {
				headers.put(headerName, getHeader(headerName));
			}
		}
		return headers;
	}

	/**
	 * Gets the parameters.
	 *
	 * @return the parameters
	 */
	public Map<String, String> getParameters() {
		return getParameterMap().entrySet().stream().collect(Collectors.toMap(Entry::getKey, e -> {
			String[] values = e.getValue();
			return values.length > 0 ? values[0] : "[EMPTY]";
		}));
	}

	/**
	 * Checks if is form post.
	 *
	 * @return true, if is form post
	 */
	public boolean isFormPost() {
		String contentType = getContentType();
		return (contentType != null && contentType.contains(FORM_CONTENT_TYPE) && METHOD_POST.equalsIgnoreCase(getMethod()));
	}

	/**
	 * The Class ParamNameEnumeration.
	 */
	private class ParamNameEnumeration implements Enumeration<String> {

		/** The iterator. */
		private final Iterator<String> iterator;

		/**
		 * Instantiates a new param name enumeration.
		 *
		 * @param values the values
		 */
		private ParamNameEnumeration(Set<String> values) {
			this.iterator = values != null ? values.iterator() : Collections.emptyIterator();
		}

		/* (non-Javadoc)
		 * @see java.util.Enumeration#hasMoreElements()
		 */
		@Override
		public boolean hasMoreElements() {
			return iterator.hasNext();
		}

		/* (non-Javadoc)
		 * @see java.util.Enumeration#nextElement()
		 */
		@Override
		public String nextElement() {
			return iterator.next();
		}
	}

	/**
	 * The Class LoggingServletInputStream.
	 */
	private class LoggingServletInputStream extends ServletInputStream {

		/** The is. */
		private final InputStream is;

		/**
		 * Instantiates a new logging servlet input stream.
		 *
		 * @param content the content
		 */
		private LoggingServletInputStream(byte[] content) {
			this.is = new ByteArrayInputStream(content);
		}

		/* (non-Javadoc)
		 * @see javax.servlet.ServletInputStream#isFinished()
		 */
		@Override
		public boolean isFinished() {
			return true;
		}

		/* (non-Javadoc)
		 * @see javax.servlet.ServletInputStream#isReady()
		 */
		@Override
		public boolean isReady() {
			return true;
		}

		/* (non-Javadoc)
		 * @see javax.servlet.ServletInputStream#setReadListener(javax.servlet.ReadListener)
		 */
		@Override
		public void setReadListener(ReadListener readListener) {
		}

		/* (non-Javadoc)
		 * @see java.io.InputStream#read()
		 */
		@Override
		public int read() throws IOException {
			return this.is.read();
		}

		/* (non-Javadoc)
		 * @see java.io.InputStream#close()
		 */
		@Override
		public void close() throws IOException {
			super.close();
			is.close();
		}
	}
}
