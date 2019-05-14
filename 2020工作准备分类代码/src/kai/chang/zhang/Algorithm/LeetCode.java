package kai.chang.zhang.Algorithm;

import java.util.Arrays;

public class LeetCode {

	//�����һ�ε��������������������Σ�
	//ʹ�����
	public int singleNum(int [] a) {
		int result = 0;
		for(int i = 0; i < a.length; i++) {
			result = result ^ a[i];
		}
		return result;
	}
	
	//������
	//Ħ��ͶƱ��
	public int  majorityElement(int [] nums) {
		int temp = 0, count = 0;
		for(int num: nums) {
			if(count == 0) {
				temp = num;
				count++;
			}
			else if(num == temp) {
				count++;
			}
			else
				count--;
		}
		return temp;
	}
	
	//������ά����
	//����һ����ÿһ�н��ж��ֲ���
	//�������������㷨
	/*
	 *�㷨���������½ǵ�Ԫ������һ������С��Ԫ�أ�ͬʱ������һ��������Ԫ�ء��Ƚ����½�Ԫ�غ�Ŀ�꣺ 
	 *�����½�Ԫ�ص���Ŀ�꣬���ҵ������½�Ԫ�ش���Ŀ�꣬��Ŀ�겻���ܴ����ڵ�ǰ��������һ�У������ģ���Լ�СΪ��ȥ�����һ�е��Ӿ�����Ѱ��Ŀ��
     *�����½�Ԫ��С��Ŀ�꣬��Ŀ�겻���ܴ����ڵ�ǰ����ĵ�һ�У������ģ���Լ�СΪ��ȥ����һ�е��Ӿ�����Ѱ��Ŀ�꣬��
     *�������СΪ�գ���˵��������
	 */
	public boolean searchMatrix(int a [][], int target) {
		int m = a.length;
		int n = a[0].length;
		int i = m-1,j = 0;
		while(i >= 0 && j <n) {
			if(a[i][j] == target) {
				return true;
			}
			else if(a[i][j]<target) {
				j++;
			}
			else {
				i--;
			}
		}
		return false;
	}
	
	//���������������������������������洢�ڵ�һ��������
	//num1[1,2,3,0,0],num2[4,5];
	//���������飬��Ϊ�м�ת������
	//m,n�ֱ�Ϊ�����ڵ�Ԫ������
	public int [] merge(int []num1, int m, int [] num2, int n) {
		int temp [] = new int [m+n];
		int i = 0, j = 0,k = 0;
		while(i < m && j < n) {
			if(num1[i] <= num2[j]) {
				temp[k++] = num1[i++];
			}
			else {
				temp[k++] = num2[j++];
			}
			while(i < m) {
				temp[k++] = num1[i++];
			}
			while(j < n) {
				temp[k++] = num2[j++];
			}
		}
		return temp;
	}
	
	//���ÿ��������飬ֱ�ӴӺ���ǰ�Ƚϲ���
	public int [] merge(int num1[], int []num2, int m, int n) {
		int k = m + n;
		while(m > 0 && n > 0) {
			if(num1[m-1] >= num2[n-1]) {
				num1[k-1] = num1[m-1];
				k--;
				m--;
			}
			else {
				num1[k-1] = num2[n-1];
				k--;
				n--;
			}
		}
		while(n>0) {
			num1[k-1] = num2[n-1];
			k--;
			n--;
		}
		return num1;
	}
	
	public static void main(String args[]) {
		int num1 [] = new int []{1,2,3,4,0,0,0};
		int num2 [] = new int [] {5,6,7};
		LeetCode l = new LeetCode();
		System.out.println(Arrays.toString(l.merge(num1, num2, 4, 3)));
	}
}















