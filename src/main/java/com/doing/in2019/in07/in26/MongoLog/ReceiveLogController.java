package com.doing.in2019.in07.in26.MongoLog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("日常come on")
public class ReceiveLogController {
	
	@Autowired MongoTemplate mongoTemplate;
	
	@RequestMapping("sysnLog")
	public String sysnLog(HttpServletRequest request, HttpServletResponse response){
		String jsonStr = request.getParameter("log");
		mongoTemplate.insert(jsonStr, "user_log");
		return "ok";
	}
	
	@RequestMapping("queryLog")
	public String queryLog(HttpServletRequest request, HttpServletResponse response){
		String userId = request.getParameter("userId");
		// 聚合用户日志，每天一个块，
		//mongoTemplate.mapReduce(domainType);
		return "ok";
	}
}
