package com.ryuhi.jtools.idcard;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 中国身份证号码验证 含大陆、香港、澳门
 * 
 * @author ryuhi<tobutatu@gmail.com>
 */
public enum IdCardUtilFactory {

	INSTANCE;

	private static final String ACTION = "check";

	public boolean check(String idNumber) {
		boolean result = false;
		String[] region = new String[] {"PRC","HK","MO"};
		try {
			for (String str : region) {
				String util = this.getClass().getPackage().getName() + ".impl." + str + "CardUtil";
				Class<?> cls = Class.forName(util);
				Object obj = cls.newInstance();// 获得类的实例
				Method[] methods = cls.getDeclaredMethods();
				Method md = null;
				for (Method m : methods) {
					if (ACTION.equals(m.getName())) {
						md = m;
						break;
					}
				}
				result = (boolean) md.invoke(obj, idNumber);
				if (result) {
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
}