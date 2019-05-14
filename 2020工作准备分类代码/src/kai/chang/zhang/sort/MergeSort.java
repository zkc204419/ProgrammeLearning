package kai.chang.zhang.sort;

import java.util.Arrays;

//πÈ≤¢≈≈–Ú

public class MergeSort {
	

	public static void main(String args[]) {
		int [] a = new int [] {9,8,7,6,5,4,3,2,1};
		MergeSort ms = new MergeSort();
		System.out.println(Arrays.toString(ms.mergesort(a)));
	}
	
	
	
	public int [] mergesort(int [] a) {
		int [] temp = new int [a.length];
		int [] b = sort(a,0,a.length-1,temp);
		return b;
	}
	
	public int [] sort(int [] arr,int left, int right, int [] temp) {
		if(left<right){
			int mid = (left+right)/2;
			sort(arr,left,mid,temp);
			sort(arr,mid+1,right,temp);
			merge(arr,left,mid,right,temp);
		}
		return arr;
	}
	
	public void merge(int [] arr, int left, int mid, int right, int [] temp) {
		int i = left;
		int j = mid + 1;
		int t = 0;
		while(i<=mid && j <= right) {
			if(arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			}
			else {
				temp[t++] = arr[j++];
			}
		}
		while(i<=mid) {
			temp[t++] = arr[i++];
		}
		while(j<=right) {
			temp[t++] = arr[j+1];
		}
		
		t = 0;
		while(left<=right) {
			arr[left++] = temp[t++];
		}
	}
	
		
}















