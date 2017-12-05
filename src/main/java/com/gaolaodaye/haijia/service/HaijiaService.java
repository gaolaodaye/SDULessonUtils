package com.gaolaodaye.haijia.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.gaolaodaye.haijia.constant.UrlConstant;
import com.gaolaodaye.haijia.domain.User;
import com.gaolaodaye.haijia.dto.DataDto;
import com.gaolaodaye.haijia.dto.Km2ResultDto;
import com.gaolaodaye.haijia.dto.UIDatasDto;
import com.gaolaodaye.haijia.dto.UserDto;
import com.gaolaodaye.haijia.exception.UserException;
import com.gaolaodaye.haijia.util.Utils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HaijiaService {
    private static final Logger logger = LoggerFactory.getLogger(HaijiaService.class);
    private static final TypeReference<DataDto<UserDto>> DATADTO_USERDTO_TYPE_REFERENCE = new TypeReference<DataDto<UserDto>>() {
    };
    private static final TypeReference<DataDto<Km2ResultDto>> DATADTO_KM2LIST_TYPE_REFERENCE = new TypeReference<DataDto<Km2ResultDto>>() {
    };

    private User user;

    public HaijiaService() {

    }

    public HaijiaService(String userName, String password) {
        user = new User(userName, password);
    }

    public void login() {
        logger.debug("func=login user={}", user);
        user.setXxzh(null);
        user.setCookieMap(null);
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("username", user.getUserName()));
        parameters.add(new BasicNameValuePair("passwordmd5", Utils.getMd5(user.getPassword())));
        HttpResponse httpResponse = HttpClientService.postHttpRequest(UrlConstant.LOGIN, parameters, user);
        String httpResponseBody = null;
        try {
            httpResponseBody = EntityUtils.toString(httpResponse.getEntity()).trim();
        } catch (IOException e) {
            logger.error("func=login", e);
            throw new UserException(UserException.DATA_EXCEPTION);
        }
        DataDto<UserDto> dataDto = JSON.parseObject(httpResponseBody, DATADTO_USERDTO_TYPE_REFERENCE);
        logger.debug(dataDto.toString());
        if (dataDto.getCode() == 0) {
            user.setXxzh(dataDto.getData().getXXZH());
            logger.info("登录成功：{}", user);

        } else {
            throw new RuntimeException("登录失败:" + httpResponseBody);
        }
    }

    /**
     * trainType=
     * osversion=7.1.1
     * ossdk=25
     * xxzh=51732177
     * imei=332BEB1DDE63199AC35DE795DA1FC184
     * appversion=4.1.1
     * version=4.1.1
     * ipaddress=172.16.3.212
     * os=an
     *
     * @return
     */
    public Km2ResultDto getKm2List() {
        logger.debug("func=getKm2List");
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("trainType", null));
        parameters.add(new BasicNameValuePair("osversion", "7.1.1"));
        parameters.add(new BasicNameValuePair("ossdk", "25"));
        parameters.add(new BasicNameValuePair("xxzh", user.getXxzh()));
        parameters.add(new BasicNameValuePair("imei", "332BEB1DDE63199AC35DE795DA1FC184"));
        parameters.add(new BasicNameValuePair("appversion", "4.1.1"));
        parameters.add(new BasicNameValuePair("version", "4.1.1"));
        parameters.add(new BasicNameValuePair("ipaddress", "172.16.3.212"));
        parameters.add(new BasicNameValuePair("os", "an"));
        HttpResponse httpResponse = HttpClientService.getHttpRequest(UrlConstant.KM2_LIST, parameters, user);
        String httpResponseBody = null;
        try {
            httpResponseBody = EntityUtils.toString(httpResponse.getEntity()).trim();
        } catch (IOException e) {
            logger.error("func=getKm2List", e);
        }
        logger.debug("func=getKm2List response={}", httpResponseBody);
        DataDto<Km2ResultDto> dataDto = JSON.parseObject(httpResponseBody, DATADTO_KM2LIST_TYPE_REFERENCE);

        if (dataDto.getCode() == 110) {
            throw new UserException(UserException.USER_NOT_LOGIN);
        }

        return dataDto.getData();
    }

    public void getKm2Detail(String yyrq, String xnsd) {
        logger.debug("func=getKm2Detail");

        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("osversion", "7.1.1"));
        parameters.add(new BasicNameValuePair("ossdk", "25"));
        parameters.add(new BasicNameValuePair("imei", "332BEB1DDE63199AC35DE795DA1FC184"));
        parameters.add(new BasicNameValuePair("xxzh", user.getXxzh()));
        parameters.add(new BasicNameValuePair("version", "4.1.1"));
        parameters.add(new BasicNameValuePair("appversion", "4.1.1"));
        parameters.add(new BasicNameValuePair("trainType", null));
        parameters.add(new BasicNameValuePair("ipaddress", "172.16.3.212"));
        parameters.add(new BasicNameValuePair("os", "an"));
        parameters.add(new BasicNameValuePair("filters[yyrq]", yyrq));
        parameters.add(new BasicNameValuePair("filters[xnsd]", xnsd));
        parameters.add(new BasicNameValuePair("filters[trainType]", null));
        parameters.add(new BasicNameValuePair("filters[xxzh]", user.getXxzh()));
        parameters.add(new BasicNameValuePair("filters[jlcbh]", null));
        HttpResponse httpResponse = HttpClientService.getHttpRequest(UrlConstant.KM2_LIST, parameters, user);
        String httpResponseBody = null;
        try {
            httpResponseBody = EntityUtils.toString(httpResponse.getEntity()).trim();
        } catch (IOException e) {
            logger.error("func=login", e);
            throw new UserException(UserException.DATA_EXCEPTION);
        }
        logger.debug("func=getKm2List response={}", httpResponseBody);
        DataDto<Km2ResultDto> dataDto = JSON.parseObject(httpResponseBody, DATADTO_KM2LIST_TYPE_REFERENCE);

    }

}
