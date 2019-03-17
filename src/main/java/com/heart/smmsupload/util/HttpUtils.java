package com.heart.smmsupload.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Http请求工具类
 * TODO：以前都是http请求发送String，现在要发送一个file文件怎么整啊
 */
public class HttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);


    /**
     * Http请求
     */
    public static String doPost(String apiUrl, String param) {

        StringBuffer responseContent = new StringBuffer();
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;

        String BOUNDARY = "---------------------------7da2e536604c8";

        try {
            //第一步：获取URL
            URL url = new URL(apiUrl);
            //第二步：使用URL获取URLConnection
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //第三步：设置相应属性
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
            //如果需要传输数据并接受返回数据，需要设置下面两项
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            //第四步：使用IO流将数据写出
            printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            printWriter.write(param);
            printWriter.flush();
            //第五步：获取响应报文
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                responseContent.append(line);
            }
        } catch (Exception e) {
            logger.error("HTTP请求通信异常：{}", e.getMessage());
        } finally {
            //第六步：关闭IO流
            try {
                if (printWriter != null) {
                    printWriter.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                logger.error("关闭IO流异常：{}", e.getMessage());
            }
        }
        logger.info("HTTP请求响应数据：{}", responseContent);
        return responseContent.toString();
    }


}
