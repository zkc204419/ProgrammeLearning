package kai.chang.zhang.Jian_Zhi_Offer;

//替换字符串中的每个空格为“%20”
//小心给定的字符串为：“   ”，此时输出应为“%20%20%20”
public class ReplaceSpace {
	public String replaceSpace(StringBuffer str) {
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				str.replace(i, i+1, "%20");
			}
		}
		return new String(str);
	}
}
