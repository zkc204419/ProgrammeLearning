package kai.chang.zhang.sort;

/*冒泡排序
 * 从小到大排序 
 * 
 * 排序流程如下：
 * 1、对数组中的各个数据，依此比较相邻元素的大小
 * 2、如果前面的数据大于后面的数据，就交换这两个数据。
 * 3、用同样的方法把剩余的数据逐个进行比较，最后便可以得到从小到大排序好的数组各数据
 * 缺点：对n个数据排序时，无论源数据有无顺序，都需要进行n-1步的中间排序。一种改进方法：在每次排序前检查是否已经有序。
 */

import java.util.Arrays;
public class BubbleSort {

	public static void main(String[] args) {
		int [] arr = new int [] {1,2,3,4,5,6};
		BubbleSort b = new BubbleSort();
		System.out.println(Arrays.toString(b.bubbleSort(arr)));
		System.out.println(Arrays.toString(b.bubbleSort_new(arr)));
	}
	
	//基本冒泡排序
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
			System.out.println("基本冒泡排序比较次数" + i);
			
		}
		
		return arr;
	}
	
	//改进冒泡排序
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
			System.out.println("改进后冒泡排序比较次数为： " + i);
			if(flag) {
				break;
			}
		}
		return arr;
	}
}
