package com.common.utils;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

    protected static final String[] ASCII_TABLE = { "!", "\"", "#", "$", "%", "&", "\'", "(", ")", "*", "+", ",", "-",
	    ".", "/", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ":", ";", "<", "=", ">", "?", "@", "A", "B",
	    "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
	    "X", "Y", "Z", "[", "\\", "]", "^", "_", "`", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
	    "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "{", "|", "}", "~", " " };
    protected static final String[] BIG5_TABLE = { "！", "”", "＃", "＄", "％", "＆", "’", "（", "）", "＊", "＋", "，", "－", "．",
	    "／", "０", "１", "２", "３", "４", "５", "６", "７", "８", "９", "：", "；", "＜", "＝", "＞", "？", "＠", "Ａ", "Ｂ", "Ｃ",
	    "Ｄ", "Ｅ", "Ｆ", "Ｇ", "Ｈ", "Ｉ", "Ｊ", "Ｋ", "Ｌ", "Ｍ", "Ｎ", "Ｏ", "Ｐ", "Ｑ", "Ｒ", "Ｓ", "Ｔ", "Ｕ", "Ｖ", "Ｗ", "Ｘ",
	    "Ｙ", "Ｚ", "〔", "＼", "〕", "︿", "＿", "｀", "ａ", "ｂ", "ｃ", "ｄ", "ｅ", "ｆ", "ｇ", "ｈ", "ｉ", "ｊ", "ｋ", "ｌ", "ｍ",
	    "ｎ", "ｏ", "ｐ", "ｑ", "ｒ", "ｓ", "ｔ", "ｕ", "ｖ", "ｗ", "ｘ", "ｙ", "ｚ", "｛", "｜", "｝", "～", "　" };

    /**
     * 轉全形
     *
     * @param s
     * @return String
     */
    public static String toFullChar(String s) {
	if (s == null || "".equalsIgnoreCase(s)) {
	    return "";
	}

	char[] ca = s.toCharArray();
	StringBuilder outStr = new StringBuilder();

	for (int a = 0; a < ca.length; a++) {
	    String caStr = String.valueOf(ca[a]);
	    for (int b = 0; b < ASCII_TABLE.length; b++) {
		if (caStr.equals(ASCII_TABLE[b])) {
		    caStr = BIG5_TABLE[b];
		    break;
		}
	    }

	    outStr.append(caStr);
	}

	return outStr.toString();
    }

    /**
     * 轉半形
     *
     * @param s
     * @return String
     */
    public static String toHalfChar(String s) {
	if (s == null || "".equalsIgnoreCase(s)) {
	    return "";
	}

	char[] ca = s.toCharArray();
	StringBuilder outStr = new StringBuilder();

	for (int a = 0; a < ca.length; a++) {
	    String caStr = String.valueOf(ca[a]);
	    for (int b = 0; b < BIG5_TABLE.length; b++) {
		if (caStr.equals(BIG5_TABLE[b])) {
		    caStr = ASCII_TABLE[b];
		    break;
		}
	    }

	    outStr.append(caStr);
	}

	return outStr.toString();
    }
}
