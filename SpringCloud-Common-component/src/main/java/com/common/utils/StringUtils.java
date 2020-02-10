package com.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

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

    /**
     * 根據分隔子切割字串
     *
     * <pre>
     * StringUtils.getTokens(null, *)         	= []
     * StringUtils.getTokens("", *)           	= []
     * StringUtils.getTokens("abc def", null) 	= ["abc", "def"]
     * StringUtils.getTokens("abc def", " ")  	= ["abc", "def"]
     * StringUtils.getTokens("abc  def", " ") 	= ["abc", "def"]
     * StringUtils.getTokens("ab:cd:ef", ":") 	= ["ab", "cd", "ef"]
     * StringUtils.getTokens("ab:cd:ef:", ":") = ["ab", "cd", "ef", ""]
     * </pre>
     *
     * @param sData   原始字串
     * @param iLength 切割的長度(byte)
     * @return 切割後的字串陣列，永不為NULL
     */
    public static String[] getTokens(String sData, String sDelim) {

	if (null == sData) {
	    return ArrayUtils.EMPTY_STRING_ARRAY;
	}

	List<String> tokens = new ArrayList<>();

	int iDataLen = sData.length();
	int iDelimLen = sDelim.length();

	int iLeft = 0;
	int iRight = sData.indexOf(sDelim);

	while (iRight >= 0) {

	    String sToken = sData.substring(iLeft, iRight).trim();
	    tokens.add(sToken);
	    iLeft = iRight + iDelimLen;
	    iRight = sData.indexOf(sDelim, iLeft);
	}

	if (iLeft < iDataLen) {
	    String sToken = sData.substring(iLeft, iDataLen);
	    tokens.add(sToken);
	}

	// 取最後一個token，如果為delim則加入一個空白("")token
	if (iDataLen >= iDelimLen) {
	    String sLastToken = sData.substring(iDataLen - iDelimLen, iDataLen);

	    if (sLastToken.equals(sDelim)) {
		tokens.add("");
	    }
	}
	return tokens.toArray(new String[tokens.size()]);

    }
}
