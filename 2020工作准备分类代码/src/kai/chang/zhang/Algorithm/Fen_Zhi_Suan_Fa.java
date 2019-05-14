package kai.chang.zhang.Algorithm;

//分治算法思想，及经典实例

/*
 * 分治法步骤：
 * 1、划分步骤：在算法的这个步骤中，把输入的问题实例划分为k>=1个子问题，每个实例的规模
 * 严格小于问题的原始规模n，一般来说，应尽量将k个子问题的规模大致相同，k=2是最常见的情况，例如
 * 下面的代码，有时候也有k=1的划分，例如折半查找，但是这种情况等价于输入数据被分割为两部分，而
 * 其中一部分被舍弃了，当然k也可以取其他值。
 * 2、治理步骤：当子问题的规模大于某个设定的阀值时，这个步骤是由k个递归调用组成的；如果子问题的
 * 规模小于阀值时则直接对问题进行求解。例如下面的实例阀值为2.
 * 3、组合步骤：这个步骤时组合k个子问题的解来得到期望的原问题的解，组合步骤对分治算法的性能起到
 * 非常关键的影响，算法的效率在很大程度上依赖于组合步骤地实习。
 */

class IntPair{
	int x;
	int y;
}
public class Fen_Zhi_Suan_Fa {
	
	public static void main(String args[]) {
		int a [] = new int [] {1,6,8,2,4,5,9};
		Fen_Zhi_Suan_Fa f = new Fen_Zhi_Suan_Fa();
		IntPair pair = f.min_max(a, 0, 6);
		System.out.println(pair.x + " " + pair.y);
	}
	
	//查找给定数组地最大值和最小值
	public IntPair min_max(int [] a, int low, int high) {
		IntPair pair = new IntPair();
		if(low>high-2) {
			if(a[low]<a[high]) {
				pair.x = a[high];
				pair.y = a[low];
			}
			else {
				pair.x = a[low];
				pair.y = a[high];
			}
		}
		else {
			int mid = (low+high)/2;
			IntPair p1 = min_max(a,low,mid);
			IntPair p2 = min_max(a,mid+1,high);
			pair.x = p1.x > p2.x ? p1.x : p2.x;
			pair.y = p1.y < p2.y ? p1.y : p2.y;
		}
		return pair;
	}
	
	
}














