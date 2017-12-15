package com.gaolaodaye.haijia.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.gaolaodaye.haijia.constant.UrlConstant;
import com.gaolaodaye.haijia.domain.User;
import com.gaolaodaye.haijia.dto.*;
import com.gaolaodaye.haijia.exception.UserException;
import com.gaolaodaye.haijia.util.Utils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HaijiaService implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(HaijiaService.class);
    private static final TypeReference<DataDto<UserDto>> DATADTO_USERDTO_TYPE_REFERENCE = new TypeReference<DataDto<UserDto>>() {
    };
    private static final TypeReference<DataDto<Km2ResultDto>> DATADTO_KM2LIST_TYPE_REFERENCE = new TypeReference<DataDto<Km2ResultDto>>() {
    };

    private HttpClientService httpClientService = new HttpClientService();

    private User user;

    public HaijiaService() {

    }

    public HaijiaService(String userName, String password, String cookie) {
        user = new User(userName, password, cookie);
    }

    public void login() {
        logger.debug("func=login user={}", user);
        user.setXxzh(null);
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("username", user.getUserName()));
        parameters.add(new BasicNameValuePair("passwordmd5", Utils.getMd5(user.getPassword())));
        HttpResponse httpResponse = httpClientService.postHttpRequest(UrlConstant.LOGIN, parameters, user);
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
        HttpResponse httpResponse = httpClientService.getHttpRequest(UrlConstant.KM2_LIST, parameters, user);
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

    public Km2ResultDto getKm2Detail(String yyrq, String xnsd) {
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
        HttpResponse httpResponse = httpClientService.getHttpRequest(UrlConstant.KM2_DETAIL, parameters, user);
        String httpResponseBody = null;
        try {
            httpResponseBody = EntityUtils.toString(httpResponse.getEntity()).trim();
        } catch (IOException e) {
            logger.error("func=login", e);
            throw new UserException(UserException.DATA_EXCEPTION);
        }
        logger.debug("func=getKm2List response={}", httpResponseBody);
        DataDto<Km2ResultDto> dataDto = JSON.parseObject(httpResponseBody, DATADTO_KM2LIST_TYPE_REFERENCE);
        return dataDto.getData();

    }

    public boolean yueKe(String yyjl, String yyrq, String yycc) {
        logger.debug("func=yueKe");
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("trainType", null));
        parameters.add(new BasicNameValuePair("osversion", "7.1.1"));
        parameters.add(new BasicNameValuePair("ossdk", "25"));
        parameters.add(new BasicNameValuePair("imei", "332BEB1DDE63199AC35DE795DA1FC184"));
        parameters.add(new BasicNameValuePair("xxzh", user.getXxzh()));
        parameters.add(new BasicNameValuePair("appversion", "4.1.1"));
        parameters.add(new BasicNameValuePair("isJcsdYyMode", "5"));
        parameters.add(new BasicNameValuePair("jlcbh", null));
        parameters.add(new BasicNameValuePair("version", "4.1.1"));
        parameters.add(new BasicNameValuePair("ipaddress", "172.16.3.212"));
        parameters.add(new BasicNameValuePair("os", "an"));
        parameters.add(new BasicNameValuePair("params", yyjl + "." + yyrq + "." + yycc + "."));
        HttpResponse httpResponse = httpClientService.getHttpRequest(UrlConstant.KM2_YUEKE, parameters, user);
        String httpResponseBody = null;
        try {
            httpResponseBody = EntityUtils.toString(httpResponse.getEntity()).trim();
        } catch (IOException e) {
            logger.error("func=login", e);
            throw new UserException(UserException.DATA_EXCEPTION);
        }
        logger.debug("func=getKm2List response={}", httpResponseBody);
        DataDto<Km2ResultDto> dataDto = JSON.parseObject(httpResponseBody, DATADTO_KM2LIST_TYPE_REFERENCE);
        return dataDto.getCode() == 0 ? true : false;

    }

    public void qiangPiao() {
        Km2ResultDto km2ResultDto = getKm2List();
        List<YyrqDto> yyrqDtos = km2ResultDto.getYyrqList();
        List<XnsdDto> xnsdDtos = km2ResultDto.getXnsdList();
        List<UIDatasDto> uiDatasDtos = km2ResultDto.getUIDatas();
        int index = 0;
        for (YyrqDto yyrqDto : yyrqDtos) {
            for (XnsdDto xnsdDto : xnsdDtos) {
                UIDatasDto uiDatasDto = uiDatasDtos.get(index++);
                if (!"周六".equals(yyrqDto.getDisplayWeek()) && !"周日".equals(yyrqDto.getDisplayWeek())) {
                    continue;
                }
                if (uiDatasDto.getSL() == 0) {
                    continue;
                }
                if ("周一".equals(yyrqDto.getDisplayWeek())) {
                    return;
                }
                if("2001".equals(xnsdDto.getXnsd())){
                    continue;;
                }
                Km2ResultDto km2ResultDto1 = getKm2Detail(getYyrq(yyrqDto.getYyrq()), xnsdDto.getXnsd());
                List<LessonDto> lessonDtos = km2ResultDto1.getResult();
                if (lessonDtos == null || lessonDtos.size() == 0) {
                    continue;
                }
                int lessonIndex = (int) (Math.random() * lessonDtos.size());
                LessonDto lessonDto = lessonDtos.get(lessonIndex >= lessonDtos.size() ? lessonDtos.size() : lessonIndex);
                boolean flag = yueKe(lessonDto.getCNBH(), getYyrq(yyrqDto.getYyrq()), xnsdDto.getXnsd());
                if (flag) {
                    throw new RuntimeException("抢课成功");
                }

            }
        }

    }

    private String getYyrq(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");


        try {
            Date date = sdf.parse(dateStr);
            return sdf2.format(date);
        } catch (ParseException e) {
            logger.error("func=getYyrq", e);
            throw new UserException(UserException.DATA_EXCEPTION);
        }
    }

    @Override
    public void run() {
        this.login();
        while (true) {
            try {
                this.qiangPiao();
                int sleepTime = (int) (Math.random() * 200) + 100;
                Thread.sleep(sleepTime);
                logger.debug("Thread {} sleep {} ms", user.getUserName(), sleepTime);
            } catch (UserException e) {
                if (UserException.USER_NOT_LOGIN == e.getCode()) {
                    this.login();
                } else {
                    logger.error("func run", e);
                }

            } catch (Exception e) {
                logger.error("user " + user.getUserName(), e);
                return;
            }
        }


    }
}
