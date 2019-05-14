package kai.chang.zhang.sort;
import java.util.Arrays;

//快速排序算法和冒泡排序算法类似，都是基于交换排序的思想。
//快速排序算法对冒泡排序算法进行了改进，从而具有更高的执行效率。

/*
 * 快速排序算法通过多次比较和交换来实现排序，其排序流程如下：
 * 1、首先设一个分界值，通过该分界值将数组分为左右两部分。
 * 2、将大于等于分界值的数据集中到数组的右边，小于分界值的数据集中到数组的左边，此时，左边部分中各元素都小于等于分界值，
 * 		而右边部分中各元素都大于等于分界值。
 * 3、然后，左边和右边数据可以独立排序，对于左侧的数据可以取一个分界值，将该部分数据分为左右两部分，同样将左边放置较小值，右边放置较大值。
 * 		右边的数组数据也可以做类似处理
 * 4、重复上述过程，可以看出，这是一个递归定义。通过递归将左侧部分排序好后，再递归排好右侧部分的顺序。当左右两部分各数据排序完成后，整个数组
 * 		的排序也就完成了。
 */
/*
 * 快速插入排序
 * 从小到大排序
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
	
	

