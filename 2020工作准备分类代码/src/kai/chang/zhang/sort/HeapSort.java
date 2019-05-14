package kai.chang.zhang.sort;

import java.util.Arrays;

//堆排序
/*
 *从一个无序序列建堆的过程就是一个反复“筛选”的过程。若将此序列看作完全二叉树，
 *则最后一个非端结点的下标为n/2-1，由此，“筛选”只需从第n/2-1个元素开始。
 *排序步骤：
 *1、比较Ai的左子树和右子树的最大值，将最大值放在Aj中。
 *2、将Ai与Aj比较，如果Ai大于等于Aj，表示以Ai为根的子树已经构成堆结构。便终止筛选。
 *3、如果Ai小于Aj，则将Ai与Aj互换位置。
 *4、经过第三步后，可能会破坏以Ai为根的堆，因为此时Ai原来的值为Aj，下面以Aj为根重复前面的步骤，
 *		直到满足堆结构定义，即父结点数据大于子节点。
 *5、在筛选运算时，值较小的数据逐层下移，这就是其称为“筛”的原因。
 */
//从小到大排序
public class HeapSort {
	
	public int [] heapSort(int a []) {
		//先把数组建成一个大顶堆，然后再去除堆顶元素，然后再继续筛选，再去除再筛选，循环进行。
		int n = a.length;
		for(int i = n/2-1 ; i>=0; i--) {
			while(2*i+1<n) { //确保a[i]点存在左子树
				int j=2*i+1;
				if((j+1)<n) {//判断是否存在右子树，如果存在，且右子树大于左子树，则将a[j]指向其右子树
					if(a[j]<a[j+1]) {
						j++;
					}
				}
				if(a[i]<a[j]) { 
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
					i = j; //当a[i]与a[j]交换后可能会破坏a[j]原为位置的子树状态，因此，要从a[j]从新筛选
				}
				else {
					break;
				}
			}
		}
		
		//去除堆顶元素，筛选
		for(int i = n-1; i>0; i-- ) {
			int t = a[0];
			a[0] = a[i];
			a[i] = t;
			int k = 0;
			while(2*k+1<i) { //将a[0]与a[i]交换后，从新从a[0]开始筛选组建堆结构。
				int j = 2*k+1;
				if((j+1)<i) {
					if(a[j]<a[j+1]) {
						j++;
					}
				}
				if(a[k]<a[j]) {
					 t = a[k];
					 a[k] = a[j];
					 a[j] = t;
					 k = j;
				}
				else {
					break;
				}
			}
		}
		return a;
		
	}
	
	
	public static void main(String args[]) {
		HeapSort hs = new HeapSort();
		int a [] = new int [] {1,2,4,6,9,0,2,4};
		System.out.println(Arrays.toString(hs.heapSort(a)));
	
	}
}
