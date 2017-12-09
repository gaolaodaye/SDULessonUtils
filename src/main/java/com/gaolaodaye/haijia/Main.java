package com.gaolaodaye.haijia;

import com.gaolaodaye.haijia.exception.UserException;
import com.gaolaodaye.haijia.service.HaijiaService;

public class Main {
    public static void main(String[] args) {
        try {
            HaijiaService haijiaService1 = new HaijiaService("15311541537", "9e7cd23b28303921d9b397415d7624d9");
            HaijiaService haijiaService2 = new HaijiaService("18910751107", "9e7cd23b28303921d9b397415d7624d9");
            HaijiaService haijiaService3 = new HaijiaService("15311541537", "9e7cd23b28303921d9b397415d7624d9");

            Thread thread1 = new Thread(haijiaService1);
            thread1.start();
            Thread thread2 = new Thread(haijiaService2);
            thread2.start();

        } catch (UserException e) {
            System.err.println(e.getCode() + "--" + e.getMsg());
        }


    }

}
