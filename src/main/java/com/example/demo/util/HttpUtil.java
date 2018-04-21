package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpEntity;

import java.io.IOException;

/**
 * Created by gmg on on 2018-01-15 16:53.
 */
public class HttpUtil {
        public static Log logger = LogFactory.getLog(HttpUtil.class);
        //get请求
        public static com.alibaba.fastjson.JSONObject doGet(String requestUrl) {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = null;
            String responseContent  = null;
            com.alibaba.fastjson.JSONObject result = null;
            try {
                //创建Get请求，
                HttpGet httpGet = new HttpGet(requestUrl);
                //执行Get请求，
                response = httpClient.execute(httpGet);
                //得到响应体
                org.apache.http.HttpEntity entity = response.getEntity();
                //获取响应内容
                responseContent  = EntityUtils.toString(entity,"UTF-8");
                //转换为map
                result = JSON.parseObject(responseContent);
            } catch (IOException e) {
                logger.error("HttpUtil=====Start");
                logger.error(e.getMessage(),e);
                logger.error("HttpUtil=====End");
            }
            return result;
        }
}
