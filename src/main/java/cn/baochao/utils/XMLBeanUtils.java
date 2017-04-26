package cn.baochao.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * XML与JavaBean相互转换工具类
 */
public final class XMLBeanUtils {


    public static String map2XmlString(Map<String, String> map) {
        String xmlResult = "";

        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        sb.append("<xml>");
        for (String key : map.keySet()) {
            String value = "<![CDATA[" + map.get(key) + "]]>";
            sb.append("<" + key + ">" + value + "</" + key + ">");
        }
        sb.append("</xml>");
        xmlResult = sb.toString();

        return xmlResult;
    }

    /**
     * @description 将xml字符串转换成map
     * @param xml
     * @return Map
     */
    public static Map<String, String> readStringXmlOut(String xml) {
        Map<String, String> map = new HashMap<String, String>();
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml); // 将字符串转为XML
            Element rootElt = doc.getRootElement(); // 获取根节点
            @SuppressWarnings("unchecked")
            List<Element> list = rootElt.elements();// 获取根节点下所有节点
            for (Element element : list) { // 遍历节点
                map.put(element.getName(), element.getText()); // 节点的name为map的key，text为map的value
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        /*
         * map.put("appid", WeixinUtils.APP_ID); map.put("mch_id",
         * WeixinUtils.MCH_ID);
         */
        map.put("device_info ", "WEB");
        //String nonce_str = RandomStringGenerator.getRandomStringByLength(32);
        map.put("nonce_str", "5K8264ILTKCH16CQ2502SI8ZNMTM67VS");
        map.put("body", "商品描述。XX项目");
        map.put("out_trade_no", "001t" + System.currentTimeMillis());
        map.put("total_fee", "0.01");
        map.put("trade_type", "JSAPI");
        map.put("openid", "o4lmljscgZDnjI4xthqMMnEr02fo");
//
//        String xmlResult = "";
//
//        StringBuffer sb = new StringBuffer();
//        sb.append("<xml>");
//        for (String key : map.keySet()) {
//            System.out.println(key + "========" + map.get(key));
//            sb.append("<" + key + ">" + map.get(key) + "</" + key + ">");
//            System.out.println();
//        }
//        sb.append("</xml>");
//        xmlResult = sb.toString();
//        System.out.println(xmlResult);
        String string = map2XmlString(map);
        System.out.println(string);
        Map<String, String> map1 = readStringXmlOut(string);
        map1.forEach((k,v)->{
            System.out.println(k+"================="+v);
        });

    }
}