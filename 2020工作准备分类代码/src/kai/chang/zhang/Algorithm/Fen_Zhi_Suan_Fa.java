package kai.chang.zhang.Algorithm;

//�����㷨˼�룬������ʵ��

/*
 * ���η����裺
 * 1�����ֲ��裺���㷨����������У������������ʵ������Ϊk>=1�������⣬ÿ��ʵ���Ĺ�ģ
 * �ϸ�С�������ԭʼ��ģn��һ����˵��Ӧ������k��������Ĺ�ģ������ͬ��k=2����������������
 * ����Ĵ��룬��ʱ��Ҳ��k=1�Ļ��֣������۰���ң�������������ȼ����������ݱ��ָ�Ϊ�����֣���
 * ����һ���ֱ������ˣ���ȻkҲ����ȡ����ֵ��
 * 2�������裺��������Ĺ�ģ����ĳ���趨�ķ�ֵʱ�������������k���ݹ������ɵģ�����������
 * ��ģС�ڷ�ֵʱ��ֱ�Ӷ����������⡣���������ʵ����ֵΪ2.
 * 3����ϲ��裺�������ʱ���k��������Ľ����õ�������ԭ����Ľ⣬��ϲ���Է����㷨��������
 * �ǳ��ؼ���Ӱ�죬�㷨��Ч���ںܴ�̶�����������ϲ����ʵϰ��
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
	
	//���Ҹ�����������ֵ����Сֵ
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














