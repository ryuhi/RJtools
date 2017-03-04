package com.ryuhi.jtools.idcard.util;

import java.util.List;

/**
 * 字符串工具
 * @author ken
 *
 */
public class StringUtil {
	
	/**
	 * 字符串替换，从字符串数组对应替换为新字符串数组
	 * @param oldCond
	 * @param newCond
	 * @param str
	 * @return
	 */
	public static String StrReplace(String[] oldCond, String[] newCond, String str) {
		String result = str;
		int oldCount = oldCond.length;
		int newCount = newCond.length;
		if (oldCount > newCount) {
			for (int i = 1; i <= oldCount; i++) {
				if (i > newCount) {
					result = str.replaceAll(oldCond[i-1], "");
				} else {
					result = str.replaceAll(oldCond[i-1], newCond[i-1]);					
				}
			}
		} else if (oldCount <= newCount) {
			for (int i = 1; i <= oldCount; i++) {
				result = str.replaceAll(oldCond[i-1], newCond[i-1]);					
			}
		} 
		return result;
	}
	
	/**
	 * 字符串替换，从List对应替换为新List
	 * @param oldCond
	 * @param newCond
	 * @param str
	 * @return
	 */
	public static String StrReplace(List<String> oldCond, List<String> newCond, String str) {
		String result = null;
		int oldCount = oldCond.size();
		int newCount = newCond.size();
		if (oldCount > newCount) {
			for (int i = 1; i <= oldCount; i++) {
				if (i > newCount) {
					result = str.replaceAll(oldCond.get(i-1), "");
				} else {
					result = str.replaceAll(oldCond.get(i-1), newCond.get(i-1));					
				}
			}
		} else if (oldCount <= newCount) {
			for (int i = 1; i <= oldCount; i++) {
				result = str.replaceAll(oldCond.get(i-1), newCond.get(i-1));					
			}
		} 
		return result;
	}
	
	/**
	 * 字符串替换，从字符串数组对应替换为新字符串
	 * @param oldCond
	 * @param newCond
	 * @param str
	 * @return
	 */
	public static String StrReplace(String[] oldCond, String newCond, String str) {
		String result = str;
		int oldCount = oldCond.length;
		for (int i = 0; i < oldCount; i++) {
			result = str.replaceAll(oldCond[i], newCond);					
		}
		return result;
	}

}
