package kai.chang.zhang.sort;

import java.util.Arrays;

//选择排序
/*
 * 1、首先从原始数组中选择最小的1个数据，将其和第一个位置的数据交换
 * 2、接着从剩下的n-1个数据中选择次小的一个数据，将其和第二个位置的数据交换
 * 3、然后不断重复上述过程，直到最后两个数据完成交换。至此，便完成了对原始数据的从小到大的排序。
 */

public class SelectSort {


	public int []  selectSort(int [] a) {
		int index;
		int temp;
		for(int i = 0; i < a.length; i++) {
			index = i;
			//内部for循环是为了在每次循环内找到比a【index】值最小的小标
			//这样可以减少中间的交换次数
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
