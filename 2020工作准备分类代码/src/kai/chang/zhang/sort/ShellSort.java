package kai.chang.zhang.sort;

import java.util.Arrays;

//希尔排序，对于大量数据时的一种高效排序方法
//希尔排序算法严格来说基于插入排序的思想，又称为希尔排序或者缩小增量排序。
/*
 * 1、将有n个元素的数组分成n/2个数字序列，第1个数据和第n/2+1个数据为一对，。。。
 * 2、一次循环使每一个序列对排好顺序。
 * 3、然后，再变为n/4个序列，再次排序
 * 4、不断重复上述过程，随着序列减少最后变为一个，也就完成了整个排序。
 */

//r为增量，每次为a.length/2取整，比如a.length=6,则r取3，1
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
