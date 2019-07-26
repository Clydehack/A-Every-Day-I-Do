package com.doing.in2019.in07.in24.working;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HolidayAndWeek {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/** 判断是否是weekend */
	public static boolean isWeekend(String sdate) throws ParseException {
		Date date = sdf.parse(sdate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			return true;
		} else {
			return false;
		}

	}

	/** 判断是否是holiday */
	public static boolean isHoliday(String sdate, List<String> list) throws ParseException {
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (sdate.equals(list.get(i))) {
					return true;
				}
			}
		}
		return false;
	}

	/** 普通方式 支持 当天+n 还有优化空间，待思考 */
	public static Date get(String day, int plus, String time) throws ParseException {
		int i = 1;
		if(plus == 0){
			return sdfTime.parse(day + " " + time);
		}
		while(plus > 0){
			if(!isWeekend(day) && !isHoliday(day, getHoliday())){ // 如果不是节假日
				plus--;
				if(plus == 0 && !isWeekend(day) && !isHoliday(day, getHoliday())) {
					return sdfTime.parse(LocalDate.now().minusDays(-i).toString() + " " + time);
				}
			}
			day = LocalDate.now().minusDays(-i).toString();
			i++;
		}
		return null;
	}

	/** 递归方式 支持任意时间 T + n + time + 1（固定值，用于计算） */
	public static Date getDate(String day, int plus, String time, int i) throws ParseException {
		if(plus == 0 && !isWeekend(day) && !isHoliday(day, getHoliday())) {// 只有到了指定天，并且当天不是节假日时才能跳出
			return sdfTime.parse(day + " " + time);
		} else {
			if(!isWeekend(day) && !isHoliday(day, getHoliday())) {
				plus--;
			}
			i++;
			day = LocalDate.now().minusDays(-i).toString();
			return getDate(day, plus, time, i);
		}
	}

	public static List<String> getHoliday() {
		List<String> holidayList = new ArrayList<>();
		holidayList.add("2018-08-29");
		holidayList.add("2018-08-30");
		holidayList.add("2018-10-01");
		holidayList.add("2018-10-02");
		holidayList.add("2018-10-03");
		holidayList.add("2018-10-04");
		holidayList.add("2018-10-05");
		holidayList.add("2018-10-06");
		holidayList.add("2018-10-07");
		return holidayList;
	}
	
	public static void main(String[] args) throws ParseException {
		//int i = 10;
		String dd = LocalDate.now().minusDays(-1).toString();
		String today = LocalDate.now().toString();
		Date d = getDate(dd, 2, "17:00:00", 1);
//		Date d = getDate(today, 2, "17:00:00", 1);
		System.out.println(today);
		System.out.println(d);
		System.out.println(dd);
	}
}
