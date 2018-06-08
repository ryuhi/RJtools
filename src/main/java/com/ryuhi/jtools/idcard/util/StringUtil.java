package com.ryuhi.jtools.idcard.util;

import java.util.List;

/**
 * 字符串工具
 * 
 * @author ken
 *
 */
public class StringUtil {

	/**
	 * 字符串替换，从字符串数组对应替换为新字符串数组
	 * 
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
					result = str.replaceAll(oldCond[i - 1], "");
				} else {
					result = str.replaceAll(oldCond[i - 1], newCond[i - 1]);
				}
			}
		} else if (oldCount <= newCount) {
			for (int i = 1; i <= oldCount; i++) {
				result = str.replaceAll(oldCond[i - 1], newCond[i - 1]);
			}
		}
		return result;
	}

	/**
	 * 字符串替换，从List对应替换为新List
	 * 
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
					result = str.replaceAll(oldCond.get(i - 1), "");
				} else {
					result = str.replaceAll(oldCond.get(i - 1), newCond.get(i - 1));
				}
			}
		} else if (oldCount <= newCount) {
			for (int i = 1; i <= oldCount; i++) {
				result = str.replaceAll(oldCond.get(i - 1), newCond.get(i - 1));
			}
		}
		return result;
	}

	/**
	 * 字符串替换，从字符串数组对应替换为新字符串
	 * 
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

	/**
	 * 半角和全角转换函数
	 * 
	 * @param String str 欲转换的字符串
	 * @param short flag 标志，如果是0,则是半角到全角；如果是1，则是全角到半角
	 * @return String
	 */
	public static String full2half(String str, short flag) {
		String[] full = { "０", "１", "２", "３", "４", "５", "６", "７", "８", "９", "Ａ", "Ｂ", "Ｃ", "Ｄ", "Ｅ", "Ｆ", "Ｇ", "Ｈ", "Ｉ",
				"Ｊ", "Ｋ", "Ｌ", "Ｍ", "Ｎ", "Ｏ", "Ｐ", "Ｑ", "Ｒ", "Ｓ", "Ｔ", "Ｕ", "Ｖ", "Ｗ", "Ｘ", "Ｙ", "Ｚ", "ａ", "ｂ", "ｃ", "ｄ",
				"ｅ", "ｆ", "ｇ", "ｈ", "ｉ", "ｊ", "ｋ", "ｌ", "ｍ", "ｎ", "ｏ", "ｐ", "ｑ", "ｒ", "ｓ", "ｔ", "ｕ", "ｖ", "ｗ", "ｘ", "ｙ",
				"ｚ", "－", " ", "：", "．", "，", "／", "％", "＃", "！", "＠", "＆", "（", "）", "＜", "＞", "＂", "＇", "？", "［", "］",
				"｛", "｝", "＼", "｜", "＋", "＝", "＿", "＾", "￥", "￣", "｀" };
		String[] half = { // 半角
				"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
				"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f",
				"g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "-",
				" ", ":", ".", ",", "/", "%", "#", "!", "@", "&", "(", ")", "<", ">", "\"", "\'", "?", "[", "]", "{",
				"}", "\\", "|", "+", "=", "_", "^", "$", "~", "`" };
		String result = null;
		switch (flag) {
		case 0:
			result = StringUtil.StrReplace(half, full, str); // 半角到全角
			break;

		case 1:
			result = StringUtil.StrReplace(full, half, str); // 全角到半角
			break;

		default:
			result = str;
		}
		return result;
	}
}
