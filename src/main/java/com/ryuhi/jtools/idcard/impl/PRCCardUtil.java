package com.ryuhi.jtools.idcard.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ryuhi.jtools.idcard.IdCardInterface;

/**
 *中国身份证号码验证 大陆版
 * @author ryuhi<tobutatu@gmail.com>
 */
public class PRCCardUtil  implements IdCardInterface {

	private static PRCCardUtil instance = new PRCCardUtil();
	
	public static PRCCardUtil getInstanceOf() {
		return instance;
	}
	
	private static final Pattern prcPattern =	 Pattern.compile("^[1-9]\\d{16}[X0-9]$");

	@Override
	public boolean check(String idNumber) {
		Matcher prc = prcPattern.matcher(idNumber);
		if (!(idNumber.length() == 18 && prc.find())) {
			return false;
		}
		boolean flag = true;
		String[] arr = idNumber.split("");
		int sum = 0;
		for (int i = 0; i< arr.length; i++) {
			if (i ==0 || i == 10) {
				sum = sum + 7 *  Integer.parseInt(arr[i]);
			} else if (i == 1 || i == 11) {
				sum = sum + 9 *  Integer.parseInt(arr[i]);
			} else if (i == 2 || i == 12) {
				sum = sum + 10 *  Integer.parseInt(arr[i]);
			} else if (i == 3 || i == 13) {
				sum = sum + 5 *  Integer.parseInt(arr[i]);
			} else if (i == 4 || i == 14) {
				sum = sum + 8 *  Integer.parseInt(arr[i]);
			} else if (i == 5 || i == 15) {
				sum = sum + 4 *  Integer.parseInt(arr[i]);
			} else if (i == 6 || i == 16) {
				sum = sum + 2 *  Integer.parseInt(arr[i]);
			} else if (i == 7) {
				sum = sum + Integer.parseInt(arr[i]);
			} else if (i == 8) {
				sum = sum + 6 *  Integer.parseInt(arr[i]);
			} else if (i == 9) {
				sum = sum + 3 *  Integer.parseInt(arr[i]);
			}
		}
        int res = sum % 11;
        int rs = 0;
        switch (res) {
            case 0:
                rs = 1;
                break;
            case 1:
                rs = 0;
                break;
            default:
                rs = 12 - res;
                break;
        }
        int compFlag = 0;
        if (arr[17].equals("X")) {
        	compFlag = 10;
        } else {
        	compFlag = Integer.parseInt(arr[17]);
        }
        if (rs != compFlag) {
            flag = false;
        }
		return flag;
	}
}
