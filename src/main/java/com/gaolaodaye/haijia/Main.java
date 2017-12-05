package com.gaolaodaye.haijia;

import com.gaolaodaye.haijia.exception.UserException;
import com.gaolaodaye.haijia.service.HaijiaService;

public class Main {
    public static void main(String[] args) {
        try {
            HaijiaService haijiaService = new HaijiaService("15311541537", "9e7cd23b28303921d9b397415d7624d9");
            haijiaService.login();
            haijiaService.getKm2List();

        } catch (UserException e) {
            System.err.println(e.getCode() + "--" + e.getMsg());
        }


    }

}
