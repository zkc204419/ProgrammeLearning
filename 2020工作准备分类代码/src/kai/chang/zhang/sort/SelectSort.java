package kai.chang.zhang.sort;

import java.util.Arrays;

//ѡ������
/*
 * 1�����ȴ�ԭʼ������ѡ����С��1�����ݣ�����͵�һ��λ�õ����ݽ���
 * 2�����Ŵ�ʣ�µ�n-1��������ѡ���С��һ�����ݣ�����͵ڶ���λ�õ����ݽ���
 * 3��Ȼ�󲻶��ظ��������̣�ֱ���������������ɽ��������ˣ�������˶�ԭʼ���ݵĴ�С���������
 */

public class SelectSort {


	public int []  selectSort(int [] a) {
		int index;
		int temp;
		for(int i = 0; i < a.length; i++) {
			index = i;
			//�ڲ�forѭ����Ϊ����ÿ��ѭ�����ҵ���a��index��ֵ��С��С��
			//�������Լ����м�Ľ�������
			for(int j = i+1; j< a.length; j++) {
				if(a[j]<a[index]) {
					index = j;
				}
			}
			if(index!=i) {
				temp = a[i];
				a[i] = a[index];
				a[index] = temp;
			}
		}
	return a;
	}

	
	public static void main(String args[]){
		int a [] =  new int [] {5,6,4,3,8};
		SelectSort s = new SelectSort();
		s.selectSort(a);
		System.out.println(Arrays.toString(a));

	}
	
	
}
