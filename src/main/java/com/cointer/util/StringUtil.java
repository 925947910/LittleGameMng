package com.cointer.util;




import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
	
	public static final String UTF_8 = "UTF-8";
	/**
	 * 空字符
	 */
	public static final String Empty = "";
	
	/**
	 * 流数据转换为字符串  UTF-8
	 * @param bytes
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getString(byte[] bytes) throws UnsupportedEncodingException {
		return new String(bytes,UTF_8);
	}
	
	public static byte[] getBytes(String str) throws UnsupportedEncodingException {
		return str==null?null:str.getBytes(UTF_8);
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static int getBytesLength(String str) {
		if (isEmpty(str)) {
			return 0;
		}
		return str.getBytes().length;
	}

	/**
	 * 字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if ((str == null) || ("".equals(str.trim()))) {
			return true;
		}

		return false;
	}
	
	/**
	 * 字符串不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	public static String getRegexStr(String sourceStr, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(sourceStr);
		if (m.find()) {
			return m.group(1);
		}

		return null;
	}

	public static String getCurrentTime() {
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		String time = f.format(new Date());
		return time;
	}

	public static Object removeEndChar(String object, String cha) {
		while ((isNotEmpty(object)) && (object.endsWith(cha))) {
			object = object.substring(0, object.length() - 1);
		}
		return object;
	}

	public static List<String> getRegexStrs(String sourceStr, String regex) {
		List<String> list = new ArrayList<String>();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(sourceStr);
		while (m.find()) {
			list.add(m.group(1));
		}
		return list;
	}

	public static String MD5(String sourceStr) {
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(sourceStr.getBytes());
			byte[] b = md.digest();

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				int i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			result = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e);
		}
		return result;
	}

	public static boolean isInteger(String str, Integer big, Integer small) {
		boolean returnb;
		if (isNotEmpty(str)) {
			try {
				int intStr = Integer.parseInt(str);
				if ((big.intValue() == 0) && (small.intValue() == 0)) {
					returnb = true;
				} else if ((intStr <= big.intValue()) && (intStr >= small.intValue())) {
					returnb = true;
				} else {
					returnb = false;
				}
			} catch (Exception e) {
				returnb = false;
			}
		} else {
			returnb = false;
		}

		return returnb;
	}
	public static boolean isPhone(String countrycode, String phone) {
		if(StringUtils.isBlank(phone)) {
			 return false;
		}
       //china phone
       if("+86".equals(countrycode)) {
           String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
           if (phone.length() != 11) {
               return false;
           } else {
               Pattern p = Pattern.compile(regex);
               Matcher m = p.matcher(phone);
               return m.matches();
           }
       }
       return true;
	}
	
	public static boolean MobileNumber(String nationalCode, String mobileNumber){
        boolean isMobileNumber = false;
        if (isEmpty(mobileNumber)){
            return isMobileNumber;
        }
        for (MobileRegularExp regularExp : MobileRegularExp.values()) {
            Pattern pattern = Pattern.compile(regularExp.getRegularExp());
            Matcher matcher = pattern.matcher(new StringBuilder().append(nationalCode).append(mobileNumber).toString());
            if (matcher.matches()) {
                isMobileNumber = true;
                // 枚举中把最常用的国际区号拍在前面可以减少校验开销
                break;
            }
        }
        return isMobileNumber;
    }
	
	
	/**
	 * 首字母大写
	 * @param str
	 * @return
	 */
	public static String capitalize(final String str) {
        final int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        return new StringBuffer(strLen).append(Character.toTitleCase(str.charAt(0))).append(str.substring(1)).toString();
    }
	private boolean checkEmail(String mobile) {
	    String regex = "\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
	    if (mobile.matches(regex)) {
	        return true;
	    } else {
	        return false;
	    }
	}


}

