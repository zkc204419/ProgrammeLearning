package kai.chang.zhang.search;
/*
 * ���ֲ����㷨���ùؼ�����������м����Ƚϣ�
 * ����ؼ���С���м���������м��������������ң�
 * ����ؼ��ִ����м���������м������Ҳ�������ҡ�
 * 
 *�������Ѿ��ź��������
 */

public class BinarySearch {
	public static void main(String args[]) {
		int a [] = new int [] {1,2,3,4,5,6,7,8}; 
		BinarySearch b = new BinarySearch();
		System.out.println(b.binarySearch(a,3,0,7));
	}
	
	
	
	//���ֲ��ҵݹ�汾
	public int binarySearch(int a [], int value, int low, int high) {
		int mid = (low + high)/2;
		if(a[mid] == value) {
			return mid;
		}
		if(a[mid] > value && low<mid) {
			return binarySearch(a,value,low,mid-1);
		}
		if(a[mid] < value && mid<high) {
			return binarySearch(a,value,mid+1,high);
		}
		return -1;
	}
	
	
	
	public boolean binarySearch(int [] array , int des) {
		int low = 0;
		int high = array.length - 1;
		while(low <= high) {
			/*
			 * ��mid = low+(value-a[low])/(a[high]-a[low])*(high-low)ʱ
			 * ���ֲ��Ҿͱ���˲�ֵ���ң����ڹؼ��ֲַ��ȽϾ��ȵĲ��ұ���˵����ֵ�����㷨��ƽ�����ܱ�
			 * ���ֲ���Ҫ�úܶࡣ��������[1,2,3,4,5,6],����5ʱ����4��ʼ���ҡ�
			 */
			
			int mid = (low+high)/2;
			if( array[mid] == des)
				return true;
			else if(des < array[mid])
				high = mid - 1;
			else if(des > array[mid])
				low = mid + 1;
		}
		return false;
	}


	public boolean Find(int target, int [][] array) {
	    int len = array.length;
		for(int i = 0; i < len; i++) {
			boolean flag = binarySearch(array[i],target);
			if(flag)
				return true;
		}
		return false;

	}
}





