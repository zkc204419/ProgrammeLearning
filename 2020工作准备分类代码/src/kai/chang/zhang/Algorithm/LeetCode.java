package kai.chang.zhang.Algorithm;

import java.util.Arrays;

public class LeetCode {

	//求出现一次的数，其他数都出现两次，
	//使用异或
	public int singleNum(int [] a) {
		int result = 0;
		for(int i = 0; i < a.length; i++) {
			result = result ^ a[i];
		}
		return result;
	}
	
	//求众数
	//摩尔投票法
	public int  majorityElement(int [] nums) {
		int temp = 0, count = 0;
		for(int num: nums) {
			if(count == 0) {
				temp = num;
				count++;
			}
			else if(num == temp) {
				count++;
			}
			else
				count--;
		}
		return temp;
	}
	
	//搜索二维矩阵
	//方法一：对每一行进行二分查找
	//方法二：分治算法
	/*
	 *算法描述：左下角的元素是这一行中最小的元素，同时又是这一列中最大的元素。比较左下角元素和目标： 
	 *若左下角元素等于目标，则找到若左下角元素大于目标，则目标不可能存在于当前矩阵的最后一行，问题规模可以减小为在去掉最后一行的子矩阵中寻找目标
     *若左下角元素小于目标，则目标不可能存在于当前矩阵的第一列，问题规模可以减小为在去掉第一列的子矩阵中寻找目标，若
     *最后矩阵减小为空，则说明不存在
	 */
	public boolean searchMatrix(int a [][], int target) {
		int m = a.length;
		int n = a[0].length;
		int i = m-1,j = 0;
		while(i >= 0 && j <n) {
			if(a[i][j] == target) {
				return true;
			}
			else if(a[i][j]<target) {
				j++;
			}
			else {
				i--;
			}
		}
		return false;
	}
	
	//将两个给定的有序数组排序，排序的数组存储在第一个数组内
	//num1[1,2,3,0,0],num2[4,5];
	//开辟新数组，作为中间转换数组
	//m,n分别为数组内的元素数量
	public int [] merge(int []num1, int m, int [] num2, int n) {
		int temp [] = new int [m+n];
		int i = 0, j = 0,k = 0;
		while(i < m && j < n) {
			if(num1[i] <= num2[j]) {
				temp[k++] = num1[i++];
			}
			else {
				temp[k++] = num2[j++];
			}
			while(i < m) {
				temp[k++] = num1[i++];
			}
			while(j < n) {
				temp[k++] = num2[j++];
			}
		}
		return temp;
	}
	
	//不用开辟新数组，直接从后向前比较插入
	public int [] merge(int num1[], int []num2, int m, int n) {
		int k = m + n;
		while(m > 0 && n > 0) {
			if(num1[m-1] >= num2[n-1]) {
				num1[k-1] = num1[m-1];
				k--;
				m--;
			}
			else {
				num1[k-1] = num2[n-1];
				k--;
				n--;
			}
		}
		while(n>0) {
			num1[k-1] = num2[n-1];
			k--;
			n--;
		}
		return num1;
	}
	
	public static void main(String args[]) {
		int num1 [] = new int []{1,2,3,4,0,0,0};
		int num2 [] = new int [] {5,6,7};
		LeetCode l = new LeetCode();
		System.out.println(Arrays.toString(l.merge(num1, num2, 4, 3)));
	}
}















