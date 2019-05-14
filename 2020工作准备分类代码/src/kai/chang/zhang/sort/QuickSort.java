package kai.chang.zhang.sort;
import java.util.Arrays;

//���������㷨��ð�������㷨���ƣ����ǻ��ڽ��������˼�롣
//���������㷨��ð�������㷨�����˸Ľ����Ӷ����и��ߵ�ִ��Ч�ʡ�

/*
 * ���������㷨ͨ����αȽϺͽ�����ʵ�������������������£�
 * 1��������һ���ֽ�ֵ��ͨ���÷ֽ�ֵ�������Ϊ���������֡�
 * 2�������ڵ��ڷֽ�ֵ�����ݼ��е�������ұߣ�С�ڷֽ�ֵ�����ݼ��е��������ߣ���ʱ����߲����и�Ԫ�ض�С�ڵ��ڷֽ�ֵ��
 * 		���ұ߲����и�Ԫ�ض����ڵ��ڷֽ�ֵ��
 * 3��Ȼ����ߺ��ұ����ݿ��Զ������򣬶����������ݿ���ȡһ���ֽ�ֵ�����ò������ݷ�Ϊ���������֣�ͬ������߷��ý�Сֵ���ұ߷��ýϴ�ֵ��
 * 		�ұߵ���������Ҳ���������ƴ���
 * 4���ظ��������̣����Կ���������һ���ݹ鶨�塣ͨ���ݹ齫��ಿ������ú��ٵݹ��ź��Ҳಿ�ֵ�˳�򡣵����������ָ�����������ɺ���������
 * 		������Ҳ������ˡ�
 */
/*
 * ���ٲ�������
 * ��С��������
 */

public class QuickSort {

	public int []  quickSort_zixie(int [] a, int left, int right) {
		int l = left;
		int r = right;
		int midindex = (left+right)/2;
		int temp = a[midindex];
		while(left < right) {
			while(a[left]<temp) {
				left++;
			}
			while(a[right]>temp) {
				right--;
			}
			if(left<right) {
				int t = a[left];
				a[left] = a[right];
				a[right] = t;
				left++;
				right--;
			}
		}
		if(l<midindex-1) {
			quickSort(a,l,midindex-1);
		}
		if(midindex+1<r) {
			quickSort(a,midindex+1,r);
		}
		return a;
	}
	
	
	public static void main(String args[]) {
		QuickSort q = new QuickSort();
		int arr [] = new int [] {2,4,6,3,1};
	//	q.quickSort_zixie(arr, 0, 4);
		q.quickSort(arr, 0, 4);
		System.out.println(Arrays.toString(arr));
	}
	
	public void quickSort(int arr[], int low, int high) {
		if(low < high) {
			int middle  = Partition( arr, low ,high);
			quickSort(arr,low,middle-1);
			quickSort(arr,middle+1,high);
		}
	}
	public int Partition(int arr [], int low, int high) {
		int key = arr[low];
		while(low < high) {
			while(low < high && arr[high]>=key) {
				high--;
			}
			arr[low] = arr[high];
			while(low < high && arr[low]<=key) {
				low++;
			}
			arr[high] = arr[low];
		}
		arr[low] = key;
		return low;
	}
}
	
	

