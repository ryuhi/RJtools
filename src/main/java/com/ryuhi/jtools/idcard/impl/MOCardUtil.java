package com.ryuhi.jtools.idcard.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ryuhi.jtools.idcard.IdCardInterface;

/**
 * 中国身份证号码验证 澳门版
 * @author ryuhi<tobutatu@gmail.com>
 *
 */
public class MOCardUtil  implements IdCardInterface {
	
	private static MOCardUtil instance = new MOCardUtil();
	
	public static MOCardUtil getInstanceOf() {
		return instance;
	}
	
	private static final Pattern mopattern = Pattern.compile("^[157]\\d{6}\\([\\d]\\)$");

	/**
	 * 澳门身份证编码规则不明，待明确后再补写相应规则。
	 */
	@Override
	public boolean check(String idNumber) {
		 Matcher mo = mopattern.matcher(idNumber);
		 if(!(idNumber.length() == 8 && mo.find())) {
			 return false;
		 }
		return true;
	}
}
