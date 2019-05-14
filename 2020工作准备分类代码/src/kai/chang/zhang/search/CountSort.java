package kai.chang.zhang.search;

import java.util.Arrays;


//¼ÆÊýÅÅÐò
public class CountSort {

	public static void main(String args[]) {
		int a [] = new int [] {4,2,1,6,8,9,2,3};
		CountSort cs = new CountSort();
		System.out.println(Arrays.toString(cs.countSort(a)));
	}
	
	public int [] countSort(int a []) {
		int b [] = new int [a.length];
		int max = a[0];
		int min = a[0];
		for(int i:a) {
			if(i>max) {
				max = i;
			}
			if(i < min) {
				min = i;
			}
		}
		int k = max-min+1;
		int c [] = new int [k];
		for(int i = 0; i<a.length; i++) {
			c[a[i]-min] +=1; 
		}
		for(int i = 1; i < c.length; i++) {
			c[i] = c[i] + c[i-1];
		}
		for(int i = a.length-1; i >=0; i--) {
			b[--c[a[i]-min]] = a[i];
		}
		return b;
		
	}
}
