package com.ryuhi.jtools.idcard.impl;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ryuhi.jtools.idcard.IdCardInterface;
import com.ryuhi.jtools.idcard.util.StringUtil;

/**
 *中国身份证号码验证 香港版
 * @author ryuhi<tobutatu@gmail.com>
 */
public class HKCardUtil  implements IdCardInterface {
	
	private static HKCardUtil instance = new HKCardUtil();
	
	public static HKCardUtil getInstanceOf() {
		return instance;
	}
	
	 private static final Pattern hkpattern = Pattern.compile("^[A-Z]{1,2}\\d{6}\\([A0-9]\\)$");

	@Override
	public boolean check(String idNumber) {
		Matcher hk = hkpattern.matcher(idNumber);
		 if (!((idNumber.length() == 8 || idNumber.length() == 9) && hk.find())) {
			 return false;
		 }
		boolean flag = true;
		String[] range = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y",
                "Z"};
		int sum = 0;
		String[] search = {"(",")"};
		idNumber = StringUtil.StrReplace(search, "", idNumber);
		String newIdNumber = new StringBuffer(idNumber).reverse().toString();
		String[] arr = newIdNumber.split("");
        int count = arr.length;
        int lastInt = 0;
        if (arr[0] == "A") {
            lastInt = 10;
        } else {
            lastInt = Integer.parseInt(arr[0]);
        }
        sum = lastInt * 1 + Integer.parseInt(arr[1]) * 2 + Integer.parseInt(arr[2]) * 3 + Integer.parseInt(arr[3]) * 4 + Integer.parseInt(arr[4]) * 5 + Integer.parseInt(arr[5]) * 6 + Integer.parseInt(arr[6]) * 7;
        int res = count -7;
        switch (res) {
            case 1:
                int index = Arrays.asList(range).indexOf(arr[count-1]) + 1;
                sum = sum + index * 8;
                break;
                
            case 2:
                int index1 = Arrays.asList(range).indexOf(arr[count-1]) + 1;
                int index2 = Arrays.asList(range).indexOf(arr[count-2]) + 1;
                sum = sum + index1 * 9 + index2 * 8;
                break;
        }
		int result = sum % 11;
		if (result != 0) {
			flag = false;
		}
		return flag;
	}

}
