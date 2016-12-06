package com.huashan.utils;

import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class HttpUtils {
	private static final Logger LOGGER = Logger.getLogger(HttpUtils.class);
	private static final String DEFAULT_CHARSET = "UTF-8";
	private static final String METHOD_POST = "POST";

	private HttpUtils() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 通过url获取数据
	 *
	 * @param url
	 *            地址
	 * @param count
	 *            尝试次数
	 * @param connectTimeout
	 *            连接超时时间（毫秒）
	 * @param readTimeout
	 *            读取超时时间（毫秒）
	 * @return
	 */
	public static String getBody(String url, int count, int connectTimeout,
			int readTimeout) {
		String body = "";
		try {
			if (count-- <= 0)
				return "";
			body = HttpUtils.doPost(url, new HashMap<String, String>(),
					connectTimeout, readTimeout);
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.error(e);
			body = getBody(url, count, connectTimeout, readTimeout);
		}
		return body;
	}

	/**
	 *
	 * post 一个xml
	 *
	 * @throws IOException
	 * @throws MalformedURLException
	 *
	 * */
	public static String postXml(String sms_data_xml, String url)
			throws MalformedURLException, IOException {
		HttpURLConnection con = null;
		con = (HttpURLConnection) new URL(url).openConnection();
		con.setRequestMethod(HttpUtils.METHOD_POST);
		con.setDoOutput(true);
		con.setDoInput(true);
		BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(
				con.getOutputStream(), HttpUtils.DEFAULT_CHARSET));
		bWriter.write(sms_data_xml);
		bWriter.flush();
		bWriter.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				con.getInputStream(), HttpUtils.DEFAULT_CHARSET));
		StringBuffer line_rs = new StringBuffer();
		String line = "";
		for (line = br.readLine(); line != null; line = br.readLine()) {
			line_rs.append(line);
		}
		return line_rs.toString();
	}

	public static String buildQuery(Map<String, String> params, String charset)
			throws UnsupportedEncodingException {
		if ((params == null) || (params.isEmpty())) {
			return null;
		}

		StringBuilder query = new StringBuilder();
		// Set entries = params.entrySet();
		boolean hasParam = false;
		for (Map.Entry<String, String> entry : params.entrySet()) {
			String name = entry.getKey();
			String value = entry.getValue();

			if (StringUtils.areNotEmpty(name, value)) {
				if (hasParam)
					query.append("&");
				else {
					hasParam = true;
				}
				query.append(name).append("=").append(charset != null ? URLEncoder.encode(value, charset) : value);
			}

		}

		return query.toString();
	}

	public static String doPost(String url, Map<String, String> params,
			int connectTimeout, int readTimeout) throws IOException {
		return doPost(url, params, HttpUtils.DEFAULT_CHARSET, connectTimeout,
				readTimeout);
	}

	public static String doPost(String url, Map<String, String> params,
			String charset, int connectTimeout, int readTimeout)
			throws IOException {
		String ctype = "application/x-www-form-urlencoded;charset=" + charset;
		String query = buildQuery(params, charset);
		byte[] content = new byte[0];
		if (query != null) {
			content = query.getBytes(charset);
		}
		return doPost(url, ctype, content, connectTimeout, readTimeout);
	}

	public static String doPost(String url, String ctype, byte[] content,
			int connectTimeout, int readTimeout) throws IOException {
		HttpURLConnection conn = null;
		OutputStream out = null;
		String rsp = null;
		try {
			conn = getConnection(new URL(url), HttpUtils.METHOD_POST, ctype);
			conn.setConnectTimeout(connectTimeout);
			conn.setReadTimeout(readTimeout);
			out = conn.getOutputStream();
			out.write(content);
			rsp = getResponseAsString(conn);
		} catch (IOException e) {
			throw e;
		} finally {
			if (out != null) {
				out.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
		return rsp;
	}

	private static HttpURLConnection getConnection(URL url, String method,
			String ctype) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(method);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestProperty("Accept", "text/xml,text/javascript,text/html");
		conn.setRequestProperty("User-Agent", "360buy-sdk-java");
		conn.setRequestProperty("Content-Type", ctype);
		return conn;
	}

	private static String getResponseAsString(HttpURLConnection conn)
			throws IOException {
		String charset = getResponseCharset(conn.getContentType());
		InputStream es = conn.getErrorStream();
		if (es == null) {
			return getStreamAsString(conn.getInputStream(), charset);
		}
		String msg = getStreamAsString(es, charset);
		if (StringUtils.isEmpty(msg)) {
			throw new IOException(conn.getResponseCode() + ":"
					+ conn.getResponseMessage());
		}

		throw new IOException(msg);
	}

	private static String getResponseCharset(String ctype) {
		String charset = HttpUtils.DEFAULT_CHARSET;

		if (!StringUtils.isEmpty(ctype)) {
			String[] params = ctype.split(";");
			for (String param : params) {
				param = param.trim();
				if (param.startsWith("charset")) {
					String[] pair = param.split("=", 2);
					if ((pair.length != 2) || (StringUtils.isEmpty(pair[1])))
						break;
					charset = pair[1].trim();
					break;
				}
			}
		}
		return charset;
	}

	private static String getStreamAsString(InputStream stream, String charset)
			throws IOException {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					stream, charset));
			StringWriter writer = new StringWriter();
			char[] chars = new char[256];
			int count = 0;
			while ((count = reader.read(chars)) > 0) {
				writer.write(chars, 0, count);
			}

			String str = writer.toString();
			return str;
		} finally {
			if (stream != null)
				stream.close();
		}
	}

    public static final String SESSIONID = "CARTID";
    public static final String COOCAA_ID = "COOCAA_ID";

    /**
	 * 根据名字获取cookie
	 *
	 * @param request
	 * @param name
	 *            cookie名字
	 * @return
	 */
	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		if (request == null) return null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name))
					return cookie;
			}
		}
		if (SESSIONID.equals(name)) {
			Object o = request.getAttribute(SESSIONID);
			if (o != null) {
				return (Cookie)o;
			}
		} else if (COOCAA_ID.equals(name)) {
			Object o = request.getAttribute(COOCAA_ID);
			if (o != null) {
				return (Cookie)o;
			}
		}
		return null;
	}
}
