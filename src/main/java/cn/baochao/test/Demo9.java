package cn.baochao.test;

import cn.baochao.model.JdPrice;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by huangbc on 2017/4/19.
 * 解析json数组
 */
public class Demo9 {

    public static void main(String[] args) {
//        String str = "{\n" +
//                "  \"member_list\": [\n" +
//                "    {\n" +
//                "      \"team_id\": 100,\n" +
//                "      \"user_id\": \"10420275-b862-11e6-a133-1ea400b87ec5\",\n" +
//                "      \"name\": \"张三\",\n" +
//                "      \"mobile\": \"13838003800\",\n" +
//                "      \"email\": \"example@example.com\",\n" +
//                "      \"join_time\": 1484443433\n" +
//                "    }\n" +
//                "  ]\n" +
//                "}";
//        JSONObject jsonObject = JSONObject.fromObject(str);
//        JSONArray jsonArray = JSONArray.fromObject(jsonObject.get("member_list"));
//        Iterator<Object> it = jsonArray.iterator();
//        while (it.hasNext()) {
//            JSONObject ob = (JSONObject) it.next();
//            System.out.println(ob.get("team_id"));
//            System.out.println(ob.get("user_id"));
//            System.out.println("---------------------------------");
//        }
        String str = "{\"result\":\n" +
                "     [\n" +
                "          {\"skuId\": 111111, \"jdPrice\":\"京东价格1\"},\n" +
                "          {\"skuId\": 222222, \"jdPrice\":\"京东价格2\"}\n" +
                "     ]\n" +
                "}";
        JSONObject jsonObject = JSONObject.fromObject(str);
        JSONArray jsonArray = JSONArray.fromObject(jsonObject.get("result"));
//        Iterator<Object> it = jsonArray.iterator();  //遍历json数组
//        while (it.hasNext()) {
//            JSONObject ob = (JSONObject) it.next();
//            System.out.println(ob.get("skuId"));
//            System.out.println(ob.get("jdPrice"));
//            System.out.println("---------------------------------");
//        }

        if (!StringUtils.isEmpty(jsonArray)){
            List<JdPrice> gd = parseJsonArrayWithGson(jsonArray.toString(), JdPrice.class);
            List<List<JdPrice>> lists = (List<List<JdPrice>>) Lists.partition(gd, 3);
            int success = 0;
            for (List<JdPrice> li : lists) {
                System.out.println(li);
            }
            System.out.println(success);
        }
    }

    // 将Json数组解析成相应的映射对象列表
    public static <T> List<T> parseJsonArrayWithGson(String jsonString,Class<T> type){
        List<T> list = new ArrayList<T>();
        try {
            Gson gson = new Gson();
            JsonArray array = new JsonParser().parse(jsonString).getAsJsonArray();
            array.forEach(arr->{
                list.add(gson.fromJson(arr,type));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
