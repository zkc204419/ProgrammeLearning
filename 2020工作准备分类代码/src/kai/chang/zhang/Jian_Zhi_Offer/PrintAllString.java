package kai.chang.zhang.Jian_Zhi_Offer;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 输入一个字符串，按照字典序打印出该字符串中字符的
 * 所有排列，例如"abc":则所有排列为：abc,acb,bac,bca,cab,cba;
 */
public class PrintAllString{
	
	public ArrayList<String> Permutation(String str){
		ArrayList<String>list = new ArrayList<>();
		if(str == null || str.length() == 0)
			return list;
		char [] chars = str.toCharArray();
		Arrays.sort(chars);
		list.add(String.valueOf(chars));
		int len = chars.length;
		while(true) {
			int sindex = len-1;
			int tempindex;
			while(sindex>=1 && chars[sindex-1]>=chars[sindex]) {
				sindex--;
			}
			if(sindex == 0)
				break;
			tempindex = sindex;
			while(tempindex<len && chars[tempindex]>chars[sindex-1]) {
				tempindex++;
			}
			swap(chars, sindex-1, tempindex-1);
			reverse(chars, sindex);
			list.add(String.valueOf(chars));
		}
		return list;
		
	}
	
	public static void reverse(char [] chars, int k) {
		if(chars == null || chars.length == 0)
			return ;
		int len = chars.length;
		for(int i = k, j = len-1; i < len; i++) {
			if(i <= j) {
				swap(chars,i,j);
				j--;
			}
			else {
				break;
			}
		}
	}
	
	public static void swap(char [] chars,int m, int n) {
		char temp = chars[m];
		chars[m]= chars[n];
		chars[n] = temp;
	}



	public static void main(String args[]) {
		char chars [] = new char [] {'a','b','c','d','e'};
		String string = String.valueOf(chars);
		System.out.println(string);
		reverse(chars, 1);
		System.out.println(Arrays.toString(chars));
	}
}
