package kai.chang.zhang.sort;

import java.util.Arrays;

//���������㷨ͨ����δ���������ִ��������������ʵ�λ��
//�����������

/*
 * ���������㷨ͨ���ȽϺͲ���ʵ�������������������£�
 * 1�����ȶ������ǰ�������ݽ��д�С���������
 * 2�����Ž��������������ź�����������ݱȽϣ������������ݲ�����ʵ�λ��
 * 3��Ȼ�󽫵��ĸ����ݲ����Ѿ��ź����ǰ���������С�
 * 4�������ظ��������̣�ֱ�����һ�����ݲ�����ʵ�λ�á���������˶�ԭʼ����Ĵ�С���������
 */
/*
 * ��ֵ����
 * ��������С����
 * ʹ�ò�ֵ�����ָ����������
 */
//���������n�����ݽ�������ʱ������ԭ��������˳�򣬶���Ҫ����n-1�����м�����
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
			//��Ҫ�����a[i]ֵ��iǰ������ֵ���бȽϣ��ҵ����ʵĲ���λ��
			while(j >= 0 && t < a[j]) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = t;
		}
		return a;
	}
	
	/*
	 * ��д��������
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
	 * ���ϲ����������
	 */
	public  int [] straightInsertSort(int[] arr,int len){
        int temp=0;
        int j=0;
        for (int i = 1; i <len ; i++) {
            if(arr[i]<arr[i-1]){
                temp=arr[i];
                for (j = i-1; j>=0&&temp<arr[j] ; j--) {
                    arr[j+1]=arr[j];//�Ӻ���ǰ�ƶ�����
                }
                arr[j+1]=temp;
            }
        }
        return arr;
    }
	
	
	
	
}
