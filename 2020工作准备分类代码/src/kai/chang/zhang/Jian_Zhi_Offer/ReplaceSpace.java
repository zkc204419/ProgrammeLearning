package kai.chang.zhang.Jian_Zhi_Offer;

//�滻�ַ����е�ÿ���ո�Ϊ��%20��
//С�ĸ������ַ���Ϊ����   ������ʱ���ӦΪ��%20%20%20��
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
