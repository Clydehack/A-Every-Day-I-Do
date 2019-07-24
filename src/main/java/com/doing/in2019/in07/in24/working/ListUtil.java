package com.doing.in2019.in07.in24.working;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListUtil {

	// 将两个list<map>不相等的数据取出来
	public List<Map<String, Object>> listMapIsEqual(List<Map<String, Object>> list1, List<Map<String, Object>> list2) {
		List<Map<String, Object>> listMap = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		// 两个循环比较不同，不同的数据装箱向上返回
		// 外循环
		for(Map<String, Object> amtMap:list1) {
			// 内循环
	    	for(Map<String, Object> queryMap:list2) {
	    		if(amtMap.get("payUserId").equals(queryMap.get("payUserId"))) {// 如果应付账目相等
	    			if(!amtMap.get("mayPayAmount").equals(queryMap.get("mayPayAmount"))) {// 但是金额已修改，修改的数据全部都
	    				map.put("payUserId", amtMap.get("payUserId"));
	    		    	map.put("payName", amtMap.get("payName"));
	    		    	map.put("mayPayAmount", amtMap.get("mayPayAmount"));
	    		    	listMap.add(map);
	    			}
	    		}
	    	}
		}
		return listMap;
	}
}
