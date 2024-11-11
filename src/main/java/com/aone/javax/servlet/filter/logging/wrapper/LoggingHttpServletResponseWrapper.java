package com.aone.javax.servlet.filter.logging.wrapper;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * The Class LoggingHttpServletResponseWrapper.
 * @author bharat tulsiyani
 */
public class LoggingHttpServletResponseWrapper extends HttpServletResponseWrapper {

	/** The logging servlet outpu stream. */
	private final LoggingServletOutpuStream loggingServletOutpuStream = new LoggingServletOutpuStream();

	/** The delegate. */
	private final HttpServletResponse delegate;

	/**
	 * Instantiates a new logging http servlet response wrapper.
	 *
	 * @param response the response
	 */
	public LoggingHttpServletResponseWrapper(HttpServletResponse response) {
		super(response);
		delegate = response;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletResponseWrapper#getOutputStream()
	 */
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return loggingServletOutpuStream;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletResponseWrapper#getWriter()
	 */
	@Override
	public PrintWriter getWriter() throws IOException {
		return new PrintWriter(loggingServletOutpuStream.baos);
	}

	/**
	 * Gets the headers.
	 *
	 * @return the headers
	 */
	public Map<String, String> getHeaders() {
		Map<String, String> headers = new HashMap<>(0);
		for (String headerName : getHeaderNames()) {
			headers.put(headerName, getHeader(headerName));
		}
		return headers;
	}

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		try {
			String responseEncoding = delegate.getCharacterEncoding();
			return loggingServletOutpuStream.baos.toString(responseEncoding != null ? responseEncoding : UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			return "[UNSUPPORTED ENCODING]";
		}
	}

	/**
	 * Gets the content as bytes.
	 *
	 * @return the content as bytes
	 */
	public byte[] getContentAsBytes() {
		return loggingServletOutpuStream.baos.toByteArray();
	}

	/**
	 * The Class LoggingServletOutpuStream.
	 */
	private class LoggingServletOutpuStream extends ServletOutputStream {

		/** The baos. */
		private ByteArrayOutputStream baos = new ByteArrayOutputStream();

		/* (non-Javadoc)
		 * @see javax.servlet.ServletOutputStream#isReady()
		 */
		@Override
		public boolean isReady() {
			return true;
		}

		/* (non-Javadoc)
		 * @see javax.servlet.ServletOutputStream#setWriteListener(javax.servlet.WriteListener)
		 */
		@Override
		public void setWriteListener(WriteListener writeListener) {
		}

		/* (non-Javadoc)
		 * @see java.io.OutputStream#write(int)
		 */
		@Override
		public void write(int b) throws IOException {
			baos.write(b);
		}

		/* (non-Javadoc)
		 * @see java.io.OutputStream#write(byte[])
		 */
		@Override
		public void write(byte[] b) throws IOException {
			baos.write(b);
		}

		/* (non-Javadoc)
		 * @see java.io.OutputStream#write(byte[], int, int)
		 */
		@Override
		public void write(byte[] b, int off, int len) throws IOException {
			baos.write(b, off, len);
		}
	}
}
