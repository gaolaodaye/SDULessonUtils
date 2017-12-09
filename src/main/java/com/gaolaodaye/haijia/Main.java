package com.gaolaodaye.haijia;

import com.gaolaodaye.haijia.exception.UserException;
import com.gaolaodaye.haijia.service.HaijiaService;

public class Main {
    public static void main(String[] args) {
        try {
            HaijiaService haijiaService1 = new HaijiaService("15311541537", "9e7cd23b28303921d9b397415d7624d9","Cookie: Webapi_LoginOn_client=%7b%0d%0a%20%20%22userName%22%3a%20%2215311541537%22%2c%0d%0a%20%20%22phoneNum%22%3a%20%2215311541537%22%2c%0d%0a%20%20%22nickName%22%3a%20%22%e9%ab%98%e8%80%81%e5%a4%a7%e7%88%b7%22%2c%0d%0a%20%20%22Id%22%3a%20%221016850%22%2c%0d%0a%20%20%22os%22%3a%20null%2c%0d%0a%20%20%22email%22%3a%20null%2c%0d%0a%20%20%22password%22%3a%20null%2c%0d%0a%20%20%22passwordmd5%22%3a%20%229e7cd23b28303921d9b397415d7624d9%22%2c%0d%0a%20%20%22authemail%22%3a%20null%2c%0d%0a%20%20%22xxzh%22%3a%20%2251732177%22%2c%0d%0a%20%20%22jgid%22%3a%20%22115001%22%2c%0d%0a%20%20%22webapiurl%22%3a%20null%2c%0d%0a%20%20%22xybh%22%3a%20%228000413120%22%2c%0d%0a%20%20%22sfzh%22%3a%20%22231025198904070034%22%2c%0d%0a%20%20%22jxcode%22%3a%20%22110108015%22%2c%0d%0a%20%20%22schoolpwd%22%3a%20%22feng123%22%2c%0d%0a%20%20%22iconpath%22%3a%20null%2c%0d%0a%20%20%22username%22%3a%20%2215311541537%22%2c%0d%0a%20%20%22phonenum%22%3a%20%2215311541537%22%2c%0d%0a%20%20%22nickname%22%3a%20%22%e9%ab%98%e8%80%81%e5%a4%a7%e7%88%b7%22%2c%0d%0a%20%20%22qquid%22%3a%20null%2c%0d%0a%20%20%22sinauid%22%3a%20null%2c%0d%0a%20%20%22apiurl%22%3a%20%22bookingcarapi%3a%3ahttp%3a%2f%2fhaijia.xuechebu.com%3a8008%3bbookingexamapi%3a%3ahttp%3a%2f%2fhaijia.xuechebu.com%3a8008%22%2c%0d%0a%20%20%22apiurlios%22%3a%20%22https%3a%2f%2fhaijiaapi.xuechebu.com%3a8007%22%2c%0d%0a%20%20%22jxmc%22%3a%20%22%e6%b5%b7%e6%b7%80%e9%a9%be%e6%a0%a1%22%2c%0d%0a%20%20%22xm%22%3a%20%22%e9%ab%98%e5%b3%b0%22%2c%0d%0a%20%20%22usertype%22%3a%20%221%22%2c%0d%0a%20%20%22clientCode%22%3a%20null%2c%0d%0a%20%20%22dz%22%3a%20null%2c%0d%0a%20%20%22SQCX%22%3a%20%22C1%22%2c%0d%0a%20%20%22SSBX%22%3a%20%22%e8%ae%a11-7%22%2c%0d%0a%20%20%22BackgroundImage%22%3a%20%22%22%2c%0d%0a%20%20%22HandImage%22%3a%20%22image2.xuechebu.com%2fxcbHandImages%2f2017-11-10%2f69920647-8b2f-4ba9-9558-c6bc1a4be53d.jpg%22%0d%0a%7d; Webapi_LoginOn=4X/YqQ9wTLRNPh0a6azvm2bwynlbp/0mng7DaXb2zQHCRnKonN3g96WhLljTHnPGy4RfT9HNVj0w/zO3j75YqECDrsmC+ZmM2qBLgGcfpqNdfqCJlc3ZhLlAxIiBsXmK8fiNZsmACcSv7eTNviOohdFILvsb0ZdDK4utLcoIovsxzFfL6eiGno0jc9rRT7oRXGYCgZ1fBCTc74tcgwMy7h+vv54MoV8b8wUEMcYW07v0V8BfVmB5Xirgf9g5nCzqEGl3CVQejVH50L5cGD2uOWx0GE2G7WMO3+StIeDkGeUFN6s9JLBIJtGdgqQuzRdLH3KAI+lljTQUqqXqE018FSaCE5yAmER8aPOS2F46RU+ofB7JmbSEgebwh/LAYjl7j6Z5vHBl1fp8gcgIumy1w92229RBM02X310i0dt8keY5j+gr6RcHlnV0gOfRylhqt1i2n2ypuPhuMy53G5Bss9P4iAuoLNnGHp+lUBhQswzBAn/yQsqjH4xrbmreznPMDChoHAZxJ5TpNXrIRWrF5AhvlQXSVOPTQr3PmgmS6Ju5xSlxbpwpVOwBilFVBRmvSFSVkHDCfUwCusFVESCcad6Z1HZamTuZuBTSGWqMfYTlZ0N0lst0XJv3F/vVH19jCuKyyXc0zLrpf7fsK07Q1JS6fgA6y5MCb7VEyWNCxCBYhwzzXCNQLJ5aqUL3TX2j4DVoMpNrN4SNI3Pa0U+6Ebn2ABtBhI484fM6783vqGpMQQCNDElMVQMqa9/qKs5qX2RQYV2Up504vQJ2pwlrjKi868ota6iFh2BVOR3/WP/dUAT8ED6kupWUsxIc7+mFoIv+foKgCINaReCdRffbL6i868ota6iFh2BVOR3/WP/dUAT8ED6kuqPo1Z3zxE2LCpfUhIgDkIy1JcCBG5mr7K8tyq/BXb3/Tqy43uaJ9Lzzmhxajpw4y7210eGt9HbRbaGmV/5tKSx3UOzw1yznOTjjNjpxaZUc4Rq6Wb+bUdOJEAyKaMA6INf0JwKFo9fmLlRJ9QbhPzToiqCzaR/r2JmpB5CXhay1pfwKxL18VFaFBhqHeSEoVtrhvtSfbZe2Y55orztgh55Da/pGvlDWA6ya5ojmr9cR+sIjeqmouzi9MWjPDoo/P7R/1LZ9DvdqJa0hHxWXvTGsxoq0jNFAQ3oIcRcDWUvmV7Wewxocndr14eqHRdh8nDBxMqpD16KQ88YMOkguxHLRSqThiO1Ph5XwphRMF+/8a2+mH03qgM2hkf4WtnFzQH2tynhhBoEKhu8Jzwu0KHtEDQGaE9KU0V2586d+/MHvyp2RGZCUPTHCPjJXtIBaZg==; JX_LoginOn=tHuIebKocq4joXX/W+I7WUr+Wusvt8ewMboCCJ16XDaK/3YY/tbBVrCbFxgH/dfOqJ1DaxQtJ/9aFC3YgUWDemsBJrMb1RupCqjQYBmqThngo7HzJBkwFg7xgeioKBwvUQJ0RW61j0GNimjLRTurua0kO+BdhSyD4I1JENeXmyyzWMTKL8sALmuQdOZg1+tw0UKpnMArE5cLv7RRVG388cx51sf4yi2hVW2lmkoE9YcmOzus2oZzbs6B16A/zWTOd9Gm8qpkZWV+7i3Y5qD9pDQmvZCraw/G5c+E/kx84S257pjE+J1iDB7iTQW1nHUn9nhPzICc0LRx4q07MJ6HStRF9imYwDoEuBMkxGKIJtENYLFp5VLj49dnr0JIQSIevPmVwdlbLig=; yunsuo_session_verify=1fe8f0b075b960b60f09017ff166a83c; yunsuo_session_verify=684ca140ed529d623a7a18414df92007");
            haijiaService1.run();
//            HaijiaService haijiaService2 = new HaijiaService("18910751107", "9e7cd23b28303921d9b397415d7624d9");
//            HaijiaService haijiaService3 = new HaijiaService("15311541537", "9e7cd23b28303921d9b397415d7624d9");
//
//            Thread thread1 = new Thread(haijiaService1);
//            thread1.start();
//            Thread thread2 = new Thread(haijiaService2);
//            thread2.start();

        } catch (UserException e) {
            System.err.println(e.getCode() + "--" + e.getMsg());
        }


    }

}
