package kai.chang.zhang.sort;

/*ð������
 * ��С�������� 
 * 
 * �����������£�
 * 1���������еĸ������ݣ����˱Ƚ�����Ԫ�صĴ�С
 * 2�����ǰ������ݴ��ں�������ݣ��ͽ������������ݡ�
 * 3����ͬ���ķ�����ʣ�������������бȽϣ�������Եõ���С��������õ����������
 * ȱ�㣺��n����������ʱ������Դ��������˳�򣬶���Ҫ����n-1�����м�����һ�ָĽ���������ÿ������ǰ����Ƿ��Ѿ�����
 */

import java.util.Arrays;
public class BubbleSort {

	public static void main(String[] args) {
		int [] arr = new int [] {1,2,3,4,5,6};
		BubbleSort b = new BubbleSort();
		System.out.println(Arrays.toString(b.bubbleSort(arr)));
		System.out.println(Arrays.toString(b.bubbleSort_new(arr)));
	}
	
	//����ð������
	public int [] bubbleSort(int [] arr) {
		int len = arr.length;
		int temp = 0;
		for(int i = 1; i < len; i++) {
			for(int j = 0; j < len-i; j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			System.out.println("����ð������Ƚϴ���" + i);
			
		}
		
		return arr;
	}
	
	//�Ľ�ð������
	public int [] bubbleSort_new(int [] arr) {
		int len = arr.length;
		int temp = 0;
		for(int i = 1; i < len; i++) {
			boolean flag= true;
			for(int j = 0; j < len-i; j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					flag = false;
				}
			}
			System.out.println("�Ľ���ð������Ƚϴ���Ϊ�� " + i);
			if(flag) {
				break;
			}
		}
		return arr;
	}
}
