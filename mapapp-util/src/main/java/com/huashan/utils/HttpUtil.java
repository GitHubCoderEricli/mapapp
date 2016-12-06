package com.huashan.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import java.util.Map.Entry;

/**
 * http请求
 * 
 * @author : tanxianlin Date: 2014/4/10 Time: 20:45
 */
public class HttpUtil {
	private static final Logger LOGGER = Logger.getLogger(HttpUtil.class);
	private final static String CHARSET = "utf-8";

	/**
	 * httpGet
	 * 
	 * @param uri
	 *            请求的资源(包含参数)
	 * @param tr
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	public static <T> T get(String uri, TypeReference<T>... tr)
			throws Exception {
		return httpMethod(uri, null, "GET", tr);
	}

	/**
	 * httpGet
	 * 
	 * @param url
	 *            地址
	 * @param params
	 *            参数
	 * @param tr
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	public static <T> T get(String url, Map<String, String> params,
			TypeReference<T>... tr) throws Exception {
		return getOrPut(url, params, "GET", tr);
	}

	/**
	 * httpPost
	 * 
	 * @param url
	 *            地址
	 * @param params
	 *            参数
	 * @param tr
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	public static <T> T post(String url, Map<String, String> params,
			TypeReference<T>... tr) throws Exception {
		return httpMethod(url, getQueryString(params), "POST", tr);
	}

	/**
	 * httpPost
	 * 
	 * @param url
	 *            地址
	 * @param params
	 *            参数
	 * @param tr
	 * @param <T>
	 * @return 返回string类型的数据
	 * @throws Exception
	 */
	public static <T> String postString(String url, Map<String, String> params,
			TypeReference<T>... tr) throws Exception {
		return httpMethodString(url, getQueryString(params), "POST", tr);
	}

