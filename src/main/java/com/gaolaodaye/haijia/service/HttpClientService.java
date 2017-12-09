package com.gaolaodaye.haijia.service;

import com.alibaba.fastjson.JSON;
import com.gaolaodaye.haijia.constant.StringConstant;
import com.gaolaodaye.haijia.domain.User;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientService {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientService.class);
    private DefaultHttpClient client = new DefaultHttpClient();


    public HttpResponse getHttpRequest(String url, List<NameValuePair> parameters,
                                       User user) {
        // 创建GET请求
        try {
            logger.debug("------------------------------------------------------------------------");
            if (parameters != null && parameters.size() > 0) {
                String paramURL = URLEncodedUtils.format(parameters, HTTP.UTF_8);
                if (url.indexOf("?") > -1) {
                    url = url + "&" + paramURL;
                } else {
                    url = url + "?" + paramURL;
                }
            }

            logger.debug("GET URL: " + url);

            HttpGet get = new HttpGet(url);
            get.setHeader(StringConstant.USER_AGENT_NAME, StringConstant.USER_AGENT_VALUE);
            get.setHeader("Cookie", user.getCookie());

            if (logger.isDebugEnabled()) {

                logger.debug("func=postHttpRequest Request parameters:{}, Request headers:{}", JSON.toJSONString(parameters), JSON.toJSONString(get.getAllHeaders()));


            }
            HttpResponse response = client.execute(get);
            if (logger.isDebugEnabled()) {
                logger.debug("***********************************************************************");

                logger.debug(" + Response headers: ");
                for (Header header : response.getAllHeaders()) {
                    logger.debug("   - " + header.getName() + " : " + header.getValue());
                }
                logger.debug("***********************************************************************");

            }
            return response;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }


    /**
     * POST请求
     *
     * @param url
     * @param parameters
     * @param user
     * @return
     */
    public HttpResponse postHttpRequest(String url, List<NameValuePair> parameters,
                                        User user) {
        try {
            logger.debug("------------------------------------------------------------------------");
            logger.debug("POST URL: " + url);

            HttpPost post = new HttpPost(url);
            post.setHeader(StringConstant.USER_AGENT_NAME, StringConstant.USER_AGENT_VALUE);
            if (user.getCookie() != null) {
                post.setHeader("Cookie", user.getCookie());
            }
            if (parameters != null) {
                UrlEncodedFormEntity uef = new UrlEncodedFormEntity(parameters, HTTP.UTF_8);
                post.setEntity(uef);
            }
            if (logger.isDebugEnabled()) {
                logger.debug("func=postHttpRequest Request parameters:{}, Request headers:{}", JSON.toJSONString(parameters), JSON.toJSONString(post.getAllHeaders()));
            }
            HttpResponse response = client.execute(post);
            if (logger.isDebugEnabled()) {
                logger.debug(" + Response headers: ");
                for (Header header : response.getAllHeaders()) {
                    logger.debug("   - " + header.getName() + " : " + header.getValue());
                }

            }
            logger.debug("***********************************************************************");
            return response;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }


    private String cookieMapToString(Map<String, String> cookieData) {

        boolean first = true;
        StringBuilder cookie = new StringBuilder();
        for (Map.Entry<String, String> me : cookieData.entrySet()) {
            if ("Webapi_LoginOn_client".equals(me.getKey())) {
                continue;
            }
            if (first) {
                first = false;
            } else {
                cookie.append(";");
            }
            cookie.append(me.getKey() + "=" + me.getValue());
        }
        cookie.append("yunsuo_session_verify=61199a51151405ba5cd4dd0d9d54995b; JX_LoginOn=tHuIebKocq4joXX/W+I7WUr+Wusvt8ewMboCCJ16XDaK/3YY/tbBVrCbFxgH/dfOqJ1DaxQtJ/9aFC3YgUWDemsBJrMb1RupCqjQYBmqThngo7HzJBkwFg7xgeioKBwvUQJ0RW61j0GNimjLRTurua0kO+BdhSyD4I1JENeXmyyzWMTKL8sALmuQdOZg1+tw0UKpnMArE5cLv7RRVG388cx51sf4yi2hVW2lmkoE9YcmOzus2oZzbs6B16A/zWTOd9Gm8qpkZWWiptAasKtR8VTJUsjMrni3L1qqCXzVz3YvCAhjDRWxdjfHwrodcfw99nhPzICc0LRx4q07MJ6HStRF9imYwDoEuBMkxGKIJtENYLFp5VLj49dnr0JIQSIevPmVwdlbLig=; yunsuo_session_verify=23a8c12d75f6ac921b6f1554b4aea282");
        logger.debug("Cookie:{}", cookie.toString());
        return cookie.toString();
    }
}



