package person.yejing.wordtemplate.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataFrame {
    public static List<Map<String, Object>> funds = new ArrayList<>();

    static{
        Map<String, Object> map1 = new HashMap<>();
        map1.put("item1", "来源预算合计");
        map1.put("item2", "100");
        map1.put("item3", "支出预算合计");
        map1.put("item4", "100");
        map1.put("item5", "0.0");
        map1.put("item6", "100");
        funds.add(map1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("item1", "一、甲方拨款");
        map2.put("item2", "100");
        map2.put("item3", "一、直接费");
        map2.put("item4", "74.824");
        map2.put("item5", "0.0");
        map2.put("item6", "74.824");
        funds.add(map2);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("item1", "二、国家其他拨款");
        map3.put("item2", "0.0");
        map3.put("item3", "1.人工费");
        map3.put("item4", "39.28");
        map3.put("item5", "0.0");
        map3.put("item6", "39.28");
        funds.add(map3);

        Map<String, Object> map4 = new HashMap<>();
        map4.put("item1", "三、地方政府拨款");
        map4.put("item2", "0.0");
        map4.put("item3", "2.设备费");
        map4.put("item4", "0.0");
        map4.put("item5", "0.0");
        map4.put("item6", "0.0");
        funds.add(map4);

        Map<String, Object> map5 = new HashMap<>();
        map5.put("item1", "四、上级单位拨款");
        map5.put("item2", "0.0");
        map5.put("item3", "3.材料费");
        map5.put("item4", "0.0");
        map5.put("item5", "0.0");
        map5.put("item6", "0.0");
        funds.add(map5);

        Map<String, Object> map6 = new HashMap<>();
        map6.put("item1", "五、自筹款");
        map6.put("item2", "0.0");
        map6.put("item3", "4.测试化验加工费");
        map6.put("item4", "15.874");
        map6.put("item5", "0.0");
        map6.put("item6", "15.874");
        funds.add(map6);

        Map<String, Object> map7 = new HashMap<>();
        map7.put("item1", "六、银行贷款");
        map7.put("item2", "0.0");
        map7.put("item3", "5.燃料动力费");
        map7.put("item4", "0.0");
        map7.put("item5", "0.0");
        map7.put("item6", "0.0");
        funds.add(map7);

        Map<String, Object> map8 = new HashMap<>();
        map8.put("item1", "七、其它来源");
        map8.put("item2", "0.0");
        map8.put("item3", "6.差旅费/会议费/国际合作交流费");
        map8.put("item4", "7.07");
        map8.put("item5", "0.0");
        map8.put("item6", "7.07");
        funds.add(map8);

        Map<String, Object> map9 = new HashMap<>();
        map9.put("item1", "");
        map9.put("item2", "");
        map9.put("item3", "7.出版/文献/信息传播/知识产权事务费");
        map9.put("item4", "5.35");
        map9.put("item5", "0.0");
        map9.put("item6", "5.35");
        funds.add(map9);

        Map<String, Object> map10 = new HashMap<>();
        map10.put("item1", "");
        map10.put("item2", "");
        map10.put("item3", "8.专家咨询费");
        map10.put("item4", "7.25");
        map10.put("item5", "0.0");
        map10.put("item6", "7.25");
        funds.add(map10);

        Map<String, Object> map11 = new HashMap<>();
        map11.put("item1", "");
        map11.put("item2", "");
        map11.put("item3", "二、间接费");
        map11.put("item4", "9.8");
        map11.put("item5", "0.0");
        map11.put("item6", "9.8");
        funds.add(map11);

        Map<String, Object> map12 = new HashMap<>();
        map12.put("item1", "");
        map12.put("item2", "");
        map12.put("item3", "三、外委支出费");
        map12.put("item4", "9.34");
        map12.put("item5", "0.0");
        map12.put("item6", "9.34");
        funds.add(map12);

        Map<String, Object> map13 = new HashMap<>();
        map13.put("item1", "");
        map13.put("item2", "");
        map13.put("item3", "四、税金");
        map13.put("item4", "6.036");
        map13.put("item5", "0.0");
        map13.put("item6", "6.036");
        funds.add(map13);

    }
}
