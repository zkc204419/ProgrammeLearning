package kai.chang.zhang.Jian_Zhi_Offer;

//�ҳ�����������ֻ����һ�����������֣���������
//���������Ρ� nums[0],nums2[0]����Ϊ���ؽ��

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public class FindNumsAppearOnce {
	
	public void findNumsAppearOnce(int [] array, int num1[], int num2[]) {
		int temp [] = new int [2];
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0,len = array.length; i <len; i++) {
			if(map.get(array[i]) == null) {
				map.put(array[i],1);
			}
			else if(map.get(array[i]) == 1) {
				map.remove(array[i]);
			}
		}
		int i = 0;
		for (Map.Entry<Integer, Integer> e: map.entrySet()) {
			temp[i++] = e.getKey();
		}
		num1[0] = temp[0];
		num2[0] = temp[1];
	}
}
