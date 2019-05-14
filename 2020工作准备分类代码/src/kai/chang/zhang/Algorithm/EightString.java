package kai.chang.zhang.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class EightString {

	public static void deal(ArrayList<String> list,String string) {
		String s = string;
		char [] a = new char [8];
		Arrays.fill(a, '0');
		if (s.length()<= 8) {
			for(int i = 0; i < s.length(); i++) {
				a[i] = s.charAt(i);
			}
			list.add(String.valueOf(a));
			return ;
		}
		while(s.length() > 8) {
			String temp = s.substring(0, 8);
			list.add(temp);
			s = s.substring(8);
		}
		if (s.length() > 0) {
			for(int i = 0; i < s.length(); i++) {
				a[i] = s.charAt(i);
			}
			list.add(String.valueOf(a));
		}
		return ; 
	}
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		scanner.close();
		String s [] = string.split(" ");
		ArrayList<String>list = new ArrayList<>();
		for(int i = 1; i < s.length; i++) {
			deal(list,s[i]);
		}
		Collections.sort(list);
		for(String ss : list) {
			System.out.print(ss + " ");
		}
	}
}
