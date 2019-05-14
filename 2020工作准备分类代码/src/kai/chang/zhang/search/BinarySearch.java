package kai.chang.zhang.search;
/*
 * 二分查找算法，让关键字与数组的中间数比较，
 * 如果关键字小于中间数，则从中间数的左侧继续查找，
 * 如果关键字大于中间数，则从中间数的右侧继续查找。
 * 
 *适用于已经排好序的数组
 */

public class BinarySearch {
	public static void main(String args[]) {
		int a [] = new int [] {1,2,3,4,5,6,7,8}; 
		BinarySearch b = new BinarySearch();
		System.out.println(b.binarySearch(a,3,0,7));
	}
	
	
	
	//二分查找递归版本
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
			 * 当mid = low+(value-a[low])/(a[high]-a[low])*(high-low)时
			 * 二分查找就变成了插值查找，对于关键字分布比较均匀的查找表来说，插值查找算法的平均性能比
			 * 二分查找要好很多。比如数组[1,2,3,4,5,6],查找5时，从4开始查找。
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





