package kai.chang.zhang.sort;

import java.util.Arrays;

//插入排序算法通过对未排序的数据执行逐个插入至合适的位置
//而完成排序工作

/*
 * 插入排序算法通过比较和插入实现排序，其排序流程如下：
 * 1、首先对数组的前两个数据进行从小到大的排序
 * 2、接着将第三个数据与排好序的两个数据比较，将第三个数据插入合适的位置
 * 3、然后将第四个数据插入已经排好序的前三个数据中。
 * 4、不断重复上述过程，直到最后一个数据插入合适的位置。最后便完成了对原始数组的从小到大的排序。
 */
/*
 * 插值排序
 * 将数据由小到大
 * 使用插值排序给指定数组排序
 */
//插入排序对n个数据进行排序时，无论原数据有无顺序，都需要进行n-1步的中间排序。
public class InsertSort {
	public static void main(String args[]) {
		int arr [] = new int [] {9,8,7,6,5,4,3,2,1};
		InsertSort is = new InsertSort();
		System.out.println(Arrays.toString(is.insertionSort(arr)));
	}

	public int []  insertionSort(int [] a) {
		int i,j,t,h;
		for(i = 1; i < a.length; i++) {
			t = a[i];
			j = i - 1;
			//将要插入的a[i]值与i前的所有值进行比较，找到合适的插入位置
			while(j >= 0 && t < a[j]) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = t;
		}
		return a;
	}
	
	/*
	 * 自写插入排序
	 */
	public int [] InsertSort(int arr[]) {
		for(int i = 1; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i]<arr[j]) {
					int temp=arr[i];
					for(int k = i-1; k >=j; k--) {
						arr[k+1]=arr[k];
					}
					arr[j]=temp;
				}
			}
		}
		return arr;	
	}
	/*
	 * 网上插入排序代码
	 */
	public  int [] straightInsertSort(int[] arr,int len){
        int temp=0;
        int j=0;
        for (int i = 1; i <len ; i++) {
            if(arr[i]<arr[i-1]){
                temp=arr[i];
                for (j = i-1; j>=0&&temp<arr[j] ; j--) {
                    arr[j+1]=arr[j];//从后向前移动数组
                }
                arr[j+1]=temp;
            }
        }
        return arr;
    }
	
	
	
	
}
