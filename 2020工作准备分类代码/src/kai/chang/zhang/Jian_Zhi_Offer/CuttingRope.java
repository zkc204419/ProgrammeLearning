package kai.chang.zhang.Jian_Zhi_Offer;


//������
public class CuttingRope {
	//��̬�滮
	public int maxProductAfterCutting(int length) {
		if(length <=1)
			return 0;
		if(length == 2) 
			return 1;
		if(length == 3)
			return 2;
		//���ڴ洢length=i���и��˻����ֵ������reuslt[i]��
		int result[] = new int [length+1]; 
		/*
		 * ���³�ʼ��ֵΪ��length>3ʱ������һ���ָ���������ֵ��
		 * ��ʱ�����ٷָ����length=5���ָ��Ϊ3��2��ʱ3*2Ϊ���
		 * ֵ�������ٷָ
		 */
		result[0] = 0;
		result[1] = 1;
		result[2] = 2;
		result[3] = 3;
		for(int i = 4; i <= length; i++) {
			int max = 0;
			for(int j = 1; j <= i/2; j++) {
				int num = result[i]*result[i-j];
				if(num > max) {
					max = num;
				}
			}
			result[i] = max;
		}
		return result[length];
	}
		
}




















