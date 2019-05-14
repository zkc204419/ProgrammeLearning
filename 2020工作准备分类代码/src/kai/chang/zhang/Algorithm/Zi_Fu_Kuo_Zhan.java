package kai.chang.zhang.Algorithm;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
/*
 *输入格式为abc2(A)
 *输出应为AAAcba
 */
public class Zi_Fu_Kuo_Zhan {

	public static char pei_dui(char c) {
		if (c == '}')
			return '{';
		else if(c == ']')
			return '[';
		else 
			return '(';
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(s);
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c!='}' && c!=']' && c!=')') {
				stack.push(c);
			}
			else {
				String result = "";
				char pei_c = pei_dui(c);
				char temp = stack.pop();
				result = temp + result;
				while((!stack.empty()) && (temp = stack.pop())!=pei_c) {
					result = temp + result;
				}
				String num_temp = "";
				while(!stack.empty()) {
					temp = stack.peek();
					if('0'<=temp && temp<='9') {
						num_temp = temp + num_temp;
						stack.pop();
					}
					else {
						break;
					}
				}
				int num = Integer.parseInt(num_temp);
				String temp_2 = "";
				for(int j = 0; j < num; j++) {
					temp_2 = result + temp_2;
				}
				int len = temp_2.length();
				for(int j = 0; j < len; j++) {
					stack.push(temp_2.charAt(j));
				}
			}
		}
		String ss = "";
		while(!stack.empty()) {
			System.out.print(stack.pop());
		}
	}
}

