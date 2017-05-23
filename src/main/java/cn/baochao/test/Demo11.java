package cn.baochao.test;


import com.alibaba.fastjson.JSON;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sun.plugin.javascript.navig.Link;

import java.util.List;
import java.util.Map;

/**
 * Created by huangbc on 2017/5/23.
 */
public class Demo11 {

    public static void main(String[] args) {
        String str = "{\n" +
                "    \"status\": 200,\n" +
                "    \"msg\": \"OK\",\n" +
                "    \"data\": {\n" +
                "        \"before\": [\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522190000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"24.9\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522180000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"26.1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522170000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"27.4\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522160000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"28.2\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522150000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"28.1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522140000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"28.3\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522130000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"27.7\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522120000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"27.0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522110000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"26.8\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522100000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"26.1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522090000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"24.2\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522080000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"23.4\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522070000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"22.4\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522060000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"21.3\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522050000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"20.3\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522040000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"20.5\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522030000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"20.7\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522020000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"21.5\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522010000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"21.8\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170522000000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"21.9\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170521230000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"21.9\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170521220000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"22.3\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170521210000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"22.8\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"precipitation\": \"0.0\",\n" +
                "                \"observTimes\": \"20170521200000\",\n" +
                "                \"stationId\": \"58467\",\n" +
                "                \"station_Name\": \"鎱堟邯\",\n" +
                "                \"dryBulTemp\": \"23.4\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"forecast\": [\n" +
                "            {\n" +
                "                \"pr03\": null,\n" +
                "                \"hours\": 15,\n" +
                "                \"rank\": null,\n" +
                "                \"ww3\": null,\n" +
                "                \"pr01\": \"0.6\",\n" +
                "                \"ww1\": null,\n" +
                "                \"rh\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"pr03\": null,\n" +
                "                \"hours\": 16,\n" +
                "                \"rank\": null,\n" +
                "                \"ww3\": null,\n" +
                "                \"pr01\": \"0.6\",\n" +
                "                \"ww1\": null,\n" +
                "                \"rh\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"pr03\": null,\n" +
                "                \"hours\": 17,\n" +
                "                \"rank\": null,\n" +
                "                \"ww3\": null,\n" +
                "                \"pr01\": \"0.6\",\n" +
                "                \"ww1\": null,\n" +
                "                \"rh\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"pr03\": null,\n" +
                "                \"hours\": 18,\n" +
                "                \"rank\": null,\n" +
                "                \"ww3\": null,\n" +
                "                \"pr01\": \"0.0\",\n" +
                "                \"ww1\": null,\n" +
                "                \"rh\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"pr03\": null,\n" +
                "                \"hours\": 19,\n" +
                "                \"rank\": null,\n" +
                "                \"ww3\": null,\n" +
                "                \"pr01\": \"0.0\",\n" +
                "                \"ww1\": null,\n" +
                "                \"rh\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"pr03\": null,\n" +
                "                \"hours\": 20,\n" +
                "                \"rank\": null,\n" +
                "                \"ww3\": null,\n" +
                "                \"pr01\": \"0.0\",\n" +
                "                \"ww1\": null,\n" +
                "                \"rh\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"pr03\": null,\n" +
                "                \"hours\": 21,\n" +
                "                \"rank\": null,\n" +
                "                \"ww3\": null,\n" +
                "                \"pr01\": \"0.5\",\n" +
                "                \"ww1\": null,\n" +
                "                \"rh\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"pr03\": null,\n" +
                "                \"hours\": 22,\n" +
                "                \"rank\": null,\n" +
                "                \"ww3\": null,\n" +
                "                \"pr01\": \"0.6\",\n" +
                "                \"ww1\": null,\n" +
                "                \"rh\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"pr03\": null,\n" +
                "                \"hours\": 23,\n" +
                "                \"rank\": null,\n" +
                "                \"ww3\": null,\n" +
                "                \"pr01\": \"0.5\",\n" +
                "                \"ww1\": null,\n" +
                "                \"rh\": null\n" +
                "            },\n" +
                "            {\n" +
                "                \"pr03\": null,\n" +
                "                \"hours\": 24,\n" +
                "                \"rank\": null,\n" +
                "                \"ww3\": null,\n" +
                "                \"pr01\": \"2.1\",\n" +
                "                \"ww1\": null,\n" +
                "                \"rh\": null\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";

        //方法1
        Object o = JSONObject.fromObject(JSONObject.fromObject(str).get("data")).get("before");
        JSONArray jsonArray = JSONArray.fromObject(o);
        for (Object o1 : jsonArray) {
            JSONObject jsonObject = JSONObject.fromObject(o1);
            String precipitation = jsonObject.get("precipitation").toString();
            String observTimes = jsonObject.get("observTimes").toString();
            String stationId = jsonObject.get("stationId").toString();
            String station_Name = jsonObject.get("station_Name").toString();
            String dryBulTemp = jsonObject.get("dryBulTemp").toString();
        }

        //方法2
        JsonObject obj = new JsonParser().parse(str).getAsJsonObject();
        JsonObject data = obj.get("data").getAsJsonObject();
        JsonArray before = data.get("before").getAsJsonArray();
        for (JsonElement element : before) {
            JsonObject jo = element.getAsJsonObject();
            String s = jo.get("precipitation").getAsString();
            String observTimes = jo.get("observTimes").toString();
            String stationId = jo.get("stationId").toString();
            String station_Name = jo.get("station_Name").toString();
            String dryBulTemp = jo.get("dryBulTemp").toString();
        }

        //方法3
        com.alibaba.fastjson.JSONObject data1 = JSON.parseObject(JSON.parseObject(str).get("data").toString());
        com.alibaba.fastjson.JSONArray result = data1.getJSONArray("before");
        List<Map> maps = JSON.parseArray(result.toJSONString(), Map.class);
        for (Map map : maps) {
            String string = map.get("precipitation").toString();
            String string1 = map.get("observTimes").toString();
            String string2 =map.get("stationId").toString();
            String string3 =map.get("station_Name").toString();
            String string4 =map.get("dryBulTemp").toString();
        }
    }

}
