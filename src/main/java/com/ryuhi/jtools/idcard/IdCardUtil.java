package com.ryuhi.jtools.idcard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ryuhi.jtools.idcard.impl.HKCardUtil;
import com.ryuhi.jtools.idcard.impl.MOCardUtil;
import com.ryuhi.jtools.idcard.impl.PRCCardUtil;
import com.ryuhi.jtools.idcard.util.StringUtil;

/**
 * 中国身份证号码验证 含大陆、香港、澳门
 * @author ryuhi<tobutatu@gmail.com>
 */
public class IdCardUtil {
	
	private static IdCardUtil instance = new IdCardUtil();
	
	public static IdCardUtil getInstanceOf() {
		return instance;
	}
	
	/**
	 * 验证身份证号码是否正确
	 * @param idNumber
	 * @return
	 * @throws Exception
	 */
	public boolean check(String idNumber) throws Exception {
		if (idNumber == null) {
			throw new Exception("身份证号码为空！");
		}
		idNumber = full2half(idNumber,(short)1).trim().toUpperCase();
		Pattern hkpattern = Pattern.compile("^[A-Z]{1,2}\\d{6}\\([A0-9]\\)$");
		Pattern mopattern = Pattern.compile("^[157]\\d{6}\\([\\d]\\)$");
		Pattern prcPattern = Pattern.compile("^[1-9]\\d{16}[X0-9]$");
		Matcher prc = prcPattern.matcher(idNumber);
		Matcher hk = hkpattern.matcher(idNumber);
		Matcher mo = mopattern.matcher(idNumber);
        if (idNumber.length() == 18 && prc.find()) {
            return PRCCardUtil.getInstanceOf().check(idNumber);
        } else if ((idNumber.length() == 8 || idNumber.length() == 9) && hk.find()) {
            return HKCardUtil.getInstanceOf().check(idNumber);
        } else if(idNumber.length() == 8 && mo.find()) {
            return MOCardUtil.getInstanceOf().check(idNumber);
        } else {
        	throw new Exception("身份证号不正确");
        }
	}
	
	/**
     * 半角和全角转换函数
     * @param String str 欲转换的字符串
     * @param short flag 标志，如果是0,则是半角到全角；如果是1，则是全角到半角
     * @return String
     */
    public String full2half(String str, short flag) {
        String[] full = {
                "０", "１", "２", "３", "４", "５", "６", "７", "８", "９", "Ａ", "Ｂ", "Ｃ", "Ｄ", "Ｅ", "Ｆ", "Ｇ", "Ｈ", "Ｉ", "Ｊ", "Ｋ", "Ｌ", "Ｍ", "Ｎ", "Ｏ",
                "Ｐ", "Ｑ", "Ｒ", "Ｓ", "Ｔ", "Ｕ", "Ｖ", "Ｗ", "Ｘ", "Ｙ", "Ｚ", "ａ", "ｂ", "ｃ", "ｄ", "ｅ", "ｆ", "ｇ", "ｈ", "ｉ", "ｊ", "ｋ", "ｌ", "ｍ", "ｎ",
                "ｏ", "ｐ", "ｑ", "ｒ", "ｓ", "ｔ", "ｕ", "ｖ", "ｗ", "ｘ", "ｙ", "ｚ", "－", "　", "：", "．", "，", "／", "％", "＃", "！", "＠", "＆", "（", "）",
                "＜", "＞", "＂", "＇", "？", "［", "］", "｛", "｝", "＼", "｜", "＋", "＝", "＿", "＾", "￥", "￣", "｀"
        };
        String[] half = {//半角
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y",
                "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "-", " ", ":", ".", ",", "/", "%", "#", "!", "@", "&", "(", ")",
                "<", ">", "\"", "\'", "?", "[", "]", "{", "}", "\\", "|", "+", "=", "_", "^", "$", "~", "`"
        };
        String result = null;
        switch  (flag) {
            case 0:
            	result = StringUtil.StrReplace(half, full, str);  //半角到全角
                break;
                
            case 1:
            	result = StringUtil.StrReplace(full, half, str);  //全角到半角
                break;
                
            default:
            	result = str;
        }
        return result;
    }


}