	/**
	 * httpPut
	 * 
	 * @param uri
	 *            请求的资源(包含参数)
	 * @param tr
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	public static <T> T put(String uri, TypeReference<T>... tr)
			throws Exception {
		return httpMethod(uri, null, "PUT", tr);
	}

	/**
	 * 
	 * @param url
	 *            地址
	 * @param params
	 *            参数
	 * @param tr
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	public static <T> T put(String url, Map<String, String> params,
			TypeReference<T>... tr) throws Exception {
		return getOrPut(url, params, "PUT", tr);
	}

	public static <T> T getOrPut(String url, Map<String, String> params,
			String method, TypeReference<T>... tr) throws Exception {
		return httpMethod(url + "?" + getQueryString(params), null, method, tr);
	}

	@SuppressWarnings("unchecked")
	public static <T> T httpMethod(String uri, String q, String method,
			TypeReference<T>... tr) throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			HttpURLConnection con = (HttpURLConnection) (new URL(uri))
					.openConnection();
			con.setRequestMethod(method);
			con.setRequestProperty("Accept-Charset", CHARSET);

			if ("POST".equals(method) && q != null) {
				con.setDoOutput(true);
				con.setRequestProperty("Content-Type",
						"application/x-www-form-urlencoded");
				out = new PrintWriter(con.getOutputStream());
				out.write(q);
				out.flush();
			}
			InputStream inputStream;
			if (con.getResponseCode() >= 400) {
				inputStream = con.getErrorStream();
			} else {
				inputStream = con.getInputStream();
			}
			in = new BufferedReader(new InputStreamReader(inputStream, CHARSET));
			String result = "", line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			int status = con.getResponseCode();
			if (!result.equals("")) {
				if (status == 200) {
					if (tr != null && tr.length == 1) {
						JSONObject jsonObject = JSONObject
								.fromObject(result);
						jsonObject.remove("avatars");
						Map<String, Object> map = (Map<String, Object>) JSONObject
								.toBean(jsonObject, Map.class);

						Map<String, String> tmap = new HashMap<String, String>();

						for (Entry<String, Object> obj : map.entrySet()) {
							tmap.put(obj.getKey() + "", obj.getValue() + "");
						}
						return (T) tmap;
						// return JsonUtil.toObject(result, tr[0]);
					}
				} else {
					// Map<String,String> error = (Map<String, String>)
					// JSONObject.toBean(JSONObject.fromObject(result),
					// Map.class);
					return (T) JSONObject.toBean(JSONObject.fromObject(result),
							Map.class);
					// throw new RuntimeException(result);
					// throw JsonUtil.toObject(result, new
					// TypeReference<CoocaaZHException>() {
					// });
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	public static <T> String httpMethodString(String uri, String q,
			String method, TypeReference<T>... tr) throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			HttpURLConnection con = (HttpURLConnection) (new URL(uri))
					.openConnection();
			con.setRequestMethod(method);
			con.setRequestProperty("Accept-Charset", CHARSET);

			if ("POST".equals(method) && q != null) {
				con.setDoOutput(true);
				con.setRequestProperty("Content-Type",
						"application/x-www-form-urlencoded");
				out = new PrintWriter(con.getOutputStream());
				out.write(q);
				out.flush();
			}
			InputStream inputStream;
			if (con.getResponseCode() >= 400) {
				inputStream = con.getErrorStream();
			} else {
				inputStream = con.getInputStream();
			}
			in = new BufferedReader(new InputStreamReader(inputStream, CHARSET));
			String result = "", line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	private static String getQueryString(Map<String, String> params) {
		if (params == null)
			return null;

		String q = "";
		int i = 0;
		for (Entry<String, String> param : params.entrySet()) {
			try {
				q += param.getKey() + "="
						+ URLEncoder.encode((String) param.getValue(), CHARSET);
			} catch (UnsupportedEncodingException e) {
			}
			i++;
			if (i != params.size())
				q += "&";
		}
		return q;
	}

	public static Map<String, List<String>> parseParameter(String parameter) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		String[] parameters = parameter.split("&");
		for (String param : parameters) {
			String[] keyAndValue = param.split("=");
			String key = keyAndValue[0];
			String value = keyAndValue.length == 2 ? keyAndValue[1] : "";
			List<String> list = map.get(key);
			if (list == null) list = new ArrayList<String>(parameters.length);
			list.add(value);
			map.put(key, list);
		}
		return map;
	}
	
	public static void main(String[] args) {
		String a = "vid=26764419&ip=183.62.168.218&cou=中国&pvc=广东省&ct=深圳市&tms=75&etm=1436836941089&ref=&key=&ser=&pt=web&feu=http%3A%2F%2F127.0.0.1%3A8080%2Findex%2Findex.htm&m=0&pn=&opid=56036&opname=admin&cu=http%3A%2F%2F127.0.0.1%3A8080%2Findex%2Findex.htm&stm=1436836993864";
		Map<String, List<String>> map = parseParameter(a);
		System.out.println(map);
	}

	//获取request ip
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Real-IP");
		LOGGER.info("X-Real-IP:" + ip);
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			String forwardedIps = request.getHeader("x-forwarded-for");
			if (StringUtils.areNotEmpty(forwardedIps)) {
				ip = forwardedIps.split(",")[0];
			}
			LOGGER.info("x-forwarded-for:" + ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
			LOGGER.info("Proxy-Client-IP:" + ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
			LOGGER.info("WL-Proxy-Client-IP:" + ip);
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			LOGGER.info("request.getRemoteAddr():" + ip);
		}
		return ip;
	}

	//得到用户的浏览器信息
	public static String getRequestBrowserInfo(String header){
		String browserVersion = "";
		if(header.indexOf("MSIE")>0){
			browserVersion = "IE";
		}else if(header.indexOf("rv")>0){
			browserVersion = "IE";
		}else if(header.indexOf("Firefox")>0){
			browserVersion = "Firefox";
		}else if(header.indexOf("Chrome")>0){
			browserVersion = "Chrome";
		}else if(header.indexOf("Safari")>0){
			browserVersion = "Safari";
		}else if(header.indexOf("Camino")>0){
			browserVersion = "Camino";
		}else if(header.indexOf("Konqueror")>0){
			browserVersion = "Konqueror";
		}else if(header.indexOf("UCWEB")>0){
			browserVersion = "UCWEB";
		}else if(header.indexOf("UCBrowser")>0){
			browserVersion = "UCBrowser";
		}else if(header.indexOf("ucweb")>0){
			browserVersion = "ucweb";
		}else if(header.indexOf("MQQBrowser")>0){
			browserVersion = "MQQBrowser";
		}else if(header.indexOf("SogouMobileBrowser")>0){
			browserVersion = "SogouMobileBrowser";
		}else if(header.indexOf("baidubrowser")>0){
			browserVersion = "baidubrowser";
		}
		return browserVersion;
	}

	//得到用户的操作系统信息
	public static String getRequestSystemInfo(String header){
		String systenInfo = "";
		if (header.indexOf("Android") > 0){
			systenInfo = "Android";
		}else if (header.indexOf("iPhone") > 0){
			systenInfo = "iPhone";
		}else if (header.indexOf("iPod") > 0){
			systenInfo = "iPod";
		}else if (header.indexOf("iPad") > 0){
			systenInfo = "iPad";
		}else if (header.indexOf("Windows Phone") > 0){
			systenInfo = "Windows Phone";
		}else if (header.indexOf("SymbianOS") > 0){
			systenInfo = "SymbianOS";
		}else if (header.indexOf("BlackBerry") > 0){
			systenInfo = "BlackBerry";
		}else if (header.indexOf("Windows CE") > 0){
			systenInfo = "Windows CE";
		}else if (header.indexOf("NT 6.0") > 0){
			systenInfo = "Windows Vista/Server 2008";
		} else if (header.indexOf("NT 5.2") > 0){
			systenInfo = "Windows Server 2003";
		} else if (header.indexOf("NT 5.1") > 0){
			systenInfo = "Windows XP";
		} else if (header.indexOf("NT 6.0") > 0){
			systenInfo = "Windows Vista";
		} else if (header.indexOf("NT 6.1") > 0){
			systenInfo = "Windows 7";
		} else if (header.indexOf("NT 6.2") > 0){
			systenInfo = "Windows Slate";
		} else if (header.indexOf("NT 6.3") > 0){
			systenInfo = "Windows 9";
		} else if (header.indexOf("NT 10.0") > 0){
			systenInfo = "Windows 10";
		} else if (header.indexOf("NT 5") > 0){
			systenInfo = "Windows 2000";
		} else if (header.indexOf("NT 4") > 0){
			systenInfo = "Windows NT4";
		} else if (header.indexOf("Me") > 0){
			systenInfo = "Windows Me";
		} else if (header.indexOf("98") > 0){
			systenInfo = "Windows 98";
		} else if (header.indexOf("95") > 0){
			systenInfo = "Windows 95";
		} else if (header.indexOf("Mac") > 0){
			systenInfo = "Mac";
		} else if (header.indexOf("Unix") > 0){
			systenInfo = "UNIX";
		} else if (header.indexOf("Linux") > 0){
			systenInfo = "Linux";
		} else if (header.indexOf("SunOS") > 0){
			systenInfo = "SunOS";
		}
		return systenInfo;
	}

	//获取request body
	public static String getRequestBody(HttpServletRequest httpRequest) {
		System.out.println(" \n\n Headers");

		Enumeration headerNames = httpRequest.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String headerName = (String)headerNames.nextElement();
			System.out.println(headerName + " = " + httpRequest.getHeader(headerName));
		}

		System.out.println("\n\nParameters");

		Enumeration params = httpRequest.getParameterNames();
		while(params.hasMoreElements()){
			String paramName = (String)params.nextElement();
			System.out.println(paramName + " = " + httpRequest.getParameter(paramName));
		}

		System.out.println("\n\n Row data");
		return  extractPostRequestBody(httpRequest);
	}

	public static String extractPostRequestBody(HttpServletRequest request) {
		if ("POST".equalsIgnoreCase(request.getMethod())) {
			Scanner s = null;
			try {
				s = new Scanner(request.getInputStream(), "UTF-8").useDelimiter("\\A");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return s.hasNext() ? s.next() : "";
		}
		return "";
	}
}
