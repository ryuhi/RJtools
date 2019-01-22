package com.ryuhi.jtools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class TimeUtil {

	/**
	 * 获取某一天是星期几的本地表述，如英文星期一为Monday，中文为星期一，日文为月曜日……
	 * @param str 日期的字符串，要符合yyyy-MM-dd格式
	 * @return 星期几的本地表述
	 */
	public static String getWeekName(String str) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
		LocalDate date = LocalDate.parse(str, formatter);
		String w = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.PRC);
		return w;
	}
	
	/**
	 * 获取某一天是星期几的本地表述，如英文星期一为Monday，中文为星期一，日文为月曜日……
	 * @param str 日期的字符串，要符合yyyy-MM-dd格式
	 * @param locale 区域设置对象
	 * @return 星期几的本地表述
	 */
	public static String getWeekName(String str, Locale locale) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
		LocalDate date = LocalDate.parse(str, formatter);
		String w = date.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
		return w;
	}
}