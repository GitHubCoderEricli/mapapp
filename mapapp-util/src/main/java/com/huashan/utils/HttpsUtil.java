package com.huashan.utils;

import org.apache.log4j.Logger;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

/**
 * Created by lixu on 2016-08-13.
 */
public class HttpsUtil {
    private static final Logger LOGGER = Logger.getLogger(HttpsUtil.class);
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String METHOD_GET = "GET";

    private static class TrustAnyTrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[] {};
        }
    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    /**
     * 访问https请求获取数据
     * @param url
     * @param params
     * @return
     */
    public static String getBody(String url, Map<String, String> params) {
        String paramStr = getParams(params);
        String urlStr;
        if (paramStr != null) {
            urlStr = url + "?&" + paramStr;
        }else {
            urlStr = url;
        }
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(urlStr);
            HttpsURLConnection connection = getConnect(realUrl);
            if (connection == null) {
                LOGGER.info("发送GET请求创建连接失败！");
                return null;
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (MalformedURLException e) {
            LOGGER.info("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            LOGGER.info("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.info("发送GET请求IO异常！" + e);
            e.printStackTrace();
        }finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (StringUtils.isEmpty(result)) {
            return null;
        }else {
            return result;
        }
    }

    private static HttpsURLConnection getConnect(URL realUrl) {
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[] { new TrustAnyTrustManager() },
                    new java.security.SecureRandom());

            HttpsURLConnection connection = (HttpsURLConnection) realUrl.openConnection();
            //设置https相关属性
            connection.setSSLSocketFactory(sc.getSocketFactory());
            connection.setHostnameVerifier(new TrustAnyHostnameVerifier());
            connection.setDoOutput(true);
            connection.setRequestMethod(METHOD_GET);

            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();

            return connection;
        } catch (KeyManagementException e) {
            LOGGER.info("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            LOGGER.info("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.info("发送GET请求打开连接失败！" + e);
            e.printStackTrace();
        }
        return null;
    }

    private static String getParams(Map<String, String> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        String str = "";
        for (String key:params.keySet()) {
            str += key + "=" + params.get(key).toString() + "&";
        }
        return str;
    }
}
