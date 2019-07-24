package com.doing.in2019.in07.in24.working;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

	// redis数据解析
	public <T> T jsonToObject(String jsonStr)throws Exception{
		T genericity = null;
        JSONObject json = JSONObject.parseObject(jsonStr);
        JSONArray array = json.getJSONArray("edges");
	    for (int i = 0; i < array.size(); i++) {
	    	JSONObject jo = array.getJSONObject(i);
	    	/*Chain chain = new Chain();
	    	Edge edge = new edge();
	    	JSONObject edge = jo.getJSONObject("calLowEdgeArg");
	    	edge.setPayVertexId(jo.getLong("payVertexId"));
	    	edge.setRcvPosition(jo.getInteger("rcvPosition"));
	    	edge.setRcvVertexId(jo.getString("rcvVertexId"));
	    	chain.setChainType(jo.getString("chainType").charAt(0));
	    	chain.setExpenseRate(jo.getFloat("expenseRate"));*/
        }
        return genericity;   
    }
}
