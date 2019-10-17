package com.doing.in2019.in07.in24.working;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

	// redis数据解析
	public <T> T jsonToObject(String jsonStr)throws Exception{
		T genericity = null;
		jsonStr = "{\"edges\":[\"test1\":\"test1\",\"test2\":\"test2\",\"test3\":\"test3\"]}";
        JSONObject json = JSONObject.parseObject(jsonStr);
        JSONArray array = json.getJSONArray("edges");
	    for (int i = 0; i < array.size(); i++) {
	    	//JSONObject jo = array.getJSONObject(i);
	    	/*Chain chain = new Chain();
	    	Edge edge = new edge();
	    	JSONObject edge = jo.getJSONObject("test1");
	    	edge.setPayVertexId(jo.getLong("test2"));
	    	edge.setRcvPosition(jo.getInteger("test3"));
	    	edge.setRcvVertexId(jo.getString("test4"));
	    	chain.setChainType(jo.getString("test5").charAt(0));
	    	chain.setExpenseRate(jo.getFloat("test6"));*/
        }
        return genericity;   
    }
	
	/*// 解析前端传的数据，格式：对象 UserDTO，需要解析 UserDTO.getFriendList
	public <T> List<T> analysisJson(UserDTO user){
		List<T> list = new ArrayList<>(); 
		String json = "\"friendList\":" + user.getFriendList();			// 自己拼json字符串
		JSONObject payListJson = JSONObject.parseObject("{"+json+"}");	// 再拼一次
		JSONArray array = payListJson.getJSONArray("friendList");
	    for (int i = 0; i < array.size(); i++) {
	    	JSONObject jo = array.getJSONObject(i);
	    	Chain chain = new Chain();
	    	Edge edge = new edge();
	    	JSONObject edge = jo.getJSONObject("test1");
	    	edge.setPayVertexId(jo.getLong("test2"));
	    	edge.setRcvPosition(jo.getInteger("test3"));
	    	edge.setRcvVertexId(jo.getString("test4"));
	    	chain.setChainType(jo.getString("test5").charAt(0));
	    	chain.setExpenseRate(jo.getFloat("test6"));
        }
        return list;  
	}*/
}
