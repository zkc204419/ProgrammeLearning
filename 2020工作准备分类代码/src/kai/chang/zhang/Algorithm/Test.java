package kai.chang.zhang.Algorithm;

import java.util.Scanner;
import java.util.Set;
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;


import java.util.Queue;
import java.awt.print.Printable;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Test{
	public int[] sort(int a[],int max) {
		int b [] = new int [max+1];
		for(int i = 0, len = a.length; i < len; i++) {
			b[a[i]]++;
		}
		return b;
	}
	
	public void print(int b[]) {
		for(int i = 0,len = b.length; i < len; i++) {
			int temp = b[i];
//			System.out.println(" i == " + i + " b[i] == " + b[i]);
			for(int j = 1; j <= temp; j++) {
				System.out.print(i + " ");
			}
		}
	}
	
	public static void main(String args[]) {
		int a [] = {1,2,4,7,3,1,3,9,10};
		Test test = new Test();
		int b [] = test.sort(a, 10);
		test.print(b);
	}
	
}























	
	
	
	
