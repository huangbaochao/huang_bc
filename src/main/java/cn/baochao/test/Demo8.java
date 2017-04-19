package cn.baochao.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by huangbc on 2017/4/18.
 */
public class Demo8 {

    public static void main(String[] args) {

        String str = "huang";
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        System.out.println(str.substring(0,str.length()-1));//输出d
        System.out.println(str.substring(str.length()-1));//输出d
    }

//
////    获取token demo如下（分别针对中文用户名和英文用户名）：
////            1、用户名为中文：
//    public static void main(String[] args) throws UnsupportedEncodingException {
//        String username = "中文用户名";
//        String password = MD5Util.getMD5Str("password ");
//        String timestamp = "2014-12-18 15:20:33";
//        String clientSecret="your clientSecret";
//        String clientId="your clientId";
//        String sign = clientSecret + timestamp + clientId+ username + password + "access_token" + clientSecret;
//        System.out.println("sign="+sign);
//        sign = MD5Util.getMD5Str(sign).toUpperCase();
//        System.out.println("sign="+sign);
//        String url = "https://bizapi.jd.com/oauth2/access_token";
//        String data =
//                "grant_type=access_token" +
//                        "&client_id=" +clientId+
//                        "&username=" + URLEncoder.encode("中文用户名", "utf-8") +
//                        "&password=" + password +
//                        "&timestamp=" + timestamp +
//                        "&sign="+sign;
//        String rev = HttpUtils.httpPostData(url, data, null);
//        System.out.println(rev);
//    }
//
////2、用户名为英文：
//    public static void main(String[] args) throws UnsupportedEncodingException {
//        String username = "your username";
//        String password = MD5Util.getMD5Str("password ");
//        String timestamp = "2014-12-18 15:20:33";
//        String clientSecret="your clientSecret";
//        String clientId="your clientId";
//        String sign = clientSecret + timestamp + clientId+ username + password + "access_token" + clientSecret;
//        System.out.println("sign="+sign);
//        sign = MD5Util.getMD5Str(sign).toUpperCase();
//        System.out.println("sign="+sign);
//        String url = "https://bizapi.jd.com/oauth2/access_token";
//        String data =
//                "grant_type=access_token" +
//                        "&client_id=" +clientId+
//                        "&username=" + username +
//                        "&password=" + password +
//                        "&timestamp=" + timestamp +
//                        "&sign="+sign;
//        String rev = HttpUtils.httpPostData(url, data, null);
//        System.out.println(rev);
//    }



}
