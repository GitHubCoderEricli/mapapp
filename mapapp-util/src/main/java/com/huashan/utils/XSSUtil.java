package com.huashan.utils;

public class XSSUtil {

	/**
	 * replace all the characters that may cause XSS attack from half-width
	 * character to full-width character
	 * 
	 * @param s
	 * @return
	 */
	public static String encodeXSS(String s) {
		if (s == null || "".equals(s)) {
			return s;
		}
		StringBuilder sb = new StringBuilder(s.length() + 16);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {

			// handle the '<' and '>' which can be used for constructing
			// <script> and </script>
			case '>':
				sb.append("&gt;");
				break;
			case '<':
				sb.append("&lt;");
				break;

			// since the html can support the characters using $#number format
			// so here also need to escape '#','&' and quote symbol
			case '\'':
				sb.append("&#x27;");
				break;
			case '"':
				sb.append("&quot;");
				break;
			case '&':
				sb.append("&amp;");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '#':
				sb.append("＃");
				break;
			/*
			 * case '/': sb.append('¡¢'); break;
			 */
			// if not the special characters ,then output it directly
			default:
				sb.append(c);
				break;
			}
		}
		return sb.toString();
	}
}
