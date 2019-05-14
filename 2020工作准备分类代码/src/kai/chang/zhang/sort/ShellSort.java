package kai.chang.zhang.sort;

import java.util.Arrays;

//ϣ�����򣬶��ڴ�������ʱ��һ�ָ�Ч���򷽷�
//ϣ�������㷨�ϸ���˵���ڲ��������˼�룬�ֳ�Ϊϣ�����������С��������
/*
 * 1������n��Ԫ�ص�����ֳ�n/2���������У���1�����ݺ͵�n/2+1������Ϊһ�ԣ�������
 * 2��һ��ѭ��ʹÿһ�����ж��ź�˳��
 * 3��Ȼ���ٱ�Ϊn/4�����У��ٴ�����
 * 4�������ظ��������̣��������м�������Ϊһ����Ҳ���������������
 */

//rΪ������ÿ��Ϊa.length/2ȡ��������a.length=6,��rȡ3��1
public class ShellSort {
	
	public static void main(String args[]) {
		ShellSort ss = new ShellSort();
	    int [] a = new int [] {2,6,1,8,9,5,4};
		System.out.println(Arrays.toString(ss.shellSort(a)));
	}
	
	public int [] shellSort(int a []) {
		for(int r=a.length; r>=1; r/=2) {
			for(int i=r; i < a.length; i++) {
				int temp = a[i];
				int j = i-r;
				while(j>=0 && temp < a[j]) {
					a[j+r] = a[j];
					j = j-r;
				}
				a[j+r] = temp;
			}
		}
		return a;
	}
}
