package cn.baochao.test;

import cn.baochao.model.User;
import cn.baochao.utils.MD5;
import net.sf.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * Created by huangbc on 2017/4/17.
 */
public class Demo7 {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        System.out.println(path);
//----------------------------------------------
        User user = new User();
        user.setName("huang");
        user.setAge("26");
        pushDict2GHB(user);

    }


    /**
     * 字典推送
     */
    public static boolean pushDict2GHB(User user){
        try {

            String path = System.getProperty("user.dir")+"/"+"test2.jks";
            String u = "https://www.baidu.com:8912/jifen/product/getCard";
            System.setProperty("javax.net.ssl.trustStore", path);
            System.setProperty("javax.net.ssl.trustStorePassword", "123456");
            System.setProperty("javax.net.ssl.keyStoreType", "JKS");
            System.setProperty("javax.net.ssl.keyStore", path);
            System.setProperty("javax.net.ssl.keyStorePassword", "123456");

            URL url = new URL(u);
            HttpsURLConnection http = (HttpsURLConnection) url.openConnection();
            http.setDoOutput(true);
            http.setDoInput(true);
            http.setRequestMethod("POST");
            OutputStreamWriter out = new OutputStreamWriter(http.getOutputStream());
            StringBuffer sb = new StringBuffer();
            sb.append("3B40D9D6CBA5003AE0530A010D3BBA63")
                    .append(user.getName())
                    .append(user.getAge());
            String token = MD5.MD5Encode(sb.toString());
            JSONObject json = new JSONObject();
            json.element("couponCode","111");
            json.element("couponName", "111");
            json.element("serviceType","111");
            json.element("serviceTypeName","111");
            json.element("dadiGovCode", "111");
            json.element("canUseStatus", 2);
            json.element("usedPlatform", "111");
            json.element("accessToken", token);
//            LogUtil.info("JSON:"+json);
            out.write(json.toString());
            out.flush();
            out.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            String line = "";
            StringBuffer bs2 = new StringBuffer();
            for (line = br.readLine(); line != null; line = br.readLine()) {
                bs2.append(line);
            }
//            LogUtil.info("参数返回：" + bs2.toString());
            JSONObject obj = JSONObject.fromObject(bs2);
            if(obj.get("resultCode").equals("0000")){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



}
